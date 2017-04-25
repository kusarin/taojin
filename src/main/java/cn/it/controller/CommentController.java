package cn.it.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView lookComment(int page) {
		return commentService.lookComment(page);
	}

	@RequestMapping("deleteComment.do")
	public String delete(@RequestParam("id") String id) {
		int id1 = Integer.parseInt(id);
		commentService.delete(id1);
		return "redirect:lookComment.do?page=1";
	}

	@RequestMapping("addComment.do")
	public ModelAndView add(Comment comment) {
		commentService.add(comment);
		return new ModelAndView("redirect:Itemlist.do");
	}

}
