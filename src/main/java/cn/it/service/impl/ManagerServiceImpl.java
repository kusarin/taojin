package cn.it.service.impl;

import java.util.List;

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
		String str = "managerInterface";
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
	//新增管理员账户
	public String add(Manager manager) {
		String str = "mlogin";
		List<Manager> mId =managerDao.managerIdFind();
		Boolean flag = true; 
		for(Manager mana:mId){
			if(mana.getAccount().equals(manager.getAccount())){
				flag = false;
				str = "addmanager";
				break;
			}
			
		}
		if(manager==null){
			str = "addmanager";
		}else if(manager.getAccount()==null||manager.getAccount().equalsIgnoreCase("")||
					manager.getPassword()==null||manager.getPassword().equalsIgnoreCase("")){
			str = "addmanager";
		}else if(flag){
			managerDao.managerAdd(manager);
			str = "managerInterface";
		}
		return str;
	}

}
