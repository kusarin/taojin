package cn.it.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


import java.util.Date;
import java.util.Iterator;
import java.util.List;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.it.dao.ItemDao;
import cn.it.dao.OrderDao;
import cn.it.dao.OrderDetailDao;
import cn.it.pojo.Item;
import cn.it.pojo.Order;
import cn.it.pojo.OrderCollection;
import cn.it.pojo.OrderDetail;
import cn.it.service.OrderService;

/**
 * 
 * 对订单进行处理
 * 包括提交订单，保存生成的订单信息、查看所有订单、查看订单详情
 * 删除订单
 * 修改订单中的交易状态
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDetailDao orderDetailDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ItemDao itemDao;
	//任意对象
	private static Object lockObj = "lockerOrder"; 
	//订单数量
    private static long orderNumCount = 0L;  
	    /** 
	     * 每毫秒生成订单号数量最大值 
	     */  
	private int maxPerMSECSize=1000; 
	
	
	/**
	 * 获取订单详情
	 * @param(userId表示用户编号)
	 * 
	 * */
	public List<OrderDetail> getAllOrderDetail(int userId){
		List<Order> olist=orderDao.selectAll(userId);//根据用户标号获取该用户的所有订单
		List<OrderDetail> rlist=new ArrayList<OrderDetail>();//存放订单明细的容器
		
		Iterator<Order> order = olist.iterator();//订单迭代器
		while(order.hasNext()){ //订单容器不为空
		    Order or= order.next();//提取容器中的元素
		    if(orderDetailDao.selectAll(or.getOrderNumber())!=null){  //根据订单id查询订单明细
		    	List<OrderDetail> list=orderDetailDao.selectAll(or.getOrderNumber());//获取订单明细对应的容器
		    	
		    	Iterator<OrderDetail> od = list.iterator();//获取订单迭代器
		    	while(od.hasNext()){ //容器不为空
		    	    OrderDetail ol= od.next(); //获取容器中的一个元素
		    	    rlist.add(ol);//将元素加入容器
		    	}
		    }
		}
		return rlist;
	}
	
    /**roe
     *获取所有订单
	 * @param(userId表示用户编号) 
     * */
	public List<Order> getAllOrder(int userId){
		
		return orderDao.selectAll(userId);
	}
	
	/**
	 * 
	 * 合并两个list
	 * */
	public List<OrderCollection> mergeList(List<Order> orderList,List<OrderDetail> orderDetailList){
		List<OrderCollection> collection = new ArrayList<OrderCollection>();
		Iterator<Order> iter1=orderList.iterator();
		Iterator<OrderDetail> iter2=orderDetailList.iterator();
		
		  while(iter1.hasNext()&&iter2.hasNext()){
		    	OrderCollection orderCollection =new OrderCollection();
		    	orderCollection.setOrder(iter1.next());
		    	orderCollection.setOrderDeatail(iter2.next());
		    	collection.add(orderCollection);
		    }
		return collection;
	}
	
	/**
	 * 更改订单的交易状态
	 * @param(flag对用户的操作进行标记)
	 * */
	public void changeOrderStatus(int flag,String orderNumber){
	     Order order=orderDao.findOrder(orderNumber);
	     switch(flag){
	     case 0: 
	    	 order.setStatus("待付款"); 
	    	 break;
	     case 1: 
	    	 order.setStatus("已付款");
	    	 break;
	     case 2:
	         order.setStatus("待收货");
	         break;
	     case 3:
	    	 order.setStatus("交易成功");
	    	 break;
	     case 4:
	    	 order.setStatus("已取消");
	     default:
	    	 break;
	     }
	     orderDao.update(order);
	}
	
	/**
	 *
	 * @param(id表示订单表的唯一标识)
	 * 获取某订单详细信息
	 * */
	public OrderCollection getOrderDetail(String orderNumber){
		OrderCollection collectionDetail=new OrderCollection();
		Order order=orderDao.findOrder(orderNumber);
		collectionDetail.setOrder(order);
		List<OrderDetail> orlist=orderDetailDao.selectAll(orderNumber);
		
		for(OrderDetail detail:orlist){
			collectionDetail.setOrderDeatail(detail);
		}
		return collectionDetail;	
	}
	
	/**
	 * 
	 * 删除订单
	 * */
	public void deleteOrder(String orderNumber){
		
		orderDao.delete(orderNumber);        //删除该订单号对应的订单
		orderDetailDao.delete(orderNumber);  //删除此订单对应的订单明细
	}
	
	/**
	 * 提交订单
	 * @param(itemId表示订单id
	 * 
	 * */
	public void submmitOrder(int itemId,int payLabel,String address,int userId){
		Order order=new Order();
		order.setUserID(userId);
        String orderNumber =new OrderServiceImpl().createOrderNum();//创建订单号
		order.setOrderNumber(orderNumber);
		order.setOrderTime(new java.sql.Date(new Date().getTime()));//下单时间
		Item item=itemDao.FindItemById(itemId);
		double unitPrice=item.getprice();      //商品单价
		order.setUnitPrice(unitPrice);
		int numbers=item.getSaleNumbers();
		order.setQuantity(numbers);  //购买的数量
		double actulPayment=item.getSaleNumbers()*item.getprice();//最终支付
		order.setActulPayment(actulPayment);
		String status="待付款";  //订单的交易状态
		order.setStatus(status);
		switch(payLabel){
			case 0:
				order.setPaymentMethod("货到付款");
			case 1:
				order.setPaymentMethod("第三方支付");
            default:
            	break;
		}
	   order.setRecivingAddress(address);  //收货地址
	   double freight=0;   //运费
	   order.setFreight(freight);
	   orderDao.add(order);
	   
	   OrderDetail orderDetail=new OrderDetail();
	   int totalQuantity =item.getSaleNumbers();
	   orderDetail.setTotalQuantity(totalQuantity);
	   orderDetail.setOrderNumber(orderNumber);
	   orderDetail.setItemId(itemId);
	   orderDetailDao.add(orderDetail);
	}
	
	/**
	 * 
	 * 创建订单号
	 * 
	 * */
	public String createOrderNum(){
		String orderNum=""; //最终生成的订单
		 synchronized (lockObj) {  
             // 取系统当前时间作为订单号变量前半部分，精确到毫秒  
             long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));  
             // 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值1000个，1秒100万  
             if (orderNumCount > maxPerMSECSize) {  
                 orderNumCount = 0L;  
             }  
           //组装订单号  
             String countStr=maxPerMSECSize +orderNumCount+"";  //每毫秒生成的最大订单数+订单的数量组成的字符串
             orderNum=nowLong+countStr.substring(1);  
             orderNumCount++;  
		return orderNum;
	   }
	}
}
