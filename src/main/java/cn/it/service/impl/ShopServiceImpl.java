package cn.it.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

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
    
	public List<Shop> getAllByUserid(int num){
		return shopDao.getAllByUserid(num);
	}
	public void changeInfoByid(Shop shop){
		shopDao.changeInfoByid(shop);
	}
    public void addShop(Shop shop){
    	shopDao.addShop(shop);
    }
    public void deleteShop(Shop shop){
    	shopDao.deleteShop(shop);
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
