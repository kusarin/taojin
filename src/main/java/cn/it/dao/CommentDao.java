package cn.it.dao;

import java.util.List;

import cn.it.pojo.Comment;

/**
 * 
 * @author sunchen
 * 留言的Dao接口,增删改查
 *
 */
public interface CommentDao {
	/**
	 * 留言添加；
	 * @param （变量为留言对象 comment，类型为Comment）；
	 */
	public void add(Comment comment);
	/**
	 * 留言删除；
	 * @param （变量为留言编号 id，类型为int）；
	 */
	public void delete(int num);
	/**
	 * 留言查看；
	 * @param （返回所有留言信息）；
	 */
	public List<Comment> findAll();
}
