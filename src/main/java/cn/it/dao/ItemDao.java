package cn.it.dao;

import cn.it.pojo.Item;
/**
 * 
 * @author zhj
 * 
 *  
 *
 */
public interface ItemDao {
	
	/**
	 * 添加商品方法
	 * @param 变量i为商品item
	 */
	public void ItemAdd(Item i);
	/**
	 * 删除商品方法
	 * @param 变量id为商品编号，为int型
	 */
	public void ItemDelete(int id);
	/**
	 * 修改商品方法
	 * @param 变量id为商品编号，为int型
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
