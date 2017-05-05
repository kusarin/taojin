package cn.it.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.it.service.OrderService;


@Controller
public class BackController{

	@Autowired
	private OrderService orderService;
	/**
	 * 支付成功
	 */
	private static final long serialVersionUID = 1L;
	
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		this.doPost(request, response);
//	}
	
	@RequestMapping("surePayment.do")
	public void surePayment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String r1_Code = request.getParameter("r1_Code");
			PrintWriter pw = response.getWriter();
			if("1".equals(r1_Code))
			{
				String p1_MerId = request.getParameter("p1_MerId");
				String r3_Amt = request.getParameter("r3_Amt");
				String r6_Order = request.getParameter("r6_Order");
				String rp_PayDate = request.getParameter("rp_PayDate");
				//修改订单状态
				orderService.changeOrderStatus(1, r6_Order);
				pw.println("支付成功！<br/>"
						+"商户编号："+p1_MerId+"<br/>"
						+"支付金额："+r3_Amt+"<br/>"
						+"订单号："+r6_Order+"<br/>"
						+"支付成功时间："+rp_PayDate);
			}
			else
			{
				pw.println("支付失败！");
			}
	}

}
