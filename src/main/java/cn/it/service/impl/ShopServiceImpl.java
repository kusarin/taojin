package cn.it.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.it.dao.ShopDao;
import cn.it.dao.UsersDao;
import cn.it.pojo.Item;
import cn.it.pojo.Shop;
import cn.it.pojo.Typeh;
import cn.it.pojo.Typel;
import cn.it.pojo.Users;
import cn.it.service.ShopService;

@Service("shopService")
public class ShopServiceImpl implements ShopService {
	@Autowired
	// @Qualifier("shopDao")
	private ShopDao shopDao;
	@Autowired
	private UsersDao usersDao;

	public Shop getAllByUserid(int num) {
		return shopDao.getAllByUserid(num);
	}

	public void changeInfoByid(Shop shop) {
		shopDao.changeInfoByid(shop);
	}

	public List<Shop> searchShop(String str) {
		return shopDao.searchShop(str);
	}

	public List<Shop> findByType(String type) {
		return shopDao.findByType(type);
	}

	public void addShop(Shop shop) {
		shopDao.addShop(shop);
	}

	public void deleteShop(Shop shop) {
		shopDao.deleteShop(shop);
	}

	public Shop findByid(int id) {
		// TODO Auto-generated method stub
		return shopDao.findByid(id);
	}

	public List<Shop> findShopList() {
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
		shopDao.updateStatus(i, id1);
	}

	public void refuseSR(int id1) {
		int i = 2;
		shopDao.updateStatus(i, id1);
	}

	public List<Integer> pageList(int page, int totalPage) {
		int n;
		List<Integer> pageList = new ArrayList<Integer>();
		for (n = page - 5; n <= totalPage && n <= page + 5; n++) {
			if (n > 0) {
				pageList.add(n);
			}
		}
		return pageList;
	}

	public int totalPage(int total) {
		int perPage = 10;
		int totalPage = total / perPage;
		if (total % perPage != 0) {
			totalPage += 1;
		}
		return totalPage;
	}

	@Override
	public List<Shop> findAll() {
		return shopDao.findAll();
	}

	@Override
	public ModelAndView doAdd(String name, String username, String email,
			String ID, String type, String intro, MultipartFile file,
			HttpServletRequest request, HttpSession session) {
		ModelAndView str = new ModelAndView("addShop");
		Users user = (Users) session.getAttribute("user");
		int user_id = user.getUser_ID();
		Shop ls = shopDao.getAllByUserid(user_id);

		if (ls != null && ls.getStatus() != 2) {
			str.addObject("error", "该用户已注册店铺！！！");
		} else if (ls.getStatus() == 2) {
			if (name == null || name.equals("") || type == null
					|| type.equals("") || username == null
					|| username.equals("") || email == null || email.equals("")
					|| ID == null || ID.equals("") || intro == null
					|| intro.equals("") || file == null || file.equals("")) {

				// 提示信息 "输入数据不能为空！！！"
				str.addObject("error", "输入数据不能为空！！！");

			} else {// 参数不为空时候，执行添加操作

				// 定义商品；
				Shop i = new Shop();
				Users u = new Users();
				i.setUser_ID(user_id);
				i.setName(name); // 商品名称
				i.setType(type); // 商品一阶类型
				i.setIntro(intro); // 商品数量
				u.setEmail(email);
				u.setID(ID);
				u.setName(username);
				// 商品图片部分
				// 获取图片存储文件的路径
				String path = request.getServletContext().getRealPath("image");
				// 将图片文件名命名为上传时间
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
				u.setIdPhoto("/image/" + fileName);
				i.setImage("/image/dislogo.jpg");
				// 商品图片部分结束
				i.setStatus(0);

				// 添加商品信息；
				shopDao.changeInfoByid(i);
				usersDao.updateUser(u);
				request.setAttribute("shop", i);
				// 提示信息 "上架成功！！！"
				str.addObject("error", "申请成功，等待审核！");
				str.addObject("shopli", i);
				// 上架成功后跳转的界面，暂时先设置为addItem【上架商品界面】
				str.setViewName("shopList");
			}
		} else {
			if (name == null || name.equals("") || type == null
					|| type.equals("") || username == null
					|| username.equals("") || email == null || email.equals("")
					|| ID == null || ID.equals("") || intro == null
					|| intro.equals("") || file == null || file.equals("")) {

				// 提示信息 "输入数据不能为空！！！"
				str.addObject("error", "输入数据不能为空！！！");

			} else {// 参数不为空时候，执行添加操作

				// 定义商品；
				Shop i = new Shop();
				Users u = new Users();
				i.setUser_ID(user_id);
				i.setName(name); // 商品名称
				i.setType(type); // 商品一阶类型
				i.setIntro(intro); // 商品数量
				u.setEmail(email);
				u.setID(ID);
				u.setName(username);
				// 商品图片部分
				// 获取图片存储文件的路径
				String path = request.getServletContext().getRealPath("image");
				// 将图片文件名命名为上传时间
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
				u.setIdPhoto("/image/" + fileName);
				i.setImage("/image/dislogo.jpg");
				// 商品图片部分结束
				i.setStatus(0);

				// 添加商品信息；
				shopDao.addShop(i);
				usersDao.updateUser(u);
				request.setAttribute("shop", i);
				// 提示信息 "上架成功！！！"
				str.addObject("error", "申请成功，等待审核！");
				str.addObject("shopli", i);
				// 上架成功后跳转的界面，暂时先设置为addItem【上架商品界面】
				str.setViewName("shopList");
			}
		}
		return str;

	}

	@Override
	public ModelAndView doChange(int shop_id, String name, String type,
			String intro, String image, MultipartFile file,
			HttpServletRequest request) {
		ModelAndView str = new ModelAndView("shopinfoChange");
		// System.out.println(">>>>>>>>>> " + request.getParameter("motopic"));

		if (shop_id == 0 || name.equalsIgnoreCase("")
				|| type.equalsIgnoreCase("") || intro.equalsIgnoreCase("")) {
			return str;
		} else {
			Shop i = shopDao.findByid(shop_id);
			// 设置商品新属性；
			i.setName(name); // 商品名称
			i.setType(type); // 商品一阶类型
			i.setIntro(intro); // 商品数量
			image = i.getImage();
			// 商品图片部分
			if (file.getOriginalFilename().equals("")
					|| file.getOriginalFilename() == null) {
				// 如果没有上传新的图片文件；
				i.setImage(image);
			} else {// 如果上传了新的图片文件
				String path = request.getServletContext().getRealPath("image");
				// 将图片文件名命名为上传时间
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
				// System.out.println(picturefile + ">>>>>>>" + fileName);
				i.setImage("/image/" + fileName);
				request.setAttribute("shop", i);
				// 商品图片部分结束
				// System.out.println(user.getPicture());
			}
			shopDao.changeInfoByid(i);
			str.addObject("shopli", shopDao.findByid(shop_id));
			str.setViewName("shopList");
			return str;
		}
	}

	/*
	 * 更新店铺浏览次数
	 */
	public void updateBrowsingTimes(int shopId) {
		Shop shop = shopDao.findByid(shopId);
		int browsingTimes = shop.getBrowsingTimes();
		browsingTimes++;
		shop.setBrowsingTimes(browsingTimes);
		shopDao.update(shop);

	}
}
