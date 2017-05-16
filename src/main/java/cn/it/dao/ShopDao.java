package cn.it.dao;

import cn.it.pojo.Shop;

import java.util.List;
public interface ShopDao {
	Shop getAllByUserid(int num);
    Shop findByid(int id);
    public void changeInfoByid(Shop shop);
    public void addShop(Shop shop);
    public void deleteShop(Shop shop);
    List<Shop> findShopList();
	List<Shop> findSRList();
	int findUserByid(int id1);
	void updateStatus(int id,int id1);
	List<Shop> findByType(String type);
	List<Shop> findAll();
	List<Shop> searchShop(String str);
	/**
	 * 更新店铺浏览次数
	 * */
	void update(Shop shop);
}
