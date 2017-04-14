package cn.it.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;













import cn.it.pojo.Address;
import cn.it.pojo.OrderCollection;
import cn.it.pojo.OrderDetail;
import cn.it.service.OrderService;


/**
 * 对订单信息进行控制
 * 
 */

@Controller
public class OrderController {
	@Resource
	private OrderService orderService;
	
	
	/*******
	 * 提交订单、下单
	 * @param(address表示收货地址，orderCollection表示订单信息，payway表示支付方式)
	 * */
	@RequestMapping(value="submitOrder.do", method=RequestMethod.POST)
	public ModelAndView submmitOrder(Address address,OrderCollection orderCollection, int payway){
		ModelAndView view=new ModelAndView("payment");
		int userId=1;   //用户Id
		orderService.submmitOrder(address, orderCollection,payway,userId);
		
		view.addObject("address", address.getReceivingaddress());
		view.addObject("actulpayment",orderCollection.getOrder().getActulPayment());
		List<OrderDetail> orderDe=orderCollection.getOrderDeatail();
		view.addObject("orderDe",orderDe);
		view.addObject("payway",payway);
		return view;
	}
	
   /***********
    * 删除订单
    * */
	@RequestMapping("deleteOrder.do")
	public ModelAndView deleteOrder(String orderNumber){
		ModelAndView view=new ModelAndView("orderItem");
		orderService.deleteOrder(orderNumber);
		return view;
	}
	
	/*******
	 * 查看订单详情
	 * */
	@RequestMapping("lookOrderDeatil.do")
	public ModelAndView lookOrderDeatil(String orderNumber){
		ModelAndView view=new ModelAndView("orderInfo");
		OrderCollection collection=orderService.getOrderDetail(orderNumber);
		view.addObject("orderDetail",collection);
		return view;
	}
	
	/*********
	 * 查看所有订单
	 * 
	 * */
	@RequestMapping("orderItem.do")
	public ModelAndView lookAllOrder(HttpServletRequest request){
		//获取用户账号
      //int num1=(Integer)(request.getSession().getAttribute("num"));
		
		int userId=1;
		ModelAndView view=new ModelAndView("orderItem");
		List<OrderCollection> collectList =new ArrayList<OrderCollection>();		
		//collectList=orderService.getAllOrder(userId);
		view.addObject("orderList",collectList);
		return view;
	}
	
	/***
	 * 确认订单信息
	 * 
	 * */
	@RequestMapping("sureOrder.do")
	public ModelAndView sureOrder(int itemId,int number){
		int userId=1;
		ModelAndView view =new ModelAndView("sureOrder");
		OrderCollection collection=orderService.sureOrder(itemId, userId, number);
		view.addObject("c", collection);
		Address address=orderService.getAddress(userId);
		view.addObject("address",address);
		return view;
	}
}
