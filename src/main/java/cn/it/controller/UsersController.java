package cn.it.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import cn.it.pojo.Users;
/**
	 * @author wz
	 */
public class UsersController {

	
	//添加用户
		@RequestMapping("addUser")
		public ModelAndView submitOrder(Users user){
			return null;
		}
	   //删除用户
		@RequestMapping("deleteUser")
		public ModelAndView deleteOrder(int userId){
			return null;
		}
		//查询用户
		@RequestMapping("searchUser")
		public ModelAndView lookOrderDeatil(int userId){
			return null;
			
		}
		
	}