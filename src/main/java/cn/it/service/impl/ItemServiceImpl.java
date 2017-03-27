package cn.it.service.impl;

import java.util.List;




import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import cn.it.dao.ItemDao;
import cn.it.pojo.Item;
import cn.it.service.ItemService;

/**
 * 
 * @author zhj
 *
 */

@Service("itemService")
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao itemDao;
	
	/**
	 * 查看单条商品信息
	 */
	public Item find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * 通过调用itemDao.FindAll()查看所有商品
	 */
	public List<Item> findItemList() {
		// TODO Auto-generated method stub
		return itemDao.FindAll();
	}
	/**
	 * 测试是否已经传值
	 */
	@Test
	public void test1(){
		 ApplicationContext ac=new ClassPathXmlApplicationContext("config.xml");
		 ItemDao item= (ItemDao) ac.getBean("itemDao");
	     List<Item> i=item.FindAll();
	     if(i!=null){
	    	 System.out.println(i.size());
	     }
	   
	}
	
}