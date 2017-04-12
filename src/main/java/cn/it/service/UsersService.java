package cn.it.service;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Users;

public interface UsersService {

	public ModelAndView login(Users user, HttpSession session)
			throws IOException;

	public ModelAndView add(Users user);

	public ModelAndView update(Users user, HttpSession session);
}
