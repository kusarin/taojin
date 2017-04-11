package cn.it.pojo;
/***
 * 
 * 收货地址类
 * 
 * */
public class Address {
	private int id; //address表的主键
	private String receivingaddress; //收货地址
	private String contacts;  //联系方式
	private String name; //收货人姓名
	private int userId;  //用户Id
	
	/*************get************set**************/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReceivingaddress() {
		return receivingaddress;
	}
	public void setReceivingaddress(String receivingaddress) {
		this.receivingaddress = receivingaddress;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
