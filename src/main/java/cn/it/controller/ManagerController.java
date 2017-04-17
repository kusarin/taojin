package cn.it.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Manager;
import cn.it.pojo.Shop;
import cn.it.service.ManagerService;
import cn.it.service.ShopService;
/**
 * 
 * @author sunchen
 *
 */

@Controller
public class ManagerController {
	@Resource
	private ManagerService managerService;
	@Resource
	private ShopService shopService;
	
	@RequestMapping("mlogin.do")
	public ModelAndView login(Manager manager,HttpSession session){
		ModelAndView result = managerService.login(manager,session);
		return result;
	}
	
	@RequestMapping("addmanager.do")
	public ModelAndView add(Manager manager){
		ModelAndView result = managerService.add(manager);
		return result;
	}
	
	@RequestMapping("updatepassword.do")
	public ModelAndView updatepassword(Manager manager){
		ModelAndView result = managerService.update(manager);
		return result;
	}
	
	@RequestMapping("lookSR.do")
	public ModelAndView lookSR(){
		ModelAndView mav = new ModelAndView("lookSR");
		List<Shop> SR;
		SR = shopService.findSR();
		mav.addObject("SR",SR);
		return mav;
	}
}
