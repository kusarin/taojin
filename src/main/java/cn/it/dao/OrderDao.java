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
     public List<Order> selectAll(int userId,int label,int startNo,int pageSize);
     /**
      * 
      * 根据订单号删除订单 
      * */
	public void delete(String orderNumber); 
	/****
	 * 批量删除订单
	 * ***/
	public void deleteAll(String[] orderNumber);
	/**
	 * 计算订单记录总数
	 * */
	public int getCount(int userId,int label);
	/*********
	 * 根据订单状态查询订单
	 * @param(userId用户Id,status：订单状态)
	 * */
	public List<Order> select(int userId,int label,String status,int startNo,int pageSize);
	/****
	 * 设置取消时间
	 * 
	 * */
	public void updateTime(Order o);
	/***
	 * 统计不同状态的订单的数量
	 * */
	public int countNumbers(int userId,String status,int label);
	/*
	 * 查询所有待付款的订单
	 * */
	public List<Order> get(String status);
	/****
	 * 设置付款时间
	 * 
	 * */
	public void updatePayTime(Order o);
	/**
	 *收货时间 
	 */
	public void updateReceGoodsTime(Order o); 
	/****
	 * 评价时间
	 * */
	public void updateEvalTime(Order o);
	
}
