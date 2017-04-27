package cn.it.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
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
public class ResourceFileServiceImpl implements ResourceFileService {
	@Autowired
	private ResourceFileDao resourceFileDao;

	// @Autowired
	// private ResourceFile rf;

	public ModelAndView findAll(int page) {
		ModelAndView mav = new ModelAndView("ResourceFile");
		List<ResourceFile> rf = resourceFileDao.findAll();
		int total = rf.size();
		int perPage = 10;
		int totalPage = total / perPage;
		if (total % perPage != 0) {
			totalPage += 1;
		}
		if (page > totalPage || page < 1) {
			page = 1;
			mav.addObject("error", "指定页码不存在!");
		}
		int n = 0;
		List<Integer> pageList = new ArrayList<Integer>();
		for (n = page - 5; n <= totalPage && n <= page + 5; n++) {
			if (n > 0) {
				pageList.add(n);
			}
		}
		if (page < totalPage) {
			List<ResourceFile> r = rf.subList((page - 1) * perPage, 10
					+ (page - 1) * perPage);
			mav.addObject("ResourceFile", r);
		} else {
			List<ResourceFile> r = rf.subList((page - 1) * perPage, rf.size());
			mav.addObject("ResourceFile", r);
		}
		mav.addObject("pageList", pageList);
		mav.addObject("totalPage", totalPage);
		mav.addObject("page", page);
		return mav;
	}

	public ModelAndView add(MultipartFile file, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("managerInterface");
		String path = request.getServletContext().getRealPath("ResourceFile");
		String fileName = file.getOriginalFilename();
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(path + "----------------------");
		ResourceFile rf = new ResourceFile();
		rf.setAddress("/ResourceFile/" + fileName);
		rf.setName(fileName);
		rf.setType(fileName.substring(fileName.indexOf('.')));
		resourceFileDao.add(rf);
		return mav;
	}

	public void delete(int id) {
		resourceFileDao.delete(id);
	}
}
