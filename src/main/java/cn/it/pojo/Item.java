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
	
	private int browingTimes; //商品浏览次数：browingTimes，后台数据，初始化为0，不能手动修改；

	
/*********************set******get***************************************/
	
	public String getname() {
		return name;
	}
	public int getitem_id() {
		return item_id;
	}
	public void setitem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getshop_id() {
		return shop_id;
	}
	public void setshop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getpart() {
		return part;
	}
	public void setpart(String part) {
		this.part = part;
	}
	public String gettypeh() {
		return typeh;
	}
	public void settypeh(String typeh) {
		this.typeh = typeh;
	}
	public String gettypel() {
		return typel;
	}
	public void settypel(String typel) {
		this.typel = typel;
	}
	public int getnumber() {
		return number;
	}
	public void setnumber(int number) {
		this.number = number;
	}
	public double getprice() {
		return price;
	}
	public void setprice(double price) {
		this.price = price;
	}
	public String getdetail() {
		return detail;
	}
	public void setdetail(String detail) {
		this.detail = detail;
	}
	public String getimage() {
		return image;
	}
	public void setimage(String image) {
		this.image = image;
	}

	public int getbrowingTimes() {
		return browingTimes;
	}
	public void setbrowingTimes(int browingTimes) {
		this.browingTimes = browingTimes;
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
