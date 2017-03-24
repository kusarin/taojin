package cn.it.pojo;

public class Shop {
	private int shop_id;
	private int num;
	private String name;
	private String type;
	private String intro;
	public int getshop_id() {
		return shop_id;
	}

	public void setshop_id(int shop_id) {
		shop_id = shop_id;
	}

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

	@Override
	public String toString() {
		return "Shop [shop_id=" + shop_id + ", num=" + num + ", name=" + name
				+ ", type=" + type + ", intro=" + intro + "]";
	}
}
