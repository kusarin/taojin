package cn.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import cn.it.dao.ResourceFileDao;
import cn.it.pojo.Comment;
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
	
	public ModelAndView findAll(int page){
		ModelAndView mav = new ModelAndView("ResourceFile");
		List<ResourceFile> rf = resourceFileDao.findAll();
		int total = rf.size();
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
			List<ResourceFile> r = rf.subList((page-1)*perPage, 10 +(page-1)*perPage);
			mav.addObject("ResourceFile",r);
		}else{
			List<ResourceFile> r = rf.subList((page-1)*perPage, rf.size());
			mav.addObject("ResourceFile",r);
		}
		mav.addObject("pageList",pageList);
		mav.addObject("totalPage",totalPage);
		mav.addObject("page",page);
		return mav;
	}
	
	public ModelAndView add(ResourceFile rf) {
		ModelAndView mav =new ModelAndView("managerInterface");
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
