package cn.it.dao;

import java.util.List;

import cn.it.pojo.OrderDetail;

/**
 * 
 * OrderDetail 订单详情接口
 * */
 
public interface OrderDetailDao {
   
	/**
	 * 将信息插入OrderDetail（订单详情）表
	 * @param(orderDetail是OrderDetail类型)
	 **/
	public void add(OrderDetail orderDetail);
	/***
	 * 根据订单号查询对应的所有商品的信息
	 * @param(id订单表的唯一标识)
	 * */
	public List<OrderDetail> selectAll(String orderNumber);
	/***
	 *
	 * 根据订单号删除对应订单明细
	 */
	public void delete(String orderNumber);
	
	/****
	 * 
	 * 批量删除
	 * **/
	public void deleteAll(String[] orderNumber);
	
	/*****
	 * 根据订单号、商品编号查询
	 * **/
	public OrderDetail findOr(String orderNumber, int itemId);
	
	/*更新订单中商品状态
	 * */
	public void update(OrderDetail or);
	/*
	 * 更新订单中的商品是否已经发货
	 * */
	public void updateFlag(OrderDetail or);
	/*
	 *商品发货时间 
	 */
	public void updateDeverliTime(OrderDetail o);
	/**
	 * 根据订单号查询
	 * */
	public List<OrderDetail> selectO(String orderNumber);
	/**
	 * 根据订单号查询
	 * 所包含的拍卖品
	 * */
	public List<OrderDetail> getLot(String orderNumber);
	
}
