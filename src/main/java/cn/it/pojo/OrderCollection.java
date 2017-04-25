package cn.it.pojo;

import java.util.List;
/****
 * 
 * 封装订单和订单细目
 * */
public class OrderCollection {
	private Order order;
	private  List<OrderDetail> orderDeatail;


	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<OrderDetail> getOrderDeatail() {
		return orderDeatail;
	}
	public void setOrderDeatail(List<OrderDetail> orderDeatail) {
		this.orderDeatail = orderDeatail;
	}

}
