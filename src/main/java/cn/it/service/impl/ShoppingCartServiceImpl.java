package cn.it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.it.dao.CartItemDao;
import cn.it.dao.ItemDao;
import cn.it.dao.ShopDao;
import cn.it.dao.ShoppingCartDao;
import cn.it.pojo.CartItem;
import cn.it.pojo.CartList;
import cn.it.pojo.Item;
import cn.it.pojo.Shop;
import cn.it.pojo.ShoppingCart;
import cn.it.service.ShoppingCartService;

@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService{

	@Autowired
	private ShoppingCartDao shoppingCartDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private CartItemDao cartItemDao;
	/****
	 * 添加商品到购物车
	 * @param(number商品数量)
	 * */
	@Override
	public void addItemToCart(int userId, int number, int itemId) {
		
		Item i=itemDao.FindItemById(itemId);
		/*
		 * 在添加商品前
		 * 判断此用户的购物车中是否有该商品
		 * 
		 * */
		//用户拥有购物车
		if(shoppingCartDao.select(userId)!=null){
			ShoppingCart s=shoppingCartDao.select(userId);
			CartItem cc=cartItemDao.select(itemId, s.getCartId());
			//购物车中有此商品，更新此商品的购买数量、更新购物车中的支付总额
			if(cc!=null){
				int tradingNumber=cc.getTradingNumbers();
				tradingNumber=tradingNumber+number;
				
				cc.setTradingNumbers(tradingNumber);
				cc.setTotalPrice(tradingNumber*i.getprice());
				cartItemDao.update(cc);
				
				double total=s.getTotal();
				total=total+number*i.getprice();
				shoppingCartDao.update(s.getCartId(), total);
			}
			//购物车中无此商品，添加商品到购物车,更新购物车中的支付总额
			else{
				CartItem c=new CartItem();
				
				int shopId=i.getshop_id();
				Shop sh=shopDao.findByid(shopId);
				c.setShopName(sh.getName());
				c.setCartId(s.getCartId());
				c.setItem(i);
				c.setItemId(itemId);
				c.setTotalPrice(i.getprice()*number);
				c.setTradingNumbers(number);
				cartItemDao.add(c);
				
				double total=s.getTotal()+i.getprice()*number;
				shoppingCartDao.update(s.getCartId(), total);
			}	
		}
	  //用户无购物车,创建购物车并将
		else{
			//创建购物车
			ShoppingCart sh=new ShoppingCart();
			sh.setUserId(userId);
			sh.setTotal(i.getprice()*number);
			shoppingCartDao.add(sh);
			
			CartItem c=new CartItem();
			int cartId=shoppingCartDao.select(userId).getCartId();
			c.setCartId(cartId);
			c.setItem(i);
			c.setItemId(itemId);
			int shopId=i.getshop_id();
			Shop s=shopDao.findByid(shopId);
			c.setShopName(s.getName());
			c.setTotalPrice(i.getprice()*number);
			c.setTradingNumbers(number);
			cartItemDao.add(c);
		}
	}

	/***
	 * 获取某用户购物车中的所有商品
	 * 一个用户一个购物车
	 * **/
	public CartList getAllItem(int userId){
		CartList cl=new CartList();
		ShoppingCart sh=shoppingCartDao.select(userId);
		//判断用户是否拥有购物车
		if(sh!=null){//拥有购物车
		   List<CartItem> c=cartItemDao.selectAll(sh.getCartId());
		   if(c!=null){
			cl.setSh(sh);
			cl.setCa(c);
		   }
		}
		return cl;	
	}
	/**
	 * 删除购物车中的商品
	 * */
	public void deleteItem(int userId,int cartItemId){
		
		ShoppingCart sh=shoppingCartDao.select(userId);
		List<CartItem> c=cartItemDao.selectAll(sh.getCartId());
		//清空购物车
		if(c.size()==1){
			cartItemDao.delete(cartItemId);
			shoppingCartDao.delete(sh.getCartId());
		}
		else{
			cartItemDao.delete(cartItemId);
			CartItem ca=cartItemDao.find(cartItemId);
			double totalprice=ca.getTotalPrice();
			double total=sh.getTotal();
			shoppingCartDao.update(sh.getCartId(), total-totalprice);
		}
	}
	
	/****
	 *更新某购物车中的商品数量 、小计、总额
	 * */
	public void updatePriceAndTotal(int userId,int itemId,int flag){
		
		ShoppingCart sh=shoppingCartDao.select(userId);
		//用户拥有购物车
		if(sh!=null){
		CartItem c =cartItemDao.select(itemId, sh.getCartId());
		Item i=itemDao.FindItemById(itemId);
		int salingNumber=c.getTradingNumbers();
		//获取此商品的总数
		int number=i.getnumber();
		switch(flag){
		case 0:
			if(salingNumber<number){
				salingNumber++;
				c.setTradingNumbers(salingNumber);
				c.setTotalPrice(salingNumber*i.getprice());
				cartItemDao.update(c);
				sh.setTotal(sh.getTotal()+i.getprice());
				shoppingCartDao.update(sh.getCartId(), sh.getTotal());
			}
			break;
		case 1:
			if(salingNumber>1){
				salingNumber=salingNumber-1;
				c.setTradingNumbers(salingNumber);
				c.setTotalPrice(salingNumber*i.getprice());
				cartItemDao.update(c);
				sh.setTotal(sh.getTotal()-i.getprice());
				shoppingCartDao.update(sh.getCartId(), sh.getTotal());
			}
			break;
		default:
			break;
		}
		}	
	}
}
