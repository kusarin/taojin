package cn.it.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.it.dao.AddressDao;
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
@Service("LotService")
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
	@Autowired
	private AddressDao addressDao;

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
				|| typel.equals("") || startprice == null
				|| startprice.equals("") || maxprice == null
				|| maxprice.equals("") || detail == null || detail.equals("")) {

			// 提示信息 "输入数据不能为空！！！"
			str.addObject("error", "输入数据不能为空！！！");

		} else if (Double.parseDouble(startprice) > Double
				.parseDouble(maxprice)) {
			str.addObject("error", "起拍价不能大于一口价，请重新输入信息！");
		} else {// 参数不为空时候，执行添加操作

			// 获取店铺编号shop_id
			Users user = (Users) session.getAttribute("user");
			int user_id = user.getUser_ID();
			Shop ls = shopDao.getAllByUserid(user_id);
			int shop_id = ls.getShop_id();

			// 将拍卖品起拍价和最高价转为规定格式：double
			// 加价额度固定为0.5,初始当前价格为起拍价
			double strpri = Double.parseDouble(startprice);
			BigDecimal b = new BigDecimal(strpri);
			double strpri1 = b.setScale(2, BigDecimal.ROUND_HALF_UP)
					.doubleValue();
			double maxpri = Double.parseDouble(maxprice);
			BigDecimal c = new BigDecimal(maxpri);
			double maxpri1 = c.setScale(2, BigDecimal.ROUND_HALF_UP)
					.doubleValue();
			double addpri = 0.5;

			// 根据二阶类型获取一阶类型
			Typel tyl = typelDao.FindTypelByName(typel);
			int typeh_id = tyl.getTypeh_id();
			Typeh tyh = typehDao.FindTypehById(typeh_id);
			String typeh = tyh.getName();
			// 获取一阶分类结束

			// 定义拍卖品
			Lot lot = new Lot();
			// 设置拍卖品属性
			lot.setShop_id(shop_id);
			lot.setName(name);
			lot.setTypeh(typeh);
			lot.setTypel(typel);
			lot.setstartprice(strpri1);
			lot.setNowprice(strpri1);
			lot.setMaxprice(maxpri1);
			lot.setAddprice(addpri);
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
			lot.setImage("/lotimage/" + fileName);
			// 图片部分结束

			// 设置初始状态status为0
			lot.setStatus(0);
			// 设置初始时间为3天
			int time = 3 * 24 * 60;
			lot.setTime(time);

			// 添加拍卖品信息
			lotDao.LotAdd(lot);

			request.setAttribute("lot", lot);
			// 提示信息 "上架成功！！！"
			str.addObject("error", "上架拍卖品成功！！！");

			// 上架成功后跳转的界面，暂时先设置为addLot【上架拍卖品界面】
			str.setViewName("addLot");
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

	/**
	 * 查看某个拍卖品；
	 */
	@Override
	public Lot findById(int lot_id) {
		Lot l = lotDao.FindLotById(lot_id);
		return l;
	}

	/**
	 * 查看所有在拍的拍卖品
	 */
	@Override
	public List<Lot> findLotList() {
		// 获取所有拍卖品
		List<Lot> list = lotDao.FindAll();
		// 选出其中在拍的拍卖品
		List<Lot> lotlist = new ArrayList<Lot>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStatus() == 0) {
				lotlist.add(list.get(i));
			}
		}
		return lotlist;
	}

	/**
	 * 查看某个店铺的所有拍卖品（卖家自己查看）
	 */
	@Override
	public List<Lot> findByShopId(int shop_id) {
		List<Lot> list = lotDao.FindLotByShopId(shop_id);
		return list;
	}

	/**
	 * 搜索拍卖品
	 */
	@Override
	public List<Lot> findBystr(String str) {
		List<Lot> list = lotDao.SearchLot(str);
		// 选出其中在拍的拍卖品
		List<Lot> lotlist = new ArrayList<Lot>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStatus() == 0) {
				lotlist.add(list.get(i));
			}
		}
		return lotlist;
	}

	/**
	 * 根据用户编号查看用户
	 * 
	 * @param id
	 * @return
	 */
	public Users finduser(int id) {
		return usersDao.findById(id);
	}

	/**
	 * 根据用户编号获得店铺编号
	 * 
	 * @param user_id
	 * @return
	 */
	public int getShopId(int user_id) {
		Shop ls = shopDao.getAllByUserid(user_id);
		int shop_id = ls.getShop_id();
		return shop_id;
	}

	/**
	 * 对拍卖品出价
	 * 
	 * @param nowprice
	 * @param user_id
	 * @return
	 */
	public ModelAndView anction(int lot_id, String yourprice, int user_id,
			String addr) {
		ModelAndView str = new ModelAndView("lookLot");
		// 判断传入参数是否为空
		if (yourprice == null || yourprice.equals("")) {
			// 提示信息 "出价不能为空！！！"
			str.addObject("error", "出价不能为空！！！");
		} else if (addr == null || addr.equalsIgnoreCase("")) {
			str.addObject("error", "请选择收货地址！！！");
		} else {
			Lot l = lotDao.FindLotById(lot_id);

			// 将出价转为double,newprice:拍卖者出价
			double newprice = Double.parseDouble(yourprice);

			// 获取拍卖品的当前价格、一口价、加价额度
			double nowprice = l.getNowprice();
			double maxprice = l.getMaxprice();
			double addprice = l.getAddprice();

			if (newprice >= maxprice) {
				// 提示信息 "出价高于最高价，建议用一口价买下该拍卖品！！！"
				str.addObject("error", "出价高于最高价，建议用一口价买下该拍卖品！！！");
			} else if (newprice < nowprice + addprice) {
				// 提示信息 "出价低于当前价格，请重新出价！！！"
				str.addObject("error", "出价低于当前价格，请重新出价！！！");
			} else {
				// 设置新属性
				l.setAddress(addr);
				l.setNowprice(newprice);
				l.setUser_id(user_id);
				// 更新拍卖品信息
				lotDao.LotUpdate(l);
				// 提示信息 "出价成功！！！"
				str.addObject("error", "出价成功！！！");
			}
		}

		return str;
	}

	@Override
	public ModelAndView updateLot(int lot_id) {
		ModelAndView mav = new ModelAndView("updateLot");
		mav.addObject("lot",lotDao.FindLotById(lot_id));
		return mav;
	}

	@Override
	public ModelAndView changeLot(String name, String typel, String startprice,
			String maxprice, String detail, MultipartFile file,
			HttpServletRequest request,String lot_id) {
		int id = Integer.parseInt(lot_id);
		ModelAndView str = new ModelAndView("updateLot");
		if (name == null || name.equals("") || typel == null
				|| typel.equals("") || startprice == null
				|| startprice.equals("") || maxprice == null
				|| maxprice.equals("") || detail == null || detail.equals("")) {

			// 提示信息 "输入数据不能为空！！！"
			str.addObject("error", "输入数据不能为空！！！");
			str.addObject("lot", lotDao.FindLotById(id));
		} else if (Double.parseDouble(startprice) > Double
				.parseDouble(maxprice)) {
			str.addObject("lot", lotDao.FindLotById(id));
			str.addObject("error", "起拍价不能大于一口价，请重新输入信息！");
		} else {// 参数不为空时候，执行添加操作
			 
			// 将拍卖品起拍价和最高价转为规定格式：double
			// 加价额度固定为0.5,初始当前价格为起拍价
			double strpri = Double.parseDouble(startprice);
			BigDecimal b = new BigDecimal(strpri);
			double strpri1 = b.setScale(2, BigDecimal.ROUND_HALF_UP)
					.doubleValue();
			double maxpri = Double.parseDouble(maxprice);
			BigDecimal c = new BigDecimal(maxpri);
			double maxpri1 = c.setScale(2, BigDecimal.ROUND_HALF_UP)
					.doubleValue();
			double addpri = 0.5;

			// 根据二阶类型获取一阶类型
			Typel tyl = typelDao.FindTypelByName(typel);
			int typeh_id = tyl.getTypeh_id();
			Typeh tyh = typehDao.FindTypehById(typeh_id);
			String typeh = tyh.getName();
			// 获取一阶分类结束

			// 定义拍卖品
			Lot lot = new Lot();
			// 设置拍卖品属性
			lot.setLot_id(id);
			lot.setName(name);
			lot.setTypeh(typeh);
			lot.setTypel(typel);
			lot.setstartprice(strpri1);
			lot.setNowprice(strpri1);
			lot.setMaxprice(maxpri1);
			lot.setAddprice(addpri);
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
			lot.setImage("/lotimage/" + fileName);
			// 图片部分结束

			// 设置初始状态status为0
			lot.setStatus(0);
			// 设置初始时间为3天
			int time = 3 * 24 * 60;
			lot.setTime(time);

			// 修改拍卖品信息
			lotDao.LotUpdate(lot);

			request.setAttribute("lot", lot);
			// 提示信息 "重新上架成功！！！"
			str.addObject("error", "重新上架拍卖品成功！！！");

			// 上架成功后跳转的界面，暂时先设置为addLot【上架拍卖品界面】
			str.setViewName("addLot");
		}
		return str;
	}

}
