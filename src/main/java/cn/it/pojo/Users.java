package cn.it.pojo;

/**
 * @author Wz;
 *
 * 用户信息
 * */

public class Users {
	
	private int num;//用户ID（PK）
	private String name;//用户名；
	private int tele;//用户电话；
	private String email;//用户email；
	private String password;//密码；
	private boolean type;//用户身份为普通/商家用户（0为普通，1为商家）；
	private String ID;//用户绑定的身份证号，普通用户可不绑定身份证；
	
	/*********************set******get***************************************/
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTele() {
		return tele;
	}
	public void setTele(int tele) {
		this.tele = tele;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
}