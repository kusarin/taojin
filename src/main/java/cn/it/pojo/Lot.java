package cn.it.pojo;
/**
 * 
 * @author zhj
 * 
 * 拍卖品类Lot
 *
 */
public class Lot {
	
	private int lot_id;     //拍卖品编号：lot_id(PK)，自增数据，不能手动修改;
	private int shop_id;     //店铺编号：shop_id，用来表示拍卖品的归属店铺,系统自动匹配；
	
	private String name;     //拍卖品名称：name；
	private String typeh;    //拍卖品类型：typeh；（拍卖品的一阶类型)
	private String typel;    //拍卖品类型：typel；（拍卖品的二阶类型）
	private int number;      //拍卖品数量：number；
	private String detail;   //拍卖品描述：detail；
	private String image;    //拍卖品图片：image；
	
	private int browsingTimes; //拍卖品浏览次数：browsingTimes，后台数据，初始化为0，不能手动修改；
	private int tradingTimes;  //拍卖品出售数量tradingTimes，后台数据，初始化为0，不能手动修改；
	
	private Shop shop;  //属性：店铺，继承店铺的所有属性
	
	private double nowPrice; // 拍卖品当前价格（拍卖价）
	private double maxPrice; // 拍卖品最高价（一口价）
	private int time;     // 拍卖品拍卖时间，单位分钟，初始为0，最大值为[3*24*60]，在Service层进行对比操作。
	
/**************************************set********get*********************************************/
	
	public int getLot_id() {
		return lot_id;
	}
	public void setLot_id(int lot_id) {
		this.lot_id = lot_id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getBrowsingTimes() {
		return browsingTimes;
	}
	public void setBrowsingTimes(int browsingTimes) {
		this.browsingTimes = browsingTimes;
	}
	public int getTradingTimes() {
		return tradingTimes;
	}
	public void setTradingTimes(int tradingTimes) {
		this.tradingTimes = tradingTimes;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public double getNowPrice() {
		return nowPrice;
	}
	public void setNowPrice(double nowPrice) {
		this.nowPrice = nowPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}	
}
