package cn.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Order;

/**
 * 对订单信息进行控制
 * 
 */
@Controller
public class OrderController {
	//提交订单
	@RequestMapping("submitOrder")
	public ModelAndView submitOrder(Order order){
		return null;
	}
   //删除订单
	@RequestMapping("deleteOrder")
	public ModelAndView deleteOrder(int orderId){
		return null;
	}
	//查看订单详情
	@RequestMapping("lookOrderDeatil")
	public ModelAndView lookOrderDeatil(int orderId){
		return null;
		
	}
	
}
