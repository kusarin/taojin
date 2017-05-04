package cn.it.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




























import cn.it.pojo.Address;
import cn.it.pojo.Item;
import cn.it.pojo.Order;
import cn.it.pojo.OrderCollection;
import cn.it.pojo.OrderDetail;
import cn.it.pojo.Page;
import cn.it.pojo.Users;
import cn.it.service.OrderService;
import cn.it.service.UsersService;


/**
 * 对订单信息进行控制
 * 
 */

@Controller
public class OrderController {
	@Resource
	private OrderService orderService;
	@Autowired
	private UsersService usersService;
	/*******
	 * 提交订单、下单
	 * @param(address表示收货地址，orderCollection表示订单信息，payway表示支付方式)
	 * */
	@RequestMapping(value="submitOrder.do", method=RequestMethod.POST)
	public String submmitOrder(String addr,OrderCollection orderCollection,HttpSession session){
		
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		Order order= orderService.submmitOrder(addr, orderCollection,userId);
		String orderNumber=order.getOrderNumber();//订单编号
		double total=order.getActulPayment(); //支付总额
		return "redirect:payment.do?p2_Order="+orderNumber+"&p3_Amt="+total;
	}
	
   /***
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
	 * 更新商品的
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
	public ModelAndView removeRecord(Page<OrderCollection> page,HttpSession session){

		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		
		ModelAndView v=new ModelAndView("removeRecord");
		v.addObject("pages",orderService.getOrder(userId,"已取消", page));
		
		v.addObject("pendingPayment",orderService.countNumbers(userId, "待付款"));
		//v.addObject("receivingGoods",orderService.countNumbers(userId, "待收货"));
		//v.addObject("assessment",orderService.countNumbers(userId, "待评价"));
		v.addObject("Payment",orderService.countNumbers(userId, "已付款"));
		return v;
	}
	
	/***
	 *待付款
	 *订单 
	 * */
	@RequestMapping("pendingPayment.do")
	public ModelAndView pendingPayment(Page<OrderCollection> page,HttpSession session){
		
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		ModelAndView v=new ModelAndView("pendingPayment");
		v.addObject("pages",orderService.getOrder(userId,"待付款", page));
		
		v.addObject("pendingPayment",orderService.countNumbers(userId, "待付款"));
		//v.addObject("receivingGoods",orderService.countNumbers(userId, "待收货"));
		//v.addObject("assessment",orderService.countNumbers(userId, "待评价"));
		v.addObject("Payment",orderService.countNumbers(userId, "已付款"));
		return v;
	}
	
	/***
	 *已付款
	 *订单 
	 * */
	@RequestMapping("payedGoods.do")
	public ModelAndView payedGoods(Page<OrderCollection> page,HttpSession session){
		
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		
		ModelAndView v=new ModelAndView("payedGoods");
		v.addObject("pages",orderService.getOrder(userId,"已付款", page));
		
		v.addObject("pendingPayment",orderService.countNumbers(userId, "待付款"));
		//v.addObject("receivingGoods",orderService.countNumbers(userId, "待收货"));
		//v.addObject("assessment",orderService.countNumbers(userId, "待评价"));
		v.addObject("Payment",orderService.countNumbers(userId, "已付款"));
		return v;
	}
	/***
	 *待评价
	 *订单 
	 * */
	@RequestMapping("pendingEvaluation.do")
	public ModelAndView saledGoods(Page<OrderCollection> page,HttpSession session){
		
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
	
		ModelAndView v=new ModelAndView("pendingEvaluation");
		v.addObject("pages",orderService.getOrder(userId,"待评价", page));
		
		v.addObject("pendingPayment",orderService.countNumbers(userId, "待付款"));
		v.addObject("receivingGoods",orderService.countNumbers(userId, "待收货"));
		v.addObject("assessment",orderService.countNumbers(userId, "待评价"));
		return v;
	}
	/*
	 * 评价订单
	 * */
	@RequestMapping("evlauateItem.do")
	public ModelAndView evlauateItem(int itemId){
		
		ModelAndView v=new ModelAndView("pendingEvaluation");
		Item it=orderService.evalOrder(itemId);
		v.addObject("it", it);
		return v;
	}
	/**
	 *提交评价 
	 * */
	@RequestMapping(value="commitEval.do",method=RequestMethod.POST)
	public String commitEval(int itemId,int score,String content,HttpSession session){
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		orderService.commitEvaluation(itemId, userId, score, content);
		return "redirect:orderItem.do";
	}
	/*******
	 * 查看订单详情
	 * */
	@RequestMapping("lookOrderDeatil.do")
	public ModelAndView lookOrderDeatil(String orderNumber,HttpSession session){
		ModelAndView view=new ModelAndView("orderInfo");
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		view.addObject("order",orderService.getOrderDetail(orderNumber));
		
		view.addObject("username",usersService.findById(userId).getName());
		return view;
	}
	
	/*********
	 * 查看所有订单
	 * 
	 * */
	@RequestMapping(value="orderItem.do")
	public ModelAndView lookAllOrder(HttpServletRequest request,Page<OrderCollection> page,HttpSession session){
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		
		ModelAndView view=new ModelAndView("orderItem");
		view.addObject("pages",orderService.getAllOrder(userId, page));
		view.addObject("pendingPayment",orderService.countNumbers(userId, "待付款"));
		view.addObject("receivingGoods",orderService.countNumbers(userId, "待收货"));
		view.addObject("assessment",orderService.countNumbers(userId, "待评价"));
		return view;
	}
	
	/***
	 * 确认订单信息
	 * 
	 * */
	@RequestMapping("sureOrder.do")
	public ModelAndView sureOrder(int itemId,String number,HttpSession session){
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		int number1=Integer.parseInt(number);
		ModelAndView view =new ModelAndView("sureOrder");
		OrderCollection collection=orderService.sureOrder(itemId, userId, number1);
		view.addObject("c", collection);
		List<Address> address=orderService.getAddress(userId);
		view.addObject("address",address);
		view.addObject("username",usersService.findById(userId).getName());
		return view;
	}
	/****
	 * 新增收货地址
	 * @throws UnsupportedEncodingException 
	 * */
	@RequestMapping("addAdr.do")
	@ResponseBody
	public Map<String,Object> addAdr(HttpServletRequest request,HttpSession session)throws UnsupportedEncodingException{
		Map<String,Object> map=new HashMap<String,Object>();
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		String addr1=request.getParameter("addr");
		String addr2=new String(addr1.getBytes("ISO-8859-1"), "utf-8");
		orderService.addAddr(addr2, userId);
		map.put("msg", "添加成功");
		return map;
		
	}
	/***
	 * 立即支付
	 * */
	@RequestMapping("paymenting.do")
	public String paymenting(String orderNumber){
		Order order= orderService.findOrder(orderNumber);
		double total=order.getActulPayment(); //支付总额
		return "redirect:payment.do?p2_Order="+orderNumber+"&p3_Amt="+total;
	}
}
