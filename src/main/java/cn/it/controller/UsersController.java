package cn.it.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.it.service.UsersService;
import cn.it.pojo.Users;
/**
	 * @author wz
	 */
@Controller
public class UsersController {
	 @Resource
	 private UsersService usersService;

	@RequestMapping("login.do")
	public ModelAndView login(Users user,HttpSession session) 
			throws IOException{
	
		ModelAndView result = usersService.login(user,session);
		return result;
	}
	//添加用户
		@RequestMapping("addUser.do")
		public String addUser(Users user){
			String result = usersService.add(user);
			return result;
		}
	   //删除用户
		@RequestMapping("deleteUser")
		public ModelAndView deleteUser(int userId){
			return null;
		}
		//查询用户
		@RequestMapping("searchUser")
		public ModelAndView searchUser(int userId){
			return null;
			
		}
		
	}