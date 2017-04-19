<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/flexslider.css" type="text/css" media="screen" rel="stylesheet"  />
<link href="${pageContext.request.contextPath}/css/jquery.fancybox.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/cloud-zoom.css" rel="stylesheet">
<title>我的订单</title>
<style>
.item{
    width:300px;
	text-align:center;
	height:45px;
 }
.co{
    width:80px;
	text-align:center;
	height:45px;
	
 }
.orderNumber{
    width:300px;
	text-align:center;
	height:45px;
 }
.buyer1{
    width:80px;
	text-align:center;
	height:45px;
 }
.buyer{
    width:80px;
	text-align:center;
	height:45px;
 }
.buyer1 a p{
	width:80px;
	overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
}
.huanhang{
    width:300px;
	height:120px;
		
}
.huanhang img{
   width:100px;
   height:120px;
   
}
.huanhang p{
    word-break:break-all;
	width:200px;
	overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
}
.sa{
    width:80px;
	height:120px;
	text-align:center;
}
a:hover{
	text-decoration:underline;
	color:red;
}
</style>
<script>
function deleteone(orderNumber){
	if(confirm("确定要删除这条订单吗？")){
		window.location.href="deleteOrder.do?pageNo=${pages.pageNo}&orderNumber="+orderNumber;
	}
}

