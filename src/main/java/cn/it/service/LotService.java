package cn.it.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Lot;
import cn.it.pojo.Users;

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

	public List<Lot> findByShopId(int shop_id);

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
	 * 根据用户编号查看用户
	 * @param id
	 * @return
	 */
	public Users finduser(int id);
	
	/**
	 * 根据用户编号获得店铺编号
	 * @param user_id
	 * @return
	 */
	public int getShopId(int user_id);

	/**
	 * 对拍卖品出价
	 * @param nowprice
	 * @param user_id
	 * @return
	 */
	public ModelAndView anction(int lot_id,String yourprice,int user_id,String addr);


	public ModelAndView updateLot(int lot_id);


	public ModelAndView changeLot(String name, String typel, String startprice,
			String maxPrice, String detail, MultipartFile file,
			HttpServletRequest request,String lot_id);
}
