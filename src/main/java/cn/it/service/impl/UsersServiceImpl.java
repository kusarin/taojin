package cn.it.service.impl;

import java.util.List;











import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import org.springframework.test.context.ContextConfiguration;




import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.dao.UsersDao;
import cn.it.pojo.Users;
import cn.it.service.UsersService;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"}) 
@Service("usersService")
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDao usersDao;
	
	public String login(String username,String password) {
		String str = "welcome";
		if(username==null||username.equals("")||password==null||password.equals("")){
			str = "login";
		}else{
			List<Users> user = usersDao.login(username, password);
			if(user == null){
				str = "login";
			}
		}
		
		return str;
	}

}