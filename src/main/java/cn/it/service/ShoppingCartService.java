package cn.it.service;





import java.util.List;

import cn.it.pojo.CartItem;
import cn.it.pojo.CartList;
import cn.it.pojo.Order;

public interface ShoppingCartService {
	
	/**
	 * 添加商品到购物车
	 * */
   public int addItemToCart(int userId, int number,int itemId);
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
   /********
    * 选择购物车中要购买的商品
    * */
   public CartList payingCart(Integer[] cartItemId);
   
   /***
	 *提交订单、下单
	 *并删除购物车 
	 */
	public Order commitOrder(List<CartItem> ca,int userId,String addr,int payAway);
   
}
