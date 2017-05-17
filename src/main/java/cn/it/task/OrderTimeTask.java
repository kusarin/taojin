package cn.it.task;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.it.dao.ItemDao;
import cn.it.dao.OrderDao;
import cn.it.dao.OrderDetailDao;
import cn.it.pojo.Item;
import cn.it.pojo.Order;
import cn.it.pojo.OrderDetail;

@Component
public class OrderTimeTask {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	    @Scheduled(cron = "30/30 * * * * ? ") // 间隔30秒执行
	    public void taskCycle() {
	    	
	    List<Order> o=orderDao.get("待付款");
	    long d2=new Date().getTime();//当前时间
	    if(o.size()!=0){
	        for(Order ol:o){
	    	long d1=ol.getOrderTime().getTime();
	    	//时间间隔分钟数
	    	long d3=(d2-d1)/(1000 * 60);
	    	if(d3>5){//下单和当前时间相差超过5分钟
	    		ol.setStatus("已取消");
	    		orderDao.update(ol);
	    		ol.setRemoveOrderTime(new Timestamp(new Date().getTime()));
	    		orderDao.updateTime(ol);
	    		/*****更新商品的总数***/
				List<OrderDetail> oli=orderDetailDao.selectAll(ol.getOrderNumber());//此订单中的所有商品
				for(OrderDetail ord:oli){
				int itemId=ord.getItemId();//订单中的商品
				
				Item ii=itemDao.FindItemById(itemId);//item表中的商品
				ii.setnumber(ii.getnumber()+ord.getItemNumbers());//更新商品总数
				itemDao.ItemUpdate(ii);//更新item表
			}
	    }
	 }
	        System.out.println("任务进行中.......");
	    }
	  }
}
