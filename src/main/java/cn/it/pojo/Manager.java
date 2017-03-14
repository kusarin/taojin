package cn.it.pojo;
/*
 * 
 * 实体类：管理员 Manager
 * 数据库表：manager
 */
public class Manager {
	private int ID;            //管理员编号：ID(PK)
	private String account;    //管理员的账户
	private String password;   //管理员账户对应的密码
	
/*********************set******get***************************************/
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
