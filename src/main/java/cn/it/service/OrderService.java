package cn.it.service;

import java.util.List;

import cn.it.pojo.Order;
import cn.it.pojo.OrderCollection;
import cn.it.pojo.OrderDetail;
/**
 * 
 * OrderServiceImpl实现类的接口
 */
public interface OrderService {
	public List<OrderDetail> getAllOrderDetail(int userId);
	public List<Order> getAllOrder(int userId);
	public List<OrderCollection> mergeList(List<Order> orderList,List<OrderDetail> orderDetailList);
	public void submmitOrder(int itemId,int payLabel,String address,int userId);
	public void deleteOrder(String orderNumber);
	public OrderCollection getOrderDetail(String orderNumber);
}
