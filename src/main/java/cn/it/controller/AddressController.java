package cn.it.controller;//Address

import java.util.List;

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
		result.setViewName("redirect:addressList.do");
		return result;
	}
	
	// 添加地址
		@RequestMapping("deleteAddress.do")
		public ModelAndView deleteAddress(Address address, HttpSession session) {
			ModelAndView result = AddressService.delete(address, session);
			result.setViewName("redirect:addressList.do");
			return result;
		}
		
	// 返回当前用户的收货地址列表
	@RequestMapping("addressList.do")
	public ModelAndView getShoplist(Address address, HttpSession session) {
		ModelAndView modelandview = new ModelAndView("address");
		List<Address> list;
		list = AddressService.findById(session);
		modelandview.addObject("addressList", list);
		return modelandview;
	}
}
