package cn.it.service.impl;

import java.io.File;
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
    public void addShop(Shop shop){
    	shopDao.addShop(shop);
    }
    public ModelAndView addShop(Shop shop, HttpServletRequest request,
			HttpSession session, MultipartFile file) {
		ModelAndView str = new ModelAndView("addShop");
		shopDao.addShop(shop);
		// 商品图片部分
		// 获取图片存储文件的路径
		String path = request.getServletContext().getRealPath("image");
		// 将图片文件名命名为上传时间
		// System.out.println(picturefile);
		String fileName = String.valueOf(System.currentTimeMillis())
				+ file.getOriginalFilename();
		// 获取图片文件路径
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存文件（图片）；
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// set方法
		shop.setImage("/image/" + fileName);
		// 商品图片部分结束
		return str;
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
	@Override
	public List<Shop> findAll() {
		return shopDao.findAll();
	}

}
