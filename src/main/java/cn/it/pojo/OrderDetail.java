package cn.it.pojo;
/**
 * 
 * 订单明细 OrderDetail
 * 
 * */
public class OrderDetail {

	private int id;  //订单明细表:id
	private double totalQuantity; //购买的商品总数：totalQuantity
    /*****************************get***************set*******/
	public int getId() {
		return id;
	}
	public double getTotalQuantity() {
		return totalQuantity;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTotalQuantity(double totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	
}
