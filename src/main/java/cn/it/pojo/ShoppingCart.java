package cn.it.pojo;

public class ShoppingCart {
	private int cartId;  //购物车Id
	private int userId;   //用户id
	private double total;  //合计
	private int totalnumber;
	/*********get***********set*************/
	
	public int getCartId() {
		return cartId;
	}
	public int getTotalnumber() {
		return totalnumber;
	}
	public void setTotalnumber(int totalnumber) {
		this.totalnumber = totalnumber;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
