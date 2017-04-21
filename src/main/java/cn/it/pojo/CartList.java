package cn.it.pojo;

import java.util.List;

public class CartList {
    private ShoppingCart sh;
    private List<CartItem> ca;
	public ShoppingCart getSh() {
		return sh;
	}
	public void setSh(ShoppingCart sh) {
		this.sh = sh;
	}
	public List<CartItem> getCa() {
		return ca;
	}
	public void setCa(List<CartItem> ca) {
		this.ca = ca;
	}
    
}
