package cn.it.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Item;
import cn.it.pojo.Manager;
import cn.it.pojo.Shop;
import cn.it.pojo.Users;
import cn.it.service.ItemService;
import cn.it.service.ManagerService;
import cn.it.service.ShopService;
import cn.it.service.UsersService;
/**
 * 
 * @author sunchen
 *
 */

@Controller
public class ManagerController {
	@Resource
	private ManagerService managerService;
	@Resource
	private ShopService shopService;
	@Resource
	private UsersService usersService;
	@Resource
	private ItemService itemService;
	
	int perPage = 10;
	@RequestMapping("mlogin.do")
	public ModelAndView login(Manager manager,HttpSession session){
		ModelAndView result = managerService.login(manager,session);
		return result;
	}
	
	@RequestMapping("addmanager.do")
	public ModelAndView add(Manager manager){
		ModelAndView result = managerService.add(manager);
		return result;
	}
	
	@RequestMapping("updatepassword.do")
	public ModelAndView updatepassword(Manager manager){
		ModelAndView result = managerService.update(manager);
		return result;
	}
	
	@RequestMapping("lookSR.do")
	public ModelAndView lookSR(int page){
		ModelAndView mav = new ModelAndView("lookSR");
		List<Shop> SR = shopService.findSR();
		int total = SR.size();
		int totalPage = managerService.totalPage(total);
		if(SR.isEmpty()){
			mav.addObject("error", "没有待处理申请!");
		}else if(page > totalPage || page < 1){
			page = 1;
			mav.addObject("error", "指定页码不存在!");
		}
		List<Integer> pageList = managerService.pageList(page,totalPage);
		if(page<totalPage){
			List<Shop> s = SR.subList((page-1)*perPage, page * perPage);
			mav.addObject("SR",s);
		}else{
			List<Shop> s = SR.subList((page-1)*perPage, SR.size());
			mav.addObject("SR",s);
		}
		mav.addObject("pageList",pageList);
		mav.addObject("totalPage",totalPage);
		mav.addObject("page", page);
		return mav;
	}
	
	@RequestMapping("findSR.do")
	public ModelAndView findSR(@RequestParam("id") String id){
		int id1=Integer.parseInt(id);
		ModelAndView mav = new ModelAndView("findSR");
		Shop sr = shopService.findByid(id1);
		int userid = shopService.findUserId(id1);
		Users u = usersService.findById(userid);
		mav.addObject("sr",sr);
		mav.addObject("user",u);
		return mav;
	}
	
	@RequestMapping("passSR.do")
	public String passSR(@RequestParam("id") String id){
		int id1=Integer.parseInt(id);
		shopService.passSR(id1);
		return "redirect:lookSR.do?page=1";
	}
	
	@RequestMapping("refuseSR.do")
	public String refuseSR(@RequestParam("id") String id){
		int id1=Integer.parseInt(id);
		shopService.refuseSR(id1);
		return "redirect:lookSR.do?page=1";
	}
	
	@RequestMapping("userManage.do")
	public ModelAndView userManage(int page){
		ModelAndView mav = new ModelAndView("userManage");
		List<Users> u = usersService.findAll();
		int total = u.size();
		int totalPage = managerService.totalPage(total);
		if(page > totalPage || page < 1){
			page = 1;
			mav.addObject("error", "指定页码不存在!");
		}
		List<Integer> pageList = managerService.pageList(page,totalPage);
		if(page<totalPage){
			List<Users> user = u.subList((page-1)*perPage, page * perPage);
			mav.addObject("user",user);
		}else{
			List<Users> user = u.subList((page-1)*perPage, u.size());
			mav.addObject("user",user);
		}
		mav.addObject("pageList",pageList);
		mav.addObject("totalPage",totalPage);
		mav.addObject("page", page);
		return mav;
	}
	
	@RequestMapping("findUser.do")
	public ModelAndView findUser(@RequestParam("id") String id){
		ModelAndView mav = new ModelAndView("findUser");
		int id1=Integer.parseInt(id);
		Users u = usersService.findById(id1);
		if(u == null){
			mav.addObject("error", "用户不存在！");
			mav.setViewName("redirect:userManage.do?page=1");
		}
		mav.addObject("user",u);
		return mav;
	}
	
	@RequestMapping("shopManage.do")
	public ModelAndView shopManage(int page){
		ModelAndView mav = new ModelAndView("shopManage");
		List<Shop> s = shopService.findAll();
		int total = s.size();
		int totalPage = managerService.totalPage(total);
		if(page > totalPage || page < 1){
			page = 1;
			mav.addObject("error", "指定页码不存在!");
		}
		List<Integer> pageList = managerService.pageList(page,totalPage);
		if(page<totalPage){
			List<Shop> shop = s.subList((page-1)*perPage, page * perPage);
			mav.addObject("shop",shop);
		}else{
			List<Shop> shop = s.subList((page-1)*perPage, s.size());
			mav.addObject("shop",shop);
		}
		mav.addObject("pageList",pageList);
		mav.addObject("totalPage",totalPage);
		mav.addObject("page", page);
		return mav;
	}
	
	@RequestMapping("findShop.do")
	public ModelAndView findShop(@RequestParam("id") String id){
		ModelAndView mav = new ModelAndView("findShop");
		int id1=Integer.parseInt(id);
		Shop s = shopService.findByid(id1);
		if(s == null){
			mav.addObject("error", "店铺不存在！");
			mav.setViewName("redirect:shopManage.do?page=1");
		}
		mav.addObject("shop",s);
		return mav;
	}	

	@RequestMapping("itemManage.do")
	public ModelAndView itemManage(int page){
		ModelAndView mav = new ModelAndView("itemManage");
		List<Item> i = itemService.itemManage();
		int total = i.size();
		int totalPage = managerService.totalPage(total);
		if(page > totalPage || page < 1){
			page = 1;
			mav.addObject("error", "指定页码不存在!");
		}
		List<Integer> pageList = managerService.pageList(page,totalPage);
		if(page<totalPage){
			List<Item> item = i.subList((page-1)*perPage, page * perPage);
			mav.addObject("item",item);
		}else{
			List<Item> item = i.subList((page-1)*perPage, i.size());
			mav.addObject("item",item);
		}
		mav.addObject("pageList",pageList);
		mav.addObject("totalPage",totalPage);
		mav.addObject("page", page);
		return mav;
	}

	@RequestMapping("findItem.do")
	public ModelAndView findItem(@RequestParam("id") String id){
		ModelAndView mav = new ModelAndView("findItem");
		int id1=Integer.parseInt(id);
		Item i = itemService.itemManagefind(id1);
		if(i == null){
			mav.addObject("error", "商品不存在！");
			mav.setViewName("redirect:itemManage.do?page=1");
		}
		mav.addObject("item",i);
		return mav;
	}	

}
