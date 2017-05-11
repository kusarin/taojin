package cn.it.pojo;

import java.util.Date;
/*****
 * 发货单
 * ***/
public class Invoice {

	private int invoice_id;//
	private String orderNumber;//订单号
	private String userName;//收货人
	private Date orderTime;//下单时间
	private Date deliverTime;//发货时间
	private String shopNme;//供货店铺
	private int flag;//发货单状态
	private int shop_id; //供货店铺Id
	/***********set********get****/
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}
	public String getShopNme() {
		return shopNme;
	}
	public void setShopNme(String shopNme) {
		this.shopNme = shopNme;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	
}
