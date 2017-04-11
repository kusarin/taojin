<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
 <title>确认订单</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
 
<link rel="stylesheet" href="${pageContext.request.contextPath}/TaoJin/css/sureOrder.css"/>
<link href="${pageContext.request.contextPath}/TaoJin/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/TaoJin/css/bootstrap-responsive.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/TaoJin/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/TaoJin/css/flexslider.css" type="text/css" media="screen" rel="stylesheet"  />
<link href="${pageContext.request.contextPath}/TaoJin/css/jquery.fancybox.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/TaoJin/css/cloud-zoom.css" rel="stylesheet">

<script>
  function plus(val){
   var num=document.getElementById("mp");
   var value=parseInt(num.value);
   var total=document.getElementById("total");
   
   if(value<val){
    num.value=value+1;
    total.innerHTML=num.value;
   }
   else{
    alert("这样的商品总共"+num.value+"件！抱歉！！");
   }
  }
  function minus(){
    var num=document.getElementById("mp");
	var value=parseInt(num.value);
	var total=document.getElementById("total");
	
	if(value>1){
    num.value=value-1;
    total.innerHTML=num.value;
	}
  }
</script>
</head>
<body>
<!-- Header Start -->
	<header>
	<div class="headerstrip">
		<div class="container">
			<div class="row">
				<div class="span12">
					<!-- Top Nav Start -->
					<div class="pull-left">
						<div class="navbar" id="topnav">
						
							<div class="navbar-inner">
							<div style="float:left;color:white;margin-top:26px;">
							  <span>您好,</span>
							  <a href="#"><span style="color:white;">登录</span></a>
							  <a href="#"> <span style="margin-left:20px;color:white;">注册</span></a>
							 </div>
							  <div style="margin-left:250px;">
								<ul class="nav">
								    <li><a class="home active" href="#">首页</a></li>
									<li><a class="myaccount" href="#">个人账户</a></li>
									<li><a class="shoppingcart" href="#">购物车</a></li>
									<li><a class="checkout" href="#">我的订单</a></li>
								    <li><a class="checkout" href="#">发布二手</a></li>
								</ul>
							 </div>
							</div>
						</div>
					</div>
					<!-- Top Nav End -->
					<div class="pull-right">
						<form class="form-search top-search">
							<input type="text" class="input-medium search-query"
								placeholder="搜索你想要的二手"/ style="border:4px solid #FFA07A;">
								<input type="submit" value="搜索"
								style="height:42px;width:auto;background-color:#FFA07A;margin-left:-4px;border:4px solid #FFA07A;"/>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</header>
	<!-- Header End -->
	
    <div class="containers">
	   <div class="orderTitle" style="color:gray;">
	      <p>请核对订单信息</p>
	   </div>
	   
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
			       <td class="nav12">小计</td>
				</tr>
				</table>
			</div>
			
		</div>
		
		<div class="shoper">
			    <span>店铺：<a href="#">${c.shopName}</a></span>
			    <input type="hidden" value="${c.shopName}" name="shopName">
		</div>
		<c:forEach items="${c.orderDeatail}" var="collection">
		<div class="orderDe" style="border:1px solid #80ffff;">
		<table>
		   <tr>
			     <td class="test1"><a href="#"><img src="${pageContext.request.contextPath}/${collection.item.image}"/></a>
		        <a href="#"><p>${collection.item.detail}</p></a></td>
				 <td class="common" style="padding-left:0px;text-align:center;">
				 <input type="button" value="-"  id="m" onclick="minus()" style="text-align:center;height:30px;width:30px;float:left;border:0;">
				 <input type="text" value="${collection.itemNumbers}" id="mp" readonly="readonly" name="number" style="background-color:white;text-align:center;width:40px;float:left;border:1px;">
				 <input type="button" value="+"  onclick="plus(3)" style="height:30px;width:30px;text-align:center;float:left;border:0;"></td>
				 <td class="common">${collection.unitPrice}</td>
				 <td class="common">${collection.itemPrice}</td>
			 </tr>
		 </table>
		</div>
		</c:forEach>
		<div class="orderDe">
		    <table class="same">
			     <tr><td style="padding-top:15px;padding-bottom:15px;"><strong class="pay" id="total">${c.totalNumbers}</strong>件商品，总商品金额：<strong class="pay">${c.order.actulPayment}</strong></td></tr>
			     <tr><td style="padding-bottom:15px;"> 运费：<strong class="pay">${c.order.freight}</strong></td></tr>
			</table>
		</div>
		
		<div class="orderDe" style="margin-top:0px;border:1px solid #80ffff;">
		  <table  class="same" style="background-color:#f0ffff;">
			     <tr><td style="padding-top:15px;">应付总额： <span class="pay">${c.order.actulPayment}</span></td></tr>
			     <tr><td style="padding-top:15px;"> 寄送至： 陕西 西安市  </td></tr>
				 <tr><td style="padding-top:15px;padding-bottom:15px;">收货人:********</td></tr>
		  </table>
		</div>
		
		<div class="commit">
		    <input type="submit" value="提交订单"/>
		</div>
    </div> 
    <!-- footer -->
	<footer style="margin-top:20px">
       <img  src="${pageContext.request.contextPath}/TaoJin/image/footer-tri.png" style="width:100%;">
            <div style="margin: 0px 0px 10px;text-align:center;padding-top:10px;">
			 
             <span>友情链接/</span>
                <a href="http://www.nwpu.edu.cn/" target="_top" class="links">西北工业大学</a>
				
            </div>
            <div style="text-align:center;margin-bottom:10px;">
               <a id="fd_footer" href="javascript:;">产品意见反馈</a>
               <a href="http://www.2shoujie.com/joinUs" target="_top">加入我们</a>
            </div>
        <div style="text-align:center;margin-bottom:10px;">
            <span>©2017   版权所有</span>
            <span>鄂ICP备14003265号-2</span>
        </div>
    </footer>
 </body>
</html>