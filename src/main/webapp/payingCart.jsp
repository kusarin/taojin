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
  function  readddr(){
	  var addr=document.getElementsByName("addr");
	  var i=-1;
	 
	  for( var j=0;j<addr.length;j++){
		  if(addr[j].checked){
			  i++;
			  break;
		  }
	  }
	  if(i==-1){
		  alert("请选择收货地址");
		  return;
	  }
  }
function  ad(){
	var addr=doucument.getElementsByName("addr");
    var j=0;
	for( ;j<addr.length;j++){
		  if(addr[j].checked){
			  break;
		  }
	  }
	  document.getElementById("rece").innerHTML= addr[j].value;
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
	
	<form action="commitOrderDeCart.do" method="post">
    <div class="containers">
	   <div class="orderTitle" style="color:gray;">
	      <p>请核对订单信息</p>
	   </div>
	   <div class="receiver">
	       <div class="info">
	       <strong>收货人地址</strong><a href="#"><strong style="float:right;font-size:12px;">新增地址</strong></a>
		   </div>
		   <c:forEach items="${address}" var="adr">
		   <div class="receiverInfo">
			     <input type="radio" name="addr" value="${adr.addr}" onclick="ad()">${adr.addr}
		   </div>
		   </c:forEach>
	   </div>
	   <div class="receive">
	       <div class="info">
	             <strong>支付方式</strong>
		    </div>
             <div class="butt">
             
			   <input type="radio" name="payAway" value="0" style="border:1px solid #DCDCDC;margin-top:-5px;">微信支付
	
			   <input type="radio" checked="true" name="payAway" value="1"  style="border:1px solid #DCDCDC;margin-top:-5px;margin-left:40px;">支付宝
			  
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
		<c:forEach items="${cl.ca}" var="c" varStatus="s">
		<div class="shoper">
			    <span>店铺：<a href="#">${c.shopName}</a></span>
			    <input type="hidden" name="ca[${s.index}].shopName" value="${c.shopName}">
		</div>
		
		<div class="orderDe" style="border:1px solid #80ffff;">
		<table>
		   <tr>
			     <td class="test1"><a href="#" style="float:left;"><img src="${pageContext.request.contextPath}${c.item.image}"/></a>
			   <!-- <input type="hidden" value="${c.item.image}" name="orderDeatail[${s.index}].item.image"> -->
		       <p style="width: 100px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;float:left;margin-top:20px;"> <a href="#">${c.item.name}</a></p>
		        </td>
				 <td class="common" style="padding-left:0px;text-align:center;">${c.tradingNumbers}
				 <input type="hidden" name="ca[${s.index}].tradingNumbers" value="${c.tradingNumbers}">
				 </td>
				 <td class="common">${c.item.price}</td>
				 <td class="common" id="itemprice">${c.totalPrice}
				 <input type="hidden" name="ca[${s.index}].totalPrice" value="${c.totalPrice}">
				 <input type="hidden" name="ca[${s.index}].itemId" value="${c.itemId}">
				 <input type="hidden" name="ca[${s.index}].cartItemId" value="${c.cartItemId}">
				 </td>
				 
			 </tr>
		 </table>
		</div>
		</c:forEach>
		<div class="orderDe">
		    <table class="same">
			     <tr><td style="padding-top:15px;padding-bottom:15px;"><strong class="pay" id="total">${cl.sh.totalnumber}</strong>件商品，总商品金额：
			     <strong class="pay" id="ac">${cl.sh.total}</strong></td></tr>
			     <tr><td style="padding-bottom:15px;"> 运费：<strong class="pay">0.0</strong></td></tr>
			</table>
		</div>
		
		<div class="orderDe" style="margin-top:0px;border:1px solid #80ffff;">
		  <table  class="same" style="background-color:#f0ffff;">
			     <tr><td style="padding-top:15px;">实际支付： 
			     <span class="pay" id="actulpayment">${cl.sh.total}</span>
			     </td></tr>
			     <tr><td style="padding-top:15px;"><p id="rece"> 寄送至：##################</p></td></tr>
				 <tr><td style="padding-top:15px;padding-bottom:15px;">收货人:######</td></tr>
		  </table>
		</div>
		
		<div class="commit">
		    <input type="submit" value="提交订单" onclick="readddr()"/>
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