package cn.it.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.tools.internal.ws.processor.model.Request;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

import cn.it.pojo.Shop;
import cn.it.pojo.Users;
import cn.it.service.ItemService;
import cn.it.service.ShopService;
import cn.it.service.UsersService;
@Controller
public class ShopController {
	@Resource
   private ShopService shopService;
	@Resource
	private UsersService usersService;
	@Resource
	   private ItemService itemService;
	@RequestMapping(value ={"/doAdd.do"},method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView doAdd(Shop shop,HttpSession session) throws IOException{
		Users user = (Users)session.getAttribute("user");
		ModelAndView str = new ModelAndView("shopList");
	    if(shopService.getAllByUserid(user.getUser_ID())==null)
	    {
	    	shopService.addShop(shop);
	    	str.addObject("error", "认证成功！");
	    	str.setViewName("/shopList");
	    }
	    else 	    	
     		str.addObject("error", "该用户店铺已存在！");
	        str.setViewName("addShop");
	    return str;
	}
	@RequestMapping(value ={"/toChange.do"},method={RequestMethod.GET,RequestMethod.POST}
	)
	public String toChange(Shop shop,Map<String,Object> map,HttpSession session){
		Users user = (Users)session.getAttribute("user");
		map.put("shop", shopService.getAllByUserid(user.getUser_ID()));
		return "/shopinfoChange";
	}
	@RequestMapping(value ={"/doChange.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String doChange(Shop shop){
		shopService.changeInfoByid(shop);
		return "redirect:/shopList.do";
	}
	@RequestMapping(value = {"/shopList.do"},method={RequestMethod.GET,RequestMethod.POST})
    public String getShoplist(Shop shop,Map<String,Object> map,HttpSession session){
		Users user = (Users)session.getAttribute("user");
		map.put("shopli", shopService.getAllByUserid(user.getUser_ID()));		
		return "/shopList";
	}
	@RequestMapping(value = {"/delete.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String doDelete(Shop shop){
		shopService.deleteShop(shop);
		return "redirect:/shopList.do";
	}
	@RequestMapping(value={"/showItem.do"},method = {RequestMethod.GET,RequestMethod.POST})
	public String showItem(Shop shop,Map<String,Object> map){
		map.put("shopit", itemService.findByShopId(shop.getShop_id()));
		return "shopItem";
	}
	@RequestMapping(value = {"/searchShop.do"},method = {RequestMethod.GET,RequestMethod.POST})
	public String searchShop(String str,Shop shop,Map<String,Object> map){
		List<Shop> list;
		list = shopService.searchShop(str);
		map.put("search", list);
		return "shopSearch";
	}
}
