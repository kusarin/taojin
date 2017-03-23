package cn.it.controller;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Shop;
import cn.it.service.ShopService;
@Controller
public class ShopController {
	@Resource
   private ShopService shopService;
	
	@RequestMapping(value = "/Certify.do")
	public ModelAndView Certify(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Certify");
		return modelAndView;
	}
	@RequestMapping(value ="/Change.do")
	public ModelAndView Change(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Change");
		return modelAndView;
	}
	@RequestMapping(value = "shopList.do")
    public ModelAndView shopList(){
		ModelAndView modelAndView = new ModelAndView("shopList");
		int num = 1;
		List<Shop> list;
		list = shopService.findShopList(num);
		modelAndView.addObject("shopli", list);
		return modelAndView;
	}
}
