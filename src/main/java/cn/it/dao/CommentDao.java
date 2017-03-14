package cn.it.dao;

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
	public void CommentsAdd(Comment comment);
	/**
	 * 留言删除；
	 * @param （变量为留言编号 id，类型为int）；
	 */
	public void CommentDelete(int num);
	/**
	 * 留言修改；
	 * @param （变量为留言编号 id，类型为int）；
	 */
	public void CommentUpdate(int num);
	/**
	 * 留言查看；
	 * @param （变量为留言编号 id，类型为int）；
	 */
	public void CommentSearch(int num);
}
