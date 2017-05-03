package cn.it.dao;

import java.util.List;

import cn.it.pojo.Lot;

/**
 * 
 * @author zhj
 * 
 * 拍卖品的Dao层接口定义
 *
 */
public interface LotDao {

	/**
	 * 添加拍卖品方法
	 * 
	 * @param l 拍卖品，Lot
	 */
	public void LotAdd(Lot l);
	/**
	 * 删除拍卖品方法
	 * 
	 * @param lot_id 拍卖品编号，int
	 */
	public void LotDelete(int lot_id);
	/**
	 * 修改拍卖品方法
	 * 
	 * @param l 拍卖品，Lot
	 */
	public void LotUpdate(Lot l);
	/**
	 * 按照拍卖品编号查看拍卖品；
	 * 
	 * @param id 拍卖品编号，int
	 * 
	 * @return Lot 返回值为一个拍卖品
	 */
	public Lot FindLotById(int lot_id);
	/**
	 * 查看所有拍卖品；
	 * 
	 * @return List<Lot> 返回值为一个拍卖品列表，包括一个或者多个拍卖品
	 */
	public List<Lot> FindAll();
	/**
	 * 按照拍卖品类型查看拍卖品1；
	 * 
	 * @param typeh 拍卖品一级分类，String
	 * 
	 * @return List<Lot> 返回值为一个拍卖品列表，包括一个或者多个拍卖品
	 */
	public List<Lot> FindLotByType1(String typeh);
	/**
	 * 按照拍卖品类型查看拍卖品2；
	 * 
	 * @param typeh 拍卖品一级分类，String
	 * @param typel 拍卖品二级分类，String
	 * 
	 * @return List<Lot> 返回值为一个拍卖品列表，包括一个或者多个拍卖品
	 */
	public List<Lot> FindLotByType2(String typeh,String typel);
	/**
	 * 按照拍卖品对应的店铺编号来获取拍卖品；
	 * 用于在店铺中显示所有归属于该店铺的所有拍卖品；
	 * 
	 * @param shop_id 店铺编号，int
	 * 
	 * @return List<Lot> 返回值为一个拍卖品列表，包括一个或者多个拍卖品
	 */
	public List<Lot> FindLotByShopId(int shop_id);
	/**
	 * 按照输入的关键词查看拍卖品
	 * 
	 * @param str 传入的查询字段
	 * 
	 * @return List<Lot> 返回值为一个拍卖品列表，包括一个或者多个商品
	 */
	public List<Lot> SearchLot(String str);
}
