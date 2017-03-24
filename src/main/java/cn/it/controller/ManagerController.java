package cn.it.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String login(Manager manager){
		String result = managerService.login(manager);
		return result;
	}
//	@RequestMapping("addmanager.do")
//	public String add(Manager manager){
//		String result = managerService.add(manager);
//		return result;
//	}
}
