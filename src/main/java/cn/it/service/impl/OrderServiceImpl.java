package cn.it.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import cn.it.dao.AddressDao;
import cn.it.dao.DiscussDao;
import cn.it.dao.InvoiceDao;
import cn.it.dao.ItemDao;
import cn.it.dao.LotDao;
import cn.it.dao.OrderDao;
import cn.it.dao.OrderDetailDao;
import cn.it.dao.ShopDao;
import cn.it.dao.UsersDao;
import cn.it.pojo.Address;
import cn.it.pojo.Discuss;
import cn.it.pojo.Invoice;
import cn.it.pojo.Item;
import cn.it.pojo.Lot;
import cn.it.pojo.Order;
import cn.it.pojo.OrderCollection;
import cn.it.pojo.OrderDetail;
import cn.it.pojo.Page;
import cn.it.pojo.Shop;
import cn.it.service.OrderService;

/**
 * 
 * 对订单进行处理 包括提交订单，保存生成的订单信息、查看所有订单、查看订单详情 删除订单 修改订单中的交易状态
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDetailDao orderDetailDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private DiscussDao discussDao;
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private InvoiceDao invoiceDao;
	@Autowired
	private LotDao lotDao;
	// 任意对象
	private static Object lockObj = "lockerOrder";
	// 订单数量
	private static long orderNumCount = 0L;
	/**
	 * 每毫秒生成订单号数量最大值
	 */
	private int maxPerMSECSize = 1000;

	/****
	 * 
	 * 获取某用户的所有订单
	 * 
	 * @param(userId用户编号)
	 * */
	public Page<OrderCollection> getAllOrder(int userId,
			Page<OrderCollection> page) {
		List<OrderCollection> clist = new ArrayList<OrderCollection>();

		page.setPagestart((page.getPageNo() - 1) * page.getPagesize());// 设置初始的页面条数
		List<Order> olist = orderDao.selectAll(userId,0, page.getPagestart(),
				page.getPagesize());// 查询非拍卖品订单

		for (Order or : olist) {

			OrderCollection collection = new OrderCollection();

			List<OrderDetail> ordlist = orderDetailDao.selectAll(or
					.getOrderNumber());

			collection.setOrder(or);// 查询到的订单
			collection.setOrderDeatail(ordlist);
			clist.add(collection);
		}
		page.setDatas(clist);
		page.setTotalrecord(orderDao.getCount(userId,0));//此用户拥有的非拍卖品订单总数
		return page;
	}

	/**
	 * 更改订单的交易状态
	 * 
	 * @param(flag对用户的操作进行标记)
	 * */
	public void changeOrderStatus(int flag, String orderNumber) {
		Order order = orderDao.findOrder(orderNumber);
		switch (flag) {
		case 0:
			order.setStatus("待付款");
		case 1:// 已付款
			order.setStatus("待发货");
			order.setPaytime(new Timestamp(new Date().getTime()));
			orderDao.updatePayTime(order);// 更新支付时间
			addInvoice(order);// 生成发货单
			break;
		case 2:
			order.setStatus("已取消");
		default:
			break;
		}
		orderDao.update(order);
	}

	/**
	 * 
	 * @param(id表示订单表的唯一标识) 获取某订单详细信息
	 * */
	public Order getOrderDetail(String orderNumber) {

		return orderDao.findOrder(orderNumber);
	}

	/**
	 * 
	 * 删除订单
	 * */
	public void deleteOrder(String orderNumber) {

		orderDetailDao.delete(orderNumber); // 删除此订单对应的订单明细
		orderDao.delete(orderNumber); // 删除该订单号对应的订单
		/***** 更新商品的总数 ***/
		List<OrderDetail> oli = orderDetailDao.selectAll(orderNumber);// 此订单中的所有商品
		for (OrderDetail ord : oli) {
			int itemId = ord.getItemId();// 订单中的商品

			Item ii = itemDao.FindItemById(itemId);// item表中的商品
			ii.setnumber(ii.getnumber() + ord.getItemNumbers());// 更新商品总数
			itemDao.ItemUpdate(ii);// 更新item表
		}
	}

	/**
	 * 批量删除
	 * **/
	public void deleteAllOrder(String[] orderNumber) {
		orderDetailDao.deleteAll(orderNumber); // 删除此订单对应的订单明细
		orderDao.deleteAll(orderNumber); // 删除该订单号对应的订单
		for (int i = 0; i < orderNumber.length; i++) {
			/***** 更新商品的总数 ***/
			List<OrderDetail> oli = orderDetailDao.selectAll(orderNumber[i]);// 此订单中的所有商品
			for (OrderDetail ord : oli) {
				int itemId = ord.getItemId();// 订单中的商品

				Item ii = itemDao.FindItemById(itemId);// item表中的商品
				ii.setnumber(ii.getnumber() + ord.getItemNumbers());// 更新商品总数
				itemDao.ItemUpdate(ii);// 更新item表
			}
		}
	}

	/**
	 * 取消订单 更新商品的总数
	 * **/
	public void remove(int flag, String orderNumber) {
		Order o = orderDao.findOrder(orderNumber);
		o.setRemoveOrderTime(new Timestamp(new Date().getTime()));// 设置取消时间
		orderDao.updateTime(o); // 更新取消时间
		changeOrderStatus(flag, orderNumber);// 更改订单状态

		/***** 更新商品的总数 ***/
		List<OrderDetail> oli = orderDetailDao.selectAll(orderNumber);// 此订单中的所有商品
		for (OrderDetail ord : oli) {
			int itemId = ord.getItemId();// 订单中的商品

			Item ii = itemDao.FindItemById(itemId);// item表中的商品
			ii.setnumber(ii.getnumber() + ord.getItemNumbers());// 更新商品总数
			itemDao.ItemUpdate(ii);// 更新item表
		}
	}

	/**
	 * 
	 * 根据订单状态获取订单记录 （status:待付款、待收货、交易完成、已取消）
	 * */
	public Page<OrderCollection> getOrder(int userId, String status,
			Page<OrderCollection> page) {
		List<OrderCollection> coll = new ArrayList<OrderCollection>();

		page.setPagestart((page.getPageNo() - 1) * page.getPagesize());
		List<Order> ol = orderDao.select(userId,0,status, page.getPagestart(),
				page.getPagesize());//普通商品订单
		for (Order oo : ol) {
			OrderCollection orc = new OrderCollection();
			List<OrderDetail> ord = orderDetailDao.selectAll(oo
					.getOrderNumber());

			orc.setOrder(oo);
			orc.setOrderDeatail(ord);
			coll.add(orc);
		}
		page.setDatas(coll);
		page.setTotalrecord(ol.size());
		return page;
	}

	/**
	 * 提交订单 生成订单记录 更新商品数量
	 * 
	 * @param(itemId表示商品id，paylabel支付方式标记，userId用户Id)
	 * 
	 * */
	public Order submmitOrder(String addr, OrderCollection orderCollection,
			int userId) {

		Order order = orderCollection.getOrder(); // 创建订单
		order.setUserID(userId); // 设置下单用户
		String orderNumber = new OrderServiceImpl().createOrderNum();// 创建订单号
		order.setOrderNumber(orderNumber); // 设置订单号

		order.setOrderTime(new Timestamp(new Date().getTime()));// 设置下单时间
		String status = "待付款";
		order.setStatus(status); // 设置订单的交易状态（待付款、已完成、已取消）

		order.setPaymentMethod("网银支付");

		order.setRecivingAddress(addr); // 收货地址
		double freight = 0; // 运费
		order.setFreight(freight);
		order.setLabel(0);//普通商品订单
		orderDao.add(order);

		// 插入订单明细，更新商品数量
		List<OrderDetail> orderDetail = orderCollection.getOrderDeatail();
		for (OrderDetail orderDe : orderDetail) {
			orderDe.setOrderNumber(orderNumber); // 设置订单编号
			int itemId = orderDe.getItemId();
			orderDe.setItemId(itemId);
			orderDe.setMark(0);// 此商品处于待评价状态
			orderDe.setFlag(0);// 未发货
			orderDetailDao.add(orderDe);

			/** 更新商品库存 */
			int itemNumbers = orderDe.getItemNumbers();// 购买的商品数量
			Item item = itemDao.FindItemById(itemId);
			item.setnumber(item.getnumber() - itemNumbers);
			itemDao.ItemUpdate(item);// 更新商品库存
		}
		return order;
	}

	/**
	 * 
	 * 创建订单号
	 * 
	 * */
	public String createOrderNum() {
		String orderNum = ""; // 最终生成的订单
		synchronized (lockObj) {
			// 取系统当前时间作为订单号变量前半部分，精确到毫秒
			long nowLong = Long.parseLong(new SimpleDateFormat(
					"yyyyMMddHHmmssSSS").format(new Date()));
			// 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值1000个，1秒100万
			if (orderNumCount > maxPerMSECSize) {
				orderNumCount = 0L;
			}
			// 组装订单号
			String countStr = maxPerMSECSize + orderNumCount + ""; // 每毫秒生成的最大订单数+订单的数量组成的字符串
			orderNum = nowLong + countStr.substring(1);
			orderNumCount++;
			return orderNum;
		}
	}

	/**
	 * 确认订单信息
	 * 
	 * @param(itemId表示商品编号，userId用户编号，number购买某件商品的数量)
	 * */
	public OrderCollection sureOrder(int itemId, int userId, int number) {

		Item item = itemDao.FindItemById(itemId);// 根据商品id查询商品信息

		OrderCollection orderCollection = new OrderCollection(); // 订单信息、订单详细信息的对象

		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setItem(item);
		orderDetail.setItemId(itemId); // 设置商品编号
		double unitPrice = item.getprice(); // 商品单价
		orderDetail.setUnitPrice(unitPrice);
		orderDetail.setItemNumbers(number); // 此次购买某件商品的数量
		double itemPrice = number * unitPrice; // 购买某件商品的总价
		orderDetail.setItemPrice(itemPrice);
		Shop shop = shopDao.findByid(item.getshop_id());// 获取该商品所属的店铺名称
		String shopName = shop.getName();
		orderDetail.setShopName(shopName);
		orderDetail.setShop_id(item.getshop_id());
		orderDetailList.add(orderDetail);// 将订单明细放入容器

		// 设置订单信息
		Order order = new Order();
		double actulPayment = 0; // 订单总价
		double freight = 0; // 运费
		order.setFreight(freight);
		actulPayment = actulPayment + itemPrice + freight;
		order.setActulPayment(actulPayment); // 订单总价

		order.setTotalQuantity(number);// 订单中商品总数
		orderCollection.setOrder(order);// 设置订单信息

		orderCollection.setOrderDeatail(orderDetailList);// 设置订单细目

		return orderCollection; // 返回订单信息
	}

	/****
	 * 
	 * 根据用户Id获取收货地址
	 * 
	 * */
	public List<Address> getAddress(int userId) {

		return addressDao.addressFind(userId);
	}

	/*****
	 * 根据订单的交易状态查统计不同 状态的订单的数量
	 * 
	 * @param(status表示订单状态)
	 * */
	public int countNumbers(int userId, String status) {

		return orderDao.countNumbers(userId, status,0);
	}

	/***
	 * 新增收货地址
	 * */
	public void addAddr(String addr, int userId) {
		Address adr = new Address();
		adr.setAddr(addr);
		adr.setuser_ID(userId);
		addressDao.addressAdd(adr);
	}

	/**
	 * 根據訂單號查詢訂單
	 * */
	public Order findOrder(String orderNumber) {
		return orderDao.findOrder(orderNumber);
	}

	/***
	 * 评价订单
	 * */
	public OrderDetail evalOrder(int itemId, String orderNumber) {

		return orderDetailDao.findOr(orderNumber, itemId);
	}

	/***
	 * 提交评价
	 * */
	public void commitEvaluation(int itemId, int userId, int score,
			String content, String orderNumber) {

		String userName = usersDao.findById(userId).getName();
		Discuss di = new Discuss();
		di.setContent(content);
		di.setItem_id(itemId);
		di.setScore(score);
		di.setUser_id(userId);
		di.setUsername(userName);
		di.setOrderNumber(orderNumber);
		discussDao.addDiscuss1(di);// 存储评论

		// 修改订单中的商品状态

		OrderDetail or = orderDetailDao.findOr(orderNumber, itemId);
		or.setMark(1);// 已评价状态
		orderDetailDao.update(or);

		// 修改订单状态
		Order o = orderDao.findOrder(orderNumber);
		List<OrderDetail> ol = orderDetailDao.selectAll(orderNumber);

		List<Discuss> dl = discussDao.select(orderNumber);
		// 当所有商品评价完修改订单状态
		if (dl.size() == ol.size()) {
			o.setStatus("交易完成");
			orderDao.update(o);
			// 评价时间
			o.setEvalTime(new Timestamp(new Date().getTime()));
			orderDao.updateEvalTime(o);
		}
	}

	/***
	 * 确认收货
	 * */
	public void sureRGoods(String orderNumber) {

		/**
		 * 更新订单交易状态
		 * */
		Order o = orderDao.findOrder(orderNumber);
		o.setStatus("已收货");
		orderDao.update(o);
		/**
		 * 更新确认收货时间
		 * */
		o.setReceGoodsTime(new Timestamp(new Date().getTime()));
		orderDao.updateReceGoodsTime(o);
		/*
		 * 更新商品销售数量
		 */
		List<OrderDetail> oli = orderDetailDao.selectAll(orderNumber);// 此订单中的所有商品
		for (OrderDetail ord : oli) {
			int itemId = ord.getItemId();// 订单中的商品
			Item ii = itemDao.FindItemById(itemId);// item表中的商品

			ii.settradingTimes(ii.gettradingTimes() + ord.getItemNumbers());// 更新销售数量
			itemDao.ItemUpdate(ii);// 更新item表
		}
	}

	/*
	 * 某个店铺中的所有待发货/已发货 订单
	 */
	public Page<Invoice> selectInvoice(int shop_id, int flag,
			Page<Invoice> pages) {

		pages.setPagestart((pages.getPageNo() - 1) * pages.getPagesize());// 设置初始的页面条数
		List<Invoice> in = invoiceDao.select(shop_id, flag,
				pages.getPagestart(), pages.getPagesize());
		pages.setDatas(in);
		pages.setTotalrecord(in.size());
		return pages;

	}

	/*
	 * 确认发货,修改订单状态
	 */
	public void sureDeliGoods(String orderNumber, int shop_id) {

		Order o = orderDao.findOrder(orderNumber);
		List<OrderDetail> li = orderDetailDao.selectAll(orderNumber);
		// 跟新商品发货时间和发货状态
		for (OrderDetail or : li) {// 此店铺对应的此订单中的商品
			int shopId = or.getItem().getshop_id();
			if (shop_id == shopId) {
				or.setFlag(1);// 此件商品已发货
				orderDetailDao.updateFlag(or);

				// 商品发货时间、发货状态
				Invoice in = invoiceDao.selectIn(orderNumber, shop_id);

				in.setFlag(1);
				in.setDeliverTime(new Timestamp(new Date().getTime()));

				invoiceDao.update(in);
			}
		}
		int num = 0;
		for (OrderDetail or1 : li) {
			if (or1.getFlag() == 1) {
				num++;
			}
		}
		if (num == li.size()) {// 订单中的商品都已发货
			o.setStatus("待收货");
			orderDao.update(o);
		}
	}

	/*
	 * 生成发货单
	 */
	public void addInvoice(Order o) {

		String orderNumber = o.getOrderNumber();
		List<OrderDetail> orl = orderDetailDao.selectO(orderNumber);
		for (OrderDetail or1 : orl) {
			Invoice in = new Invoice();

			in.setOrderNumber(o.getOrderNumber());
			in.setOrderTime(o.getOrderTime());
			String username = (usersDao.findById(o.getUserID())).getName();
			in.setUserName(username);
			in.setFlag(0);
			in.setShop_id(or1.getShop_id());
			in.setShopNme(or1.getShopName());
			invoiceDao.add(in);
		}
	}

	/*一口价拍卖
	 * 生成拍卖品订单
	 */
	public Order createLotOrder(int lot_id,String addr) {
		Lot l = lotDao.FindLotById(lot_id);
		Order o = new Order();
		int user_id = l.getLot_id();// 当前出价人id
		o.setUserID(user_id);// 用户名
		String orderNumber = createOrderNum();// 订单号
		o.setOrderNumber(orderNumber);
		o.setOrderTime(new Timestamp(new Date().getTime()));// 下单时间
		o.setActulPayment(l.getNowprice());// 最终支付
		o.setStatus("待付款");
		o.setFreight(0);
		o.setPaymentMethod("网银支付");// 支付方式
		o.setRecivingAddress(addr);// 收货地址
		o.setTotalQuantity(1);// 购买总数
		o.setLabel(1);//标识拍卖品订单
		orderDao.add(o);// 生成订单记录

		OrderDetail ord = new OrderDetail();
		ord.setItemId(lot_id);// 拍卖品id
		ord.setOrderNumber(orderNumber);// 订单号
		ord.setItemNumbers(1);// 购买数量
		ord.setItemPrice(l.getNowprice());// 支付
		ord.setShop_id(l.getShop_id()); // 供货店铺id
		int shopid = l.getShop_id();
		String shopname = (shopDao.findByid(shopid)).getName();// 供货店铺
		ord.setShopName(shopname);
		ord.setMark(0);// 评价状态
		ord.setFlag(0);// 未发货

		orderDetailDao.add(ord);
		return o;
	}

	/**
	 * 用户的拍卖订单
	 * */
	public Page<OrderCollection> getLotOrder(int userId,
			Page<OrderCollection> page) {
		List<OrderCollection> clist = new ArrayList<OrderCollection>();

		page.setPagestart((page.getPageNo() - 1) * page.getPagesize());// 设置初始的页面条数
		List<Order> olist = orderDao.selectAll(userId,1, page.getPagestart(),
				page.getPagesize());// 查询拍卖品订单

		for (Order or : olist) {

			OrderCollection collection = new OrderCollection();

			List<OrderDetail> ordlist = orderDetailDao.getLot(or
					.getOrderNumber());

			collection.setOrder(or);// 查询到的订单
			collection.setOrderDeatail(ordlist);
			clist.add(collection);
		}
		page.setDatas(clist);
		page.setTotalrecord(orderDao.getCount(userId,1));//此用户拥有的拍卖品订单
		return page;
	}
	
	/**
	 * 确认拍卖品订单
	 * */
	public Lot sureLotOrder(int lot_id){
		
		return lotDao.FindLotById(lot_id);
	}
	/**
	 * 返回店铺名
	 * */
	public String getShopName(int shop_id){
		return (shopDao.findByid(shop_id)).getName();
	}
	
	/**
	 * 非一口价拍
	 * 生成拍卖品订单
	 * */
	public Order productLotOrder(int lot_id) {
		Lot l = lotDao.FindLotById(lot_id);
		Order o = new Order();
		int user_id = l.getLot_id();// 当前出价人id
		o.setUserID(user_id);// 用户名
		String orderNumber = createOrderNum();// 订单号
		o.setOrderNumber(orderNumber);
		o.setOrderTime(new Timestamp(new Date().getTime()));// 下单时间
		o.setActulPayment(l.getNowprice());// 最终支付
		o.setStatus("待付款");
		o.setFreight(0);
		o.setPaymentMethod("网银支付");// 支付方式
		o.setRecivingAddress(l.getAddress());// 收货地址
		o.setTotalQuantity(1);// 购买总数
		o.setLabel(1);//标识拍卖品订单
		orderDao.add(o);// 生成订单记录

		OrderDetail ord = new OrderDetail();
		ord.setItemId(lot_id);// 拍卖品id
		ord.setOrderNumber(orderNumber);// 订单号
		ord.setItemNumbers(1);// 购买数量
		ord.setItemPrice(l.getNowprice());// 支付
		ord.setShop_id(l.getShop_id()); // 供货店铺id
		int shopid = l.getShop_id();
		String shopname = (shopDao.findByid(shopid)).getName();// 供货店铺
		ord.setShopName(shopname);
		ord.setMark(0);// 评价状态
		ord.setFlag(0);// 未发货

		orderDetailDao.add(ord);
		return o;
	}

}
