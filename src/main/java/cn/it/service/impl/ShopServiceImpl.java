package cn.it.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.it.dao.ShopDao;
import cn.it.pojo.Shop;
import cn.it.pojo.Users;
import cn.it.service.ShopService;
@Service("ShopService")
public class ShopServiceImpl implements ShopService {
	@Autowired
	//@Qualifier("shopDao")
	private ShopDao shopDao;
    
	public Shop getAllByUserid(int num){
		return shopDao.getAllByUserid(num);
	}
	public void changeInfoByid(Shop shop){
		shopDao.changeInfoByid(shop);
	}
	public List<Shop> searchShop(String str){
		return shopDao.searchShop(str);
	}
	public List<Shop> findByType(String type){
		return shopDao.findByType(type);
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

	public List<Shop> findShopList(){
		// TODO Auto-generated method stub
		return shopDao.findShopList();
	}

	public long viewHits(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	public List<Shop> findSR() {
		return shopDao.findSRList();
	}
	public int findUserId(int id1) {
		return shopDao.findUserByid(id1);
	}
	public void passSR(int id1) {
		int i = 1;
		shopDao.updateStatus(i,id1);
	}
	public void refuseSR(int id1) {
		int i = 2;
		shopDao.updateStatus(i,id1);
	}
	public List<Integer> pageList(int page,int totalPage){
		int n;
		List<Integer> pageList = new ArrayList<Integer>();
		for(n = page - 5 ;n <= totalPage && n<= page+5;n++){
			if(n>0){
				pageList.add(n);
			}
		}
		return pageList;
	}
	
	public int totalPage(int total){
		int perPage = 10;
		int totalPage = total/perPage;
		if(total % perPage != 0){
		    totalPage += 1;
		}
		return totalPage;
	}
	@Override
	public List<Shop> findAll() {
		return shopDao.findAll();
	}

}
