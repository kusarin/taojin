package cn.it.pojo;

import java.sql.Date;
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
	private double unitPrice;   //单价：unitPrice
	private int quantity;       //购买的数量：quantity
	private double actulPayment;  //实际的付款：actulPayment
	private String statusString;  //交易状态：待付款、取消订单、交易成功、待收货：statusString
	private String paymentMethod;  //支付方式：paymentMethod
	private String recivingAddress; //收货地址：recivingAddress
	private String freight;      //运费：freight
/******************************get****************************set**********/
	public int getId() {
		return id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getActulPayment() {
		return actulPayment;
	}
	public String getStatusString() {
		return statusString;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public String getRecivingAddress() {
		return recivingAddress;
	}
	public String getFreight() {
		return freight;
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
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setActulPayment(double actulPayment) {
		this.actulPayment = actulPayment;
	}
	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public void setRecivingAddress(String recivingAddress) {
		this.recivingAddress = recivingAddress;
	}
	public void setFreight(String freight) {
		this.freight = freight;
	}
	
}
