package cn.it.pojo;
/***
 * 
 * 收货地址类
 * 
 * */
public class Address {
	private int addressid; //address表的主键
	private String address; //收货地址
	private int user_ID;  //用户Id
	
	/*************get************set**************/
	public int getuser_ID() {
		return user_ID;
	}
	public void setuser_ID(int user_ID) {
		this.user_ID = user_ID;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
