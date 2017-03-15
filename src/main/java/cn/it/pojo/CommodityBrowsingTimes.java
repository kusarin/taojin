package cn.it.pojo;
/**
 * 
 * @author Administrator
 * 商品浏览次数记录
 */

public class CommodityBrowsingTimes {
	private int id;//商品浏览次数表的主键
	private int times;//商品浏览次数
	/***********get*************set**********/
	public int getId() {
		return id;
	}
	public int getTimes() {
		return times;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	
}
