package cn.it.dao;

import cn.it.pojo.Manager;

/**
 * 
 * @author sunchen
 *Manager 的Dao接口;增删改查
 */
public interface ManagerDao {
	/**
	 * 管理员添加；
	 * @param （变量为管理员对象manager，类型为Manager）；
	 */
	public void ManagerAdd(Manager manager);
	/**
	 * 管理员删除；
	 * @param （变量为管理员编号 id，类型为int）；
	 */
	public void ManagerDelete(int num);
	/**
	 * 管理员修改；
	 * @param （变量为管理员编号 id，类型为int）；
	 */
	public void ManagerUpdate(int num);
	/**
	 * 管理员查看；
	 * @param （变量为管理员编号 id，类型为int）；
	 */
	public void ManagerSearch(int num);
	
}
