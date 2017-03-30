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
	 * @return 
	 */
	public void managerAdd(Manager manager);
	/**
	 * 管理员密码修改；
	 * @param （变量为管理员对象，类型为Manager）；
	 */
	public void managerUpdate(Manager manager);
	/**
	 * 管理员添加的辅助方法；
	 * @param （返回所有管理员对象的列表）；
	 */
	public List<Manager> managerIdFind();
	/**
	 * 管理员登录：
	 */
	public Manager login(Manager manager);
}
