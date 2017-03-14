package cn.it.pojo;
/*
 * @author zhj;
 * 
 * 商品类 Item； 
 * 
 * */
public class Item {

	private int ID;          //商品编号：ID(PK);
	private String name;     //商品名称：name；
	private String part;     //商品类别：part；（拍卖品或者非拍卖品）
	private String type;     //商品类型：type；
	private double price;    //商品价格：price；
	private String detail;   //商品描述：detail；
	private String image;    //商品图片：image；
	private String evaluate; //商品评论：evaluate；
	
/*********************set******get***************************************/
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

}
