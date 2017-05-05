package cn.it.service.impl;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.it.dao.LotDao;
import cn.it.dao.ShopDao;
import cn.it.dao.TypehDao;
import cn.it.dao.TypelDao;
import cn.it.dao.UsersDao;
import cn.it.pojo.Lot;
import cn.it.pojo.Shop;
import cn.it.pojo.Typeh;
import cn.it.pojo.Typel;
import cn.it.pojo.Users;
import cn.it.service.LotService;

/**
 * 
 * @author zhj
 * 
 *         拍卖品的Service层操作类
 * 
 */
public class LotServiceImpl implements LotService {

	@Autowired
	private LotDao lotDao;
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private TypehDao typehDao;
	@Autowired
	private TypelDao typelDao;
	@Autowired
	private UsersDao usersDao;
	/**
	 * 添加拍卖品
	 * 
	 * @param name
	 *            拍卖品名称，String
	 * @param typel
	 *            拍卖品二级分类，String
	 * @param startPrice
	 *            拍卖品起拍价，String，之后强转为double
	 * @param maxPrice
	 *            拍卖品最高价（一口价），String，之后强转为double
	 * @param detail
	 *            拍卖品描述，String
	 * @param file
	 *            拍卖品品图片，MultipartFile
	 * @param request
	 *            前台请求 HttpServletRequest
	 * 
	 * @return ModelAndView
	 */
	public ModelAndView addLot(String name, String typel, String startprice,
			String maxprice, String detail, MultipartFile file,
			HttpServletRequest request, HttpSession session) {	
		ModelAndView str = new ModelAndView("addLot"); // 跳转到addLot.jsp界面

		// 判断传入参数是否为空
				if (name == null || name.equals("") || typel == null
						|| typel.equals("") || startprice == null || startprice.equals("")
						|| maxprice == null || maxprice.equals("") || detail == null
						|| detail.equals("")) {

					// 提示信息 "输入数据不能为空！！！"
					str.addObject("error", "输入数据不能为空！！！");

				} else {// 参数不为空时候，执行添加操作
					
					// 获取店铺编号shop_id
					Users user = (Users)session.getAttribute("user");
					int user_id = user.getUser_ID();
					Shop ls = shopDao.getAllByUserid(user_id);
					int shop_id=ls.getShop_id();
					

					// 将拍卖品起拍价和最高价转为规定格式：double
					double strpri = Double.parseDouble(startprice);
					double maxpri = Double.parseDouble(maxprice);
					
					// 根据二阶类型获取一阶类型
					Typel tyl = typelDao.FindTypelByName(typel);
					int typeh_id = tyl.getTypeh_id();
					Typeh tyh = typehDao.FindTypehById(typeh_id);
					String typeh = tyh.getName();
					// 获取一阶分类结束
					
					// 定义拍卖品
					Lot lot=new Lot();
					// 设置拍卖品属性
					lot.setShop_id(shop_id);
					lot.setName(name);
					lot.setTypeh(typeh);
					lot.setTypel(typel);
					lot.setstartprice(strpri);
					lot.setMaxprice(maxpri);
					lot.setDetail(detail);
					
					// 拍卖品图片部分
					// 获取图片存储文件的路径
					String path = request.getServletContext().getRealPath("lotimage");
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
					lot.setImage("/upload/" + fileName);
					// 图片部分结束
					
					// 设置初始状态status为0
					lot.setStatus(0);
					// 设置初始时间为3天
					int time = 3*24*60;
					lot.setTime(time);
					
					// 添加拍卖品信息
					lotDao.LotAdd(lot);
					
					request.setAttribute("lot", lot);
					// 提示信息 "上架成功！！！"
					str.addObject("error", "上架成功！！！");
					
					// 上架成功后跳转的界面，暂时先设置为addItem【上架商品界面】
					str.setViewName("addItem");
				}

		return str;
	}

	@Override
	public ModelAndView deleteLot(int lot_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView updateLot(int lot_id, String name, String typel,
			String startprice, String nowPrice, String maxPrice, String detail,
			String image, MultipartFile file, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lot findById(int lot_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lot> findLotList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lot> findByType1(String typeh) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lot> findByType2(String typeh, String typel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lot> findByShopId1(int shop_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lot> findByShopId2(int shop_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lot> findBystr(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shop showShop(int shop_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
