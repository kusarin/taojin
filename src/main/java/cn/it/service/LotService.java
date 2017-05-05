package cn.it.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Item;
import cn.it.pojo.Lot;
import cn.it.pojo.Shop;

/**
 * 
 * @author zhj
 * 
 *         拍卖品的Service层定义接口
 * 
 */
public interface LotService {

	/**
	 * 添加拍卖品
	 * 
	 * @param name
	 *            拍卖品名称，String
	 * @param typel
	 *            拍卖品二级分类，String
	 * @param startprice
	 *            拍卖品起拍价，String，之后强转为double
	 * @param maxprice
	 *            拍卖品最高价（一口价），String，之后强转为double
	 * @param detail
	 *            拍卖品描述，String
	 * @param file
	 *            拍卖品品图片，MultipartFile
	 * @param request
	 *            前台请求 HttpServletRequest
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView addLot(String name, String typel, String startprice,
			String maxprice, String detail, MultipartFile file,
			HttpServletRequest request, HttpSession session);

	/**
	 * 删除拍卖品
	 * 
	 * @param lot_id
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView deleteLot(int lot_id);

	/**
	 * 更新拍卖品
	 * 
	 * @param lot_id
	 *            拍卖品编号，int
	 * @param name
	 *            拍卖品名称，String
	 * @param typeh
	 *            拍卖品一级分类，String
	 * @param typel
	 *            拍卖品二级分类，String
	 * @param number
	 *            拍卖品数量，String，之后强转为int
	 * @param nowprice
	 *            拍卖品当前价格（添加时作为起拍价），String，之后强转为double
	 * @param maxprice
	 *            拍卖品最高价（一口价），String，之后强转为double
	 * @param detail
	 *            拍卖品描述，String
	 * @param image
	 *            拍卖品品图片，String
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView updateLot(int lot_id, String name, String typel,
			String startprice, String nowprice, String maxprice, String detail,
			String image, MultipartFile file, HttpServletRequest request);

	/**
	 * 按照拍卖品编号查找拍卖品信息
	 * 
	 * @param lot_id
	 *            拍卖品编号，int
	 * 
	 * @return Lot 返回值为一个拍卖品
	 */
	public Lot findById(int lot_id);

	/**
	 * 按照条目显示拍卖品
	 * 
	 * @return List<Lot> 返回值为一个拍卖品列表，包括一个或者多个拍卖品
	 */
	public List<Lot> findLotList();

	/**
	 * 按照拍卖品类型查找拍卖品信息，此处输入拍卖品一级分类
	 * 
	 * @param typeh
	 *            拍卖品一级分类，String
	 * @param typel
	 *            拍卖品二级分类，String
	 * 
	 * @return List<Lot> 返回值为一个拍卖品列表，包括一个或者多个拍卖品
	 */
	public List<Lot> findByType1(String typeh);

	/**
	 * 按照拍卖品类型查找拍卖品信息，此处输入拍卖品一级分类和二级分类
	 * 
	 * @param typeh
	 *            拍卖品一级分类，String
	 * @param typel
	 *            拍卖品二级分类，String
	 * 
	 * @return List<Lot> 返回值为一个拍卖品列表，包括一个或者多个拍卖品
	 */
	public List<Lot> findByType2(String typeh, String typel);

	/**
	 * 按照店铺归宿查找所有拍卖品(在售)
	 * 
	 * @param shop_id
	 *            店铺编号，int
	 * 
	 * @returnList<Lot> 返回值为一个拍卖品列表，包括一个或者多个拍卖品
	 */
	public List<Lot> findByShopId1(int shop_id);

	/**
	 * 按照店铺归宿查找所有拍卖品(不在售)
	 * 
	 * @param shop_id
	 *            店铺编号，int
	 * 
	 * @returnList<Lot> 返回值为一个拍卖品列表，包括一个或者多个拍卖品
	 */
	public List<Lot> findByShopId2(int shop_id);

	/**
	 * 按照输入的关键词查看拍卖品；
	 * 
	 * @param str
	 *            传入的查询字段
	 * 
	 * @return List<Item> 返回值为一个商品列表，包括一个或者多个商品
	 */
	public List<Lot> findBystr(String str);

	/**
	 * 查看商品对应的店铺
	 * 
	 * @param shop_id
	 *            店铺编号
	 * @return Shop 返回值为一个店铺
	 */
	public Shop showShop(int shop_id);

}
