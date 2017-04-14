package cn.it.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Manager;
import cn.it.service.ManagerService;
/**
 * 
 * @author sunchen
 *
 */

@Controller
public class ManagerController {
	@Resource
	private ManagerService managerService;
	
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
}
