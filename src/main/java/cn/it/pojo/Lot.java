package cn.it.pojo;
/**
 * 
 * @author zhj
 * 
 * 拍卖品类Lot
 *
 */
public class Lot {
	
	private int lot_id;      // 拍卖品编号：lot_id(PK)，自增数据，不能手动修改;
	private int shop_id;     // 店铺编号：shop_id，用来表示拍卖品的归属店铺,系统自动匹配；
	
	private int user_id;     // 用户编号：user_id，用来表示当前出价人的id
	
	private String name;     // 拍卖品名称：name；
	private String typeh;    // 拍卖品类型：typeh；（拍卖品的一阶类型)
	private String typel;    // 拍卖品类型：typel；（拍卖品的二阶类型）
	private String detail;   // 拍卖品描述：detail；
	private String image;    // 拍卖品图片：image；
	
	private int status;      // 拍卖品状态：0/1/2；0表示在售状态，1表示流拍状态，2表示卖出。
	
	private double startprice;// 拍卖品底价
	private double nowprice; // 拍卖品当前价格（拍卖价）
	private double maxprice; // 拍卖品最高价（一口价）
	
	private double addprice;    // 拍卖品加价额度
	
	private int time;        // 拍卖品拍卖时间，单位分钟，初始为0，最大值为[3*24*60]，在Service层进行对比操作。
	private String address;   //当前出价者选择的收货地址
	private Shop shop;       //属性：店铺，继承店铺的所有属性
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getstartprice() {
		return startprice;
	}
	public void setstartprice(double startprice) {
		this.startprice = startprice;
	}
	public double getNowprice() {
		return nowprice;
	}
	public void setNowprice(double nowprice) {
		this.nowprice = nowprice;
	}
	public double getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(double maxprice) {
		this.maxprice = maxprice;
	}
	public double getAddprice() {
		return addprice;
	}
	public void setAddprice(double addprice) {
		this.addprice = addprice;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}	
	/**************************************set********get*******end********************************/
	/**
	 * toString方法，测试用。
	 * 输出拍卖品的属性
	 */
	@Override
	public String toString(){
		return "\n Lot ["+lot_id+"] =("+shop_id+"   "+name+"   "+typeh+"   "
				                      +typel+"   "+nowprice+"   "
				                      +maxprice+"   "+detail+"   "
				                      +image+"   "+status+"   "
				                      +time+"   " +")";
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
