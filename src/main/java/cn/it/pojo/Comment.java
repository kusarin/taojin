package cn.it.pojo;

import java.util.Date;

/*
 * 实体类 留言Comment
 * 数据库表 comment
 *
 */
public class Comment {
	private int comment_id;            //留言编号：ID(PK)
	private String content;    //留言内容
	private Date datetime;	   //留言的时间
	private int user_id;
	
/*********************set******get***************************************/	
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
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
}
