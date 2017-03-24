package cn.it.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String login(HttpServletRequest request){
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		String result = managerService.login(account,password);
		return result;
	}
	@RequestMapping("addmanager.do")
	public String add(HttpServletRequest request){
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		String result = managerService.add(account,password);
		return result;
	}
}
