package cn.it.dao;

import cn.it.pojo.ShoppingCart;

public interface ShoppingCartDao {
      
	public void add(ShoppingCart sh);
	public void delete(int cartId);
}
