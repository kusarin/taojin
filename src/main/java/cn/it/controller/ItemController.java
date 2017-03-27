package cn.it.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import cn.it.pojo.Item;
import cn.it.service.ItemService;

/**
 * 
 * @author zhj
 *
 */

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemservice;

	/**
	 * 按条目显示商品
	 * @param request
	 * @return
	 */
	@RequestMapping("Itemlist.do")
	public ModelAndView showItem(HttpServletRequest request){
		ModelAndView modeandview = new ModelAndView("Itemlist");	
		List<Item> list;
		list = itemservice.findItemList();//获取商品条目list
		
		System.out.println("----------------"); // 测试list是否已经获取到Item中的数据
		System.out.println(list);
		System.out.println("----------------");
		
		modeandview.addObject("itemlist",list);//将商品条目list传递到itemlist	
		return modeandview;
	}

	/**
	 * 按照选择的商品类型查看商品
	 * @param request
	 * @return
	 */
	@RequestMapping("ItemType.do")
	public ModelAndView showTypeItem(HttpServletRequest request){
		return null;
	}
	
	/**
	 * 查看单个商品，id为商品编号
	 * @param id
	 * @return
	 */
	@RequestMapping("lookItem.do")
	public ModelAndView lookItem(HttpServletRequest request){
		
		return null;
	}

	/**
	 * 上架商品；i为商品
	 * @param i
	 * @return
	 */
	@RequestMapping("addItem.do")
	public ModelAndView addItem(HttpServletRequest request){
		return null;
	}
	
	/**
	 * 下架商品，id为商品编号
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteItem.do")
	public ModelAndView deleteItem(HttpServletRequest request){
		return null;
	}
	
	/**
	 * 修改商品信息，id为商品编号
	 * @param id
	 * @return
	 */
	@RequestMapping("changeItem.do")
	public ModelAndView changeItem(HttpServletRequest request){
		return null;
	}
	

}
