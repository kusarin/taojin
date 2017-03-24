<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
 <title>确认订单</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
 
<link rel="stylesheet" href="sureOrder.css" />
<link rel="stylesheet" href="./TaoJin/css/orderInfo.css" />
</head>

<body>
    <div class="container">
	   <div class="orderTitle" style="color:gray;">
	      <p>请核对订单信息</p>
	   </div>
	   <div class="downline"></div>
	   <div class="receiver">
	       <div class="info">
	       <strong>收货人地址</strong><a href="#"><strong style="float:right;font-size:12px;">新增地址</strong></a>
		   </div>
		   <div class="receiverInfo">
			     <input checked="checked" type="radio">### 陕西 西安市 莲湖区 陕西省西安市莲湖区劳动南路西工大旺园学生公寓 188****
		   </div>
	   </div>
	   <div class="receive">
	       <div class="info">
	             <strong>支付方式</strong>
		    </div>
             <div class="butt">
			   <button class="btnn">货到付款</button>
			   <button class="bttn">在线支付</button>
		     </div>
		 </div>
		 <div class="downline"></div>
		<div class="receive">
		      <div class="info">
	             <strong>订单信息</strong>
		      </div>
		    <div class="nav1">
			    <table>
				<tr>
				   <td class="nav11">商品</td>
			       <td class="nav12">数量</td>
			       <td class="nav12">单价</td>
			       <td class="nav12">优惠方式</td>
			       <td class="nav12">小计</td>
				</tr>
				</table>
			</div>
			<div class="shoper">
			    <span>店铺：<a href="#">dkbov帝克博威旗舰店</a></span>
			</div>
		</div>
		<div class="downline"></div>
		<div class="orderDe">
		<table>
		   <tr>
			     <td class="test1"><a href="#"><img src="image/order1.jpg"/></a>
		         <a href="#"><p>Seagate希捷移动硬盘1T Backup Plus 新睿品4 2tb USB3.0超薄包邮 [交易快照]套餐类型：套餐一颜色分类：土豪金500G
		        gdfghjkll;lkjhjkl;;jkjiuygjhgghoopll</p></a></td>
				 <td class="common">1</td>
				 <td class="common">370.00</td>
				 <td class="common">省100</td>
				 <td class="common">270.00</td>
			 </tr>
		 </table>
		</div>
		<div class="downline"></div>
		<div class="orderDe">
		    <table class="same" cellspacing="15">
			     <tr><td><strong class="pay">1</strong>件商品，总商品金额：<strong class="pay">￥29.90</strong></td></tr>
			     <tr><td> 运费：<strong class="pay">￥0.00</strong></td></tr>
			     <tr><td>优惠：<strong class="pay">￥100.00</strong></td></tr>
			</table>
		</div>
		<div class="downline"></div>
		<div class="orderDe" style="margin-top:0px;">
		  <table class="same" cellspacing="15" style="background-color:#f0ffff;">
			     <tr><td>应付总额： <span class="pay">￥270.00</span></td></tr>
			     <tr><td> 寄送至： 陕西 西安市  收货人:********</td></tr>
		  </table>
		</div>
		<div class="downline"></div>
		<div class="commit">
		    <button>提交订单</button>
		</div>
    </div> 
 </body>
</html>