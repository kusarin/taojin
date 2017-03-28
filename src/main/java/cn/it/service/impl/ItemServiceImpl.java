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
	 * 
	 * @param shop_id 店铺编号，int
	 * @param name 商品名称，String
	 * @param part 商品类别，String
	 * @param typeh 商品一级分类，String
	 * @param typel 商品二级分类，String
	 * @param number 商品数量，int
	 * @param price 商品价格，double
	 * @param detail 商品描述，String
	 * @param image 商品图片，String
	 * 
	 * @return String 返回值为一个提示信息，String
	 */
	public String addItem(int shop_id,String name, String part, String typeh, String typel,
			String number, String price, String detail, String image) {	
		// 判断传入参数是否为空 
		if(name==null||name.equals("")
				||part==null||part.equals("")
				||typeh==null||typeh.equals("")
				||typel==null||typel.equals("")
				||number==null||number.equals("")
				||price==null||price.equals("")
				||detail==null||detail.equals("")
				||image==null||image.equals("")){
			
			// 返回提示信息 "输入数据不能为空！！！"
			return "输入数据不能为空！！！";
			
		}else{// 参数不为空时候，执行添加操作
			
			// 将商品数量和价格转为规定格式：商品数量int，商品价格double
			int num = Integer.parseInt(number);
			double pri = Double.parseDouble(price);
			
			// 定义商品；
			Item i = new Item();
			// 设置商品属性；
			i.setshop_id(shop_id);  // 店鋪编号
			i.setname(name);        // 商品名称
			i.setpart(part);        // 商品类别
			i.settypeh(typeh);      // 商品一阶类型
			i.settypel(typel);      // 商品二阶类型
			i.setnumber(num);       // 商品数量
			i.setprice(pri);        // 商品价格
			i.setdetail(detail);    // 商品描述
			i.setimage(image);      // 商品图片
			
			// 设置浏览次数和出售数量初始值为0；
			i.setbrowsingTimes(0);
			i.settradingTimes(0);
			
			// 添加商品信息；
			itemDao.ItemAdd(i);	
			// 返回提示信息 "上架商品成功！！！"
			return "上架商品成功！！！";
		}
	}
	
	/**
	 * 删除商品
	 * 
	 * @param item_id 商品编号，int
	 * 
	 * @return String 返回值为一个提示信息，String
	 */
	public String deleteItem(int item_id) {
		itemDao.ItemDelete(item_id);	
		// 返回提示信息 "下架商品成功！！！"
		return "下架商品成功！！！";
	}

	/**
	 * 更新商品
	 * 
	 * @param item_id 商品编号，int
	 * @param name 商品名称，String
	 * @param part 商品类别，String
	 * @param typeh 商品一级分类，String
	 * @param typel 商品二级分类，String
	 * @param number 商品数量，int
	 * @param price 商品价格，double
	 * @param detail 商品描述，String
	 * @param image 商品图片，String
	 * 
	 * @return String 返回值为一个提示信息，String
	 */
	public String updateItem(int item_id,String name,String part,String typeh,String typel,
			String number,String price,String detail,String image) {
		// 判断传入参数是否为空 
		if(name==null||name.equals("")
			||part==null||part.equals("")
			||typeh==null||typeh.equals("")
			||typel==null||typel.equals("")
			||number==null||number.equals("")
			||price==null||price.equals("")
			||detail==null||detail.equals("")
			||image==null||image.equals("")){
			
			// 返回提示信息 "输入数据不能为空！！！"		
			return "输入数据不能为空！！！";
					
		}else{// 参数不为空时候，执行修改操作
			
			// 将商品数量和价格转为规定格式：商品数量int，商品价格double
			int num = Integer.parseInt(number);
			double pri = Double.parseDouble(price);
		
			// 定义商品；
			Item i = new Item();
			// 设置商品属性；
			i.setitem_id(item_id);    // 商品编号
			i.setname(name);          // 商品名称
			i.setpart(part);          // 商品类别
			i.settypeh(typeh);        // 商品一阶类型
			i.settypel(typel);        // 商品二阶类型
			i.setnumber(num);         // 商品数量
			i.setprice(pri);          // 商品价格
			i.setdetail(detail);      // 商品描述
			i.setimage(image);        // 商品图片
			
			// 更新商品信息
			itemDao.ItemUpdate(i);
			// 返回提示信息 "修改商品信息成功！！！"
			return "修改商品信息成功！！！";
		}
	}
	
	/**
	 * 通过调用itemDao.FindItemById(),查看单个商品信息
	 * 
	 * @param item_id 商品编号，int
	 * 
	 * @return Item 返回值为一个商品
	 */
	public Item findById(int item_id) { 
		return itemDao.FindItemById(item_id);
	}
		
	/**
	 * 通过调用itemDao.FindAll(),查看所有商品
	 * 
	 * @return List<Item> 返回值为一个商品列表，包括一个或者多个商品
	 */
	public List<Item> findItemList() {	
		return itemDao.FindAll();
	}
	
	/**
	 * 通过调用itemDao.FindItemByType()，根据所选的类型查看商品
	 * 
	 * @param typeh 商品一阶类型，String
	 * @param typel 商品二阶类型，String
	 * 
	 * @return List<Item> 返回值为一个商品列表，包括一个或者多个商品
	 */
	public List<Item> findByType(String typeh,String typel){
		return itemDao.FindItemByType(typeh, typel);
	}	
	
