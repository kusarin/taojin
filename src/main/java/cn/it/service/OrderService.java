package cn.it.service;




import java.util.List;

import cn.it.pojo.Address;
import cn.it.pojo.Order;
import cn.it.pojo.OrderCollection;
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
}
