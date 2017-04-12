package cn.it.pojo;

public class ShopRequest {
	
	private int shopRequest_id;
	private int user_id;
	private String name;
	private String type;
	private String intro;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getShopRequest_id() {
		return shopRequest_id;
	}
	public void setShopRequest_id(int shopRequest_id) {
		this.shopRequest_id = shopRequest_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
