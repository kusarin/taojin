package cn.it.pojo;



/**
 * 
 * 订单明细 OrderDetail
 * 
 * */
public class OrderDetail {

	private int id;  //订单明细表:id
	private int totalQuantity; //购买的商品总数：totalQuantity
	private int orderId;
	private int itemId;
	private Item item;
    /*****************************get***************set*******/
	public int getId() {
		return id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	
}
