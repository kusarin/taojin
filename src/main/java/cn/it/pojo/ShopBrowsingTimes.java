package cn.it.pojo;
/**
 * 
 * @author Administrator
 * 店铺浏览次数记录
 */
public class ShopBrowsingTimes {

	private int id;//店铺浏览次数表的主键
	private int times;//店铺浏览次数
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
