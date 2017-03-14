package cn.it.dao;

import cn.it.pojo.Users;


/**
 * @author wz;
 *
 * 用户信息的Dao类
 * */

public interface UsersDao {
	
	
	public void UsersAdd(Users user);
	public void UsersDelete(int num);
	public void UsersUpdate(int num);
	public void UsersSearch(int num);
	
}