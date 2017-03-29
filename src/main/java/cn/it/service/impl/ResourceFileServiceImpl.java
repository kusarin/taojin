package cn.it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
