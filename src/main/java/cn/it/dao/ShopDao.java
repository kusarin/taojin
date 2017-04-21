package cn.it.dao;

import cn.it.pojo.Shop;

import java.util.List;
public interface ShopDao {
	List<Shop> getAllByUserid(int num);
    Shop findByid(int id);
    public void changeInfoByid(Shop shop);
    public void addShop(Shop shop);
    public void deleteShop(Shop shop);
    List<Shop> findShopList(int num);
	List<Shop> findSRList();
	int findUserByid(int id1);
	void updateStatus(int id,int id1);
	List<Shop> findAll();
	List<Shop> searchShop(String str);
}
