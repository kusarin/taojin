package cn.it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.it.dao.ItemDao;
import cn.it.dao.ShopDao;
import cn.it.pojo.Item;
import cn.it.pojo.Shop;
import cn.it.service.ShopService;
@Service("ShopService")
public class ShopServiceImpl implements ShopService {
	@Autowired
	//@Qualifier("shopDao")
	private ShopDao shopDao;
	@Autowired
	private ItemDao itemDao;

	public Item ItemSearch(int id) {
		// TODO Auto-generated method stub
		return itemDao.ItemSearch(id);
	}

	public Shop findByid(int id) {
		// TODO Auto-generated method stub
		return shopDao.findByid(id);
	}

	public List<Shop> findShopList(int num){
		// TODO Auto-generated method stub
		return shopDao.findShopList(num);
	}

	public long viewHits(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
