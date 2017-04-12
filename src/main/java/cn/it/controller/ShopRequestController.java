package cn.it.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.ShopRequest;
import cn.it.service.ShopRequestService;

@Controller
public class ShopRequestController {
	@Resource
	private ShopRequestService shopRequestService;
	
	@RequestMapping("findSR")
	public ModelAndView findSR(){
		ModelAndView mav = new ModelAndView("");
		List<ShopRequest> sr;
		sr = shopRequestService.findAll();
		mav.addObject("",sr);
		return mav;
	}
	@RequestMapping("deleteSR")
	public ModelAndView deleteSR(int num){
		ModelAndView mav = new ModelAndView("");
		shopRequestService.delete(num);
		return mav;
	}
	@RequestMapping("passSR")
	public ModelAndView passSR(int num){
		ModelAndView mav = new ModelAndView("");
		shopRequestService.passSR(num);
		return mav;
	}
}
