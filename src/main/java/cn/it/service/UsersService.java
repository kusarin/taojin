package cn.it.service;

import javax.servlet.http.HttpSession;

import cn.it.pojo.Users;

public interface UsersService {
  
	 public String login(Users user,HttpSession session);
	 
	 public String add(Users user);
}
