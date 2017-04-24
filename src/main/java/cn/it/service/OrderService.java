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
	public Page<OrderCollection> getAllOrder(int userId,Page<OrderCollection> page);
	/**
	 * 提交订单
	 * 
	 * @param(itemId表示商品id，paylabel支付方式标记，userId用户Id)
	 * 
	 * */
	public Order submmitOrder(String addr,OrderCollection orderCollection, int payway, int userId);
	public void deleteOrder(String orderNumber);
	public void deleteAllOrder(String[] orderNumber);
	public Order getOrderDetail(String orderNumber);
	public OrderCollection sureOrder(int itemId,int userId,int number);
	public List<Address> getAddress(int userId);
	public void remove(int flag,String orderNumber);
	public Page<OrderCollection> getOrder(int userId,String status,Page<OrderCollection> page);
	public int countNumbers(int userId,String status);
}
