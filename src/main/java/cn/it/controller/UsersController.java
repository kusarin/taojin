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
	public ModelAndView login(Users user, HttpSession session)
			throws IOException {

		ModelAndView result = usersService.login(user, session);
		return result;
	}

	// 添加用户
	@RequestMapping("addUser.do")
	public ModelAndView addUser(Users user) {
		ModelAndView result = usersService.add(user);
		return result;
	}

	// 删除用户
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(int userId) {
		return null;
	}

	// 查询用户
	@RequestMapping("searchUser")
	public ModelAndView searchUser(int userId) {
		return null;
	}

	//更新用户信息
	@RequestMapping("updateUser.do")
	public ModelAndView updateUser(Users user, HttpSession session) {
		ModelAndView result = usersService.update(user, session);
		return result;
	}
	
	//更新用户信息
		@RequestMapping("changepw.do")
		public ModelAndView changepw(Users user, HttpSession session) {
			ModelAndView result = usersService.changepw(user, session);
			return result;
		}
}