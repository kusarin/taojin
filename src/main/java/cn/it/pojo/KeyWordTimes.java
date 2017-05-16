package cn.it.pojo;
/**
 * 
 * 关键字搜索次数统计类
 **/
public class KeyWordTimes {
      
	private int keyWordTimes_id; //关键字搜索次数统计表的主键
	private int user_id;//用户id;
	private String keyWord;  //关键字
	private int times;//关键字使用次数
	/**************get*******************set********/
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public int getTimes() {
		return times;
	}

	
	public int getKeyWordTimes_id() {
		return keyWordTimes_id;
	}

	public void setKeyWordTimes_id(int keyWordTimes_id) {
		this.keyWordTimes_id = keyWordTimes_id;
	}

	public void setTimes(int times) {
		this.times = times;
	}
	
}
