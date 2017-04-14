package cn.it.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Item;
import cn.it.service.ItemService;

/**
 * 
 * @author zhj
 * 
 *         商品的Controller层操作类
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
	public ModelAndView addItem(HttpServletRequest request) {

		// 获取前台传入的数据；
		// -------------------
		// 暂时缺少店铺编号的获取；非输入数据，来源于跳转用数据。
		// 暂时先设定为1，用于测试使用
		// -------------------
		int shop_id = 1;

		String name = request.getParameter("name");
		String typeh = request.getParameter("typeh");
		String typel = request.getParameter("typel");
		String number = request.getParameter("number");
		String price = request.getParameter("price");
		String detail = request.getParameter("detail");
		String image = request.getParameter("image");

		// 进行添加商品信息操作，并且获取提示信息
		ModelAndView modeandview = itemservice.addItem(shop_id, name, typeh,
				typel, number, price, detail, image);

		return modeandview;
	}

	/**
	 * 下架商品
	 * 
	 * @param request
	 *            ，@RequestParam("id")前台传递的商品编号
	 * @return
	 */
	@RequestMapping("deleteItem.do")
	public ModelAndView deleteItem(HttpServletRequest request,
			@RequestParam("id") String id) {

		// 获取前台传入的数据，商品编号id转为int类型；
		int item_id = Integer.parseInt(id);
		// 进行删除商品信息操作；
		ModelAndView modeandview = itemservice.deleteItem(item_id);
		// 重定向刷新页面；
		modeandview.setViewName("redirect:shopItem.do");

		return modeandview;
	}

	/**
	 * 进入要修改的商品信息
	 * 
	 * @param request
	 *            ，@RequestParam("id")前台传递的商品编号
	 * @return
	 */
	@RequestMapping("showchangeItem.do")
	public ModelAndView showchangeItem(HttpServletRequest request,
			@RequestParam("id") String id) {
		ModelAndView modeandview = new ModelAndView("changeItem"); // 到changeItem.jsp界面

		// 获取前台传入的数据，商品编号id转为int类型；
		int item_id = Integer.parseInt(id);
		// 根据商品编号，获得商品；
		Item i = itemservice.findById(item_id);
		// 将商品i传递到lookitem
		modeandview.addObject("change", i);

		return modeandview;
	}

	/**
	 * 修改商品信息
	 * 
	 * @param request
	 *            ，@RequestParam("id")前台传递的商品编号
	 * @return
	 */
	@RequestMapping("changeItem.do")
	public ModelAndView changeItem(HttpServletRequest request,
			@RequestParam("id") String id) {

		// 获取前台传入的数据，商品编号id转为int类型；
		int item_id = Integer.parseInt(id);
		String name = request.getParameter("name");
		String typeh = request.getParameter("typeh");
		String typel = request.getParameter("typel");
		String number = request.getParameter("number");
		String price = request.getParameter("price");
		String detail = request.getParameter("detail");
		String image = request.getParameter("image");

		// 进行修改商品信息操作，并且获取提示信息
		ModelAndView modeandview = itemservice.updateItem(item_id, name, typeh,
				typel, number, price, detail, image);
		// 重定向刷新页面；
		modeandview.setViewName("redirect:shopItem.do");

		return modeandview;
	}

	/**
	 * 查看单个商品
	 * 
	 * @param request
	 *            ，@RequestParam("id")前台传递的商品编号
	 * @return
	 */
	@RequestMapping("lookItem.do")
	public ModelAndView lookItem(HttpServletRequest request,
			@RequestParam("id") String id) {
		ModelAndView modeandview = new ModelAndView("lookItem"); // 到lookItem.jsp界面

		// 获取前台传入的数据，商品编号id转为int类型；
		int item_id = Integer.parseInt(id);

		// 根据商品编号，获得商品；
		Item i = itemservice.findById(item_id);

		// 测试i是否已经获取到Item中的数据
		System.out.println("----------------");
		System.out.println(i);
		System.out.println("----------------");

		// 将商品i传递到lookitem
		modeandview.addObject("lookitem", i);
		return modeandview;
	}

	/**
	 * 按条目显示商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("Itemlist.do")
	public ModelAndView showItem(HttpServletRequest request) {
		ModelAndView modeandview = new ModelAndView("Itemlist"); // 到Itemlist.jsp界面
		// 获取商品条目list
		List<Item> list;
		list = itemservice.findItemList();

		// 测试list是否已经获取到Item中的数据
		System.out.println("----------------");
		System.out.println(list);
		System.out.println("----------------");

		// 将商品条目list传递到itemlist
		modeandview.addObject("itemlist", list);
		return modeandview;
	}

	/**
	 * 按照选择的商品类型查看商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("ItemType.do")
	public ModelAndView showTypeItem(HttpServletRequest request) {
		ModelAndView modeandview = new ModelAndView("Itemtype"); // 到Itemtype.jsp界面

		// 从前台获取商品类型信息；
		String typeh = request.getParameter("typeh");
		String typel = request.getParameter("typel");

		// 根据类型，获得商品；
		List<Item> list;
		list = itemservice.findByType(typeh, typel);

		// 测试list是否已经获取到Item中对应的数据
		System.out.println("----------------");
		System.out.println(list);
		System.out.println("----------------");

		// 这里用来传递已经选择的类型
		Item i = list.get(1);
		modeandview.addObject("itemtypechoice", i);

		// 将商品条目list传递到itemtype
		modeandview.addObject("itemtype", list);
		return modeandview;
	}

	/**
	 * 根据店铺编号shop_id按照条目显示商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("shopItem.do")
	public ModelAndView showShopItem(HttpServletRequest request) {
		ModelAndView modeandview = new ModelAndView("shopItem"); // 到shopItem.jsp界面

		// --------------
		// 暂时缺少获取前台传入shop_id的操作！！！
		// 暂时先设定为1，用于测试使用
		// ---------------
		int shop_id = 1;

		// 获取商品条目list
		List<Item> list;
		list = itemservice.findByShopId(shop_id);

		// 测试list是否已经获取到Item中的数据
		System.out.println("----------------");
		System.out.println(list);
		System.out.println("----------------");

		// 将商品条目list传递到shopItem
		modeandview.addObject("shopItem", list);
		return modeandview;
	}
	/**
	 * 根据输入的关键词str查询商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("searchItem.do")
	public ModelAndView showSearchItem(HttpServletRequest request){
		ModelAndView modeandview = new ModelAndView("Itemlist"); // 到Itemlist.jsp界面
		// 从前台获取搜索关键词str；
		String str = request.getParameter("str");
		
		//根据输入关键词，搜索商品
		List<Item> list;
		list = itemservice.findBystr(str);
		
		// 测试list是否已经获取到Item中的数据
		System.out.println("----------------");
		System.out.println(list);
		System.out.println("----------------");

		// 将商品条目list传递到searchlist
		modeandview.addObject("searchlist", list);
		
		return modeandview;
	}
}
