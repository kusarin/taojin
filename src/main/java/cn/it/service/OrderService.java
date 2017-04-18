package cn.it.service;




import cn.it.pojo.Address;
import cn.it.pojo.Order;
import cn.it.pojo.OrderCollection;
import cn.it.pojo.Page;
/**
 * 
 * OrderServiceImpl实现类的接口
 */
public interface OrderService {
	public Page<OrderCollection> getAllOrder(int userId,Page<OrderCollection> page);
	public void submmitOrder(Address address,OrderCollection orderCollection, int payway, int userId);
	public void deleteOrder(String orderNumber);
	public void deleteAllOrder(String[] orderNumber);
	public OrderCollection getOrderDetail(String orderNumber);
	public OrderCollection sureOrder(int itemId,int userId,int number);
	public Address getAddress(int userId);
	public void remove(int flag,String orderNumber);
	public Page<OrderCollection> getOrder(int userId,String status,Page<OrderCollection> page);
}
