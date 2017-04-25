package cn.it.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.it.dao.DiscussDao;
import cn.it.dao.ItemDao;
import cn.it.dao.ShopDao;
import cn.it.dao.TypehDao;
import cn.it.dao.TypelDao;
import cn.it.pojo.Discuss;
import cn.it.pojo.Item;
import cn.it.pojo.Shop;
import cn.it.pojo.Typeh;
import cn.it.pojo.Typel;
import cn.it.pojo.Users;
import cn.it.service.ItemService;

/**
 * 
 * @author zhj
 * 
 *         商品的Service层操作类
 * 
 */

@Service("itemService")
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private DiscussDao discussDao;
	@Autowired
	private TypehDao typehDao;
	@Autowired
	private TypelDao typelDao;

	/**
	 * 添加商品
	 * 
	 * @param name
	 *            商品名称，String
	 * @param typel
	 *            商品二级分类，String
	 * @param number
	 *            商品数量，String，之后强转为int
	 * @param price
	 *            商品价格，String，之后强转为double
	 * @param detail
	 *            商品描述，String
	 * @param file
	 *            商品图片文件，MultipartFile
	 * @param request
	 *            前台请求 HttpServletRequest
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView addItem(String name, String typel,
			String number, String price, String detail, MultipartFile file,
			HttpServletRequest request,HttpSession session) {
		ModelAndView str = new ModelAndView("addItem"); // 跳转到addItem.jsp界面

		// 判断传入参数是否为空
		if (name == null || name.equals("") || typel == null
				|| typel.equals("") || number == null || number.equals("")
				|| price == null || price.equals("") || detail == null
				|| detail.equals("")) {

			// 提示信息 "输入数据不能为空！！！"
			str.addObject("error", "输入数据不能为空！！！");

		} else {// 参数不为空时候，执行添加操作

			// 获取店铺编号shop_id
			Users user = (Users)session.getAttribute("user");
			int user_id = user.getUser_ID();
			List<Shop> ls = shopDao.getAllByUserid(user_id);
			int shop_id=ls.get(0).getShop_id();
			
			// 将商品数量和价格转为规定格式：商品数量int，商品价格double
			int num = Integer.parseInt(number);
			double pri = Double.parseDouble(price);

			// 根据商品的二阶类型获取商品的一阶类型
			Typel tyl = typelDao.FindTypelByName(typel);
			int typeh_id = tyl.getTypeh_id();
			Typeh tyh = typehDao.FindTypehById(typeh_id);
			String typeh = tyh.getName();
			// 获取商品一阶分类结束

			// 定义商品；
			Item i = new Item();
			// 设置商品属性；
			i.setshop_id(shop_id);  // 店鋪编号
			i.setname(name);        // 商品名称
			i.settypeh(typeh);      // 商品一阶类型
			i.settypel(typel);      // 商品二阶类型
			i.setnumber(num);       // 商品数量
			i.setprice(pri);        // 商品价格
			i.setdetail(detail);    // 商品描述

			// 商品图片部分
			// 获取图片存储文件的路径
			String path = request.getServletContext().getRealPath("upload");
			// 将图片文件名命名为上传时间
			String fileName = String.valueOf(System.currentTimeMillis())
					+ file.getOriginalFilename();
			// 获取图片文件路径
			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			// 保存文件（图片）；
			try {
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// set方法
			i.setimage("/upload/" + fileName);
			// 商品图片部分结束

			// 设置浏览次数和出售数量初始值为0；
			i.setbrowsingTimes(0);
			i.settradingTimes(0);
			// 设置商品状态为0，在售；
			i.setStatus(0);

			// 添加商品信息；
			itemDao.ItemAdd(i);
			request.setAttribute("item", i);
			// 提示信息 "上架成功！！！"
			str.addObject("error", "上架成功！！！");

			// 上架成功后跳转的界面，暂时先设置为addItem【上架商品界面】
			str.setViewName("addItem");
		}
		// 返回提示信息

		return str;
	}

	/**
	 * 删除商品
	 * 
	 * @param item_id
	 *            商品编号，int
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView deleteItem(int item_id) {
		ModelAndView str = new ModelAndView("shopItem"); // 跳转到shopList.jsp界面
		itemDao.ItemDelete(item_id);
		// 返回提示信息 "删除商品成功！！！"
		str.addObject("error", "删除商品成功！！！");
		return str;
	}

	/**
	 * 更新商品
	 * 
	 * @param item_id
	 *            商品编号，int
	 * @param name
	 *            商品名称，String
	 * @param typeh
	 *            商品一级分类，String
	 * @param typel
	 *            商品二级分类，String
	 * @param number
	 *            商品数量，String，之后强转为int
	 * @param price
	 *            商品价格，String，之后强转为double
	 * @param detail
	 *            商品描述，String
	 * @param image
	 *            商品原文件路径，String
	 * @param file
	 *            商品图片文件，MultipartFile
	 * @param request
	 *            前台请求 HttpServletRequest
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView updateItem(int item_id, String name, String typel,
			String number, String price, String detail, String image,
			MultipartFile file, HttpServletRequest request) {
		ModelAndView str = new ModelAndView("shopItem"); // 跳转到shopItem.jsp界面

		// 判断传入参数是否为空
		if (name == null || name.equals("") || typel == null
				|| typel.equals("") || number == null || number.equals("")
				|| price == null || price.equals("") || detail == null
				|| detail.equals("")) {

			// 提示信息 "输入数据不能为空！！！"
			str.addObject("error", "输入数据不能为空！！！");
		} else {// 参数不为空时候，执行修改操作

			// 将商品数量和价格转为规定格式：商品数量int，商品价格double
			int num = Integer.parseInt(number);
			double pri = Double.parseDouble(price);

			// 根据商品的二阶类型获取商品的一阶类型
			Typel tyl = typelDao.FindTypelByName(typel);
			int typeh_id = tyl.getTypeh_id();
			Typeh tyh = typehDao.FindTypehById(typeh_id);
			String typeh = tyh.getName();
			// 获取商品一阶分类结束

			// 定义商品；
			Item i = itemDao.FindItemById(item_id);
			// 设置商品新属性；
			i.setname(name); // 商品名称
			i.settypeh(typeh); // 商品一阶类型
			i.settypel(typel); // 商品二阶类型
			i.setnumber(num); // 商品数量
			i.setprice(pri); // 商品价格
			i.setdetail(detail); // 商品描述

			// 商品图片部分
			if (file.getOriginalFilename().equals("")
					|| file.getOriginalFilename() == null) {
				// 如果没有上传新的图片文件；
				i.setimage(image);
			} else {// 如果上传了新的图片文件
				// 获取图片存储文件的路径
				String path = request.getServletContext().getRealPath("upload");
				// 将图片文件名命名为上传时间
				String fileName = String.valueOf(System.currentTimeMillis())
						+ file.getOriginalFilename();
				// 获取新的图片文件路径
				File targetFile = new File(path, fileName);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				// 保存文件（图片）；
				try {
					file.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// set方法
				i.setimage("/upload/" + fileName);
			}

			// 商品图片部分结束

			// 更新商品信息
			itemDao.ItemUpdate(i);
			request.setAttribute("item", i);
			// 提示信息 "修改商品信息成功！！！"
			str.addObject("error", "修改商品信息成功！！！");
		}
		return str;
	}

	/**
	 * 改变商品状态（“在售”=>“下架” or “下架”=>“在售”）
	 * 
	 * @param item_id
	 *            商品编号，int
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView updownItem(int item_id) {
		ModelAndView str = new ModelAndView("shopItem"); // 跳转到shopList.jsp界面
		Item i = itemDao.FindItemById(item_id);
		if (i.getStatus() == 0) {
			i.setStatus(1);
		} else if (i.getStatus() == 1) {
			i.setStatus(0);
		}
		itemDao.ItemUpdate(i);
		return str;
	}

	/**
	 * 通过调用itemDao.FindItemById(),查看单个商品信息
	 * 
	 * @param item_id
	 *            商品编号，int
	 * 
	 * @return Item 返回值为一个商品
	 */
	public Item findById(int item_id) {
		// 获取要查看的商品
		Item i = itemDao.FindItemById(item_id);
		// 浏览次数+1；
		int num = i.getbrowsingTimes() + 1;
		i.setbrowsingTimes(num);
		// 更新
		itemDao.ItemUpdate(i);
		// 返回查看的商品
		return i;
	}

	/**
	 * 通过调用itemDao.FindAll(),查看所有商品
	 * 
	 * @return List<Item> 返回值为一个商品列表，包括一个或者多个商品
	 */
	public List<Item> findItemList() {
		List<Item> shoplist = itemDao.FindAll();

		// 建立属于“在售”状态的商品列表list
		List<Item> list = new ArrayList<Item>();
		// 将属于“在售”状态的商品添加到列表list
		for (int i = 0; i < shoplist.size(); i++) {
			if (shoplist.get(i).getStatus() == 0) {
				list.add(shoplist.get(i));
			}
		}
		return list;
	}

	/**
	 * 通过调用itemDao.FindItemByType2()，根据所选的类型查看商品 此处输入商品一级分类
	 * 
	 * @param typeh
	 *            商品一阶类型，String
	 * 
	 * @return List<Item> 返回值为一个商品列表，包括一个或者多个商品
	 */
	public List<Item> findByType1(String typeh) {
		return itemDao.FindItemByType1(typeh);
	}

	/**
	 * 通过调用itemDao.FindItemByType2()，根据所选的类型查看商品 此处输入商品一级分类和二级分类
	 * 
	 * @param typeh
	 *            商品一阶类型，String
	 * @param typel
	 *            商品二阶类型，String
	 * 
	 * @return List<Item> 返回值为一个商品列表，包括一个或者多个商品
	 */
	public List<Item> findByType2(String typeh, String typel) {
		return itemDao.FindItemByType2(typeh, typel);
	}

	/**
	 * 通过调用itemDao.FindItemByShopId(shop_id)，根据店铺编号查看商品(在售)
	 * 
	 * @param shop_id
	 *            店铺编号，int
	 * 
	 * @return List<Item> 返回值为一个商品列表，包括一个或者多个商品
	 */
	public List<Item> findByShopId(int shop_id) {
		// 获取所有属于该店铺的商品
		List<Item> shoplist = itemDao.FindItemByShopId(shop_id);
		// 建立属于“在售”状态的商品列表list
		List<Item> list = new ArrayList<Item>();
		// 将属于“在售”状态的商品添加到列表list
		for (int i = 0; i < shoplist.size(); i++) {
			if (shoplist.get(i).getStatus() == 0) {
				list.add(shoplist.get(i));
			}
		}
		return list;
	}

	/**
	 * 通过调用itemDao.FindItemByShopId(shop_id)， 根据店铺编号查看商品 从中获取status=1的“已下架的商品”
	 * 
	 * @param shop_id
	 *            店铺编号，int
	 * @return List<Item> 返回值为一个商品列表，包括一个或者多个商品
	 */
	public List<Item> findByShopId2(int shop_id) {
		// 获取所有属于该店铺的商品
		List<Item> shoplist2 = itemDao.FindItemByShopId(shop_id);
		// 建立属于“已下架”状态的商品列表list2
		List<Item> list2 = new ArrayList<Item>();
		// 将属于“已下架”状态的商品添加到列表list2
		for (int i = 0; i < shoplist2.size(); i++) {
			if (shoplist2.get(i).getStatus() == 1) {
				list2.add(shoplist2.get(i));
			}
		}
		return list2;
	}

	/**
	 * 按照输入的关键词查看商品；
	 * 
	 * @param str
	 *            传入的查询字段
	 * 
	 * @return List<Item> 返回值为一个商品列表，包括一个或者多个商品
	 */
	public List<Item> findBystr(String str) {
		return itemDao.SearchItem(str);
	}

	/**
	 * 查看商品对应的评论
	 * 
	 * @param item_id
	 *            商品编号
	 * @return List<Discuss> 返回值为一个评论列表，包括一个或者多个评论
	 */
	public List<Discuss> showDisscussList(int item_id) {
		return discussDao.FindItemDiscuss(item_id);
	}

	/**
	 * 给某个商品添加评论
	 * 
	 * @param item_id
	 *            商品编号
	 * @param content
	 *            评论内容
	 * @return
	 */
	public ModelAndView addDiscuss1(int item_id, String content,
			HttpServletRequest request) {
		ModelAndView str = new ModelAndView("lookItem"); // 跳转到addItem.jsp界面

		// 判断传入参数是否为空
		if (content == null || content.equals("")) {

			// 提示信息 "输入数据不能为空！！！"
			str.addObject("error", "输入评论不能为空！！！");
		} else {

			// 定义评论；
			Discuss d = new Discuss();
			// 设置评论属性；
			d.setItem_id(item_id); // 商品编号
			d.setContent(content); // 评论内容

			// 添加评论信息；
			discussDao.addDiscuss1(d);
			request.setAttribute("discuss", d);

			// 提示信息 "上架成功！！！"
			str.addObject("error", "评论成功！！！");

			str.setViewName("lookItem");
		}

		// 返回提示信息
		return str;
	}

	/**
	 * 查看商品对应的店铺
	 * 
	 * @param shop_id
	 *            店铺编号
	 * @return Shop 返回值为一个店铺
	 */
	public Shop showShop(int shop_id) {
		return shopDao.findByid(shop_id);
	}
	
	/**
	 * 根据用户编号获得对应的店铺编号
	 * 
	 * @param user_id 用户编号
	 * @return
	 */
	public int getShopId(int user_id){
		List<Shop> ls = shopDao.getAllByUserid(user_id);
		int shop_id=ls.get(0).getShop_id();
		return shop_id;
	}
	
	/**
	 * 孙琛改的，用在管理员后台管理。
	 */
	public List<Item> itemManage() {
		return itemDao.FindAll();
	}

	public Item itemManagefind(int id) {
		return itemDao.FindItemById(id);
	}

	// // 判断输入字符串是否为数字的方法，用来判断number和price是否为数字【听说可以在前端网页执行，所以先注释掉】
	// public static boolean isNumeric(String str){
	// for (int i = 0; i < str.length(); i++){
	// System.out.println(str.charAt(i));
	// if (!Character.isDigit(str.charAt(i))){
	// return false;
	// }
	// }
	// return true;
	// }

	/******************************* 测试类,用于测试能否成功调用来自Dao层的方法 *************************************/
	/**
	 * 测试1，用于测试是否添加商品
	 */
	@Test
	public void test1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		ItemDao itemdao = (ItemDao) ac.getBean("itemDao");
		Item i = new Item();

		// 设置商品属性；
		i.setshop_id(1);
		i.setname("第五个商品");
		i.settypeh("高级分类1");
		i.settypel("低级分类2");
		i.setnumber(23);
		i.setprice(150.25);
		i.setdetail("五个详细信息");
		i.setimage("这就是一张图片");

		System.out.println("设置商品属性完成");
		// 设置浏览次数和出售数量初始值为0；
		// i.setbrowsingTimes(0);
		// i.settradingTimes(0);

		itemdao.ItemAdd(i);
		System.out.println("添加成功！！！");
	}

	/**
	 * 测试2，用于测试是否删除商品
	 */
	@Test
	public void test2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		ItemDao itemdao = (ItemDao) ac.getBean("itemDao");
		itemdao.ItemDelete(5);
		System.out.println("删除成功！！！");
	}

	/**
	 * 测试3，用于测试是否修改商品
	 */
	@Test
	public void test3() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		ItemDao itemdao = (ItemDao) ac.getBean("itemDao");

		Item i = new Item();
		System.out.println("设置完成");

		// 设置商品属性；
		i.setitem_id(5);
		i.setname("第7个商品");
		i.settypeh("高级分类2");
		i.settypel("低级分类1");
		i.setnumber(41);
		i.setprice(158.23);
		i.setdetail("7个详细信息");
		i.setimage("这999是一张图片");

		itemdao.ItemUpdate(i);
		System.out.println("修改成功！！！");
	}

	/**
	 * 测试4，用于测试FindAll()是否已经传值；
	 */
	@Test
	public void test4() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		ItemDao itemdao = (ItemDao) ac.getBean("itemDao");
		List<Item> i = itemdao.FindAll();
		System.out.println(i);
	}

	/**
	 * 测试5，用于测试FindItemById(id)是否传值
	 */
	@Test
	public void test5() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		ItemDao itemdao = (ItemDao) ac.getBean("itemDao");
		int id = 1;
		Item i = itemdao.FindItemById(id);
		System.out.println(i);
	}

	/**
	 * 测试6，用于测试FindItemByType2(typeh,typel)是否传值
	 */
	@Test
	public void test6() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		ItemDao itemdao = (ItemDao) ac.getBean("itemDao");
		String typeh = "高级分类1";
		String typel = "低级分类1";
		List<Item> i = itemdao.FindItemByType2(typeh, typel);
		System.out.println(i);
	}

	/**
	 * 测试7，用于测试SearchItem(str)是否传值
	 */
	@Test
	public void test7() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		ItemDao itemdao = (ItemDao) ac.getBean("itemDao");
		String str = "一号";
		List<Item> i = itemdao.SearchItem(str);
		System.out.println(i);
	}

	/**
	 * 评论部分
	 */
	/**
	 * 测试8，用于测试addDiscuss1(id)是否传值
	 */
	@Test
	public void test8() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		DiscussDao discussdao = (DiscussDao) ac.getBean("discussDao");
		// 定义评论；
		Discuss d = new Discuss();
		// 设置评论属性；
		d.setItem_id(1); // 商品编号
		d.setContent("绝对一号的第三条评论"); // 评论内容

		// 添加评论信息；
		discussdao.addDiscuss1(d);
		System.out.println(d);
		System.out.println("添加成功！！！");
	}

	/**
	 * 测试9，用于测试FindItemDiscuss(id)是否传值
	 */
	@Test
	public void test9() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		DiscussDao discussdao = (DiscussDao) ac.getBean("discussDao");
		int id = 1;
		List<Discuss> i = discussdao.FindItemDiscuss(id);
		System.out.println(i);
	}

}
