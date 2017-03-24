package cn.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.it.dao.ItemDao;
import cn.it.pojo.Item;

/**
 * 
 * @author zhj
 *
 */

@Controller
public class ItemController {
	
	@Autowired
	private ItemDao itemdao;
	
	/**
	 * 上架商品；i为商品
	 * @param i
	 * @return
	 */
	@RequestMapping("addItem.do")
	public ModelAndView addItem(Item i){
		itemdao.ItemAdd(i);
		return null;
	}
	
	/**
	 * 下架商品，id为商品编号
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteItem.do")
	public ModelAndView deleteItem(int id){
		itemdao.ItemDelete(id);
		return null;
	}
	
	/**
	 * 查看商品，id为商品编号
	 * @param id
	 * @return
	 */
	@RequestMapping("lookItem.do")
	public ModelAndView lookItem(int id){
		itemdao.FindItemById(id);
		return null;
	}
	
	/**
	 * 修改商品信息，id为商品编号
	 * @param id
	 * @return
	 */
	@RequestMapping("changeItem.do")
	public ModelAndView changeItem(int id){
		itemdao.ItemUpdate(id);
		return null;
	}
}
