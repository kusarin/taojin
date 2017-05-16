package cn.it.pojo;
/*
 * 
 * 销售排行榜类
 * */
public class SalesRanking {
	private int id;//销售排行榜表主键
	private double salesAmount;//某件商品的交易额
	private int ranking;//商品交易排名
	private String itemName;//商品名
	/***********************get***********set*********/
	public int getId() {
		return id;
	}
	public int getRanking() {
		return ranking;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public double getSalesAmount() {
		return salesAmount;
	}
	public void setSalesAmount(double salesAmount) {
		this.salesAmount = salesAmount;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
