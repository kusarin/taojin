package cn.it.service;

import java.util.List;

import cn.it.pojo.OrderCollection;
/**
 * 
 * OrderServiceImpl实现类的接口
 */
public interface OrderService {
	public List<OrderCollection> getAllOrder(int userId);
	public void submmitOrder(int itemId,int payLabel,int userId);
	public void deleteOrder(String orderNumber);
	public OrderCollection getOrderDetail(String orderNumber);
	public OrderCollection sureOrder(int itemId,int userId,int number);
}
