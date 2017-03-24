package cn.it.dao;

import java.util.List;

import cn.it.pojo.Manager;
import cn.it.pojo.Users;

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
	public void managerAdd(Manager manager);
	/**
	 * 管理员删除；
	 * @param （变量为管理员编号 id，类型为int）；
	 */
	public void managerDelete(int num);
	/**
	 * 管理员修改；
	 * @param （变量为管理员编号 id，类型为int）；
	 */
	public void managerUpdate(int num);
	/**
	 * 管理员查看；
	 * @param （变量为管理员编号 id，类型为int）；
	 */
	public void managerSearch(int num);
	/**
	 * 管理员登录：
	 */
	public List<Manager> login(String account, String password);
}
