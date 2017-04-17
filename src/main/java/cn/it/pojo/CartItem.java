package cn.it.pojo;
/**
 * 
 *@author Administrator
 *
 *购买的商品列表
 * **/
public class CartItem {
	
	private int cartId;  // 购物车项目列表Id
	private int cartItemId;//购物车Id
	private int itemId;// 商品表Id
	private int tradingNumbers;//购买的某件商品的数量
	private double totalPrice;//销售额
	private String shopName;//店铺名称
	private Item item;//商品
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getTradingNumbers() {
		return tradingNumbers;
	}
	public void setTradingNumbers(int tradingNumbers) {
		this.tradingNumbers = tradingNumbers;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
}
