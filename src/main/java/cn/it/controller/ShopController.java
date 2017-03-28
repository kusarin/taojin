package cn.it.controller;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.regexp.internal.recompile;

import cn.it.pojo.Shop;
import cn.it.pojo.Users;
import cn.it.service.ShopService;
@Controller
public class ShopController {
	@Resource
   private ShopService shopService;
	
	@RequestMapping(value ={"TaoJin/doAdd.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String doAdd(Shop shop){
		shopService.addShop(shop);
		return "redirect:/shopList.do";
	}
	@RequestMapping(value ={"/toChange.do"},method={RequestMethod.GET,RequestMethod.POST}
	)
	public String toChange(Shop shop,Map<String,Object> map){
		map.put("shop", shopService.findByid(shop.getShop_id()));
		return "/shopinfoChange";
	}
	@RequestMapping(value ={"/doChange.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String doChange(Shop shop){
		shopService.changeInfoByid(shop);
		return "redirect:/shopList.do";
	}
	@RequestMapping(value = {"/shopList.do"},method={RequestMethod.GET,RequestMethod.POST})
    public String getShoplist(Shop shop,Map<String,Object> map){
		int num = 2;
		List<Shop> list;
		list = shopService.getAllByUserid(num);
		map.put("shopli", list);		
		return "/shopList";
	}
	@RequestMapping(value = {"/delete.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String doDelete(Shop shop){
		shopService.deleteShop(shop);
		return "redirect:/shopList.do";
	}
}
