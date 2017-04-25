package cn.it.dao;

import cn.it.pojo.Typel;

/**
 * 
 * @author zhj
 * 
 *  商品二阶类型 的Dao层定义接口
 *
 */
public interface TypelDao {
	/**
	 * 按照商品二阶类型名称查看商品二阶类型
	 * 
	 * @param name 商品二阶类型名称，String
	 * @return Typel
	 */
	public Typel FindTypelByName(String name);
}
