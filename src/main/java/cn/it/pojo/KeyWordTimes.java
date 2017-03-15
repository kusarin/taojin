package cn.it.pojo;
/**
 * 
 * 关键字搜索次数统计类
 **/
public class KeyWordTimes {
      
	private int id; //关键字搜索次数统计表的主键
	private String useTimeString;  //关键字使用次数
	private int times;//关键字使用次数
	/**************get*******************set********/
	public int getId() {
		return id;
	}
	public String getUseTimeString() {
		return useTimeString;
	}
	public int getTimes() {
		return times;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUseTimeString(String useTimeString) {
		this.useTimeString = useTimeString;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	
}
