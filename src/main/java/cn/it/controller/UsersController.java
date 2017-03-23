package cn.it.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
 
	@RequestMapping("login.do")//http://localhost:8080/Taojin/login
	public String login(String username,String password,Map<String,Object> map){
		String result = usersService.login(username,password,map);
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