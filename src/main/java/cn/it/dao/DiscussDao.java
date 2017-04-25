package cn.it.dao;

import java.util.List;
import cn.it.pojo.Discuss;

/**
 * 
 * @author zhj
 * 
 *  评论的Dao层定义接口
 *
 */
public interface DiscussDao {
	
	/**
	 * 添加商品评论方法
	 * 
	 * @param discuss
	 */
	public void addDiscuss1(Discuss discuss);
	
	/**
	 * 查看某个商品的所有评论
	 * 
	 * @param item_id 商品编号
	 * @return List<Discuss> 返回值为一个评论列表，包括一个或者多个评论
	 */
	public List<Discuss> FindItemDiscuss(int item_id);
}
