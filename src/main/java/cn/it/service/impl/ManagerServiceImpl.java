package cn.it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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
	
	//管理员登录
	public ModelAndView login(Manager manager) {
		ModelAndView mav =new ModelAndView("managerInterface");
		if(manager==null){
			if(manager.getAccount()==null||manager.getAccount().equalsIgnoreCase("")||
					manager.getPassword()==null||manager.getPassword().equalsIgnoreCase("")){
				mav.setViewName("mlogin");
			}
		}else{
			Manager m = managerDao.login(manager);
			if(m == null){
				mav.setViewName("mlogin");
			}
		}
		return mav;
	}
	//新增管理员账户
	public ModelAndView add(Manager manager) {
		ModelAndView mav =new ModelAndView("mlogin");
		List<Manager> mId =managerDao.managerIdFind();
		Boolean flag = true; 
		for(Manager mana:mId){
			if(mana.getAccount().equals(manager.getAccount())){
				flag = false;
				mav.setViewName("addmanager");
				break;
			}
		}
		if(manager==null){
			mav.setViewName("addmanager");
		}else if(manager.getAccount()==null||manager.getAccount().equalsIgnoreCase("")||
					manager.getPassword()==null||manager.getPassword().equalsIgnoreCase("")){
			mav.setViewName("addmanager");
		}else if(flag){
			managerDao.managerAdd(manager);
			mav.setViewName("managerInterface");
		}
		return mav;
	}
}
