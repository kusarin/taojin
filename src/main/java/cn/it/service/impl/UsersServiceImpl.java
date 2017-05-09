package cn.it.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.it.dao.UsersDao;
import cn.it.pojo.Users;
import cn.it.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersDao usersDao;

	// public ModelAndView tologin() {
	// ModelAndView str = new ModelAndView("login");
	// str.addObject("error", "请登录后再进行操作！");
	// return str;
	// }

	public ModelAndView login(Users user, HttpSession session)
			throws IOException {
		ModelAndView str = new ModelAndView("Itemlist");
		if (user.getUsername().equals("") || user.getUsername() == null
				|| user.getPassword().equals("") || user.getPassword() == null) {
			str.addObject("error", "用户名或密码为空");
			str.setViewName("login");
		} else {
			Users u = usersDao.login(user);
			if (u == null) {
				str.addObject("error", "用户名或密码错误");
				str.setViewName("login");
			} else {
				str.setViewName("redirect:Itemlist.do?page=1");
				session.setAttribute("user", u);
			}
		}

		return str;
	}

	public ModelAndView add(Users user) {
		ModelAndView str = new ModelAndView("register");
		List<Users> userlist = usersDao.UsersFind();
		Boolean flag = true;
		for (Users u : userlist) {
			if (u.getUsername().equalsIgnoreCase(user.getUsername())) {
				flag = false;
				str.addObject("error", "该用户名已存在");
				break;
			}
		}
		if (user.getUsername() == null
				|| user.getUsername().equalsIgnoreCase("")
				|| user.getPassword() == null
				|| user.getPassword().equalsIgnoreCase("")) {
			str.addObject("error", "用户名或密码为空");
			flag = false;
		} else if (flag) {
			usersDao.UsersAdd(user);
			str.setViewName("login");
		}
		return str;
	}

	public ModelAndView update(Users user, HttpServletRequest request,
			HttpSession session, MultipartFile picturefile) {
		ModelAndView str = new ModelAndView("UsersUpdate");
		user.setType(1);// 暂时没用了
		// System.out.println(">>>>>>>>>> " + request.getParameter("motopic"));

		// 商品图片部分
		if (!picturefile.getOriginalFilename().equals("")
				&& picturefile.getOriginalFilename() != null) {
			String path = request.getServletContext().getRealPath("image");
			// 将图片文件名命名为上传时间

			String fileName = String.valueOf(System.currentTimeMillis())
					+ picturefile.getOriginalFilename();
			// 获取图片文件路径
			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			// 保存文件（图片）；
			try {
				picturefile.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// set方法
			// System.out.println(picturefile + ">>>>>>>" + fileName);
			user.setPicture("/image/" + fileName);
		} else {
			user.setPicture(request.getParameter("motopic"));
		}
		// 商品图片部分结束
		// System.out.println(user.getPicture());
		usersDao.updateUser(user);
		session.setAttribute("user", user);
		return str;
	}

	public ModelAndView logout(Users user, HttpSession session) {
		ModelAndView str = new ModelAndView("Itemlist");
		session.invalidate();
		str.setViewName("redirect:Itemlist.do?page=1");
		return str;
	}

	public ModelAndView changepw(Users user, HttpSession session) {
		ModelAndView str = new ModelAndView("changepw");
		System.out.println(">>>>>>>>>>>>}}}}]]]]" + user.getUser_ID());
		usersDao.changepw(user);
		session.setAttribute("user", user);
		return str;
	}

	public Users findById(int userid) {
		return usersDao.findById(userid);
	}

	public List<Users> findAll() {
		return usersDao.UsersFind();
	}
}