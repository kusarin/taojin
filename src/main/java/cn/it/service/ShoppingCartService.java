package cn.it.service;

public interface ShoppingCartService {
	
	/**
	 * 添加商品到购物车
	 * */
   public void addItemToCart(int userId, int number,int itemId);
}
