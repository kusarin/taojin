package cn.it.controller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView doAdd(@RequestParam(value = "file", required = false)MultipartFile file,HttpServletRequest request,HttpSession session){
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String ID = request.getParameter("ID");
		String type = request.getParameter("type");
		String intro = request.getParameter("intro");

		// 进行添加商品信息操作，并且获取提示信息
		ModelAndView modelandview = shopService.doAdd(name,username,email,ID, type, intro,
				 file, request,session);

		return modelandview;
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
	@RequestMapping("doChange.do")
	public ModelAndView doChange(@RequestParam(value = "file", required = false) MultipartFile file,
	Shop shop, HttpServletRequest request, HttpSession session,@RequestParam("id") String id) {
		int shop_id = Integer.parseInt(id);
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String intro = request.getParameter("intro");
		String image = request.getParameter("image");
		ModelAndView result = shopService.doChange(shop_id, name,
				type, intro,image, file, request);
		return result;
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
	@RequestMapping(value = {"/showAllShop.do"},method = {RequestMethod.GET,RequestMethod.POST})
	public String showAllShop(Shop shop,Map<String, Object> map,int page){
		List<Shop> list;
		list = shopService.findShopList();
		int total = list.size(); // 商品总数量
		int perPage = 6; // 每页显示数量
		int totalPage =  shopService.totalPage(total);
		if (list.isEmpty()) {
			map.put("error0", "抱歉！！没有找到符合搜索信息的店铺！！！！");
		}else
		{
			// 设置page页码有效区间
	    	if (page > totalPage || page < 1) {
							page = 1;
					}
						// 设置下方页码显示的部分
						int n = 0;
						List<Integer> pageList = shopService.pageList(page, totalPage);
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
		}
		return "showAllShop";
		
	}
	@RequestMapping(value = {"/showShop.do"},method = {RequestMethod.GET,RequestMethod.POST})
	public String showShop(String type,Shop shop,Map<String, Object> map,int page) throws UnsupportedEncodingException{
		String stypeh = new String(type.getBytes("ISO-8859-1"), "utf-8");
		List<Shop> list;
		list = shopService.findByType(type);
		int total = list.size(); // 商品总数量
		int perPage = 6; // 每页显示数量
		int totalPage =  shopService.totalPage(total);
		if (list.isEmpty()) {
			map.put("error0", "抱歉！！没有找到符合搜索信息的店铺！！！！");
		}else
		{
			// 设置page页码有效区间
	    	if (page > totalPage || page < 1) {
							page = 1;
					}
						// 设置下方页码显示的部分
						int n = 0;
						List<Integer> pageList = shopService.pageList(page, totalPage);
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
		}
		map.put("show", "目前显示分类");
		map.put("type", type);
		return null;
		
	}
	@RequestMapping(value = {"/searchShop.do"},method = {RequestMethod.GET,RequestMethod.POST})
	public String searchShop(HttpServletRequest request,Shop shop,Map<String,Object> map,Integer  page){
		String str = request.getParameter("str");
		List<Shop> list;
		list = shopService.searchShop(str);
		int total = list.size(); // 商品总数量
		int perPage = 6; // 每页显示数量
		int totalPage =  shopService.totalPage(total);
		if (list.isEmpty()) {
			map.put("error0", "抱歉！！没有找到符合搜索信息的店铺！！！！");
			map.put("search", str);
		}else
		{
			// 设置page页码有效区间
			if (page > totalPage || page < 1) {
				page = 1;
			}
			// 设置下方页码显示的部分
			int n = 0;
			List<Integer> pageList = shopService.pageList(page, totalPage);
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
}
