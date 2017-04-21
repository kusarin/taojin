package cn.it.dao;



import java.util.List;

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
	 * 根据商品id,购物车id,查询购物项目表
	 * */
	public CartItem select(int itemId,int cartId);
	/**
	 * 
	 * 更新加入购物车中的某件商品的数量、小计
	 * */
	public void update(CartItem c);
	/**
	 * 获取某用户购物车中的所有商品
	 * */
	public List<CartItem> selectAll(int cartId);
	/**
	 * 查询某条购物车细目
	 * */
	public CartItem find(int cartItemId);
}
