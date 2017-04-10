package cn.it.dao;

import java.util.List;

import cn.it.pojo.Order;
import java.lang.String;
/**
 * 
 * Order（订单）的接口
 */
public interface OrderDao {
	/***
	 * 添加订单记录
	 * @param(参数类型为Order)
	 */
	public void add(Order order);
     /**
      * 根据订单号查询订单
      * */
     public Order findOrder(String orderNumber);
     /**
      * 更改订单中的交易状态（待付款、交易成功、交易失败）
      * @param(or 指一个订单记录的实体)
      */
     public void update(Order or);
     /***
      * 根据用户编号查询该用户的所有订单*
      * 
      * */
     public List<Order> selectAll(int userId);
     /**
      * 
      * 根据订单号删除订单 
      * */
	public void delete(String orderNumber);     
}
