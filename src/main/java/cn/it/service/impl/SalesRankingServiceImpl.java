package cn.it.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import cn.it.dao.ItemDao;
//import cn.it.dao.SalesRankingDao;
import cn.it.pojo.Item;
import cn.it.pojo.Page;
import cn.it.pojo.SalesRanking;
import cn.it.service.SalesRankingService;


@Service("salesRankingService")
public class SalesRankingServiceImpl implements SalesRankingService {

//	@Autowired
//	private SalesRankingDao salesRankingDao;
	
	@Autowired
	private ItemDao itemDao;
//	@Autowired
//	private SalesRankingDao salesRankingDao;
	
	/**
	 * @param(typeh商品所属类型)
	 * 根据商品所属类型的不同
	 * 对不同类商品进行销售排行
	 * 
	 */
	public List<SalesRanking> getSalesRanking(String typeh) {
		
		/**
		 * 对出售的商品进行处理
		 * */
		double salesAmount;//某件商品的交易额
		String itemName; //商品名
		int ranking=1;//商品交易排名
		List<SalesRanking> sales=new ArrayList<SalesRanking>();//无序的销售排行表
		
		List<Item> itemList=itemDao.FindItemByType1(typeh);//查找typeh类型的所有商品
		//构建销售列表
		for(Item item:itemList){
			SalesRanking s=new SalesRanking();
		    salesAmount=item.gettradingTimes()*item.getprice();
		    s.setSalesAmount(salesAmount);
		    itemName=item.getname();
		    s.setItemName(itemName);
		    s.setRanking(ranking);
		   
		    sales.add(s);
		}
	
		//实例化比较器
		Comparator<SalesRanking> comparator=new Comparator<SalesRanking> (){

			public int compare(SalesRanking o1, SalesRanking o2) {
				// TODO Auto-generated method stub
					return Double.compare(o1.getSalesAmount(), o2.getSalesAmount());
			}
			
		};
		//先升序排列
		Collections.sort(sales, comparator);
		//再降序排列
		Collections.reverse(sales);
		//对排序后的列表设置其排行
		for(SalesRanking ras:sales){
			
			ras.setRanking(ranking);
			ranking++;
			
		}
		return sales;
		
	}
	/*
	 * 销售分类
	 * 分页
	 * */
	Page<SalesRanking> fenye(Page<SalesRanking> page){
		page.setPagestart(page.getPageNo());
		return null;
	}
	
}
