package cn.it.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.it.pojo.Item;
import cn.it.pojo.Lot;
import cn.it.pojo.Lot;
import cn.it.pojo.Users;
import cn.it.service.LotService;

/**
 * 
 * @author zhj
 * 
 *         拍卖品的Controller层操作类
 * 
 */

@Controller
public class LotController {

	@Autowired
	private LotService lotservice;

	/**
	 * 上架拍卖品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("addLot.do")
	public ModelAndView addLot(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, HttpSession session) {
		// 获取前台传入的数据
		String name = request.getParameter("name");
		String typel = request.getParameter("typel");
		String startprice = request.getParameter("startprice");
		String maxPrice = request.getParameter("maxprice");
		String detail = request.getParameter("detail");

		// 添加拍卖品操作，并且获得提示信息
		ModelAndView modelandview = lotservice.addLot(name, typel, startprice,
				maxPrice, detail, file, request, session);
		return modelandview;
	}

	/**
	 * 查看单个拍卖品
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("lookLot.do")
	public ModelAndView lookLot(HttpServletRequest request,
			@RequestParam("id") String id) {
		ModelAndView modelandview = new ModelAndView("lookLot");

		// 获取拍卖品
		int lot_id = Integer.parseInt(id);
		Lot l = lotservice.findById(lot_id);

		modelandview.addObject("lookLot", l);

		// 获取拍卖人
		int user_id = l.getUser_id();
		Users u = lotservice.finduser(user_id);

		modelandview.addObject("us", u);

		return modelandview;
	}

	/**
	 * 按条目显示拍卖品（在拍）
	 * 
	 * @param request
	 * @param page
	 * @return
	 */
	@RequestMapping("Lotlist.do")
	public ModelAndView lookLot(HttpServletRequest request, int page) {
		ModelAndView modelandview = new ModelAndView("Lotlist");

		// 获取拍卖品列表
		List<Lot> list = lotservice.findLotList();

		// 分页操作区域
		// 获取总页数
		int total = list.size(); // 商品总数量
		int perPage = 15; // 每页显示数量
		int totalPage = total / perPage;
		if (total % perPage != 0) {
			totalPage += 1;
		}
		// 设置page页码有效区间
		if (page > totalPage || page < 1) {
			page = 1;
			modelandview.addObject("error", "指定页码不存在!");
		}
		// 设置下方页码显示的部分
		int n = 0;
		List<Integer> pageList = new ArrayList<Integer>();
		for (n = page - 3; n <= totalPage && n <= page + 3; n++) {
			if (n > 0) {
				pageList.add(n);
			}
		}

		// 设置每页显示的商品，并且进行传递操作
		if (page < totalPage) {
			List<Lot> l = list.subList((page - 1) * perPage, page * perPage);
			modelandview.addObject("Lotlist", l);
		} else {
			List<Lot> l = list.subList((page - 1) * perPage, list.size());
			modelandview.addObject("Lotlist", l);
		}

		// 传递页码显示部分
		modelandview.addObject("pageList", pageList);
		modelandview.addObject("totalPage", totalPage);
		modelandview.addObject("page", page);

		// 分页操作结束

		return modelandview;
	}

	/**
	 * 按照输入的关键词查询拍卖品 搜索处用
	 * 
	 * @return
	 */
	@RequestMapping("searchLot.do")
	public ModelAndView searchLot(HttpServletRequest request, int page) {
		ModelAndView modelandview = new ModelAndView("searchLot");

		// 从前台获取搜索关键词str；
		String str = request.getParameter("str");
		// 获取拍卖品
		List<Lot> list = lotservice.findBystr(str);

		// 是否有满足条件商品的判断
		if (list.size() == 0) {
			modelandview.addObject("error0", "抱歉！！没有找到符合搜索信息的商品！！！！");
			modelandview.addObject("search", str);
		} else {

			// 分页操作区域
			// 获取总页数
			int total = list.size(); // 商品总数量
			int perPage = 15; // 每页显示数量
			int totalPage = total / perPage;
			if (total % perPage != 0) {
				totalPage += 1;
			}
			// 设置page页码有效区间
			if (page > totalPage || page < 1) {
				page = 1;
				modelandview.addObject("error", "指定页码不存在!");
			}
			// 设置下方页码显示的部分
			int n = 0;
			List<Integer> pageList = new ArrayList<Integer>();
			for (n = page - 3; n <= totalPage && n <= page + 3; n++) {
				if (n > 0) {
					pageList.add(n);
				}
			}

			// 设置每页显示的商品，并且进行传递操作
			if (page < totalPage) {
				List<Lot> l = list
						.subList((page - 1) * perPage, page * perPage);
				modelandview.addObject("Lotlist", l);
			} else {
				List<Lot> l = list.subList((page - 1) * perPage, list.size());
				modelandview.addObject("Lotlist", l);
			}

			// 传递页码显示部分
			modelandview.addObject("pageList", pageList);
			modelandview.addObject("totalPage", totalPage);
			modelandview.addObject("page", page);
			modelandview.addObject("search", str);
			// 分页操作结束
		}

		return modelandview;
	}

	/**
	 * 按照输入的关键词查询拍卖品 分页处用
	 * 
	 * @return
	 */
	@RequestMapping("searchLot2.do")
	public ModelAndView searchLot2(HttpServletRequest request, String str,
			int page) {
		ModelAndView modelandview = new ModelAndView("searchLot");
		// 获取拍卖品
		List<Lot> list = lotservice.findBystr(str);

		// 是否有满足条件商品的判断
		if (list.size() == 0) {
			modelandview.addObject("error0", "抱歉！！没有找到符合搜索信息的商品！！！！");
			modelandview.addObject("search", str);
		} else {

			// 分页操作区域
			// 获取总页数
			int total = list.size(); // 商品总数量
			int perPage = 15; // 每页显示数量
			int totalPage = total / perPage;
			if (total % perPage != 0) {
				totalPage += 1;
			}
			// 设置page页码有效区间
			if (page > totalPage || page < 1) {
				page = 1;
				modelandview.addObject("error", "指定页码不存在!");
			}
			// 设置下方页码显示的部分
			int n = 0;
			List<Integer> pageList = new ArrayList<Integer>();
			for (n = page - 3; n <= totalPage && n <= page + 3; n++) {
				if (n > 0) {
					pageList.add(n);
				}
			}

			// 设置每页显示的商品，并且进行传递操作
			if (page < totalPage) {
				List<Lot> l = list
						.subList((page - 1) * perPage, page * perPage);
				modelandview.addObject("Lotlist", l);
			} else {
				List<Lot> l = list.subList((page - 1) * perPage, list.size());
				modelandview.addObject("Lotlist", l);
			}

			// 传递页码显示部分
			modelandview.addObject("pageList", pageList);
			modelandview.addObject("totalPage", totalPage);
			modelandview.addObject("page", page);
			modelandview.addObject("search", str);
			// 分页操作结束
		}

		return modelandview;
	}
}
