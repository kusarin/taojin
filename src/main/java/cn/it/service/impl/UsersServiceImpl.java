package cn.it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.it.dao.UsersDao;
import cn.it.pojo.Manager;
import cn.it.pojo.Users;
import cn.it.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDao usersDao;
	
	@SuppressWarnings("null")
	public String login(Users user) {
		String str = "welcome";
		if(user==null){
			if(user.getUsername().equals("")||user.getUsername()==null||user.getPassword().equals("")||user.getPassword()==null){
				str = "login";
			}
		}else{
			Users u = usersDao.login(user);
			if(u == null){
				str = "login";
			}
		}
		return str;
	}

	public String add(Users user) {
		String str = "register";
		List<Users> userlist =usersDao.UsersFind();
		Boolean flag = true;
		for(Users u:userlist){
			if(u.getUsername().equalsIgnoreCase(user.getUsername())){
				flag = false;
				break;
			}
		}
		if(user.getUsername()==null||user.getUsername().equalsIgnoreCase("")||
				user.getPassword()==null||user.getPassword().equalsIgnoreCase("")){
			flag = false;
		}else if(flag){
			usersDao.UsersAdd(user);
			str = "login";
		}
		return str;
	}
}