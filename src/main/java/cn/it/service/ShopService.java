package cn.it.service;
import cn.it.pojo.Item;
import cn.it.pojo.Shop;

import java.util.List;
public interface ShopService {
   Item ItemSearch(int id);
   Shop findByid(int id);
   List<Shop> findShopList(int num);
   long viewHits(Long id);
}
