package cn.it.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.it.dao.ItemDao;
import cn.it.dao.OrderDao;
import cn.it.dao.OrderDetailDao;
import cn.it.dao.ShopDao;
import cn.it.pojo.Item;
import cn.it.pojo.Order;
import cn.it.pojo.OrderCollection;
import cn.it.pojo.OrderDetail;
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
	public List<OrderCollection> getAllOrder(int userId) {
		List<OrderCollection> clist = new ArrayList<OrderCollection>();
		List<Order> olist = orderDao.selectAll(userId);
		Iterator<Order> oitr = olist.iterator();
		while (oitr.hasNext()) {
			OrderCollection collection = new OrderCollection();
			Order o = oitr.next();
			collection.setOrder(o);
			if (orderDetailDao.selectAll(o.getOrderNumber()) != null) {
				List<OrderDetail> ordlist = orderDetailDao.selectAll(o
						.getOrderNumber());
				collection.setOrderDeatail(ordlist);
			}
		}
		return clist;
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
			break;
		case 1:
			order.setStatus("已付款");
			break;
		case 2:
			order.setStatus("待收货");
			break;
		case 3:
			order.setStatus("交易成功");
			break;
		case 4:
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

		orderDao.delete(orderNumber); // 删除该订单号对应的订单
		orderDetailDao.delete(orderNumber); // 删除此订单对应的订单明细
	}

	/**
	 * 提交订单
	 * 
	 * @param(itemId表示商品id，paylabel支付方式标记，userId用户Id)
	 * 
	 * */
	public void submmitOrder(int itemId, int payLabel, int userId) {
		// 提交订单并保存
		Order order = new Order();
		order.setUserID(userId); // 设置下单用户
		String orderNumber = new OrderServiceImpl().createOrderNum();// 创建订单号
		order.setOrderNumber(orderNumber);
		order.setOrderTime(new java.sql.Date(new Date().getTime()));// 下单时间
		Item item = itemDao.FindItemById(itemId);
		double actulPayment = item.gettradingTimes() * item.getprice();// 最终支付
		order.setActulPayment(actulPayment);
		String status = "待付款"; // 订单的交易状态
		order.setStatus(status);
		switch (payLabel) {
		case 0:
			order.setPaymentMethod("货到付款");
		case 1:
			order.setPaymentMethod("第三方支付");
		default:
			break;
		}
		String address = "";
		order.setRecivingAddress(address); // 收货地址
		double freight = 0; // 运费
		order.setFreight(freight);
		orderDao.add(order);

		// 插入订单明细
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderNumber(orderNumber); // 设置订单编号
		orderDetail.setItemId(itemId); // 设置商品编号
		double unitPrice = item.getprice(); // 设置商品单价
		orderDetail.setUnitPrice(unitPrice);
		int itemNumbers = item.gettradingTimes();
		orderDetail.setItemNumbers(itemNumbers);// 设置已购买的某件商品的数量
		double itemPrice = itemNumbers * unitPrice;
		orderDetail.setItemPrice(itemPrice);// 设置商品总价
		orderDetailDao.add(orderDetail);
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
		orderDetail.setId(itemId); // 设置商品编号
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
		orderCollection.setOrder(order);// 设置订单信息

		orderCollection.setOrderDeatail(orderDetailList);// 设置订单细目
		orderCollection.setTotalNumbers(number);//订单中商品总数
		orderCollection.setShopName(shopName);
		return orderCollection; // 返回订单信息
	}
}
