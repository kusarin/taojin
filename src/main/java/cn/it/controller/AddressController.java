package cn.it.controller;//Address

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Address;
import cn.it.service.AddressService;

/**
 * @author wz
 */
@Controller
public class AddressController {
	@Resource
	private AddressService AddressService;

	// 添加地址
	@RequestMapping("addAddress.do")
	public ModelAndView addAddress(Address address, HttpSession session) {
		ModelAndView result = AddressService.add(address, session);
		return result;
	}
}
