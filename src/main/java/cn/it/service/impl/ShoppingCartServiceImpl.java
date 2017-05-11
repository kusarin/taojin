package cn.it.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import cn.it.dao.CartItemDao;
import cn.it.dao.ItemDao;
import cn.it.dao.OrderDao;
import cn.it.dao.OrderDetailDao;
import cn.it.dao.ShopDao;
import cn.it.dao.ShoppingCartDao;
import cn.it.pojo.CartItem;
import cn.it.pojo.CartList;
import cn.it.pojo.Item;
import cn.it.pojo.Order;
import cn.it.pojo.OrderDetail;
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
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderDetailDao orderDetailDao;
	/****
	 * 添加商品到购物车
	 * @param(number商品数量)
	 * */
	@Override
	public int addItemToCart(int userId, int number, int itemId) {
		
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
				shoppingCartDao.update(s.getCartId(), total,s.getTotalnumber());
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
				int totalnumber=s.getTotalnumber();//购物车商品总数
				totalnumber=totalnumber+1;
				shoppingCartDao.update(s.getCartId(), total,totalnumber);
			}	
			return 1;
		}
	  //用户无购物车,创建购物车并将
		else{
			//创建购物车
			ShoppingCart sh=new ShoppingCart();
			sh.setUserId(userId);
			sh.setTotal(i.getprice()*number);
			int totalnumber=1;
			sh.setTotalnumber(totalnumber);
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
		return 1;
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
		}//删除购物车中的某一项
		else{
			
			CartItem ca=cartItemDao.find(cartItemId);
			double totalprice=ca.getTotalPrice();
			double total=sh.getTotal();
			int totalnumber=sh.getTotalnumber();
			totalnumber=totalnumber-1;
			shoppingCartDao.update(sh.getCartId(), total-totalprice,totalnumber);
			cartItemDao.delete(cartItemId);//删除
		}
	}
	
	/****
	 *更新某购物车中的商品数量 、小计、总额
	 *@param(userId用户编号，itemid商品编号，flag：0表示该商品数量加1、1表示该商品数量减1)
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
		//加1
		case 0:
			if(salingNumber<number){
				salingNumber++;
				c.setTradingNumbers(salingNumber);
				c.setTotalPrice(salingNumber*i.getprice());
				cartItemDao.update(c);
				sh.setTotal(sh.getTotal()+i.getprice());
				shoppingCartDao.update(sh.getCartId(), sh.getTotal(),sh.getTotalnumber());
			}
			break;
			//减1
		case 1:
			if(salingNumber>1){
				salingNumber=salingNumber-1;
				c.setTradingNumbers(salingNumber);
				c.setTotalPrice(salingNumber*i.getprice());
				cartItemDao.update(c);
				sh.setTotal(sh.getTotal()-i.getprice());
				shoppingCartDao.update(sh.getCartId(), sh.getTotal(),sh.getTotalnumber());
			}
			break;
		default:
			break;
		}
		}	
	}
	/*****
	 * 挑选购物车中商品去结算
	 * */
	public CartList payingCart(Integer[] cartItemId){
		
		CartList clist=new CartList();
		ShoppingCart sh=new ShoppingCart();
		List<CartItem> cl=new ArrayList<CartItem>();
		double total=0; //总计
		int totalNumber=0; //购买总数
		for(int i=0;i<cartItemId.length;i++){
			CartItem c = cartItemDao.find(cartItemId[i]);
			cl.add(c);
			
			//更新小计和购买数量
			Item ii=c.getItem();
			int number=ii.getnumber();//商品库存
			int number1=c.getTradingNumbers();//购物车中此件商品的数量
			if(number1<=number){
				totalNumber++;
				total=total+c.getTotalPrice();
			}
		
		}
		sh.setTotal(total);
		sh.setTotalnumber(totalNumber);
		clist.setSh(sh);
		clist.setCa(cl);
		return clist;
	}
	
	/***
	 *提交订单、下单
	 *并删除购物车 
	 */
	public Order commitOrder(List<CartItem> ca,int userId,String addr,int payAway){
		Order o=new Order();
		List<OrderDetail> or=new ArrayList<OrderDetail>();
		String orderNumber=new OrderServiceImpl().createOrderNum();
		double actulPayment=0;
		int totalQuantity=0;
		for(CartItem c:ca){
			OrderDetail ord=new OrderDetail();
			int itemId=c.getItemId();
			Item iii=itemDao.FindItemById(itemId);
			ord.setItemId(c.getItemId());//商品编号
			ord.setItemNumbers(c.getTradingNumbers()); //此间商品的购买数量
			ord.setItemPrice(c.getTotalPrice()); //此件商品的销售额
			ord.setOrderNumber(orderNumber);//订单编号
			ord.setShopName(c.getShopName());//此商品所属顶铺名称
			ord.setShop_id(iii.getshop_id());//店铺id
			ord.setMark(0);//此商品处于待评价状态
			ord.setFlag(0);//未发货
			totalQuantity++;
			actulPayment=actulPayment+c.getTotalPrice();
			or.add(ord);
		}
		o.setUserID(userId);  //用户编号
		o.setOrderNumber(orderNumber); //订单编号
		o.setOrderTime(new Timestamp(new Date().getTime()));//下单时间
		/**
		 * 判断支付方式
		 * */
	
		o.setPaymentMethod("网银支付"); //支付方式
	
		
		o.setStatus("待付款");  //订单状态
		o.setTotalQuantity(totalQuantity); //购买总数
		o.setActulPayment(actulPayment); //支付总额
		o.setRecivingAddress(addr); //收货地址
		orderDao.add(o);// 插入订单到order表
		for(OrderDetail or1:or){
			orderDetailDao.add(or1); //插入订单细目ordetail表
			
		}
		/******
		 * 从购物车清除这些已下单的商品
		 * **/
		for(CartItem cc:ca){
			int cartItemId=cc.getCartItemId();
			deleteItem(userId,cartItemId);
			/**
			 * 更新商品库存
			 * */
			Item i=itemDao.FindItemById(cc.getItemId());
			int number=i.getnumber();
			number=number-cc.getTradingNumbers();
			i.setnumber(number);
			itemDao.ItemUpdate(i);
		}
		return o;
	}
}
