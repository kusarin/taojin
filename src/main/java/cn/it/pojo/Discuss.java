package cn.it.pojo;

import java.util.Date;

/*
 * @author zhj;
 * 
 * 评论类 Discuss； 
 * 
 * */
public class Discuss {
	private int discuss_id; // 评论编号：disscuss_id(PK)，自增数据，不能手动修改
	private String content; // 评论内容：content
	private int score; // 评论星级：score
	private Date time; // 评论时间：time
	private String username; // 用户名：username

	private int item_id; // 商品编号：item_id；所评论的商品标识，外键
	private int user_id; // 用户编号：user_id；参与评论的用户编号，外键
	private String orderNumber;

	/************************************** set********get *********************************************/

	public int getDiscuss_id() {
		return discuss_id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setDiscuss_id(int discuss_id) {
		this.discuss_id = discuss_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/************************************** set********get*******end ********************************/

	/**
	 * toString方法，测试用。 目前只针对商品评论 输出商品的属性
	 */
	@Override
	public String toString() {
		return "\n 评论[" + discuss_id + "] :评论归属[" + item_id + "]" + "评论内容：["
				+ content + "]" + "评论时间[" + time + "]";
	}

}
