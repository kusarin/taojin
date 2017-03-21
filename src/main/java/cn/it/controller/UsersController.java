package cn.it.controller;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.it.service.UsersService;
import cn.it.pojo.Users;
/**
	 * @author wz
	 */
public class UsersController {
	
	 private UsersService usersService;
 
	@RequestMapping("login.do")//http://localhost:8080/Taojin/login.do
	public String login(Users user,Map<String,Object> map,Model model,ModelMap maps){
		String result = usersService.login(user,map);
		return result;
	}
	//添加用户
		@RequestMapping("addUser")
		public ModelAndView addUser(Users user){
			return null;
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