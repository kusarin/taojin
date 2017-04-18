package cn.it.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Address;

public interface AddressService {

	public ModelAndView add(Address address, HttpSession session);


}
