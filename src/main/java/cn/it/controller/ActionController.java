package cn.it.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.it.pojo.ChatMassage;
@Controller
public class ActionController {

	@RequestMapping("chatlogin.do")
	@ResponseBody
	public String chatlogin(Map<String,Object> map,HttpServletRequest req, HttpServletResponse res){
		String currentURL = req.getServletPath();
		String path = currentURL.substring(0, currentURL.indexOf("."));
		String name = req.getParameter("name");
		ChatMassage cm = ChatMassage.Instance();

		String result = null;
		if (cm.isFull()) {
			result = "聊天室人数己满！";
		} else if (cm.hasUser(name)) {
			HttpSession session = req.getSession();
		} else {
			cm.addUser(name);
			HttpSession session = req.getSession();
			session.setAttribute("username", name);
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			String date = dateFormat.format(new Date());
			cm.setMassage("<br><font color='red' >" + name + "进入聊天室！("
					+ date + ")</font><br>");
		}
		return "/chat_main";
		
	}
	@RequestMapping("loadData.do")
	@ResponseBody
	public Map<String,Object> loadData(HttpServletRequest req, HttpServletResponse res){
		String currentURL = req.getServletPath();
		String path = currentURL.substring(0, currentURL.indexOf("."));
		HttpSession session = req.getSession();
		String numb = req.getParameter("num");
		// 上次加载时客户端信息总数
		int num;
		if (numb == null) {
			num = Integer.valueOf(session.getAttribute("massageNumber")
					.toString());
		} else {
			num = Integer.valueOf(numb.trim());
		}
		ChatMassage cm = ChatMassage.Instance();
		// 得到对话信息
		String mas = cm.getMassage(num);

		// 得到信息总数
		int massageNumber = cm.mass_num;
		session.setAttribute("massageNumber", massageNumber);

		Map<String,Object> map=new HashMap<String, Object>();
		map.put("massage", mas);
		map.put("massageNumber", massageNumber);
		return map;
		
	}
	@RequestMapping("loadUser.do")
	@ResponseBody
	public Map<String,Object> loadUser(HttpServletRequest req, HttpServletResponse res){
		String currentURL = req.getServletPath();
		String path = currentURL.substring(0, currentURL.indexOf("."));
		ChatMassage cm = ChatMassage.Instance();
		String userMass = cm.getUsers();
		int CurrentUsers = cm.userNum;

		Map<String,Object> map=new HashMap<String, Object>();
		map.put("num", CurrentUsers);
		map.put("userMass", userMass);
		return map;
		
	}
	@RequestMapping("sendMassage.do")
	@ResponseBody
	public Map<String,Object> sendMassage(HttpServletRequest req, HttpServletResponse res){
		String currentURL = req.getServletPath();
		String path = currentURL.substring(0, currentURL.indexOf("."));
		String content = req.getParameter("content").trim();
		ChatMassage cm = ChatMassage.Instance();
		// 用户姓名
		String name = req.getSession().getAttribute("username").toString();

		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String date = dateFormat.format(new Date());
		System.out.println(content);
		// 得到当前用户的颜色
		String color = cm.getColor(name);
		String mass = "<font color='" + color + "'>" + name + "  " + date
				+ "</font><br><span style='color:#6495ED;'>&nbsp&nbsp"
				+ content + "</span><br>";
		cm.setMassage(mass);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("massage", mass);
		return map;
		
	}
	@RequestMapping("exit.do")
	@ResponseBody
	public Map<String,Object> exit(HttpServletRequest req, HttpServletResponse res){
		String currentURL = req.getServletPath();
		String path = currentURL.substring(0, currentURL.indexOf("."));
		// 加载用户列表
					HttpSession session = req.getSession();
					ChatMassage cm = ChatMassage.Instance();
					Object name = session.getAttribute("username");

					if (name != null) {
						cm.setMassage("<font color='#708090'>" + name.toString()
								+ " 已退出聊天！</font><br>");
						cm.exit(name.toString());
					}
					return null;
		
	}
	/**
	 * 转义字符
	 * @param source
	 * @return
	 */
	private String filer(String source){
		StringBuffer result = new StringBuffer(source);
		Pattern p = Pattern.compile("[^0-9|^a-z|^A-Z|^\u4e00-\u9fa5]");
		Matcher m = p.matcher(source);
        boolean f=true;
        
        List<Integer> a = new ArrayList<Integer>();
        while (f) {
           f = m.find();
           if (f) {
               int con = m.start();
               a.add(con);
           }
        }
        int n=0;  // '\'的数量
        for(int i:a){
        	result.insert(i+n, "\\\\");
        	n++;
        }
        return result.toString();
	}



}
