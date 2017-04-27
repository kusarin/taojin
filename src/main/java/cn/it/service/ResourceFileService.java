package cn.it.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @author sunchen
 *
 */
public interface ResourceFileService {
	public ModelAndView findAll(int page);

	public ModelAndView add(MultipartFile file, HttpServletRequest request);
	
	public void delete(int id);
}
