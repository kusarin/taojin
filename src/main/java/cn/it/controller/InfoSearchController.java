package cn.it.controller;

import java.io.UnsupportedEncodingException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Users;
import cn.it.service.InfoSearchService;

/****
 * 控制获取参考售价
 * 控制根据关键字获取商品信息
 * 
 * **/
@Controller
public class InfoSearchController {
	
	@Autowired
    private InfoSearchService infoSearchService;

	/*
	 * 获取参考售价
	 * @throws UnsupportedEncodingException 
	 * */
	@RequestMapping("getRefPrice.do")
	@ResponseBody
	public double[] getRefPrice(HttpServletRequest request)throws UnsupportedEncodingException{
//		Map<String,Object> map=new HashMap<String,Object>();
		
		String typel=request.getParameter("typel");
		String typel2=new String(typel.getBytes("ISO-8859-1"), "utf-8");//转化编码格式
		double[] refPrice=infoSearchService.getRefPrice(typel2);
//		map.put("msg", "添加成功");
		return refPrice;
	}
	/*
	 * 关键字搜索记录
	 */
	@RequestMapping("getKeyWords.do")
	public ModelAndView getKeyWords(HttpSession session){
		Users user=(Users) session.getAttribute("user");
		int userId=user.getUser_ID();   //用户Id
		ModelAndView v=new ModelAndView("keywords");
		v.addObject("keyw", infoSearchService.getKeyWords(userId));
		return v;
	}
}
