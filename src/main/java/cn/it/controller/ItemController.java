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
		
		//-------------------
		//暂时缺少店铺编号的获取；非输入数据，来源于跳转用数据。
		//暂时先设定为1，用于测试使用
		//-------------------
		int shop_id = 1;
		
		String name = request.getParameter("name");
		String part = request.getParameter("part");
		String typeh = request.getParameter("typeh");
		String typel = request.getParameter("typel");
		String number = request.getParameter("number");
		String price = request.getParameter("price");
		String detail = request.getParameter("detail");
		String image = request.getParameter("image");
				
		// 进行添加商品信息操作，并且获取提示信息
		ModelAndView modeandview=itemservice.addItem(shop_id,name, part, typeh, typel, number, price, detail, image);
		
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
		
		//-------------------
		//暂时缺少商品编号的获取；非输入数据，来源于跳转用数据。
		//暂时先设定为10，用于测试使用
		//-------------------		
		int item_id = 10;
		
		String name = request.getParameter("name");
		String part = request.getParameter("part");
		String typeh = request.getParameter("typeh");
		String typel = request.getParameter("typel");
		String number = request.getParameter("number");
		String price = request.getParameter("price");
		String detail = request.getParameter("detail");
		String image = request.getParameter("image");
		
		// 进行修改商品信息操作，并且获取提示信息
		ModelAndView modeandview =itemservice.updateItem(item_id,name, part, typeh, typel, number, price, detail, image);
			
		//-------------------------------------
		//暂时缺少将提示信息传递到前台的操作！！！
		//-------------------------------------
		
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
	 * 查看单个商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("lookItem.do")
	public ModelAndView lookItem(HttpServletRequest request){
		ModelAndView modeandview = new ModelAndView("lookItem"); // 到lookItem.jsp界面
		
		//--------------
		// 暂时缺少获取前台传入item_id的操作！！！
		// 暂时先设定为10，用于测试使用
		//---------------
		int item_id = 10;

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
	
	/**
	 * 按照选择的商品类型查看商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("ItemType.do")
	public ModelAndView showTypeItem(HttpServletRequest request){
		ModelAndView modeandview = new ModelAndView("Itemtype"); // 到Itemtype.jsp界面

		String typeh = request.getParameter("typeh");
		String typel = request.getParameter("typel");
		
		// 根据类型，获得商品；
		List<Item> list;
		list = itemservice.findByType(typeh, typel);
		
		// 测试list是否已经获取到Item中对应的数据
		System.out.println("----------------"); 
		System.out.println(list);
		System.out.println("----------------");
		
		//这里用来传递已经选择的类型
		Item i = list.get(1);
		modeandview.addObject("itemtypechoice",i);	
		
		//将商品条目list传递到itemtype
		modeandview.addObject("itemtype",list);	
		return modeandview;
	}
}
