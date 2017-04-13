package cn.it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.it.dao.ShopDao;
import cn.it.dao.ShopRequestDao;
import cn.it.pojo.Shop;
import cn.it.pojo.ShopRequest;
import cn.it.service.ShopRequestService;

@Service("ShopRequestService")
public class ShopRequestServiceImpl implements ShopRequestService{
	@Autowired
	private ShopRequestDao shopRequestDao;
	private Shop shop;
	private ShopDao shopDao;
	
	public List<ShopRequest> findAll(){
		List<ShopRequest> SR = shopRequestDao.findAll();
		return SR;
	}

	public void delete(int num) {
		shopRequestDao.delete(num);
	}

	public void passSR(int num) {
		ShopRequest SR = shopRequestDao.findById(num);
		shop.setName(SR.getName());
		shop.setType(SR.getType());
		shop.setIntro(SR.getIntro());
		shop.setUser_ID(SR.getUser_id());
		shopDao.addShop(shop);
		shopRequestDao.delete(num);
	}

	public ShopRequest find(int num) {
		return shopRequestDao.findById(num);
	}
}
