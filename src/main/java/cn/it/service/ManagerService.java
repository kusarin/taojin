package cn.it.service;

import cn.it.pojo.Manager;
/**
 * 
 * @author sunchen
 *
 */
public interface ManagerService {
	//管理员登录方法的定义
	public String login(Manager manager);

	public String add(Manager manager);
	
	
}
