package cn.it.dao;

import cn.it.pojo.Item;
import cn.it.pojo.Shop;

import java.util.List;
public interface ShopDao {
	List<Shop> getAllByUserid(int num);
    Shop findByid(int id);
    public void changeInfoByid(Shop shop);
    List<Shop> findShopList(int num);
}
