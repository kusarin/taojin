package cn.it.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.it.dao.UsersDao;
import cn.it.pojo.Users;
import cn.it.service.UsersService;
@Service("usersService")
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDao usersdao;
	public String login(String username,String password,Map<String,Object> map) {
		String str = "welcome";
		if(username==null||username.equals("")||password==null||password.equals("")){
			str = "login";
			map.put("error", "用户名或密码为空");
		}else{
			Users user = usersdao.login(username, password);
			if(user == null){
				str = "login";
				map.put("error", "用户不存在");
			}
		}
		
		return null;
	}
}
