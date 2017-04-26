package cn.it.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.CartList;
import cn.it.pojo.Order;
import cn.it.pojo.Users;
import cn.it.service.OrderService;
import cn.it.service.ShoppingCartService;
import cn.it.service.UsersService;


@Controller
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UsersService usersService;
	/***
	 * 添加商品到购物车
	 * */
	@RequestMapping("index.do")
	public String addItem(String number,int itemId,HttpSession session){
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		int number1=Integer.parseInt(number);
		shoppingCartService.addItemToCart(userId, number1, itemId);
		return "redirect:lookItem.do?id="+itemId;
	}
	/********
	 *显示购物车所有商品 
	 */
	@RequestMapping("showCartAllItem.do")
	public ModelAndView showCartAllItem(HttpSession session){
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		ModelAndView v=new ModelAndView("ShoppingCart");
		v.addObject("clist", shoppingCartService.getAllItem(userId));
		return v;
	}
	/******
	 *删除购物车中的商品
	 *或删除购物车 
	 */
	@RequestMapping("deleteCart.do")
	public String deleteCart(int cartItemId,HttpSession session){
		
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		
		 shoppingCartService.deleteItem(userId, cartItemId);
         return "redirect:showCartAllItem.do";
	}
	/******
	 * 更新购物车中商品数量
	 * */
	@RequestMapping("updateNumberAndTotal.do")
	public String updateNumberAndTotal(int itemId, int flag,HttpSession session){
		
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		shoppingCartService.updatePriceAndTotal(userId, itemId, flag);
		
		return "redirect:showCartAllItem.do";
	}
	/*****
	 * 挑选购物车中商品去结算
	 * 跳转到结算页
	 * */
	@RequestMapping(value="payingCart.do",method=RequestMethod.POST)
	public ModelAndView payingCart(Integer[] cartItemId,HttpSession session){
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		ModelAndView v=new ModelAndView("payingCart");
		v.addObject("cl", shoppingCartService.payingCart(cartItemId));
		v.addObject("address", orderService.getAddress(userId));
		v.addObject("username",usersService.findById(userId).getName());
		return v;	
	}
	/*****
	 * 提交订单、删除购物车中已下单的商品
	 * */
	@RequestMapping(value="commitOrderDeCart.do",method=RequestMethod.POST)
	public String commitOrderDeCart(CartList cartList,String addr,int payAway,HttpSession session){
		
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		
	    Order order= shoppingCartService.commitOrder(cartList.getCa(), userId,addr,payAway);
	    
	    String orderNumber=order.getOrderNumber();//订单编号
	    
		double total=order.getActulPayment(); //支付总额
		
		return "redirect:payment.do?p2_Order="+orderNumber+"&p3_Amt="+total;
		
	}
	
}
