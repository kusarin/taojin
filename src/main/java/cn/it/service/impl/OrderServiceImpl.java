package cn.it.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import cn.it.dao.AddressDao;
import cn.it.dao.ItemDao;
import cn.it.dao.OrderDao;
import cn.it.dao.OrderDetailDao;
import cn.it.dao.ShopDao;
import cn.it.pojo.Address;
import cn.it.pojo.Item;
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
public  class OrderServiceImpl implements OrderService {
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
	public Page<OrderCollection> getAllOrder(int userId,Page<OrderCollection> page) {
		List<OrderCollection> clist = new ArrayList<OrderCollection>();
		
		page.setPagestart((page.getPageNo()-1)*page.getPagesize());//设置初始的页面条数
		List<Order> olist = orderDao.selectAll(userId,page.getPagestart(),page.getPagesize());//查询结
		 
		for(Order or:olist) {
	
			OrderCollection collection = new OrderCollection();
			
			List<OrderDetail> ordlist = orderDetailDao.selectAll(or.getOrderNumber());
			
				collection.setOrder(or);//查询到的订单
				collection.setOrderDeatail(ordlist);
				clist.add(collection);
		}
		page.setDatas(clist);
		page.setTotalrecord(orderDao.getCount(userId));
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
		case 1:
			order.setStatus("待收货");
			break;
		case 2:
			order.setStatus("交易成功");
			break;
		case 3:
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
	public OrderCollection getOrderDetail(String orderNumber) {
		OrderCollection orderDetail = new OrderCollection();
		Order order = orderDao.findOrder(orderNumber);
		if (order != null) {
			orderDetail.setOrder(order);
		}
		List<OrderDetail> orlist = orderDetailDao.selectAll(orderNumber);
		if (orlist != null) {
			orderDetail.setOrderDeatail(orlist);
		}
		return orderDetail;
	}

	/**
	 * 
	 * 删除订单
	 * */
	public void deleteOrder(String orderNumber) {

		orderDetailDao.delete(orderNumber); // 删除此订单对应的订单明细
		orderDao.delete(orderNumber); // 删除该订单号对应的订单
	}
	/***
	 *批量删除 
	 * **/
	public void deleteAllOrder(String[] orderNumber){
		orderDetailDao.deleteAll(orderNumber); // 删除此订单对应的订单明细
		orderDao.deleteAll(orderNumber); // 删除该订单号对应的订单
	}
	/****
	 * 取消订单
	 * **/
	public void remove(int flag, String orderNumber){
		Order o=orderDao.findOrder(orderNumber);
		o.setOrderTime(new java.sql.Date(new Date().getTime()));// 设置取消时间
		orderDao.updateTime(o);  //更新取消时间
		changeOrderStatus( flag, orderNumber);//更改订单状态
	}
	/**
	 * 
	 * 根据订单状态获取订单记录
	 * （status:待付款、待收货、已完成、已取消）
	 * */
	public Page<OrderCollection> getOrder(int userId,String status,Page<OrderCollection> page){
		List<OrderCollection> coll=new ArrayList<OrderCollection>();
		
		page.setPagestart((page.getPageNo()-1)*page.getPagesize());
		List<Order> ol=orderDao.select(userId, status, page.getPagestart(), page.getPagesize());
		for(Order oo:ol){
			OrderCollection orc=new OrderCollection();
			List<OrderDetail> ord=orderDetailDao.selectAll(oo.getOrderNumber());
			
			orc.setOrder(oo);
			orc.setOrderDeatail(ord);
			coll.add(orc);
		}
		page.setDatas(coll);
		page.setTotalrecord(ol.size());
		return page;
	}
	/**
	 * 提交订单
	 * 
	 * @param(itemId表示商品id，paylabel支付方式标记，userId用户Id)
	 * 
	 * */
	public void submmitOrder(Address address,OrderCollection orderCollection, int payway, int userId) {
		
		Order order = orderCollection.getOrder();   //创建订单
		order.setUserID(userId);    // 设置下单用户
		String orderNumber = new OrderServiceImpl().createOrderNum();// 创建订单号
		order.setOrderNumber(orderNumber);  //设置订单号
		order.setOrderTime(new java.sql.Date(new Date().getTime()));// 设置下单时间
		String status = "待付款";
		order.setStatus(status); // 设置订单的交易状态（待付款、已付款、待收货、已完成、已取消）
		switch (payway) {
		case 0:
			order.setPaymentMethod("货到付款");
		case 1:
			order.setPaymentMethod("第三方支付");
		default:
			break;
		}
		
		order.setRecivingAddress(address.getAddr()); // 收货地址
		double freight = 0; // 运费
		order.setFreight(freight);
		orderDao.add(order);

		// 插入订单明细
		List<OrderDetail> orderDetail = orderCollection.getOrderDeatail();
		for(OrderDetail orderDe:orderDetail){
			orderDe.setOrderNumber(orderNumber); // 设置订单编号
			int itemId=orderDe.getItemId();
			orderDe.setItemId(itemId);
			orderDetailDao.add(orderDe);
		}
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
		
		Item item = itemDao.FindItemById(itemId);//根据商品id查询商品信息

		OrderCollection orderCollection = new OrderCollection(); // 订单信息、订单详细信息的对象
		/** 暂不处理收货地址 */
		// //根据ueserId，获取收货地址
		// Address address=addressDao.select(userId);
		// //设置收货地址信息
		// orderCollection.setAddress(address);

		/**
		 * 支付方式暂不设定
		 * */

		/***
		 * 生成订单细目
		 * 
		 * */
		
		List<OrderDetail> orderDetailList =new ArrayList<OrderDetail>();
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
		orderDetailList.add(orderDetail);// 将订单明细放入容器
         
		// 设置订单信息
		Order order = new Order();
		double actulPayment = 0; // 订单总价
		double freight = 0; // 运费
		order.setFreight(freight);
		actulPayment = actulPayment + itemPrice + freight;
		order.setActulPayment(actulPayment); // 订单总价
		
		order.setTotalQuantity(number);//订单中商品总数
		orderCollection.setOrder(order);// 设置订单信息

		orderCollection.setOrderDeatail(orderDetailList);// 设置订单细目
		orderCollection.setShopName(shopName);
		return orderCollection; // 返回订单信息
	}
	
	/****
	 * 
	 * 根据用户Id获取收货地址
	 * 
	 * */
	public List<Address> getAddress(int userId){
		
		return addressDao.addressFind(userId);
	}
}
