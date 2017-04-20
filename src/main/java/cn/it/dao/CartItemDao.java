package cn.it.dao;



import cn.it.pojo.CartItem;

public interface CartItemDao {

	/**
	 * 插入商品信息
	 * */
	public void add(CartItem ct);
	/**
	 * 删除购物车中的
	 * 某个项目
	 * */
	public void delete(int cartItemId);
	/*****
	 * 根据商品id查询购物项目表
	 * */
	public CartItem select(int itemId,int cartId);
	/**
	 * 
	 * 更新加入购物车中的某件商品的数量、小计
	 * */
	public CartItem update(CartItem c);
}
