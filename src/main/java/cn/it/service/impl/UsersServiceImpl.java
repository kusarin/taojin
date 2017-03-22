package cn.it.service.impl;

import java.util.Map;

import cn.it.dao.UsersDao;

public class UsersServiceImpl {
	private UsersDao usersdao;
	public String login(String username,String password,Map<String,Object> map) {
		String str = "success";
		if(username==null||username.equals("")||password==null||password.equals("")){
			str = "login";
			map.put("error", "用户名或密码为空");
		}else{
			usersdao.login(username, password);
		}
		
		return null;
	}
}
