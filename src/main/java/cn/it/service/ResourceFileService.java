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
	public List<ResourceFile> findAll();

	public ModelAndView add(ResourceFile rf);
}
