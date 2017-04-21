package cn.it.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Service;

import cn.it.dao.AddressDao;
import cn.it.pojo.Address;
import cn.it.pojo.Users;
import cn.it.service.AddressService;

@Service("AddressService")
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;
	
	public ModelAndView add(Address address, HttpSession session) {
		ModelAndView str = new ModelAndView("address");
		Users user = (Users)session.getAttribute("user");
		List<Address> addresslist = addressDao.addressFind(user.getUser_ID());
		for (Address ad : addresslist) {
			if (ad.getAddr().equalsIgnoreCase(address.getAddr())) {
				str.addObject("error", "该地址已存在");
				break;
			}
		}
		addressDao.addressAdd(address);
		return str;
	}

	public ModelAndView delete(Address address, HttpSession session) {
		ModelAndView str = new ModelAndView("address");
		addressDao.addressDelete(address);
		return str;
	}
	
	public List<Address> findById(HttpSession session) {
		Users user = (Users)session.getAttribute("user");
		return addressDao.addressFind(user.getUser_ID());
	}
}
