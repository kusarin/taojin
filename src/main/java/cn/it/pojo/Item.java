package cn.it.pojo;
/*
 * @author zhj;
 * 
 * 商品类 Item； 
 * 
 * */
public class Item {

	private int Item_id;     //商品编号：Item_id(PK)，自增数据，不能手动修改;
	private int Shop_id;     //店铺编号：Shop_id，用来表示商品的归属店铺；    
	
	private String Name;     //商品名称：Name；
	private String Part;     //商品类别：Part；（拍卖品或者非拍卖品）
	private String Typeh;    //商品类型：Typeh；（商品的上层类型）
	private String Typel;    //商品类型：Typel；（商品的下层类型）
	private int Number;      //商品数量：Number；
	private double Price;    //商品价格：Price；
	private String Detail;   //商品描述：Detail；
	private String Image;    //商品图片：Image；
	
	private int BrowingTimes; //商品浏览次数：BrowingTimes，后台数据，初始化为0，不能手动修改；

	
/*********************set******get***************************************/
	
	public String getName() {
		return Name;
	}
	public int getItem_id() {
		return Item_id;
	}
	public void setItem_id(int Item_id) {
		this.Item_id = Item_id;
	}
	public int getShop_id() {
		return Shop_id;
	}
	public void setShop_id(int Shop_id) {
		this.Shop_id = Shop_id;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getPart() {
		return Part;
	}
	public void setPart(String Part) {
		this.Part = Part;
	}
	public String getTypeh() {
		return Typeh;
	}
	public void setTypeh(String Typeh) {
		this.Typeh = Typeh;
	}
	public String getTypel() {
		return Typel;
	}
	public void setTypel(String Typel) {
		this.Typel = Typel;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int Number) {
		this.Number = Number;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double Price) {
		this.Price = Price;
	}
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String Detail) {
		this.Detail = Detail;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String Image) {
		this.Image = Image;
	}

	public int getBrowingTimes() {
		return BrowingTimes;
	}
	public void setBrowingTimes(int BrowingTimes) {
		this.BrowingTimes = BrowingTimes;
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
