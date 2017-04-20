package cn.it.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView findResourceFile(){
		ModelAndView modelandview = new ModelAndView("ResourceFile");
		List<ResourceFile> list = resourceFileService.findAll();
		modelandview.addObject("ResourceFile",list);
		return modelandview;
	}
	
	@RequestMapping("addRF.do")
	public ModelAndView addRF(ResourceFile rf){
		ModelAndView result = resourceFileService.add(rf);
		result.setViewName("redirect:findResourceFile.do");
		return result;
	}
	
	@RequestMapping("deleteRF.do")
	public String delete(@RequestParam("id") String id){
		int id1=Integer.parseInt(id);
		resourceFileService.delete(id1);
		return "redirect:findResourceFile.do";
	}
}
