package cn.it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import cn.it.dao.ResourceFileDao;
import cn.it.pojo.ResourceFile;
import cn.it.service.ResourceFileService;

/**
 * 
 * @author sunchen
 *
 */
@Service("resourceFileService")
public class ResourceFileServiceImpl implements ResourceFileService{
	@Autowired
	private ResourceFileDao resourceFileDao;
	
	public List<ResourceFile> findAll(){
		List<ResourceFile> rf = resourceFileDao.findAll();
		return rf;
	}
	
	public ModelAndView add(ResourceFile rf) {
		ModelAndView mav =new ModelAndView("ResourceFile");
		
		if(rf==null){
			mav.setViewName("addRF");
		}else if(rf.getName()==null||rf.getName().equalsIgnoreCase("")||
					rf.getAddress()==null||rf.getAddress().equalsIgnoreCase("")||
					rf.getType()==null||rf.getType().equalsIgnoreCase("")){
			mav.setViewName("addRF");
			mav.addObject("error","信息为空！");
		}else {
			resourceFileDao.add(rf);
		}
		return mav;
	}
	
	public void delete(int id){
		resourceFileDao.delete(id);
	}
}
