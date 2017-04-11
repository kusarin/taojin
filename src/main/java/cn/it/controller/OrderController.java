package cn.it.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;










import cn.it.pojo.OrderCollection;

import cn.it.service.OrderService;


/**
 * 对订单信息进行控制
 * 
 */

@Controller
public class OrderController {
	@Resource
	private OrderService orderService;
	
	
	//提交订单
	@RequestMapping("/submitOrder.do")
	public ModelAndView submitOrder(OrderCollection orderCollection){
		ModelAndView view=new ModelAndView("payment");
		int itemId = 1;  //商品编号
		int payLabel=0; //支付方式标记
		int userId=1;   //用户Id
		orderService.submmitOrder(itemId, payLabel,userId);
		return view;
	}
   //删除订单
	@RequestMapping("deleteOrder.do")
	public ModelAndView deleteOrder(String orderNumber){
		ModelAndView view=new ModelAndView("orderItem");
		orderService.deleteOrder(orderNumber);
		return view;
	}
	//查看订单详情
	@RequestMapping("lookOrderDeatil.do")
	public ModelAndView lookOrderDeatil(String orderNumber){
		ModelAndView view=new ModelAndView("orderInfo");
		OrderCollection collection=orderService.getOrderDetail(orderNumber);
		view.addObject("orderDetail",collection);
		return view;
	}
	//查看所有订单
	@RequestMapping("orderItem.do")
	public ModelAndView lookAllOrder(HttpServletRequest request){
		//获取用户账号
      //int num1=(Integer)(request.getSession().getAttribute("num"));
		
		int userId=1;
		ModelAndView view=new ModelAndView("orderItem");
		List<OrderCollection> collectList =new ArrayList<OrderCollection>();		
		collectList=orderService.getAllOrder(userId);
		view.addObject("orderList",collectList);
		return view;
	}
	/***
	 * 确认订单信息
	 * 
	 * */
	@RequestMapping("sureOrder.do")
	public ModelAndView sureOrder(int itemId,int userId,int number){
		ModelAndView view =new ModelAndView("sureOrder");
		OrderCollection collection=orderService.sureOrder(itemId, userId, number);
		view.addObject("c", collection);
		return view;
		
	}
}
