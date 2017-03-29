package cn.it.service.impl;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import cn.it.dao.UsersDao;
import cn.it.pojo.Users;
import cn.it.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDao usersDao;
	
	public ModelAndView login(Users user,HttpSession session) 
	throws IOException{
		ModelAndView str = new ModelAndView("welcome");
			if(user.getUsername().equals("")||user.getUsername()==null||
			user.getPassword().equals("")||user.getPassword()==null){
				str.addObject("error", "用户名或密码为空");
				str.setViewName("login");
		}else{
			Users u = usersDao.login(user);
			if(u == null){
				str.addObject("error", "用户名或密码错误");
				str.setViewName("login");
			}else{
				session.setAttribute("user", u);
			}
		}
		
		return str;
	}

	public ModelAndView add(Users user) {
		ModelAndView str = new ModelAndView("register");
		List<Users> userlist =usersDao.UsersFind();
		Boolean flag = true;
		for(Users u:userlist){
			if(u.getUsername().equalsIgnoreCase(user.getUsername())){
				flag = false;
				str.addObject("error", "用户名重复");
				break;
			}
		}
		if(user.getUsername()==null||user.getUsername().equalsIgnoreCase("")||
				user.getPassword()==null||user.getPassword().equalsIgnoreCase("")){
			str.addObject("error", "用户名或密码为空");
			flag = false;
		}else if(flag){
			usersDao.UsersAdd(user);
			str.setViewName("login");
		}
		return str;
	}
	public ModelAndView update(Users user){
		return null;
		
	}
}