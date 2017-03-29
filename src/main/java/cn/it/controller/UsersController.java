package cn.it.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

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
	public ModelAndView login(Users user,HttpSession session,HttpServletResponse response) 
			throws IOException{
	
		ModelAndView result = usersService.login(user,session,response);
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