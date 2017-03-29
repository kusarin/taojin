package cn.it.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.ResourceFile;
import cn.it.service.ResourceFileService;

/**
 * 
 * @author sunchen
 *
 */

@Controller
public class ResourceFileController {
	@Resource
	private ResourceFileService resourceFileService;
	@RequestMapping("findResourceFile.do")
	public ModelAndView findResourceFile(HttpServletRequest request){
		ModelAndView modelandview = new ModelAndView("ResourceFile");
		List<ResourceFile> list;
		list = resourceFileService.findAll();
		modelandview.addObject("ResourceFile",list);
		return modelandview;
	}
}
