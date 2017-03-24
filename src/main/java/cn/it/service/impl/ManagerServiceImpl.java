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
	
	public String login(String account, String password) {
		String str = "welcome";
		if(account==null||account.equals("")||password==null||password.equals("")){
			str = "mlogin";
		}else{
			Manager manager = managerDao.login(account, password);
			if(manager == null){
				str = "mlogin";
			}
		}
		
		return str;
	}
	
}
