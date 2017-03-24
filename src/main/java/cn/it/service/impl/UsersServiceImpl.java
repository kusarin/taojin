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
	
	public String login(String username,String password) {
		String str = "welcome";
		if(username==null||username.equals("")||password==null||password.equals("")){
			str = "login";
		}else{
			Users user = usersDao.login(username, password);
			if(user == null){
				str = "login";
			}
		}
		
		return str;
	}

}