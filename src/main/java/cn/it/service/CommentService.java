package cn.it.service;


import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Comment;

/**
 * 
 * @author sunchen
 *
 */
public interface CommentService {
	public void delete(int id);
	public void add(Comment comment);
	public ModelAndView lookComment(int page);
}
