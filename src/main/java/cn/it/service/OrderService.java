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
	public List<OrderDetail> getALLItem(int num);
	public List<Order> getAllOrder(int num);
	public List<OrderCollection> mergeList(List<Order> orderList,List<OrderDetail> orderDetailList);
}
