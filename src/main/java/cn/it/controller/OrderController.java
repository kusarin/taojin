package cn.it.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;









import cn.it.pojo.Order;
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
	
	
	//提交订单
	@RequestMapping("/submitOrder.do")
	public ModelAndView submitOrder(@RequestParam int itemId){
		ModelAndView view=new ModelAndView("pay");
		itemId=1;  //商品编号
		int payLabel=0; //支付方式标记
		String address="";  //收货地址
		int userId=1;   //用户Id
		orderService.submmitOrder(itemId, payLabel, address, userId);
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
		view.addObject("orderNumber",collection);
		return view;
	}
	//查看所有订单
	@RequestMapping("orderItem.do")
	public ModelAndView lookAllOrder(HttpServletRequest request){
		//获取用户账号
      //int num1=(Integer)(request.getSession().getAttribute("num"));
		
		int userId=1;
		ModelAndView view=new ModelAndView("orderItem");
		List<Order> order=orderService.getAllOrder(userId);
		List<OrderDetail> delist=orderService.getAllOrderDetail(userId);
		List<OrderCollection> collectList =new ArrayList<OrderCollection>();		
		collectList=orderService.mergeList(order, delist);
		view.addObject("orderList",collectList);
		return view;
	}
}
