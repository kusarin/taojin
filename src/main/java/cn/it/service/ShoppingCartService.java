package cn.it.service;


import cn.it.pojo.CartList;

public interface ShoppingCartService {
	
	/**
	 * 添加商品到购物车
	 * */
   public void addItemToCart(int userId, int number,int itemId);
   /****
    * 
    * 查询购物车中的商品
    * */
   public CartList getAllItem(int userId);
   /*****
    * 删除购物车中的商品
    * */
   public void deleteItem(int userId,int cartItemId);
   /****
	 *更新某购物车中的商品数量 、小计、总额
	 * */
   public void updatePriceAndTotal(int userId,int itemId,int flag);
}
