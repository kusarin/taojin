package cn.it.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView addItem(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		// 获取店铺编号shop_id
		String id = request.getParameter("Shop_id");
		int shop_id = Integer.parseInt(id);

		// 获取前台传入的数据；
		String name = request.getParameter("name");
		String typeh = request.getParameter("typeh");
		String typel = request.getParameter("typel");
		String number = request.getParameter("number");
		String price = request.getParameter("price");
		String detail = request.getParameter("detail");

		// 进行添加商品信息操作，并且获取提示信息
		ModelAndView modelandview = itemservice.addItem(shop_id, name, typeh,
				typel, number, price, detail, file, request);

		return modelandview;
	}

	/**
	 * 删除商品
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
		ModelAndView modelandview = itemservice.deleteItem(item_id);
		// 重定向刷新页面；
		modelandview.setViewName("redirect:shopItem.do");

		return modelandview;
	}

	/**
	 * 改变商品状态（“在售”=>“下架” or “下架”=>“在售”）
	 * 
	 * @param request
	 * @param id
	 *            ，@RequestParam("id")前台传递的商品编号
	 * @return
	 */
	@RequestMapping("updownItem.do")
	public ModelAndView updownItem(HttpServletRequest request,
			@RequestParam("id") String id) {
		// 获取前台传入的数据，商品编号id转为int类型；
		int item_id = Integer.parseInt(id);
		// 进行修改商品状态操作；
		ModelAndView modelandview = itemservice.updownItem(item_id);
		// 重定向刷新页面；
		modelandview.setViewName("redirect:shopItem.do");

		return modelandview;
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
		ModelAndView modelandview = new ModelAndView("changeItem"); // 到changeItem.jsp界面

		// 获取前台传入的数据，商品编号id转为int类型；
		int item_id = Integer.parseInt(id);
		// 根据商品编号，获得商品；
		Item i = itemservice.findById(item_id);
		// 将商品i传递到lookitem
		modelandview.addObject("change", i);

		return modelandview;
	}

	/**
	 * 修改商品信息
	 * 
	 * @param request
	 *            ，@RequestParam("id")前台传递的商品编号
	 * @return
	 */
	@RequestMapping("changeItem.do")
	public ModelAndView changeItem(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, @RequestParam("id") String id) {

		// 获取前台传入的数据，商品编号id转为int类型；
		int item_id = Integer.parseInt(id);
		String name = request.getParameter("name");
		String typeh = request.getParameter("typeh");
		String typel = request.getParameter("typel");
		String number = request.getParameter("number");
		String price = request.getParameter("price");
		String detail = request.getParameter("detail");

		// 获取原图片路径
		String image = request.getParameter("image");

		// 进行修改商品信息操作，并且获取提示信息
		ModelAndView modelandview = itemservice.updateItem(item_id, name,
				typeh, typel, number, price, detail, image, file, request);
		// 重定向刷新页面；
		modelandview.setViewName("redirect:shopItem.do");

		return modelandview;
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
		ModelAndView modelandview = new ModelAndView("lookItem"); // 到lookItem.jsp界面

		// 获取前台传入的数据，商品编号id转为int类型；
		int item_id = Integer.parseInt(id);

		// 根据商品编号，获得商品；
		Item i = itemservice.findById(item_id);

		// 获取该商品的店铺编号；
		int shop_id = i.getshop_id();
		// 获取同属于商品的列表；
		List<Item> list = itemservice.findByShopId(shop_id);
		// 将本商品从列表中移除；
		for (int m = 0; m < list.size(); m++) {
			if (list.get(m).getitem_id() == item_id) {
				list.remove(m);
			}
		}

		// 将商品i传递到lookitem
		modelandview.addObject("lookitem", i);
		// 将商品列表list传递到list
		modelandview.addObject("looklist", list);

		return modelandview;
	}

	/**
	 * 按条目显示商品（显示所有在售商品）
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("Itemlist.do")
	public ModelAndView showItem(HttpServletRequest request) {
		ModelAndView modelandview = new ModelAndView("Itemlist"); // 到Itemlist.jsp界面
		// 获取商品条目list
		List<Item> list;
		list = itemservice.findItemList();

		// 将商品条目list传递到itemlist
		modelandview.addObject("itemlist", list);
		return modelandview;
	}

	/**
	 * 按照选择的商品类型查看商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("ItemType.do")
	public ModelAndView showTypeItem(HttpServletRequest request) {
		ModelAndView modelandview = new ModelAndView("Itemtype"); // 到Itemtype.jsp界面

		// 从前台获取商品类型信息；
		String typeh = request.getParameter("typeh");
		String typel = request.getParameter("typel");

		// 根据类型，获得商品；
		List<Item> list;
		list = itemservice.findByType(typeh, typel);

		// 这里用来传递已经选择的类型
		Item i = list.get(1);
		modelandview.addObject("itemtypechoice", i);

		// 将商品条目list传递到itemtype
		modelandview.addObject("itemtype", list);
		return modelandview;
	}

	/**
	 * 根据店铺编号shop_id按照条目显示商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("shopItem.do")
	public ModelAndView showShopItem(HttpServletRequest request,
			@RequestParam("shopid") String id) {
		ModelAndView modelandview = new ModelAndView("shopItem"); // 到shopItem.jsp界面

		// 获取店铺编号shop_id
		int shop_id = Integer.parseInt(id);

		// 获取商品条目list（在售）
		List<Item> list;
		list = itemservice.findByShopId(shop_id);
		// 获取商品条目list2（已下架）
		List<Item> list2;
		list2 = itemservice.findByShopId2(shop_id);

		// 将商品条目list（在售）传递到shopItem
		modelandview.addObject("shopItem", list);
		// 将商品条目list2（已下架）传递到shopItem2
		modelandview.addObject("shopItem2", list2);

		return modelandview;
	}

	/**
	 * 根据输入的关键词str查询商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("searchItem.do")
	public ModelAndView showSearchItem(HttpServletRequest request) {
		ModelAndView modelandview = new ModelAndView("Itemlist"); // 到Itemlist.jsp界面
		// 从前台获取搜索关键词str；
		String str = request.getParameter("str");

		// 根据输入关键词，搜索商品
		List<Item> list;
		list = itemservice.findBystr(str);

		// 将商品条目list传递到searchlist
		modelandview.addObject("itemlist", list);

		return modelandview;
	}
}
