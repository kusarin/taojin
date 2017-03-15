package cn.it.dao;

import cn.it.pojo.Order;

/**
 * 
 * Order（订单）的接口
 */
public interface OrderDao {
	/***
	 * 添加订单记录
	 * @param(参数类型为Order)
	 */
	public void add(OrderDao order);
	/**
	 * 获取订单信息
	 * @return(Order表示返回一个订单对象)
	 * @param(id订单表中唯一标识一个订单记录)
	 */
     public Order select(int id);
     /**
      * 更改订单中的交易状态（待付款、交易成功、交易失败）
      * @param(id 指一个订单记录的唯一标识)
      */
     public void update(int id);
}
