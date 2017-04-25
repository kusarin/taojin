package cn.it.pojo;
/*
 * @author zhj;
 * 
 * 商品类 Item； 
 * 
 * */
public class Item {

	private int item_id;     //商品编号：item_id(PK)，自增数据，不能手动修改;
	private int shop_id;     //店铺编号：shop_id，用来表示商品的归属店铺,系统自动匹配；
	
	private String name;     //商品名称：name；
	private String typeh;    //商品类型：typeh；（商品的一阶类型)
	private String typel;    //商品类型：typel；（商品的二阶类型）
	private int number;      //商品数量：number；
	private double price;    //商品价格：price；
	private String detail;   //商品描述：detail；
	private String image;    //商品图片：image；
	
	private int status;      //商品状态：0/1；0表示在售状态，1表示不在售状态。
	
	private int browsingTimes; //商品浏览次数：browsingTimes，后台数据，初始化为0，不能手动修改；
	private int tradingTimes;  //商品出售数量tradingTimes，后台数据，初始化为0，不能手动修改；
	
	private Shop shop;  //属性：店铺，继承店铺的所有属性

/**************************************set********get*********************************************/
	
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
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
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

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getbrowsingTimes() {
		return browsingTimes;
	}
	public void setbrowsingTimes(int browsingTimes) {
		this.browsingTimes = browsingTimes;
	}		
	public int gettradingTimes() {
		return tradingTimes;
	}
	public void settradingTimes(int tradingTimes) {
		this.tradingTimes = tradingTimes;
	}	
	
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
/**************************************set********get*******end********************************/
	
	/**
	 * toString方法，测试用。
	 * 输出商品的属性
	 */
	@Override
	public String toString(){
		return "\n Item ["+item_id+"] =("+shop_id+"   "+name+"   "+typeh+"   "
				                      +typel+"   "+number+"   "
				                      +price+"   "+detail+"   "
				                      +image+"   "+status+"   "
				                      +browsingTimes+"   "
						              +tradingTimes+"   " +")";
	}
}

