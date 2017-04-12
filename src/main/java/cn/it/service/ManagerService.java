package cn.it.service;


import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Manager;
/**
 * 
 * @author sunchen
 *
 */
public interface ManagerService {
	//管理员登录方法的定义
	public ModelAndView login(Manager manager,HttpSession session);

	public ModelAndView add(Manager manager);
	
	public ModelAndView update(Manager manager);
}
