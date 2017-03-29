package cn.it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import cn.it.dao.ResourceFileDao;
import cn.it.pojo.Manager;
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
		ModelAndView mav =new ModelAndView("mlogin");
		
		if(rf==null){
			mav.setViewName("ResourceFile");
		}else if(rf.getName()==null||rf.getName().equalsIgnoreCase("")||
					rf.getAddress()==null||rf.getAddress().equalsIgnoreCase("")||
					rf.getType()==null||rf.getType().equalsIgnoreCase("")){
			mav.setViewName("ResourceFile");
		}else {
			resourceFileDao.add(rf);
			mav.setViewName("managerInterface");
		}
		return mav;
	}
}
