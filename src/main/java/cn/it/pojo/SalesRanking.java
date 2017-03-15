package cn.it.pojo;
/*
 * 
 * 销售排行榜类
 * */
public class SalesRanking {
	private int id;//销售排行榜表主键
	private int tradingTimes;//某件商品的交易次数
	private int ranking;//商品交易排名
	/***********************get***********set*********/
	public int getId() {
		return id;
	}
	public int getTradingTimes() {
		return tradingTimes;
	}
	public int getRanking() {
		return ranking;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTradingTimes(int tradingTimes) {
		this.tradingTimes = tradingTimes;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	
	

}
