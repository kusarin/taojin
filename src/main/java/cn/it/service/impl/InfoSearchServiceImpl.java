package cn.it.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import cn.it.dao.ItemDao;
import cn.it.dao.KeyWordTimesDao;
import cn.it.dao.TypehDao;
import cn.it.dao.TypelDao;
import cn.it.pojo.Item;
import cn.it.pojo.KeyWordTimes;
import cn.it.pojo.Typeh;
import cn.it.pojo.Typel;
import cn.it.service.InfoSearchService;

/***
 * 
 * @author Administrator 信息检索 获取参考售价 统计关键字
 */
@Service("infoSearchService")
public class InfoSearchServiceImpl implements InfoSearchService {

	@Autowired
	private ItemDao itemDao;
	@Autowired
	private KeyWordTimesDao keyWordTimesDao;
	@Autowired
	private TypelDao typelDao;
	@Autowired
	private TypehDao typehDao;

	/*
	 * 
	 * 根据关键字搜索商品信息 并统计搜索关键字
	 */
	public void searchItemInfo(String keyWords, int userId) {
		// TODO Auto-generated method stub
		List<Item> ilist = itemDao.SearchItem(keyWords);
		
		int times = 0;
		if (ilist.size() != 0) {
			KeyWordTimes ke=keyWordTimesDao.selectUK(userId,keyWords);
			if(ke==null){
				times++;
				KeyWordTimes key = new KeyWordTimes();
				key.setKeyWord(keyWords);
				key.setTimes(times);
				key.setUser_id(userId);
				keyWordTimesDao.add(key);	
			}
			else{
				times=ke.getTimes()+1;
				ke.setTimes(times);
				keyWordTimesDao.update(ke);
			}
		}
	}

	/*
	 * 获取参考售价
	 */
	public double[] getRefPrice(String typel) {
		// TODO Auto-generated method stub
		double[] refPrice = new double[3];
		// 根据商品的二阶类型获取商品的一阶类型
		Typel tyl = typelDao.FindTypelByName(typel);
		int typeh_id = tyl.getTypeh_id();
		Typeh tyh = typehDao.FindTypehById(typeh_id);
		String typeh = tyh.getName();
		// 获取商品一阶分类结束
		List<Item> itemList = itemDao.FindItemByType2(typeh, typel);
		double averagePrice = 0; // 平均价格
		double totalPrice = 0;
		double floorPrice = 0;// 最低价格

		double ceilingPrice = 0; // 最高价格
		if (itemList.size() != 0) {
			floorPrice = itemList.get(0).getprice();
			totalPrice = itemList.get(0).getprice();
			ceilingPrice = itemList.get(0).getprice();
		}

		for (int i = 1; i < itemList.size(); i++) {
			Item item1 = itemList.get(i);
			// 搜索查询到的商品的最高价格
			if (ceilingPrice < item1.getprice()) {
				ceilingPrice = item1.getprice();
			}
			// 搜索查询到的商品中的最低价格
			if (floorPrice > item1.getprice()) {
				floorPrice = item1.getprice();
			}
			// 此种商品的商品总价
			totalPrice += item1.getprice();
		}
		// 平均价格
		averagePrice = totalPrice / itemList.size();
		refPrice[0] = floorPrice;
		refPrice[1] = averagePrice;
		refPrice[2] = ceilingPrice;
		return refPrice;
	}
	/**
	 * 获取用户的搜索关键字记录
	 * */
	public List<KeyWordTimes> getKeyWords(int userId){
		
		return keyWordTimesDao.select(userId);
	}
}
