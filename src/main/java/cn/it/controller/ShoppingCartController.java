package cn.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.CartList;
import cn.it.service.OrderService;
import cn.it.service.ShoppingCartService;


@Controller
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private OrderService orderService;
	/***
	 * 添加商品到购物车
	 * */
	@RequestMapping("index.do")
	public void addItem(int number,int itemId){
		int userId=1;
		shoppingCartService.addItemToCart(userId, number, itemId);
		return;
	}
	/********
	 *显示购物车所有商品 
	 */
	@RequestMapping("showCartAllItem.do")
	public ModelAndView showCartAllItem(){
		int userId=1;
		ModelAndView v=new ModelAndView("ShoppingCart");
		v.addObject("clist", shoppingCartService.getAllItem(userId));
		return v;
	}
	/******
	 *删除购物车中的商品
	 *或删除购物车 
	 */
	@RequestMapping("deleteCart.do")
	public String deleteCart(int cartItemId){
		
		 int userId=1;
		
		 shoppingCartService.deleteItem(userId, cartItemId);
         return "redirect:showCartAllItem.do";
	}
	/******
	 * 更新购物车中商品数量
	 * */
	@RequestMapping("updateNumberAndTotal.do")
	public String updateNumberAndTotal(int itemId, int flag){
		int userId=1;
		shoppingCartService.updatePriceAndTotal(userId, itemId, flag);
		
		return "redirect:showCartAllItem.do";
	}
	/*****
	 * 挑选购物车中商品去结算
	 * 跳转到结算页
	 * */
	@RequestMapping(value="payingCart.do",method=RequestMethod.POST)
	public ModelAndView payingCart(Integer[] cartItemId){
		int userId=1;
		ModelAndView v=new ModelAndView("payingCart");
		v.addObject("cl", shoppingCartService.payingCart(cartItemId));
		v.addObject("address", orderService.getAddress(userId));
		return v;	
	}
	/*****
	 * 提交订单、删除购物车中已下单的商品
	 * */
	@RequestMapping(value="commitOrderDeCart.do",method=RequestMethod.POST)
	public ModelAndView commitOrderDeCart(CartList cartList,String addr,int payAway){
		
		int userId=1;
		ModelAndView v=new ModelAndView("payment");
		v.addObject("order", shoppingCartService.commitOrder(cartList.getCa(), userId,addr,payAway));
		return v;
	}
	
}
