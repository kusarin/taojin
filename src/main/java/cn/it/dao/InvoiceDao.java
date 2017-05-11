package cn.it.dao;

import java.util.List;

import cn.it.pojo.Invoice;

public interface InvoiceDao {
    /**
     * 
     * 生成供货清单
     * */
	public void add(Invoice in);
	/****
	 *查询某个店铺的不同状态的发货清单 （已发货、未发货）
	 */
	public List<Invoice> select(int shop_id,int flag,int start, int size);
	/*
	 * 删除某个供货清单
	 * */
	public void delete(int invoice_id);
	/*
	 * 更新发货时间、发货状态
	 * */
	public void update(Invoice in);
	/*
	 * 根据订单号、店铺id查询发货单
	 * */
	public Invoice selectIn(String orderNumber, int shop_id);
}
