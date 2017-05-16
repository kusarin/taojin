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
	private Date paytime;  //付款时间
	private double actulPayment;  //实际的付款：actulPayment
	private String status;  //交易状态：待付款、取消订单、交易成功、待收货
	private String paymentMethod;  //支付方式：paymentMethod
	private String recivingAddress; //收货地址：recivingAddress
	private double freight;   //运费：freight
	private int userID; //用户编号
	private int totalQuantity; //购买总数
    private Date receGoodsTime;//收货时间
    private Date evalTime;//评价时间
    private int label;//标识是普通商品还是拍卖品生成的订单
	/******************************get****************************set**********/
    
 
	public double getFreight() {
		return freight;
	}
	public int getLabel() {
		return label;
	}
	public void setLabel(int label) {
		this.label = label;
	}
	public Date getEvalTime() {
		return evalTime;
	}
	public void setEvalTime(Date evalTime) {
		this.evalTime = evalTime;
	}
	public Date getReceGoodsTime() {
		return receGoodsTime;
	}
	public void setReceGoodsTime(Date receGoodsTime) {
		this.receGoodsTime = receGoodsTime;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public Date getPaytime() {
		return paytime;
	}
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}
	public Date getRemoveOrderTime() {
		return removeOrderTime;
	}
	public void setRemoveOrderTime(Date removeOrderTime) {
		this.removeOrderTime = removeOrderTime;
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
