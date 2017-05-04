package cn.it.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.it.dao.DiscussDao;
import cn.it.pojo.Comment;
import cn.it.pojo.Discuss;
import cn.it.pojo.Item;
import cn.it.pojo.Shop;
import cn.it.pojo.Users;
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
			HttpServletRequest request, HttpSession session) {

		// 获取前台传入的数据；
		String name = request.getParameter("name");
		String typel = request.getParameter("typel");
		String number = request.getParameter("number");
		String price = request.getParameter("price");
		String detail = request.getParameter("detail");

		// 进行添加商品信息操作，并且获取提示信息
		ModelAndView modelandview = itemservice.addItem(name, typel, number,
				price, detail, file, request, session);

		return modelandview;
	}

	/**
	 * 删除商品
	 * 
	 * @param request
	 *            ，@RequestParam("id")前台传递的商品编号
	 * @return
	 */
	// @RequestMapping("deleteItem.do")
	// public ModelAndView deleteItem(HttpServletRequest request,
	// @RequestParam("id") String id) {
	//
	// // 获取前台传入的数据，商品编号id转为int类型；
	// int item_id = Integer.parseInt(id);
	// // 进行删除商品信息操作；
	// ModelAndView modelandview = itemservice.deleteItem(item_id);
	// // 重定向刷新页面；
	// modelandview.setViewName("redirect:shopItem.do");
	//
	// return modelandview;
	// }

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

		// 获取商品的店铺编号
		Item i = itemservice.findById(item_id);
		int shop_id = i.getshop_id();

		// 重定向刷新页面；
		modelandview.setViewName("redirect:shopItem.do?shopid=" + shop_id);

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
		String typel = request.getParameter("typel");
		String number = request.getParameter("number");
		String price = request.getParameter("price");
		String detail = request.getParameter("detail");

		// 获取原图片路径
		String image = request.getParameter("image");

		// 进行修改商品信息操作，并且获取提示信息
		ModelAndView modelandview = itemservice.updateItem(item_id, name,
				typel, number, price, detail, image, file, request);

		// 获取商品的店铺编号
		Item i = itemservice.findById(item_id);
		int shop_id = i.getshop_id();

		// 重定向刷新页面；
		modelandview.setViewName("redirect:shopItem.do?shopid=" + shop_id);

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

		// 将商品i传递到lookitem
		modelandview.addObject("lookitem", i);

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

		// 如果商品多于4个，则只获取前4个商品
		if (list.size() > 4) {
			List<Item> list4 = new ArrayList<Item>();
			for (int n = 0; n < 4; n++) {
				list4.add(list.get(n));
			}
			// 将商品列表list4传递到looklist
			modelandview.addObject("looklist", list4);
		} else {
			// 将商品列表list传递到looklist
			modelandview.addObject("looklist", list);
		}

		// 商品的评论数量
		int dnum = 0;
		// 获取商品的评论列表
		List<Discuss> discuss = itemservice.showDisscussList(item_id);
		dnum = discuss.size();
		modelandview.addObject("dnum", dnum);
		// 判断评论是否为空
		if (discuss.size() == 0) {
			modelandview.addObject("error0", "目前还没有评论哟");
		} else {
			modelandview.addObject("discusslist", discuss);
		}

		return modelandview;
	}

	/**
	 * 按条目显示商品（显示所有在售商品）
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("Itemlist.do")
	public ModelAndView showItem(HttpServletRequest request, int page) {
		ModelAndView modelandview = new ModelAndView("Itemlist"); // 到Itemlist.jsp界面

		// 获取商品条目list
		List<Item> list;
		list = itemservice.findItemList();

		// 分页操作区域
		// 获取总页数
		int total = list.size(); // 商品总数量
		int perPage = 12; // 每页显示数量
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
			List<Item> i = list.subList((page - 1) * perPage, page * perPage);
			modelandview.addObject("itemlist", i);
		} else {
			List<Item> i = list.subList((page - 1) * perPage, list.size());
			modelandview.addObject("itemlist", i);
		}
		// 传递页码显示部分
		modelandview.addObject("pageList", pageList);
		modelandview.addObject("totalPage", totalPage);
		modelandview.addObject("page", page);

		// 分页操作结束

		return modelandview;
	}

	/**
	 * 按照选择的商品类型查看商品，此处输入商品一级分类
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("ItemType1.do")
	public ModelAndView showTypeItem1(HttpServletRequest request,
			@RequestParam("typeh") String typeh, int page)
			throws UnsupportedEncodingException {
		ModelAndView modelandview = new ModelAndView("ItemType1"); // 到Itemtype.jsp界面

		// 将传入的数据转为中文
		String stypeh = new String(typeh.getBytes("ISO-8859-1"), "utf-8");

		// 根据类型，获得商品；
		List<Item> list;
		list = itemservice.findByType1(stypeh);

		// 是否有满足条件的商品
		if (list.size() == 0) {
			modelandview.addObject("error0", "抱歉！！没有找到符合类型的商品！！！！");

		} else {
			// 分页操作区域
			// 获取总页数
			int total = list.size(); // 商品总数量
			int perPage = 12; // 每页显示数量
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
				List<Item> i = list.subList((page - 1) * perPage, page
						* perPage);
				modelandview.addObject("itemlist", i);
			} else {
				List<Item> i = list.subList((page - 1) * perPage, list.size());
				modelandview.addObject("itemlist", i);
			}
			// 传递页码显示部分
			modelandview.addObject("pageList", pageList);
			modelandview.addObject("totalPage", totalPage);
			modelandview.addObject("page", page);

			// 分页操作结束
		}

		// 将商品类型typeh和typel传递到前台目前显示分类
		modelandview.addObject("show", "目前显示分类");
		modelandview.addObject("typeh", stypeh);

		return modelandview;
	}

	/**
	 * 按照选择的商品类型查看商品，此处输入商品一级分类和二级分类
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("ItemType2.do")
	public ModelAndView showTypeItem2(HttpServletRequest request,
			@RequestParam("typeh") String typeh,
			@RequestParam("typel") String typel, int page)
			throws UnsupportedEncodingException {
		ModelAndView modelandview = new ModelAndView("ItemType2"); // 到Itemtype.jsp界面

		// 将传入的数据转为中文
		String stypeh = new String(typeh.getBytes("ISO-8859-1"), "utf-8");
		String stypel = new String(typel.getBytes("ISO-8859-1"), "utf-8");

		// 根据类型，获得商品；
		List<Item> list;
		list = itemservice.findByType2(stypeh, stypel);
		// 是否有满足条件商品的判断
		if (list.size() == 0) {
			modelandview.addObject("error0", "抱歉！！没有找到符合类型的商品！！！！");
		} else {
			// 分页操作区域
			// 获取总页数
			int total = list.size(); // 商品总数量
			int perPage = 12; // 每页显示数量
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
				List<Item> i = list.subList((page - 1) * perPage, page
						* perPage);
				modelandview.addObject("itemlist", i);
			} else {
				List<Item> i = list.subList((page - 1) * perPage, list.size());
				modelandview.addObject("itemlist", i);
			}
			// 传递页码显示部分
			modelandview.addObject("pageList", pageList);
			modelandview.addObject("totalPage", totalPage);
			modelandview.addObject("page", page);

			// 分页操作结束
		}

		// 将商品类型typeh和typel传递到前台
		modelandview.addObject("show", "目前显示分类");
		modelandview.addObject("typeh", stypeh);
		modelandview.addObject("typel", stypel);

		return modelandview;
	}

	/**
	 * 根据店铺编号shop_id按照条目显示商品（店家管理商品使用）
	 * 
	 * @param request
	 * @param id
	 *            前台传入的店铺编号
	 * @return
	 */
	@RequestMapping("shopItem.do")
	public ModelAndView showShopItem(HttpServletRequest request,
			HttpSession session) {
		ModelAndView modelandview = new ModelAndView("shopItem"); // 到shopItem.jsp界面

		// 获取店铺编号shop_id
		Users user = (Users) session.getAttribute("user");
		int user_id = user.getUser_ID();
		int shop_id = itemservice.getShopId(user_id);

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
	 * 根据店铺编号shop_id按照条目显示商品（买家查看商品使用）
	 * 
	 * @param request
	 * @param id
	 *            前台传入的店铺编号
	 * @return
	 */
	@RequestMapping("lookshopItem.do")
	public ModelAndView lookShopItem(HttpServletRequest request,
			@RequestParam("shopid") String id,int page) {
		ModelAndView modelandview = new ModelAndView("showshopItem");// 到showshopItem.jsp界面

		// 获取前台传入的数据，商品编号id转为int类型；
		int shop_id = Integer.parseInt(id);

		// 获取商品条目list（在售）
		List<Item> list;
		list = itemservice.findByShopId(shop_id);

		// 分页操作区域
				// 获取总页数
				int total = list.size(); // 商品总数量
				int perPage = 12; // 每页显示数量
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
					List<Item> i = list.subList((page - 1) * perPage, page * perPage);
					modelandview.addObject("showshopItem", i);
				} else {
					List<Item> i = list.subList((page - 1) * perPage, list.size());
					modelandview.addObject("showshopItem", i);
				}
				// 传递页码显示部分
				modelandview.addObject("pageList", pageList);
				modelandview.addObject("totalPage", totalPage);
				modelandview.addObject("page", page);

				// 分页操作结束
		

		// 获取商品归属的店铺信息；
		Shop shop;
		shop = itemservice.showShop(shop_id);

		// 将获取到的店铺信息shop传递到 shopinfo
		modelandview.addObject("shopinfo", shop);

		return modelandview;
	}

	/**
	 * 根据输入的关键词str查询商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("searchItem.do")
	public ModelAndView showSearchItem(HttpServletRequest request, int page) {
		ModelAndView modelandview = new ModelAndView("searchItem"); // 到searchItem.jsp界面

		// 从前台获取搜索关键词str；
		String str = request.getParameter("str");

		// 根据输入关键词，搜索商品
		List<Item> list;
		list = itemservice.findBystr(str);
		// 是否有满足条件商品的判断
		if (list.size() == 0) {
			modelandview.addObject("error0", "抱歉！！没有找到符合搜索信息的商品！！！！");
			modelandview.addObject("search", str);
		} else {
			// 分页操作区域
			// 获取总页数
			int total = list.size(); // 商品总数量
			int perPage = 12; // 每页显示数量
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
				List<Item> i = list.subList((page - 1) * perPage, page
						* perPage);
				modelandview.addObject("itemlist", i);
			} else {
				List<Item> i = list.subList((page - 1) * perPage, list.size());
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
	
	/**
	 * 根据输入的关键词str查询商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("searchItem2.do")
	public ModelAndView showSearchItem2(HttpServletRequest request,String str, int page) {
		ModelAndView modelandview = new ModelAndView("searchItem"); // 到searchItem.jsp界面

		// 根据输入关键词，搜索商品
		List<Item> list;
		list = itemservice.findBystr(str);
		// 是否有满足条件商品的判断
		if (list.size() == 0) {
			modelandview.addObject("error0", "抱歉！！没有找到符合搜索信息的商品！！！！");
			modelandview.addObject("search", str);
		} else {
			// 分页操作区域
			// 获取总页数
			int total = list.size(); // 商品总数量
			int perPage = 12; // 每页显示数量
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
				List<Item> i = list.subList((page - 1) * perPage, page
						* perPage);
				modelandview.addObject("itemlist", i);
			} else {
				List<Item> i = list.subList((page - 1) * perPage, list.size());
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

	

	@RequestMapping("addItemDiscuss.do")
	public ModelAndView addItemDiscuss(HttpServletRequest request,
			@RequestParam("id") String id, HttpSession session) {

		// 获取商品编号item_id
		int item_id = Integer.parseInt(id);
		// 获取用户编号user_id（评论者）
		Users user = (Users) session.getAttribute("user");
		int user_id = user.getUser_ID();
		// 获取评论内容和评论星级
		String content = request.getParameter("content");
		String score = request.getParameter("score");

		// 进行添加评论的操作
		ModelAndView modelandview = itemservice.addDiscuss(item_id, user_id,
				content, score, request);

		// 重定向刷新页面；
		modelandview.setViewName("redirect:lookItem.do?id=" + id);

		return modelandview;
	}
}
