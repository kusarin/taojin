package cn.it.pojo;

import java.util.Date;
/**
 * 
 * @author Administrator
 * 订单 ：Order
 *
 */
public class Order {

	private int id;   //唯一标识一个订单记录：id
	private String orderNumber;  //订单号，唯一标识一个订单：orderNumber
	private Date orderTime;     //下单时间：orderTime
	private Date removeOrderTime;//取消订单时间
	private double actulPayment;  //实际的付款：actulPayment
	private String status;  //交易状态：待付款、取消订单、交易成功、待收货
	private String paymentMethod;  //支付方式：paymentMethod
	private String recivingAddress; //收货地址：recivingAddress
	private double freight;   //运费：freight
	private int userID; //用户编号
	private int totalQuantity;

	/******************************get****************************set**********/
 
	public double getFreight() {
		return freight;
	}
	public Date getRemoveOrderTime() {
		return removeOrderTime;
	}
	public void setRemoveOrderTime(Date removeOrderTime) {
		this.removeOrderTime = removeOrderTime;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public void setFreight(double freight) {
		this.freight = freight;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getId() {
		return id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public Date getOrderTime() {
		return orderTime;
	}

	public double getActulPayment() {
		return actulPayment;
	}
	public String getStatus() {
		return status;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public String getRecivingAddress() {
		return recivingAddress;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public void setActulPayment(double actulPayment) {
		this.actulPayment = actulPayment;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public void setRecivingAddress(String recivingAddress) {
		this.recivingAddress = recivingAddress;
	}
}
