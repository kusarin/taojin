package cn.it.dao;

import cn.it.pojo.Item;
/**
 * 
 * @author zhj
 * 
 *  商品的Dao接口，增删改查；
 *
 */
public interface ItemDao {
	
	/**
	 * 商品添加；
	 * @param （变量为商品 i，类型为Item）；
	 */
	public void ItemAdd(Item i);
	/**
	 * 商品删除；
	 * @param （变量为商品编号 id，类型为int）；
	 */
	public void ItemDelete(int id);
	/**
	 * 商品修改；
	 * @param （变量为商品编号 id，类型为int）；
	 */
	public void ItemUpdate(int id);
	/**
	 * 商品查看；
	 * @param （变量为商品编号 id，类型为int）；
	 */
	public void ItemSearch(int id);
}
