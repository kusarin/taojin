package cn.it.pojo;

import java.util.Date;

/*
 * 实体类 留言Comment
 * 数据库表 comment
 *
 */
public class Comment {
	private int ID;            //留言编号：ID(PK)
	private String content;    //留言内容
	private Date datetime;	   //留言的时间
	private int User_id;
	
/*********************set******get***************************************/	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
}
