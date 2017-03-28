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
 * 商品的Controller层操作类
 *
 */

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemservice;
	
	/**
	 * 上架商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("addItem.do")
	public ModelAndView addItem(HttpServletRequest request){
		ModelAndView modeandview = new ModelAndView("addItem"); //到addItem界面 
		
		//-------------------
		//暂时缺少获取前台数据的操作！！！
		//-------------------
		int shop_id = 0;
		String name = null;
		String part = null;
		String typeh = null;
		String typel = null;
		String number = null;
		String price = null;
		String detail = null;
		String image = null;
		
		// 定义提示信息str
		String str;
		// 进行添加商品信息操作，并且获取提示信息
		str=itemservice.addItem(shop_id,name, part, typeh, typel, number, price, detail, image);
		
		
		//-------------------
		//暂时缺少将提示信息传递到前台的操作！！！
		//-------------------
		
		
		return modeandview;
	}
	
	
	/**
	 * 下架商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("deleteItem.do")
	public ModelAndView deleteItem(HttpServletRequest request){
		ModelAndView modeandview = new ModelAndView("deleteItem"); //到deleteItem界面 
		
		//-------------------
		//暂时缺少获取前台数据的操作！！！
		//-------------------
		
		int item_id=0;
		
		// 定义提示信息str
		String str;
		str = itemservice.deleteItem(item_id);
		
		//-------------------
		//暂时缺少将提示信息传递到前台的操作！！！
		//-------------------
		
		return modeandview;
	}
	
	
	/**
	 * 修改商品信息 
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("changeItem.do")
	public ModelAndView changeItem(HttpServletRequest request){

		ModelAndView modeandview = new ModelAndView("changeitem"); //到changeitem界面 
		
		//-------------------
		//暂时缺少获取前台数据的操作！！！
		//-------------------
		
		int item_id = 0;
		String name = null;
		String part = null;
		String typeh = null;
		String typel = null;
		String number = null;
		String price = null;
		String detail = null;
		String image = null;
		
		// 定义提示信息str
		String str;
		// 进行修改商品信息操作，并且获取提示信息
		str=itemservice.updateItem(item_id,name, part, typeh, typel, number, price, detail, image);
			
		//-------------------
		//暂时缺少将提示信息传递到前台的操作！！！
		//-------------------
		
		return modeandview;
	}
	
	
	/**
	 * 按条目显示商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("Itemlist.do")
	public ModelAndView showItem(HttpServletRequest request){
		ModelAndView modeandview = new ModelAndView("Itemlist"); // 到Itemlist.jsp界面
		//获取商品条目list
		List<Item> list;
		list = itemservice.findItemList();
		
		// 测试list是否已经获取到Item中的数据
		System.out.println("----------------"); 
		System.out.println(list);
		System.out.println("----------------");
		
		//将商品条目list传递到itemlist
		modeandview.addObject("itemlist",list);	
		return modeandview;
	}

	
	/**
	 * 按照选择的商品类型查看商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("ItemType.do")
	public ModelAndView showTypeItem(HttpServletRequest request){
		ModelAndView modeandview = new ModelAndView("Itemtype"); // 到Itemtype.jsp界面
		
		//--------------
		// 暂时缺少获取前台typeh和typel的操作！！！
		//---------------
		
		String typeh = null;
		String typel = null;
		
		// 根据类型，获得商品；
		List<Item> list;
		list = itemservice.findByType(typeh, typel);
		
		// 测试list是否已经获取到Item中的数据
		System.out.println("----------------"); 
		System.out.println(list);
		System.out.println("----------------");
		
		//将商品条目list传递到itemtype
		modeandview.addObject("itemtype",list);	
		return modeandview;
	}
	
	
	/**
	 * 查看单个商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("lookItem.do")
	public ModelAndView lookItem(HttpServletRequest request){
		ModelAndView modeandview = new ModelAndView("lookItem"); // 到lookItem.jsp界面
		
		//--------------
		// 暂时缺少获取前台typeh和typel的操作！！！
		//---------------
		int item_id = 0;

		// 根据商品编号，获得商品；
		Item i = itemservice.findById(item_id);
		
		// 测试i是否已经获取到Item中的数据
		System.out.println("----------------"); 
		System.out.println(i);
		System.out.println("----------------");
		
		//将商品i传递到lookitem
		modeandview.addObject("lookitem",i);		
		return modeandview;
	}
}
