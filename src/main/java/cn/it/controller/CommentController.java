package cn.it.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Comment;
import cn.it.service.CommentService;

/**
 * 
 * @author sunchen
 * 
 */

@Controller
public class CommentController {
	@Resource
	private CommentService commentService;
	@RequestMapping("lookComment.do")
	public ModelAndView lookComment(HttpServletRequest request){
		ModelAndView modelandview = new ModelAndView("Comment");
		List<Comment> list;
		list = commentService.findAll();
		modelandview.addObject("Comment",list);
		return modelandview;
	}
}
