<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
 <title>确认订单</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
 
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sureOrder.css"/>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/flexslider.css" type="text/css" media="screen" rel="stylesheet"  />
<link href="${pageContext.request.contextPath}/css/jquery.fancybox.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/cloud-zoom.css" rel="stylesheet">

<script>
  function plus(val){
   var num=document.getElementById("mp");
   var value=parseInt(num.value);
   var total=document.getElementById("total");
   var itemprice=document.getElementById("itemprice");
   var unitPrice=document.getElementById("unitPrice");
   var actulpayment=document.getElementById("actulpayment");
   var ac=document.getElementById("ac");
   if(value<val){
    num.value=value+1;
    total.innerHTML=num.value;
    itemprice.innerHTML=""+parseFloat(unitPrice.value)*parseInt(num.value);
    actulpayment.innerHTML=itemprice.innerHTML;
    ac.innerHTML=actulpayment.innerHTML;
   }
   else{
    alert("这样的商品总共"+num.value+"件！抱歉！！");
   }
  }
  function minus(){
    var num=document.getElementById("mp");
	var value=parseInt(num.value);
	var total=document.getElementById("total");
	var itemprice=document.getElementById("itemprice");
	var unitPrice=document.getElementById("unitPrice");
	var actulpayment=document.getElementById("actulpayment");
	var ac=document.getElementById("ac");
	if(value>1){
    num.value=value-1;
    total.innerHTML=num.value;
    itemprice.innerHTML=""+parseFloat(unitPrice.value)*parseInt(num.value);
    actulpayment.innerHTML=itemprice.innerHTML;
    ac.innerHTML=actulpayment.innerHTML;
	}
  }
  function test(obj) {
	  if(obj.id=='btn1') {
	    x=document.getElementById("btn1");
		x.style.border="2px solid red";
		y=document.getElementById("btn2");
	    y.style.border="1px solid #DCDCDC";
	    z=document.getElementById("payway");
	    z.value=0;
	  } 
	  if(obj.id=='btn2'){
	    x=document.getElementById("btn1");
		x.style.border="1px solid #DCDCDC";
	    y=document.getElementById("btn2");
	    y.style.border="2px solid red";
	    z=document.getElementById("payway");
	    z.value=1;
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
	
	<form action="submitOrder.do" method="post">
    <div class="containers">
	   <div class="orderTitle" style="color:gray;">
	      <p>请核对订单信息</p>
	   </div>
	   <div class="receiver">
	       <div class="info">
	       <strong>收货人地址</strong><a href="#"><strong style="float:right;font-size:12px;">新增地址</strong></a>
		   </div>
		   <div class="receiverInfo">
			     <input checked="checked" type="radio" name="receivingaddress" value="${address.receivingaddress}">${address.receivingaddress}
		   </div>
	   </div>
	   <div class="receive">
	       <div class="info">
	             <strong>支付方式</strong>
		    </div>
             <div class="butt">
			   <button class="btnn" id="btn1" onclick="test(this)" style="border:1px solid #DCDCDC;">货到付款</button>
			   <button class="bttn" id="btn2" onclick="test(this)" style="border:1px solid #DCDCDC;">在线支付</button>
			   <input type="hidden" id="payway" value="1" name="payway">
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
		<c:forEach items="${c.orderDeatail}" var="collection" varStatus="s">
		<div class="orderDe" style="border:1px solid #80ffff;">
		<table>
		   <tr>
			     <td class="test1"><a href="#"><img src="${pageContext.request.contextPath}${collection.item.image}"/></a>
			     <input type="hidden" value="${collection.item.image}" name="orderDeatail[${s.index}].item.image">
		        <a href="#"><p>${collection.item.detail}</p></a>
		        <input type="hidden" value="${collection.item.image}" name="orderDeatail[${s.index}].item.detail">
		        <input type="hidden" value="${collection.itemId}" name="orderDeatail[${s.index}].itemId">
		        </td>
				 <td class="common" style="padding-left:0px;text-align:center;">
				 <input type="button" value="-"  id="m" onclick="minus()" style="text-align:center;height:30px;width:30px;float:left;border:0;">
				 <input type="text" value="${collection.itemNumbers}" id="mp" readonly="readonly" name="number" style="background-color:white;text-align:center;width:40px;float:left;border:1px;">
				 <input type="button" value="+" onclick="plus(3)" style="height:30px;width:30px;text-align:center;float:left;border:0;"></td>
				 <td class="common">${collection.unitPrice}
				 <input type="hidden" value="${collection.unitPrice}" name="orderDeatail[${s.index}].unitPrice" id="unitPrice">
				 </td>
				 <td class="common" id="itemprice">${collection.itemPrice}</td>
			 </tr>
		 </table>
		</div>
		</c:forEach>
		<div class="orderDe">
		    <table class="same">
			     <tr><td style="padding-top:15px;padding-bottom:15px;"><strong class="pay" id="total">${c.order.totalQuantity}</strong>件商品，总商品金额：<strong class="pay" id="ac">${c.order.actulPayment}</strong>
			     <input type="hidden" value="${c.order.totalQuantity}" name="order.totalQuantity"></td></tr>
			     <tr><td style="padding-bottom:15px;"> 运费：<strong class="pay">${c.order.freight}</strong></td></tr>
			</table>
		</div>
		
		<div class="orderDe" style="margin-top:0px;border:1px solid #80ffff;">
		  <table  class="same" style="background-color:#f0ffff;">
			     <tr><td style="padding-top:15px;">实际支付： <span class="pay" id="actulpayment">${c.order.actulPayment}</span>
			      <input type="hidden" value="${c.order.actulPayment}" name="order.actulPayment" id="unitPrice">
			     </td></tr>
			     <tr><td style="padding-top:15px;"> 寄送至： ${address.receivingaddress}</td></tr>
				 <tr><td style="padding-top:15px;padding-bottom:15px;">收货人:${address.name}</td></tr>
		  </table>
		</div>
		
		<div class="commit">
		    <input type="submit" value="提交订单"/>
		</div>
    </div> 
    </form>
    <!-- footer -->
	<footer style="margin-top:20px">
       <img  src="${pageContext.request.contextPath}/image/footer-tri.png" style="width:100%;">
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