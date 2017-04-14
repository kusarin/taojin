package cn.it.service;

import java.util.List;
import cn.it.pojo.Comment;

/**
 * 
 * @author sunchen
 *
 */
public interface CommentService {
	public List<Comment> findAll();
	public void delete(int id);
	public void add(Comment comment);
}
