package cn.it.controller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.tools.internal.ws.processor.model.Request;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

import cn.it.pojo.Item;
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
	/**
	 * @param shop
	 * @param file
	 * @param request
	 * @param session
	 * @return
	 * @throws IOException
	 */
	/**
	 * @param shop
	 * @param file
	 * @param request
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value ={"/doAdd.do"},method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView doAdd(Shop shop,MultipartFile file,
			HttpServletRequest request,HttpSession session) throws IOException{
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
		if(shopService.getAllByUserid(user.getUser_ID())==null)
		{
			 return "/addShop";
		}
		else
		{
		map.put("shop", shopService.getAllByUserid(user.getUser_ID()));
		return "/shopinfoChange";
		}
	}
	@RequestMapping(value ={"/doChange.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String doChange(Shop shop){
		shopService.changeInfoByid(shop);
		return "redirect:/shopList.do";
	}
	@RequestMapping(value = {"/shopList.do"},method={RequestMethod.GET,RequestMethod.POST})
    public String getShoplist(Shop shop,Map<String,Object> map,HttpSession session){
		Users user = (Users)session.getAttribute("user");
		if(shopService.getAllByUserid(user.getUser_ID())==null)
		{
			 return "/addShop";
		}
		else
		{
			map.put("shopli", shopService.getAllByUserid(user.getUser_ID()));		
			return "/shopList";
		}		
	}
	@RequestMapping(value = {"/delete.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String doDelete(Shop shop){
		shopService.deleteShop(shop);
		return "redirect:/shopList.do";
	}
	@RequestMapping(value={"/showItem.do"},method = {RequestMethod.GET,RequestMethod.POST})
	public String showItem(Shop shop,Map<String,Object> map,HttpSession session){
		Users user = (Users)session.getAttribute("user");
		if(shopService.getAllByUserid(user.getUser_ID())==null)
		{
			 return "/addShop";
		}
		else
		{
		map.put("shopit", itemService.findByShopId(shop.getShop_id()));
		return "shopItem";
		}
	}
	@RequestMapping(value = {"/searchShop.do"},method = {RequestMethod.GET,RequestMethod.POST})
	public String searchShop(HttpServletRequest request,Shop shop,Map<String,Object> map,Integer  page){
		String str = request.getParameter("str");
		List<Shop> list;
		list = shopService.searchShop(str);
		if (list.size() == 0) {
			map.put("error0", "抱歉！！没有找到符合搜索信息的商品！！！！");
			map.put("search", str);
		}else
		{
			int total = list.size(); // 商品总数量
			int perPage = 6; // 每页显示数量
			int totalPage = total / perPage;
			if (total % perPage != 0) {
				totalPage += 1;
				map.put("error", "指定页码不存在!");
			}
			// 设置page页码有效区间
			if (page > totalPage || page < 1) {
				page = 1;
			}
			// 设置下方页码显示的部分
			int n = 0;
			List<Integer> pageList = new ArrayList<Integer>();
			for (n = page - 3; n <= totalPage && n <= page + 3; n++) {
				if (n > 0) {
					pageList.add(n);
				}
			}

			// 设置每页显示的商品，并且进行传递操作
			if (page < totalPage) {
				List<Shop> i = list.subList((page - 1) * perPage, page * perPage);
				map.put("shoplist", list);
			} else {
				List<Shop> i = list.subList((page - 1) * perPage, list.size());
				map.put("shoplist", list);
			}
			map.put("pageList", pageList);
			map.put("totalPage", totalPage);
			map.put("page", page);
			map.put("search", str);
		}
		return "shopSearch";
	}
	@RequestMapping("searchShop2.do")
	public ModelAndView showSearchItem2(HttpServletRequest request,String str, Integer page) {
		ModelAndView modelandview = new ModelAndView("searchShop"); // 到searchItem.jsp界面

		// 根据输入关键词，搜索商品
		List<Shop> list;
		list = shopService.searchShop(str);
		// 是否有满足条件商品的判断
		if (list.size() == 0) {
			modelandview.addObject("error0", "抱歉！！没有找到符合搜索信息的商品！！！！");
			modelandview.addObject("search", str);
		} else {
			// 分页操作区域
			// 获取总页数
			int total = list.size(); // 商品总数量
			int perPage = 6; // 每页显示数量
			int totalPage = total / perPage;
			if (total % perPage != 0) {
				totalPage += 1;
			}
			// 设置page页码有效区间
			if (page > totalPage || page < 1) {
				page = 1;
				modelandview.addObject("error", "指定页码不存在!");
			}
			// 设置下方页码显示的部分
			int n = 0;
			List<Integer> pageList = new ArrayList<Integer>();
			for (n = page - 3; n <= totalPage && n <= page + 3; n++) {
				if (n > 0) {
					pageList.add(n);
				}
			}

			// 设置每页显示的商品，并且进行传递操作
			if (page < totalPage) {
				List<Shop> i = list.subList((page - 1) * perPage, page
						* perPage);
				modelandview.addObject("itemlist", i);
			} else {
				List<Shop> i = list.subList((page - 1) * perPage, list.size());
				modelandview.addObject("itemlist", i);
			}
			// 传递页码显示部分
			modelandview.addObject("pageList", pageList);
			modelandview.addObject("totalPage", totalPage);
			modelandview.addObject("page", page);
			modelandview.addObject("search", str);
			// 分页操作结束
		}

		return modelandview;
	}
}
