package cn.it.service.impl;

import java.util.ArrayList;


import java.util.Iterator;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.it.dao.OrderDao;
import cn.it.dao.OrderDetailDao;
import cn.it.pojo.Order;
import cn.it.pojo.OrderCollection;
import cn.it.pojo.OrderDetail;
import cn.it.service.OrderService;

/**
 * 
 * 对订单进行处理
 * 包括提交订单、保存生成的订单信息、读取订单信息、查看所有订单、查看订单详情
 * 删除订单
 * 修改订单中的交易状态
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDetailDao orderDetailDao;
	@Autowired
	private OrderDao orderDao;
	/**
	 * 获取订单详情
	 * @param(num表示用户编号)
	 * 
	 * */
	public List<OrderDetail> getALLItem(int num){
		List<Order> olist=orderDao.selectAll(num);//根据用户标号获取订单
		List<OrderDetail> rlist=new ArrayList<OrderDetail>();//创建存放订单明细的容器
		Iterator<Order> order = olist.iterator();//生成订单迭代器
		while(order.hasNext()){ //订单容器不为空
		    Order or= order.next();//提取容器中的元素
		    if(orderDetailDao.selectAll(or.getId())!=null){  //根据订单id查询订单明细
		    	List<OrderDetail> list=orderDetailDao.selectAll(or.getId());//获取订单明细对应的容器
		    	Iterator<OrderDetail> od = list.iterator();//获取迭代器
		    	while(od.hasNext()){ //容器不为空
		    	    OrderDetail ol= od.next(); //获取容器中的一个元素
		    	    rlist.add(ol);//将元素加入容器
		    	}
		    }
		}
		return rlist;
	}
    /**roe
     *获取订单详情
	 * @param(num表示用户编号) 
     * */
	public List<Order> getAllOrder(int num){
		
		return orderDao.selectAll(num);
	}
	/**
	 * 
	 * 合并两个list
	 * */
	public List<OrderCollection> mergeList(List<Order> orderList,List<OrderDetail> orderDetailList){
		List<OrderCollection> collection = new ArrayList<OrderCollection>();
		Iterator<Order> iter1=orderList.iterator();
		Iterator<OrderDetail> iter2=orderDetailList.iterator();
		
		  while(iter1.hasNext()&&iter2.hasNext()){
		    	OrderCollection orderCollection =new OrderCollection();
		    	orderCollection.setOrder(iter1.next());
		    	orderCollection.setOrderDeatail(iter2.next());
		    	collection.add(orderCollection);
		    }
		return collection;
	}
}
