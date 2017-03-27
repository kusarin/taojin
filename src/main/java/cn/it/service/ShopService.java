package cn.it.service;
import cn.it.pojo.Item;
import cn.it.pojo.Shop;

import java.util.List;
public interface ShopService {
   Shop findByid(int id);
   List<Shop> getAllByUserid(int num);
   List<Shop> findShopList(int num);
   public Shop changeInfoByid(int num);
   long viewHits(Long id);
}
