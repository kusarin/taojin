package cn.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
	public ModelAndView login(Manager manager,HttpSession session) {
		ModelAndView mav =new ModelAndView("managerInterface");
		if(manager.getAccount()==null||manager.getAccount().equalsIgnoreCase("")||
			manager.getPassword()==null||manager.getPassword().equalsIgnoreCase("")){
			mav.addObject("error","账户或密码为空！");
			mav.setViewName("mlogin");
			
		}else{
			Manager m = managerDao.login(manager);
			if(m == null){
				mav.addObject("error","账户或密码错误！");
				mav.setViewName("mlogin");
			}else{
				session.setAttribute("manager", m);
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
			mav.addObject("error","账户名或密码不能为空！");
			mav.setViewName("addmanager");
		}else if(flag){
			managerDao.managerAdd(manager);
			mav.setViewName("managerInterface");
		}else{
			mav.addObject("error","账户名重复！");
		}
		return mav;
	}
	
	public ModelAndView update(Manager manager) {
		ModelAndView mav =new ModelAndView("managerInterface");

		if(manager.getPassword()==null||manager.getPassword().equalsIgnoreCase("")){
			mav.addObject("error", "新密码为空！");
			mav.setViewName("updateMpassword");
		}else if(manager.getAccount()==null||manager.getAccount().equalsIgnoreCase("")){
			mav.addObject("error", "session已过期！请重新登录！");
			mav.setViewName("updateMpassword");
		}else{
			managerDao.managerUpdate(manager);
		}
		return mav;
	}

	public List<Integer> pageList(int page,int totalPage){
		int n;
		List<Integer> pageList = new ArrayList<Integer>();
		for(n = page - 5 ;n <= totalPage && n<= page+5;n++){
			if(n>0){
				pageList.add(n);
			}
		}
		return pageList;
	}
	
	public int totalPage(int total){
		int perPage = 10;
		int totalPage = total/perPage;
		if(total % perPage != 0){
		    totalPage += 1;
		}
		return totalPage;
	}
	
}
