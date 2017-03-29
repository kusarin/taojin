package cn.it.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
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