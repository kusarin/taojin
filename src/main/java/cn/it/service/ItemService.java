package cn.it.service;

import java.util.List;

import cn.it.pojo.Item;

/**
 * 
 * @author zhj
 *
 * 商品的Service层定义接口
 */
public interface ItemService {
	
	/**
	 * 添加商品
	 * @param name 商品名称，String
	 * @param part 商品类别，String
	 * @param typeh 商品一级分类，String
	 * @param typel 商品二级分类，String
	 * @param number 商品数量，int
	 * @param price 商品价格，double
	 * @param detail 商品描述，String
	 * @param image 商品图片，String
	 */
	public String addItem(int shop_id,String name,String part,String typeh,String typel,
			String number,String price,String detail,String image);
	/**
	 * 删除商品
	 * @param id 商品编号，int
	 */
	public String deleteItem(int id);
	/**
	 * 更新商品
	 * @param name 商品名称，String
	 * @param part 商品类别，String
	 * @param typeh 商品一级分类，String
	 * @param typel 商品二级分类，String
	 * @param number 商品数量，int
	 * @param price 商品价格，double
	 * @param detail 商品描述，String
	 * @param image 商品图片，String
	 */
	public String updateItem(int id, String name,String part,String typeh,String typel,
			String number,String price,String detail,String image);
	/**
	 * 按照商品编号查找商品信息
	 * @param id 商品编号，int
	 * @return
	 */
	public  Item findById(int id);
	/**
	 * 按照条目查找商品信息
	 * @return
	 */
	public List<Item> findItemList();
	/**
	 * 按照商品类型查找商品信息
	 * @param typeh 商品一级分类，String
	 * @param typel 商品二级分类，String
	 * @return
	 */
	public List<Item> findByType(String typeh,String typel);
	
}