package cn.it.pojo;

import java.util.Date;

/**
 * 
 * 订单明细 OrderDetail
 * 
 * */
public class OrderDetail {

	private int id;    //订单明细表:id
	private String orderNumber;   //订单编号
	private int itemId;     //商品Id
	private double unitPrice;   //商品单价
	private int itemNumbers;   //购买的某件商品的数量
	private double itemPrice;   //商品总价
	private String shopName; //店铺对应的名称
	private Item item;
	private int mark;//标识订单中的商品是否进行过评价
	private int flag;//标记此件商品是否发货
	private int shop_id;
	
    /*****************************get***************set*******/
	
	public int getId() {
		return id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getItemNumbers() {
		return itemNumbers;
	}
	public void setItemNumbers(int itemNumbers) {
		this.itemNumbers = itemNumbers;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
}