//	// 判断输入字符串是否为数字的方法，用来判断number和price是否为数字【听说可以在前端网页执行，所以先注释掉】
//	public static boolean isNumeric(String str){
//		for (int i = 0; i < str.length(); i++){
//			System.out.println(str.charAt(i));
//			if (!Character.isDigit(str.charAt(i))){
//				return false;
//			}
//		}
//		return true;
//	}
	
/*******************************测试类,用于测试能否成功调用来自Dao层的方法*************************************/	
	/**
	 * 测试1，用于测试是否添加商品
	 */
	@Test
	public void test1(){
		 ApplicationContext ac=new ClassPathXmlApplicationContext("config.xml");
		 ItemDao itemdao= (ItemDao) ac.getBean("itemDao");
		 Item i = new Item();
	 
			// 设置商品属性；
		 	i.setshop_id(1);
			i.setname("第五个商品");
			i.setpart("拍卖品");
			i.settypeh("高级分类1");
			i.settypel("低级分类2");
			i.setnumber(23);
			i.setprice(150.25);
			i.setdetail("五个详细信息");
			i.setimage("这就是一张图片");

		     System.out.println("设置商品属性完成");
			// 设置浏览次数和出售数量初始值为0；
			i.setbrowsingTimes(0);
			i.settradingTimes(0);
			
		 
	     itemdao.ItemAdd(i);
	     System.out.println("添加成功！！！");
	}
	
	/**
	 * 测试2，用于测试是否删除商品
	 */
	@Test
	public void test2(){
		 ApplicationContext ac=new ClassPathXmlApplicationContext("config.xml");
		 ItemDao itemdao= (ItemDao) ac.getBean("itemDao");
	     itemdao.ItemDelete(5);
	     System.out.println("删除成功！！！");
	}
	
	/**
	 * 测试3，用于测试是否修改商品
	 */
	@Test
	public void test3(){
		 ApplicationContext ac=new ClassPathXmlApplicationContext("config.xml");
		 ItemDao itemdao= (ItemDao) ac.getBean("itemDao");
		 
		 Item i =  new Item();
	     System.out.println("设置完成");
	 
			// 设置商品属性；
	     	i.setitem_id(5);
			i.setname("第7个商品");
			i.setpart("拍卖品");
			i.settypeh("高级分类2");
			i.settypel("低级分类1");
			i.setnumber(41);
			i.setprice(158.23);
			i.setdetail("7个详细信息");
			i.setimage("这999是一张图片");
			
	     itemdao.ItemUpdate(i);
	     System.out.println("修改成功！！！");
	}
	
	/**
	 * 测试4，用于测试FindAll()是否已经传值；
	 */
	@Test
	public void test4(){
		 ApplicationContext ac=new ClassPathXmlApplicationContext("config.xml");
		 ItemDao itemdao= (ItemDao) ac.getBean("itemDao");
	     List<Item> i=itemdao.FindAll();
	     System.out.println(i);   
	}
	
	/**
	 * 测试5，用于测试FindItemById(id)是否传值
	 */
	@Test
	public void test5(){
		 ApplicationContext ac=new ClassPathXmlApplicationContext("config.xml");
		 ItemDao itemdao= (ItemDao) ac.getBean("itemDao");
		 int id = 1;
	     Item i = itemdao.FindItemById(id);
	     System.out.println(i);  
	}
	
	/**
	 * 测试6，用于测试FindItemByType(typeh,typel)是否传值
	 */
	@Test
	public void test6(){
		 ApplicationContext ac=new ClassPathXmlApplicationContext("config.xml");
		 ItemDao itemdao= (ItemDao) ac.getBean("itemDao");
		 String typeh = "高级分类1";
		 String typel = "低级分类1";
	     List<Item> i = itemdao.FindItemByType(typeh,typel);
    	 System.out.println(i); 
	}	
}