package cn.it.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * coding utf-8
 * 
 * @author chow
 * 
 */
public class ChatMassage {

	public static ChatMassage chatMassage = null;
	// 用户
	private List<String> users = new ArrayList<String>();
	// 最大聊天室人数
	private final int USER_NUMBER = 3;
	// 聊天室人数
	public static int userNum = 0;
	// 对话信息
	private List<String> massages = new ArrayList<String>();
	// 信息总数目
	public static int mass_num = 0;
	// 用户显示的颜色
	private Map<String, String> color = new HashMap<String, String>();

	protected ChatMassage() {
	}

	public static ChatMassage Instance() {
		if (chatMassage == null) {
			return chatMassage = new ChatMassage();
		}
		return chatMassage;
	}

	/**
	 * 登记用户名
	 * 
	 * @param name
	 *            用户姓名
	 * @return boolean 添加是否成功
	 */
	public boolean addUser(String name) {
		synchronized (users) {
			// 如果没有此用户，而且聊天室人数未满
			if (!this.hasUser(name) && !isFull()) {
				users.add(name);
				// 为当前用户设置显示颜色
				String color = createColor();
				this.color.put(name, color);
				userNum++;
				return true;
			}
		}
		return false;
	}

	public boolean isFull() {
		if (userNum < this.USER_NUMBER) {
			return false;
		}
		return true;
	}

	/**
	 * 查看此用户名是否被使用
	 * 
	 * @param name
	 *            用户姓名
	 * @return boolean 是否存在
	 */
	public boolean hasUser(String name) {
		for (String na : users) {
			if (name.equalsIgnoreCase(na)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 得到用户列表
	 * 
	 * @return
	 */
	public String getUsers() {
		StringBuffer user = new StringBuffer();
		int i = 0;
		while (i < userNum) {
			String name = this.users.get(i);
			String color = this.getColor(name);
			String userMass = "<font color='" + color + "'>" + name
					+ "</font><br>";
			user.append(userMass);
			i++;
		}
		return user.toString();
	}

	/**
	 * 返回信息
	 * 
	 * @param i
	 *            前台中存有的对话信息数
	 * @return
	 */
	public String getMassage(int i) {
		StringBuffer massage = new StringBuffer();
		// 只有在前台对话信息数小于后台信息总数时才返回
		while (i < mass_num && i >= 0) {
			massage.append(massages.get(i));
			i++;
		}
		return massage.toString();
	}

	/**
	 * 添加对话信息
	 * 
	 * @param massage
	 *            信息内容
	 */
	public void setMassage(String massage) {
		synchronized (massages) {
			massages.add(massage);
			mass_num++;
		}
	}

	/**
	 * 退出聊天室
	 * 
	 * @param name
	 *            退出人的姓名
	 */
	public void exit(String name) {
		if (users.remove(name)) {
			userNum--;
			// 如果聊天室没有人了，则始化信息
			if (userNum == 0) {
				mass_num = 0;
				massages.clear();
				users.clear();
				color.clear();
			} else {
				color.remove(name);
			}
		}
		;
	}

	/**
	 * 根据用户名得到当前用户的颜色
	 * 
	 * @param username
	 * @return
	 */
	public String getColor(String username) {
		return color.get(username);
	}

	/**
	 * 随机创建颜色
	 * 
	 * @return
	 */
	private String createColor() {
		StringBuffer color = new StringBuffer("#");
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			int a = random.nextInt(256);
			// 转换成十六进制
			color.append(Integer.toHexString(a));
		}
		return color.toString();
	}

}
