package cn.it.pojo;

import java.util.Date;

/*
 * 实体类 留言Comment
 * 数据库表 comment
 *
 */
public class Comment {
	private int comment_id; // 留言编号：ID(PK)
	private String content; // 留言内容
	private Date datetime; // 留言的时间
	private int user_ID;

	/********************* set******get ***************************************/
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}
