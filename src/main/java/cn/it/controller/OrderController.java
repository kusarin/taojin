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
 * 瀵硅鍗曚俊鎭繘琛屾帶鍒�
 * 
 */

@Controller
public class OrderController {
	@Resource
	private OrderService orderService;
	//鎻愪氦璁㈠崟
	@RequestMapping("/submitOrder.do")
	public ModelAndView submitOrder(Order order){
		return null;
	}
   //鍒犻櫎璁㈠崟
	@RequestMapping("deleteOrder.do")
	public ModelAndView deleteOrder(int orderId){
		return null;
	}
	//鏌ョ湅璁㈠崟璇︽儏
	@RequestMapping("lookOrderDeatil.do")
	public ModelAndView lookOrderDeatil(int orderId){
		return null;
	}
	//鏌愮敤鎴风殑鎵�湁璁㈠崟
	@RequestMapping("orderItem.do")
	public ModelAndView lookAllOrder(HttpServletRequest request){
		//鑾峰彇session鍩熶腑鐨勫�
//	    int num1=(Integer)(request.getSession().getAttribute("num"));
		
		int num=1;//鐢ㄦ埛缂栧彿
		ModelAndView view=new ModelAndView("orderItem");
		List<Order> order=orderService.getAllOrder(num);//鑾峰彇鎵�湁璁㈠崟
		List<OrderDetail> delist=orderService.getALLItem(num);//鑾峰彇璁㈠崟鏄庣粏
		List<OrderCollection> collectList =new ArrayList<OrderCollection>();//鍒涘缓OrderCollecton瀹瑰櫒		
		collectList=orderService.mergeList(order, delist);
		view.addObject("orderList",collectList);
		return view;
	}
}
