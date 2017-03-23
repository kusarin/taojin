package cn.it.dao;

import cn.it.pojo.Item;
import cn.it.pojo.Shop;

import java.util.List;
public interface ShopDao {
    public void showInfo(Shop shop);
    Shop findByid(int id);
    List<Shop> findShopList(int num);
}
