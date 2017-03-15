package cn.it.dao;

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
	/**
	 *获取 OrderDetail表中的详细信息
	 * @param(id 表示OrderDetail表的主键)
	 * 
	 **/
	public OrderDetail select(int id);
	
}
