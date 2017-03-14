package cn.it.dao;

import cn.it.pojo.Users;


/**
 * @author wz;
 *
 * 用户信息的Dao类
 * */

public interface UsersDao {
	
	/**
	 * 用户信息添加；
	 * @param （变量为用户user，类型为Users）；
	 */
	public void UsersAdd(Users user);
	/**
	 * 用户信息删除；
	 * @param （变量为用户ID:num，类型为int）；
	 */
	public void UsersDelete(int num);
	/**
	 * 用户信息修改；
	 * @param （变量为用户ID:num，类型为int）；
	 */
	public void UsersUpdate(int num);
	/**
	 * 用户信息查询；
	 * @param （变量为用户ID:num，类型为int）；
	 */
	public void UsersSearch(int num);
	
}