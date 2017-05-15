package cn.it.service;

import java.util.List;

import cn.it.pojo.KeyWordTimes;

/*****
 * 
 * 
 * InformationRetrivalServiceImpl
 *实现类的接口
 * */
public interface InfoSearchService {
	/*
	 * 
	 * 根据关键字搜索商品信息
	 * 并统计搜索关键字
	 * */
	public void searchItemInfo(String keyWords,int userId);
	/*
	 * 获取参考售价
	 * 
	 * */
	public double[] getRefPrice(String typel);
	/**
	 * 获取用户的搜索关键字记录
	 * */
	public List<KeyWordTimes> getKeyWords(int userId);
}
