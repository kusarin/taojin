package cn.it.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.ShopRequest;
import cn.it.service.ShopRequestService;

@Controller
public class ShopRequestController {
	@Resource
	private ShopRequestService shopRequestService;
	
	@RequestMapping("lookSR")
	public ModelAndView lookSR(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("lookSR");
		List<ShopRequest> sr;
		sr = shopRequestService.findAll();
		mav.addObject("ShopRequest",sr);
		return mav;
	}
	@RequestMapping("deleteSR")
	public String deleteSR(@RequestParam("id") String id){
		int num = Integer.parseInt(id);
		shopRequestService.delete(num);
		return "redirect:lookSR.do";
	}
	@RequestMapping("passSR")
	public ModelAndView passSR(@RequestParam("id") String id){
		ModelAndView mav = new ModelAndView("lookSR");
		int num = Integer.parseInt(id);
		shopRequestService.passSR(num);
		mav.setViewName("redirect:lookSR.do");
		return mav;
	}
	@RequestMapping("findSR")
	public ModelAndView findSR(@RequestParam("id") String id){
		ModelAndView mav = new ModelAndView("lookSR");
		int num = Integer.parseInt(id);
		ShopRequest sr = shopRequestService.find(num);
		mav.addObject("SR",sr);
		return mav;
	}
}
