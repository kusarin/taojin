package cn.it.pojo;
/*
 * @author zhj;
 * 
 * 商品类 Item； 
 * 
 * */
public class Item {

	private int item_id;     //商品编号：item_id(PK)，自增数据，不能手动修改;
	private int shop_id;     //店铺编号：shop_id，用来表示商品的归属店铺；    
	
	private String name;     //商品名称：name；
	private String part;     //商品类别：part；（拍卖品或者非拍卖品）
	private String typeh;    //商品类型：typeh；（商品的上层类型）
	private String typel;    //商品类型：typel；（商品的下层类型）
	private int number;      //商品数量：number；
	private double price;    //商品价格：price；
	private String detail;   //商品描述：detail；
	private String image;    //商品图片：image；
	
	private int browingtimes; //商品浏览次数：browingtimes，后台数据，初始化为0，不能手动修改；

	
/*********************set******get***************************************/
	
	public String getName() {
		return name;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getTypeh() {
		return typeh;
	}
	public void setTypeh(String typeh) {
		this.typeh = typeh;
	}
	public String getTypel() {
		return typel;
	}
	public void setTypel(String typel) {
		this.typel = typel;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public int getBrowingtimes() {
		return browingtimes;
	}
	public void setBrowingtimes(int browingtimes) {
		this.browingtimes = browingtimes;
	}	
	
	
//商品评论变为新的一张表	private String evaluate; //商品评论：evaluate；	
//	public String getEvaluate() {
//		return evaluate;
//	}
//	public void setEvaluate(String evaluate) {
//		this.evaluate = evaluate;
//	}


	/**
	 * toString方法，测试用。
	 */
	@Override
	public String toString(){
		return "Item is OK!!";
	}
}
