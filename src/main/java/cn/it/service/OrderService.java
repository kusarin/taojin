package cn.it.service;

import java.util.List;




import cn.it.pojo.Address;
import cn.it.pojo.OrderCollection;
import cn.it.pojo.Page;
/**
 * 
 * OrderServiceImpl实现类的接口
 */
public interface OrderService {
	public List<OrderCollection> getAllOrder(int userId,Page<OrderCollection> page);
	public void submmitOrder(Address address,OrderCollection orderCollection, int payway, int userId);
	public void deleteOrder(String orderNumber);
	public OrderCollection getOrderDetail(String orderNumber);
	public OrderCollection sureOrder(int itemId,int userId,int number);
	public Address getAddress(int userId);
}
