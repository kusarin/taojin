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
 * 商品的Service层操作类
 * 
 */

@Service("itemService")
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao itemDao;
	
	/**
	 * 添加商品
	 * @param name 商品名称，String
	 * @param part 商品类别，String
	 * @param typeh 商品一级分类，String
	 * @param typel 商品二级分类，String
	 * @param number 商品数量，int
	 * @param price 商品价格，double
	 * @param detail 商品描述，String
	 * @param image 商品图片，String
	 */
	public void addItem(String name, String part, String typeh, String typel,
			int number, double price, String detail, String image) {
		
		// 定义商品；
		Item i = null;
		// 设置商品属性；
		i.setname(name);
		i.setpart(part);
		i.settypeh(typeh);
		i.settypel(typel);
		i.setnumber(number);
		i.setprice(price);
		i.setdetail(detail);
		i.setimage(image);
		
		// 浏览次数和出售数量初始值为0；
		i.setbrowingTimes(0);
		i.setSaleNumbers(0);
		
		// 添加商品信息；
		itemDao.ItemAdd(i);
		
	}
	
	/**
	 * 删除商品
	 * @param id 商品编号，int
	 */
	public void deleteItem(int id) {
		itemDao.ItemDelete(id);
		
	}

	/**
	 * 更新商品
	 * @param name 商品名称，String
	 * @param part 商品类别，String
	 * @param typeh 商品一级分类，String
	 * @param typel 商品二级分类，String
	 * @param number 商品数量，int
	 * @param price 商品价格，double
	 * @param detail 商品描述，String
	 * @param image 商品图片，String
	 */
	public void updateItem(String name,String part,String typeh,String typel,
			int number,double price,String detail,String image) {
		
		// 定义商品；
		Item i = null;
		// 设置商品属性；
		i.setname(name);
		i.setpart(part);
		i.settypeh(typeh);
		i.settypel(typel);
		i.setnumber(number);
		i.setprice(price);
		i.setdetail(detail);
		i.setimage(image);
		
		// 更新商品信息
		itemDao.ItemUpdate(i);
	}
	
	/**
	 * 查看单条商品信息
	 * @param id 商品编号，int
	 */
	public Item findById(int id) {
		// TODO Auto-generated method stub
		return itemDao.FindItemById(id);
	}
		
	/**
	 * 通过调用itemDao.FindAll()查看所有商品
	 */
	public List<Item> findItemList() {
		// TODO Auto-generated method stub
		return itemDao.FindAll();
	}
	
	/**
	 * 通过调用itemDao.FindItemByType，根据所选的类型查看商品
	 * @param typeh 商品一级分类，String
	 * @param typel 商品二级分类，String
	 */
	public List<Item> findByType(String typeh,String typel){
		return itemDao.FindItemByType(typeh, typel);
	}	
	
	
	/*******************************测试类*************************************/
	
	/**
	 * 测试1，用于测试FindAll()是否已经传值；
	 */
	@Test
	public void test1(){
		 ApplicationContext ac=new ClassPathXmlApplicationContext("config.xml");
		 ItemDao item= (ItemDao) ac.getBean("itemDao");
	     List<Item> i=item.FindAll();
	     System.out.println(i);   
	}
	
	/**
	 * 测试2，用于测试FindItemById(id)是否传值
	 */
	@Test
	public void test2(){
		 ApplicationContext ac=new ClassPathXmlApplicationContext("config.xml");
		 ItemDao item= (ItemDao) ac.getBean("itemDao");
		 int id = 1;
	     Item i = item.FindItemById(id);
	     System.out.println(i);  
	}
	/**
	 * 测试3，用于测试FindItemByType(typeh,typel)是否传值
	 */
	@Test
	public void test3(){
		 ApplicationContext ac=new ClassPathXmlApplicationContext("config.xml");
		 ItemDao item= (ItemDao) ac.getBean("itemDao");
		 String typeh = "高级分类1";
		 String typel = "低级分类1";
	     List<Item> i = item.FindItemByType(typeh,typel);
    	 System.out.println(i); 
	}
	
	/**
	 * 测试4，用于测试是否删除商品
	 */
	@Test
	public void test4(){
		 ApplicationContext ac=new ClassPathXmlApplicationContext("config.xml");
	     System.out.println("K1");
		 ItemDao item= (ItemDao) ac.getBean("itemDao");
	     System.out.println("K2");
	     item.ItemDelete(5);
	     System.out.println("删除成功");
	}

}