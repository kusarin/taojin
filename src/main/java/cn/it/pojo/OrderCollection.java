package cn.it.pojo;

import java.util.List;

public class OrderCollection {
	private Order order;
	private  List<OrderDetail> orderDeatail;
	private String shopName;
	private int totalNumbers;//item总数
	
	public int getTotalNumbers() {
		return totalNumbers;
	}
	public void setTotalNumbers(int totalNumbers) {
		this.totalNumbers = totalNumbers;
	}
	public Order getOrder() {
		return order;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
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
