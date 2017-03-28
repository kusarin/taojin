package cn.it.dao;

import java.util.List;

import cn.it.pojo.Item;
/**
 * 
 * @author zhj
 * 
 *  商品的Dao层定义接口
 *
 */
public interface ItemDao {
	
	/**
	 * 添加商品方法
	 * @param i 商品，item
	 */
	public void ItemAdd(Item i);
	/**
	 * 删除商品方法
	 * @param id 商品编号，int
	 */
	public void ItemDelete(int item_id);
	/**
	 * 修改商品方法
	 * @param id 商品编号，int
	 */
	public void ItemUpdate(Item i);
	/**
	 * 按照商品编号查看商品；
	 * @param id 商品编号，int
	 * @return 
	 */
	public Item FindItemById(int item_id);
	/**
	 * 查看所有商品；
	 * @return
	 */
	public List<Item> FindAll();
	/**
	 * 按照商品类型查看商品；
	 * @param typeh 商品一级分类，String
	 * @param typel 商品二级分类，String
	 * 
	 */
	public List<Item> FindItemByType(String typeh,String typel);

}
