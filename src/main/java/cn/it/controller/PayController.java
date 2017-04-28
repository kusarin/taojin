package cn.it.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.it.pojo.Pay_01;



@Controller
public class PayController{
	/**
	 * 支付
	 */
	private static final long serialVersionUID = 1L;
//	public void doGet(HttpServletRequest request,HttpServletResponse response)
//			throws ServletException, IOException{
//		doPost(request,response);
//	}
	@RequestMapping("payment.do")
	public void payment(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
	    request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String p0_Cmd = "Buy";
		String p1_MerId = "10001126856";
		String p2_Order = request.getParameter("p2_Order");
		String p3_Amt = request.getParameter("p3_Amt");
		//System.out.println("输出参数是"+p2_Order+"\t"+p3_Amt);
		String p4_Cur = "CNY";
		String p5_Pid = "";
		String p6_Pcat = "";
		String p7_Pdesc = "";
		String p8_Url = "http://localhost:8080/yibaozhi/surePayment.do";
		String p9_SAF = "";
		String pa_MP = "";
		String pd_FrpId = "ICBC-NET-B2C";
		String pr_NeedResponse = "1";
		
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		String hmac = Pay_01.buildHmac(p0_Cmd,p1_MerId,p2_Order,p3_Amt,p4_Cur,
				p5_Pid,p6_Pcat,p7_Pdesc,p8_Url,p9_SAF,pa_MP,pd_FrpId,pr_NeedResponse,keyValue);
		String url="https://www.yeepay.com/app-merchant-proxy/node?"+
				"&p0_Cmd="+p0_Cmd+
				"&p1_MerId="+p1_MerId+
				"&p2_Order="+p2_Order+
				"&p3_Amt="+p3_Amt+
				"&p4_Cur="+p4_Cur+
				"&p5_Pid="+p5_Pid+
				"&p6_Pcat="+p6_Pcat+
				"&p7_Pdesc="+p7_Pdesc+
				"&p8_Url="+p8_Url+
				"&p9_SAF="+p9_SAF+
				"&pa_MP="+pa_MP+
				"&pd_FrpId="+pd_FrpId+
				"&pr_NeedResponse="+pr_NeedResponse+
				"&hmac="+hmac;
		
		response.sendRedirect(url);
		}

}
