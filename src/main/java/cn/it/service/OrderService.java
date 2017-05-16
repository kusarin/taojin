package cn.it.service;




import java.util.List;

import cn.it.pojo.Address;
import cn.it.pojo.Invoice;
import cn.it.pojo.Item;
import cn.it.pojo.Lot;
import cn.it.pojo.Order;
import cn.it.pojo.OrderCollection;
import cn.it.pojo.OrderDetail;
import cn.it.pojo.Page;
/**
 * 
 * OrderServiceImpl实现类的接口
 */
public interface OrderService {
	/****
	 * 
	 * 获取某用户的所有订单
	 * 
	 * @param(userId用户编号)
	 * */
	public Page<OrderCollection> getAllOrder(int userId,Page<OrderCollection> page);
	/**
	 * 提交订单
	 * 
	 * @param(itemId表示商品id，paylabel支付方式标记，userId用户Id)
	 * 
	 * */
	public Order submmitOrder(String addr,OrderCollection orderCollection, int userId);
	/**
	 * 
	 * 删除订单
	 * */
	public void deleteOrder(String orderNumber);
	/***
	 *批量删除 
	 * **/
	public void deleteAllOrder(String[] orderNumber);

	/**
	 * 
	 * @param(id表示订单表的唯一标识) 获取某订单详细信息
	 * */
	public Order getOrderDetail(String orderNumber);
	/**
	 * 确认订单信息
	 * 
	 * @param(itemId表示商品编号，userId用户编号，number购买某件商品的数量)
	 * */
	public OrderCollection sureOrder(int itemId,int userId,int number);
	
	/****
	 * 
	 * 根据用户Id获取收货地址
	 * 
	 * */
	public List<Address> getAddress(int userId);
	/****
	 * 取消订单
	 * **/
	
	public void remove(int flag,String orderNumber);
	
	/**
	 * 
	 * 根据订单状态获取订单记录
	 * （status:待付款、待收货、已完成、已取消）
	 * */
	public Page<OrderCollection> getOrder(int userId,String status,Page<OrderCollection> page);
	
	/*****
	 * 根据订单的交易状态查统计不同
	 * 状态的订单的数量
	 * @param(status表示订单状态)
	 * */
	public int countNumbers(int userId,String status);
	
	/**
	 * 更改订单的交易状态
	 * 
	 * @param(flag对用户的操作进行标记)
	 * */
	public void changeOrderStatus(int flag, String orderNumber);
	
	/***
	 * 新增收货地址
	 * */
	public void addAddr(String addr,int userId);
	
	/**
	 * 根據訂單號查詢訂單
	 * */
	public Order findOrder(String orderNumber);
	/**
	 * 评价订单
	 * */
	public OrderDetail evalOrder(int itemId,String orderNumber);
	/**
	 * 提交评价
	 * */
	public void commitEvaluation(int itemId,int userId,int score,String content,String orderNumber);
	/***
	 * 确认收货
	 * */
	public void sureRGoods(String orderNumber);
	/*
	 * 某个店铺中的所有待发货/已发货
	 * 订单
	 */
	public Page<Invoice> selectInvoice(int shop_id,int flag,Page<Invoice> pages);
	/*
	 *确认发货,修改订单状态
	 */
	public void sureDeliGoods(String orderNumber,int shop_id);
	
	/*
	 * 拍卖品订单
	 * */
	public Order createLotOrder(int lot_id,String addr);
	/**
	 * 用户的拍卖订单
	 * */
	public Page<OrderCollection> getLotOrder(int userId,
			Page<OrderCollection> page);
	/**
	 * 确认拍卖品订单
	 * */
	public Lot sureLotOrder(int lot_id);
	/**
	 * 返回店铺名
	 * */
	public String getShopName(int shop_id);
	/**
	 * 非一口价拍
	 * 生成拍卖品订单
	 * */
	public Order productLotOrder(int lot_id);
}
