package cn.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import cn.it.dao.CommentDao;
import cn.it.pojo.Comment;
import cn.it.service.CommentService;

@Service("commentService") 
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentDao;
	
	public void delete(int id){
		commentDao.delete(id);
	}
	
	public void add(Comment comment){
		commentDao.add(comment);
	}
	
	public ModelAndView lookComment(int page){
		ModelAndView mav =new ModelAndView("Comment");
		List<Comment> list = commentDao.findAll();
		int total = list.size();
		int perPage = 10;
		int totalPage = total/perPage;
		if(total % perPage != 0){
		    totalPage += 1;
		}
		if(page > totalPage || page < 1){
			page = 1;
			mav.addObject("error", "指定页码不存在!");
		}
		int n = 0;
		List<Integer> pageList = new ArrayList<Integer>();
		for(n = page - 5 ;n <= totalPage && n<= page+5;n++){
			if(n>0){
				pageList.add(n);
			}
		}
		if(page<totalPage){
			List<Comment> c = list.subList((page-1)*perPage, page * perPage);
			mav.addObject("Comment",c);
		}else{
			List<Comment> c = list.subList((page-1)*perPage, list.size());
			mav.addObject("Comment",c);
		}
		mav.addObject("pageList",pageList);
		mav.addObject("totalPage",totalPage);
		mav.addObject("page",page);
		return mav;
	}

}
