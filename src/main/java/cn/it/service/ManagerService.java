package cn.it.service;

import cn.it.pojo.Manager;
/**
 * 
 * @author sunchen
 *
 */
public interface ManagerService {
	//管理员登录方法的定义
	public String login(String account,String password);
	//新增管理员的方法的定义
	public String add(String account,String password);
	
}
