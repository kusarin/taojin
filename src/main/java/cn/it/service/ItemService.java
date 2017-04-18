package cn.it.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Item;

/**
 * 
 * @author zhj
 * 
 *         商品的Service层定义接口
 */
public interface ItemService {

	/**
	 * 添加商品
	 * 
	 * @param shop_id
	 *            店铺编号，int
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
	 * @param file
	 *            商品图片文件，MultipartFile
	 * @param request
	 *            前台请求 HttpServletRequest
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView addItem(int shop_id, String name, String typeh,
			String typel, String number, String price, String detail,
			MultipartFile file, HttpServletRequest request);

	/**
	 * 删除商品
	 * 
	 * @param item_id
	 *            商品编号，int
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView deleteItem(int item_id);

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
	public ModelAndView updateItem(int item_id, String name, String typeh,
			String typel, String number, String price, String detail,
			String image, MultipartFile file, HttpServletRequest request);

	/**
	 * 改变商品状态（“在售”=>“下架” or “下架”=>“在售”）
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView updownItem(int item_id);

	/**
	 * 按照商品编号查找商品信息
	 * 
	 * @param item_id
	 *            商品编号，int
	 * 
	 * @return Item 返回值为一个商品
	 */
	public Item findById(int item_id);

	/**
	 * 按照条目显示商品
	 * 
	 * @return List<Item> 返回值为一个商品列表，包括一个或者多个商品
	 */
	public List<Item> findItemList();

	/**
	 * 按照商品类型查找商品信息
	 * 
	 * @param typeh
	 *            商品一级分类，String
	 * @param typel
	 *            商品二级分类，String
	 * 
	 * @return List<Item> 返回值为一个商品列表，包括一个或者多个商品
	 */
	public List<Item> findByType(String typeh, String typel);

	/**
	 * 按照店铺归宿查找所有商品
	 * 
	 * @param shop_id
	 *            店铺编号，int
	 * 
	 * @returnList<Item> 返回值为一个商品列表，包括一个或者多个商品
	 */
	public List<Item> findByShopId(int shop_id);
	/**
	 * 通过调用itemDao.FindItemByShopId(shop_id)， 根据店铺编号查看商品 从中获取status=1的“已下架的商品”
	 * 
	 * @param shop_id
	 *            店铺编号，int
	 * @return List<Item> 返回值为一个商品列表，包括一个或者多个商品
	 */
	public List<Item> findByShopId2(int shop_id);

	/**
	 * 按照输入的关键词查看商品；
	 * 
	 * @param str
	 *            传入的查询字段
	 * 
	 * @return List<Item> 返回值为一个商品列表，包括一个或者多个商品
	 */
	public List<Item> findBystr(String str);

}