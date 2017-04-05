package cn.it.service.impl;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Lot;
import cn.it.service.LotService;

/**
 * 
 * @author zhj
 * 
 * 拍卖品的Service层操作类
 *
 */
public class LotServiceImpl implements LotService{

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
			String number,String nowPrice,String maxPrice,String detail,String image){
		return null;
	}
	/**
	 * 删除拍卖品
	 * 
	 * @param lot_id
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView deleteLot(int lot_id){
		return null;
	}
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
			String number,String nowPrice,String maxPrice,String detail,String image){
		return null;
	}
	/**
	 * 按照拍卖品编号查找拍卖品信息
	 * 
	 * @param lot_id 拍卖品编号，int
	 * 
	 * @return Lot 返回值为一个拍卖品
	 */
	public  Lot findById(int lot_id){
		return null;
	}
	/**
	 * 按照条目显示拍卖品
	 * 
	 * @return List<Lot> 返回值为一个拍卖品列表，包括一个或者多个拍卖品
	 */
	public List<Lot> findLotList(){
		return null;
	}
	/**
	 * 按照拍卖品类型查找拍卖品信息
	 * 
	 * @param typeh 拍卖品一级分类，String
	 * @param typel 拍卖品二级分类，String
	 * 
	 * @return List<Lot> 返回值为一个拍卖品列表，包括一个或者多个拍卖品
	 */
	public List<Lot> findByType(String typeh,String typel){
		return null;
	}
	/**
	 * 按照店铺归宿查找所有拍卖品
	 * 
	 * @param shop_id 店铺编号，int
	 * 
	 * @returnList<Lot> 返回值为一个拍卖品列表，包括一个或者多个拍卖品
	 */
	public List<Lot> findByShopId(int shop_id){
		return null;
	}
}
