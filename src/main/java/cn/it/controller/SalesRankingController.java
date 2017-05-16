package cn.it.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.it.service.SalesRankingService;

/*
 * 销售分类排行榜
 * */
@Controller
public class SalesRankingController {
	@Autowired
	private SalesRankingService salesRankingService;
  /*
   * 获取某一类型的销售分类排行榜
   * */
	@RequestMapping("getSalesRanking.do")
 public ModelAndView getSalesRanking(String typeh) throws UnsupportedEncodingException{
	 ModelAndView v=new ModelAndView("sales");
	 String typeh2=new String(typeh.getBytes("ISO-8859-1"), "utf-8");//转化编码格式
	 
	 System.out.println("商品类型"+typeh2);
	 v.addObject("sales", salesRankingService.getSalesRanking(typeh2));
	return v;
	 
 }
}
