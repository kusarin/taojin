package cn.it.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Manager;
import cn.it.pojo.Shop;
import cn.it.pojo.Users;
import cn.it.service.ManagerService;
import cn.it.service.ShopService;
import cn.it.service.UsersService;
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
	@Resource
	private UsersService usersService;
	
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
	
	@RequestMapping("findSR.do")
	public ModelAndView findSR(@RequestParam("id") String id){
		int id1=Integer.parseInt(id);
		ModelAndView mav = new ModelAndView("findSR");
		Shop sr = shopService.findByid(id1);
		int userid = shopService.findUserId(id1);
		Users u = usersService.findById(userid);
		mav.addObject("sr",sr);
		mav.addObject("user",u);
		return mav;
	}
	
	@RequestMapping("passSR.do")
	public String passSR(@RequestParam("id") String id){
		int id1=Integer.parseInt(id);
		shopService.passSR(id1);
		return "redirect:lookSR.do";
	}
	
	@RequestMapping("refuseSR.do")
	public String refuseSR(@RequestParam("id") String id){
		int id1=Integer.parseInt(id);
		shopService.refuseSR(id1);
		return "redirect:lookSR.do";
	}
}
