package cn.it.service;

import java.util.List;

import cn.it.pojo.SalesRanking;

public interface SalesRankingService {
	/**
	 * @param(typeh商品所属类型)
	 * 根据商品所属类型的不同
	 * 对不同类商品进行销售排行
	 * 
	 */
	public List<SalesRanking> getSalesRanking(String typeh);
}
