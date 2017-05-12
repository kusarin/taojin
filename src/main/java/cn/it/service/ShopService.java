package cn.it.service;
import cn.it.pojo.Shop;
import cn.it.pojo.Users;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
public interface ShopService {
   Shop findByid(int id);
   Shop getAllByUserid(int num);
   List<Shop> findShopList();
   public void changeInfoByid(Shop shop);
   public void addShop(Shop shop);
   public ModelAndView doChange(int shop_id, String name, String type,
			String intro,String image,MultipartFile file, HttpServletRequest request);
   public ModelAndView doAdd(String name, String type,
			String intro,MultipartFile file, HttpServletRequest request, HttpSession session);
   public void deleteShop(Shop shop); 
   long viewHits(Long id);
   List<Shop> findSR();
   int findUserId(int id1);
   void passSR(int id);
   void refuseSR(int id1);
   List<Shop> findAll();
   List<Shop> searchShop(String str);
   public int totalPage(int total);
   public List<Integer> pageList(int page, int totalPage);
   List<Shop> findByType(String type);
}
