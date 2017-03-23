package cn.it.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ModelAndView submitOrder(Order order){
		return null;
	}
   //删除订单
	@RequestMapping("deleteOrder.do")
	public ModelAndView deleteOrder(int orderId){
		return null;
	}
	//查看订单详情
	@RequestMapping("lookOrderDeatil.do")
	public ModelAndView lookOrderDeatil(int orderId){
		return null;
	}
	//某用户的所有订单
	@RequestMapping("orderItem.do")
	public ModelAndView lookAllOrder(HttpServletRequest request){
		//获取session域中的值
//	    int num1=(Integer)(request.getSession().getAttribute("num"));
		
		int num=1;//用户编号
		ModelAndView view=new ModelAndView("orderItem");
		List<Order> order=orderService.getAllOrder(num);//获取所有订单
		List<OrderDetail> delist=orderService.getALLItem(num);//获取订单明细
		List<OrderCollection> collectList =new ArrayList<OrderCollection>();//创建OrderCollecton容器
		
		collectList=orderService.mergeList(order, delist);
		view.addObject("orderList",collectList);
		return view;
	}
}
