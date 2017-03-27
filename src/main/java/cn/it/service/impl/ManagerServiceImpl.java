package cn.it.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.it.dao.ManagerDao;
import cn.it.pojo.Manager;
import cn.it.service.ManagerService;

/**
 * 
 * @author sunchen
 * 
 */

@Service("managerService")
public class ManagerServiceImpl implements ManagerService{
	@Autowired
	private ManagerDao managerDao;
	
	public String login(Manager manager) {
		String str = "addmanager";
		if(manager==null){
			if(manager.getAccount()==null||manager.getAccount().equalsIgnoreCase("")||
					manager.getPassword()==null||manager.getPassword().equalsIgnoreCase("")){
				str = "mlogin";
			}
		}else{
			Manager m = managerDao.login(manager);
			if(m == null){
				str = "mlogin";
			}
		}
		return str;
	}
	public void add(Manager manager) {
		String str = "mlogin";
		if(manager==null){
			if(manager.getAccount()==null||manager.getAccount().equalsIgnoreCase("")||
					manager.getPassword()==null||manager.getPassword().equalsIgnoreCase("")){
				str = "addmanager";
			}
		}else {
			managerDao.managerAdd(manager);
		}
		
	}

}
