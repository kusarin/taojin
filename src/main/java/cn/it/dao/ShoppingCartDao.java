package cn.it.dao;

import cn.it.pojo.ShoppingCart;

public interface ShoppingCartDao {
    /*
     *添加购物车 
     * */  
	public void add(ShoppingCart sh);
	/*
	 * 删除购物车
	 * */
	public void delete(int cartId);
	/****
	 * 查询购物车
	 * @param(userId表示用户编号)
	 * */
	public ShoppingCart select(int userId);
	/***
	 * 更新购物车中的商品总额
	 * */
	public void update(int cartId,double total);
}
