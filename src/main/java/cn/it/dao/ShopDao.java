package cn.it.dao;

import cn.it.pojo.Item;
import cn.it.pojo.Shop;

import java.util.List;
public interface ShopDao {
	List<Shop> getAllByUserid(int num);
    Shop findByid(int id);
    public Shop changeInfoByid(int id);
    List<Shop> findShopList(int num);
}
