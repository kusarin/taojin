package cn.it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.it.dao.CommentDao;
import cn.it.pojo.Comment;
import cn.it.service.CommentService;

@Service("commentService") 
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentDao;
	
	public List<Comment> findAll(){
		
		List<Comment> comment = commentDao.findAll();
		
		return comment;
		
	}
}
