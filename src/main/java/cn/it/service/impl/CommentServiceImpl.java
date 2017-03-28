package cn.it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.it.dao.CommentDao;
import cn.it.pojo.Comment;

@Service("commentService") 
public class CommentServiceImpl {
	@Autowired
	private CommentDao commentDao;
	
	public List<Comment> findAll(){
//		String str = "managerInterface";
		
		List<Comment> comment = commentDao.findAll();
		
		return comment;
		
	}
}
