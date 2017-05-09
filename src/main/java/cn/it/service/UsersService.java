package cn.it.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Users;

public interface UsersService {

	public ModelAndView login(Users user, HttpSession session)
			throws IOException;

	public ModelAndView add(Users user);

	public ModelAndView update(Users user, HttpServletRequest request,
			HttpSession session, MultipartFile picture);

	public ModelAndView changepw(Users user, HttpSession session);

	public Users findById(int userid);

	public List<Users> findAll();

	public ModelAndView logout(Users user, HttpSession session);

	// public ModelAndView tologin();
}
