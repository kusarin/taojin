package cn.it.service.impl;

import java.util.List;

import cn.it.dao.ItemDao;
import cn.it.dao.ShopInfoDao;
import cn.it.pojo.Item;
import cn.it.pojo.Shop;
import cn.it.service.ShopService;

public class ShopServiceImpl implements ShopService {
	private ShopInfoDao shopinfodao;
	private ItemDao itemdao;

	public Item ItemSearch(int id) {
		// TODO Auto-generated method stub
		return itemdao.ItemSearch(id);
	}

	public Shop findByid(int id) {
		// TODO Auto-generated method stub
		return shopinfodao.findByid(id);
	}

	public List<Shop> findShopList() throws Exception {
		// TODO Auto-generated method stub
		return shopinfodao.findShopList();
	}

	public long viewHits(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
