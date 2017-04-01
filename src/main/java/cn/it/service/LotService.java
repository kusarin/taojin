package cn.it.service;

import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author zhj
 * 
 * 拍卖品的Service层定义接口
 *
 */
public interface LotService {

	/**
	 * 添加拍卖品
	 * 
	 * @param shop_id 店铺编号，int
	 * @param name    拍卖品名称，String
	 * @param typeh   拍卖品一级分类，String
	 * @param typel   拍卖品二级分类，String
	 * @param number  拍卖品数量，String，之后强转为int
	 * @param nowPrice 拍卖品当前价格（添加时作为起拍价），String，之后强转为double
	 * @param maxPrice 拍卖品最高价（一口价），String，之后强转为double
	 * @param detail 拍卖品描述，String
	 * @param image 拍卖品品图片，String
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView addLot(int shop_id,String name,String typeh,String typel,
			String number,String nowPrice,String maxPrice,String detail,String image);
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
	 * @param lot_id  拍卖品编号，int
	 * @param name    拍卖品名称，String
	 * @param typeh   拍卖品一级分类，String
	 * @param typel   拍卖品二级分类，String
	 * @param number  拍卖品数量，String，之后强转为int
	 * @param nowPrice 拍卖品当前价格（添加时作为起拍价），String，之后强转为double
	 * @param maxPrice 拍卖品最高价（一口价），String，之后强转为double
	 * @param detail 拍卖品描述，String
	 * @param image 拍卖品品图片，String
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView updateLot(int lot_id,String name,String typeh,String typel,
			String number,String nowPrice,String maxPrice,String detail,String image);
	
	
}
