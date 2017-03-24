package cn.it.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.it.dao.UsersDao;
import cn.it.pojo.Users;
import cn.it.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDao usersDao;
	
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

}