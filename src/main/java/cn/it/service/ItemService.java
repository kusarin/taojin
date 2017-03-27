package cn.it.service;

import java.util.List;

import cn.it.pojo.Item;

/**
 * 
 * @author zhj
 *
 */
public interface ItemService {
	
	/**
	 * 添加商品
	 * @param i
	 */
	public void addItem(Item i);
	/**
	 * 删除商品
	 * @param id
	 */
	public void deleteItem(int id);
	/**
	 * 更新商品
	 */
	public void updateItem(Item i);
	/**
	 * 按照商品编号查找商品信息
	 * @param id
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
	 * @param typeh
	 * @param typel
	 * @return
	 */
	public List<Item> findByType(String typeh,String typel);
	
}