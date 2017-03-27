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
	
}