function deleteAll(){
	var ii=0;
	var cks=document.getElementsByName("orderNumber");
    for(var i =0;i<cks.length;i++){
 	   if(cks[i].checked){
 		   ii++;
 	   }
    }
    if(ii==0){
 	   alert("至少选择一条");
      return;
    }
    if(confirm("确定要删除这"+ii+"条订单吗？")){
 	   document.myform.action="deleteAllOrder.do?pageNo=${pages.pageNo}";
 	   document.myform.submit();
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
							<input type="text" class="input-medium search-query"  style="width:auto;height:40px;border:4px solid #FFA07A"
								placeholder="搜索你想要的二手"><input type="submit" value="搜索"
								style="height:40px;width:auto;background-color:#FFA07A;border:4px solid #FFA07A;">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</header>
	<!-- Header End -->

	<div id="maincontainer" style="height:auto;">
		<div class="container" style="height:auto;">
			<div class="row" style="margin-top:20px;float:left;">
				<!-- Sidebar Start-->
				<aside class="span3">
				<div class="sidewidt">
					<h2 class="heading2">
						<strong style="font-size:16px;">订单中心</strong>
					</h2>
					<ul class="nav nav-list categories">
						<li><a href="#">我的订单</a></li>
						<li><a href="#">待付款
						<c:if test="${pendingPayment!=0}">
						<sup style="color:red;font-size:12px;">${pendingPayment}</sup>
						</c:if>
						</a></li>
						<li><a href="#">待收货
						<c:if test="${receivingGoods!=0}">
						<sup style="color:red;font-size:12px;">${receivingGoods}</sup>
						</c:if>
						</a></li>
						<li><a href="#">待评价
						<c:if test="${assessment!=0}">
						<sup style="color:red;font-size:12px;">${assessment}</sup>
						</c:if>
						</a></li>
						<li><a href="removeRecord.do">取消订单记录</a></li>
					</ul>
				</div>
				</aside>
			</div>
			<!-- Sidebar End-->
			<div class="span9" style="float:left;margin-top:20px;">
			    <div style="margin-top:20px;font-size:15px;color:#808A87;margin-bottom:10px;">
				 <strong>待评价的订单</strong>	
				</div> 
				<div style="height:auto;width:700px;">
				<table style="height:auto;width:700px; font-size:14px;">
				    <tr style="background-color:#F5F5F5;height:auto;width:700px;">
					    <td class="item">商品</td>
					    <td class="co">单价</td>
						<td class="co">数量</td>
						<td class="co">实付款</td>
						<td class="co">交易状态</td>
						<td class="co">操作</td>
					</tr>
				</table>
				</div>
				<div style="height:30px;width:auto;"></div>
				
				<div style="font-size:12px;height:auto;width:700px;color:black;text-align:right;margin-bottom:5px;">
				<button onclick="deleteAll()">删除选中</button>
				</div>
				
				
				<form action="orderItem.do" method="post" name="myform">
				<c:forEach items="${pages.datas}" var="orderc">
				<div style="height:auto;width:700px;margin-bottom:20px;">
				    <table  style="font-size:12px;height:auto;width:700px;color:black;">
		                <tr style="background-color:#F5F5F5;">
		                     <td class="orderNumber"><input type="checkbox" name="orderNumber" value="${orderc.order.orderNumber}" style="float:left;">
		                     <span style="float:left;margin-left:20px;margin-right:5px;">
		                     <strong style="color:black;">${orderc.order.orderTime}</strong></span>
		                     <span><p style="float:left;margin-right:5px;">订单号: </p>
							 <p style="color:black;float:left;">${orderc.order.orderNumber}</p></span></td>
			                 <td class="buyer1"><a href="#"><p>移动硬盘专营店qwertd6y7u89irtyui35uio34567i8qwerdtfy7gu789u0-34t5y6u7i89awearestuyri678d5657ii6i7</p></a></td>
				             <td class="buyer">&nbsp;</td>
				             <td class="buyer">&nbsp;</td>
				             <td class="buyer">&nbsp;</td>
				             <td style="text-align:center;"><a onclick="deleteone(${orderc.order.orderNumber})" href="javascript:void(0)">删除</a></td>
			            </tr>
			            
			            
						<tr style="border-left:1px solid #F5F5F5;border-right:1px solid #F5F5F5;border-bottom:1px solid #F5F5F5;"> 
						
	                     <td class="huanhang">
	                     <c:forEach items="${orderc.orderDeatail}" var="ord">
	                     <a href="#"><img src="${pageContext.request.contextPath}${ord.item.image}"/></a>
		                 <a href="#"><p>${ord.item.detail}</p></a>
		                 </c:forEach> 
		                 </td>
		                 
		                 <td class="sa" style="border-right:1px solid #F5F5F5;border-bottom:1px solid #F5F5F5;">
		                  <c:forEach items="${orderc.orderDeatail}" var="ord">
		                     <p>${ord.unitPrice}</p>
		                     <div style="height:120px;width:auto;"></div>
		                 </c:forEach> 
		                 </td>
		                    <td class="sa" style="border-right:1px solid #F5F5F5;border-bottom:1px solid #F5F5F5;">${orderc.order.totalQuantity}</td>
		                    <td class="sa" style="border-right:1px solid #F5F5F5;border-bottom:1px solid #F5F5F5;">${orderc.order.actulPayment}</td>
		                    <td class="sa" style="border-right:1px solid #F5F5F5;border-bottom:1px solid #F5F5F5;">${orderc.order.status}
		                    </td>
	                        <td class="sa" style="border-bottom:1px solid #F5F5F5;">
	                        <a href="#"><p>订单详情</p></a>
							<a href="#"><p>评价订单</p></a>
							</td>
		                </tr>
		            </table>  
				</div>
				</c:forEach>
				</form>
				
				
				<div style="height:40px;width:700px;text-align:right;padding-top:5px;margin-top:15px;">
				    <span>总页数</span><span style="margin-right:10px;color:red;margin-left:10px;">${pages.totalpage}</span>
				    <c:if test="${pages.pageNo>1}">
				    <a href="orderItem.do?pageNo=${pages.pageNo-1}" style="line-height:40px;">上一页</a>
				    </c:if>
				    <c:if test="${pages.pageNo==1}">
				    <span style="line-height:40px;">上一页</span>
				    </c:if>
					<span style="margin-left:10px;margin-right:10px;color:red;">${pages.pageNo}</span>
					<c:if test="${pages.pageNo<pages.totalpage}">
				    <a href="orderItem.do?pageNo=${pages.pageNo+1}" style="line-height:40px;">下一页</a>
				    </c:if>
				    <c:if test="${pages.pageNo==pages.totalpage}">
				     <span style="line-height:40px;">下一页</span>
				    </c:if>
				</div>
			</div>
		</div>	
	</div>
	<!--footer-->
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