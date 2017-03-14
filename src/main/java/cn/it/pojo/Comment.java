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
	private Date time;	   //留言的时间
	private int announcerID;   //留言发布者的ID
	
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getAnnouncerID() {
		return announcerID;
	}
	public void setAnnouncerID(int announcerID) {
		this.announcerID = announcerID;
	}
	
	
}
