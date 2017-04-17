package cn.it.pojo;

public class Shop {
	private int shop_id;
	private int user_ID;
	private String Name;
	private String Type;
	private String Intro;
	private int BrowsingTimes;
	private int Status;
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public int getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getIntro() {
		return Intro;
	}
	public void setIntro(String intro) {
		Intro = intro;
	}
	@Override
	public String toString() {
		return "Shop [Shop_id=" + shop_id + ", User_ID=" + user_ID + ", Name="
				+ Name + ", Type=" + Type + ", Intro=" + Intro
				+ ", BrowsingTimes=" + BrowsingTimes + "]";
	}
	
}
