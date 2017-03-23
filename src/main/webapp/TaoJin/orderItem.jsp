<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>我的订单</title>

 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel="stylesheet" type="text/css" href="./TaoJin/css/orderItem.css"/>
</head>
<body>
<div class="container">
    <div class="orderTitle">
     <strong>我的订单</strong>
    </div>
	<div class="nav">
	     <table>
		     <tr>
	             <td class="shop">商品</td>
	             <td class="common">单价</td>
	             <td class="common">数量</td>
	             <td class="common">实付款</td>
	             <td class="common">交易状态</td>
			     <td class="common">交易操作</td>
			 </tr>
	     </table>
	</div>
	<div class="bton">
	    <button class="btn1"><a href="#">上一页</a></button>
		<button class="btn2"><a href="#">下一页</a></button>
	</div>
	<c:forEach items="${orderList}" var="collection">
	<div class="content">
	<div class="orderOne">
	     <table>
		     <tr>
		         <td class="orderNumber"><span class="date">${collection.order.orderTime}</span><span>订单号: 3179981484474492</span></td>
			     <td class="buyer1"><a href="#"><p>移动硬盘专营店qwertd6y7u89irtyui35uio34567i8qwerdtfy7gu789u0-34t5y6u7i89awearestuyri678d5657ii6i7</p></a></td>
				 <td class="buyer">&nbsp;</td>
				 <td class="buyer">&nbsp;</td>
				 <td class="buyer">&nbsp;</td>
				 <td class="bg"><a href="#"><img src="./TaoJin/image/delete.jpg"/></a></td>
			 </tr>
		 </table>
	</div>
	<div class="orderContent">
	   <table>
	         <tr> 
	             <td class="huanhang"><a href="#"><img src="${collection.orderDeatail.item.image}"/></a>
		         <a href="#"><p>Seagate希捷移动硬盘1T Backup Plus 新睿品4 2tb USB3.0超薄包邮 [交易快照]套餐类型：套餐一颜色分类：土豪金500G
		        gdfghjkll;lkjhjkl;;jkjiuygjhgghoopll</p></a></td>
		         <td class="same">￥270.00</td>
		         <td class="same">1</td>
		         <td class="same">￥270.00</td>
		         <td class="same">交易成功</td>
	             <td class="same"><a href="orderInfo.html">订单详情</a><br/><a href="#" style="margin-top:10px;">取消订单</a>
				 <br/><a href="#" style="margin-top:10px;">评价订单</a></td>
		     </tr>
		 </table>
	</div>
	</div>
	</c:forEach>
</div>
</body>
</html>