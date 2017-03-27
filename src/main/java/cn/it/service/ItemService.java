package cn.it.service;

import java.util.List;

import cn.it.pojo.Item;

/**
 * 
 * @author zhj
 *
 */
public interface ItemService {

	public  Item find(int id);
	/**
	 * 按照条目查找商品信息
	 * @return
	 */
	public List<Item> findItemList();
	
}