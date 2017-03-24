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
	 * 按照商品编号查看商品；
	 * @param （变量为商品编号 id，类型为int）；
	 */
	public void FindItemById(int id);
	/**
	 * 按照商品类型查看商品；
	 * @param typeh
	 * @param typel
	 * 
	 * 在impl中还没有具体方法
	 */
	public void FindItemByType(String typeh,String typel);
}
