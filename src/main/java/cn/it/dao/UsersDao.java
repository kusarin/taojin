package cn.it.dao;

import java.util.List;

import cn.it.pojo.Users;


/**
 * @author wz;
 *
 * 增删改查接口
 * */

public interface UsersDao {
	
	/**
	 * 用户信息添加；
	 * @param （变量为用户user，类型为Users）；
	 */
	public void UsersAdd(Users user);
	/**
	 * 用户信息删除；
	 * @param （变量为用户ID:userID，类型为int）；
	 */
	public void UsersDelete(int userID);
	/**
	 * 用户信息修改；
	 * @param （变量为用户ID:userID，类型为int）；
	 */
	public void UsersUpdate(int userID);
	/**
	 * 用户信息查询；
	 * @param （变量为用户ID:userID，类型为int）；
	 */
	public void UsersSearch(int userID);

	public Users login(Users user);
	
}