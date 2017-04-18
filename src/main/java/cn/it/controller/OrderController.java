package cn.it.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;













import cn.it.pojo.Address;
import cn.it.pojo.OrderCollection;
import cn.it.pojo.OrderDetail;
import cn.it.pojo.Page;
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
		System.out.println(orderCollection.getOrder().getTotalQuantity());
		int userId=1;   //用户Id
		orderService.submmitOrder(address, orderCollection,payway,userId);
		
		view.addObject("address", address.getAddr());
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
	public String deleteOrder(String orderNumber, RedirectAttributes arr, Page<OrderCollection> page){
		
		orderService.deleteOrder(orderNumber);
		arr.addAttribute("pageNo", page.getPageNo());
		return "redirect:orderItem.do";
	}
	/**
	 * 批量删除
	 * */
	@RequestMapping(value="deleteAllOrder.do",method=RequestMethod.POST)
	public String deleteAllOrder(String[] orderNumber,RedirectAttributes arr, Page<OrderCollection> page){
		orderService.deleteAllOrder(orderNumber);
		arr.addAttribute("pageNo", page.getPageNo());
		return "redirect:orderItem.do";
	}
	/*******
	 * 
	 * 取消订单
	 * @param(flag标记购买操作进行到那一步)
	 * */
	@RequestMapping(value="removeOrder.do")
	public String removeOrder(int flag,String orderNumber){
		
		orderService.remove(flag,orderNumber);
		return "redirect:orderItem.do";
		
	}
	
	/***
	 *已取消的
	 *订单记录 
	 * */
	@RequestMapping("removeRecord.do")
	public ModelAndView removeRecord(Page<OrderCollection> page){
		int userId=1;
		
		ModelAndView v=new ModelAndView("removeRecord");
		v.addObject("pages",orderService.getOrder(userId,"已取消", page));
		return v;
	}
	
	/***
	 *待付款
	 *订单 
	 * */
	@RequestMapping("pendingPayment.do")
	public ModelAndView pendingPayment(Page<OrderCollection> page){
		int userId=0;
		int flag=0;
		ModelAndView v=new ModelAndView("orderItem");
		v.addObject("page",orderService.getOrder(userId,"待付款", page));
		v.addObject("flag", flag);
		return v;
	}
	
	/***
	 *待收货
	 *订单 
	 * */
	@RequestMapping("receivingGoods.do")
	public ModelAndView receivingGoods(Page<OrderCollection> page){
		int userId=1;
		int flag=1;
		ModelAndView v=new ModelAndView("orderItem");
		v.addObject("page",orderService.getOrder(userId,"待收货", page));
		v.addObject("flag", flag);
		return v;
	}
	/***
	 *已完成交易
	 *订单 
	 * */
	@RequestMapping("saledGoods.do")
	public ModelAndView saledGoods(Page<OrderCollection> page){
		int userId=1;
		int flag=3;
		ModelAndView v=new ModelAndView("orderItem");
		v.addObject("page",orderService.getOrder(userId,"已完成", page));
		v.addObject("flag", flag);
		return v;
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
	@RequestMapping(value="orderItem.do")
	public ModelAndView lookAllOrder(HttpServletRequest request,Page<OrderCollection> page){
		//获取用户账号
      //int num1=(Integer)(request.getSession().getAttribute("num"));
		
		int userId=1;
		ModelAndView view=new ModelAndView("orderItem");
	    
		view.addObject("pages",orderService.getAllOrder(userId, page));
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
