package cn.it.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.ResourceFile;

/**
 * 
 * @author sunchen
 *
 */
public interface ResourceFileService {
	public ModelAndView findAll(int page);

	public ModelAndView add(ResourceFile rf);
	
	public void delete(int id);
}
