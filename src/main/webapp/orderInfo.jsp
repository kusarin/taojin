<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
 <title>订单详情</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
 
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sureOrder.css"/>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/flexslider.css" type="text/css" media="screen" rel="stylesheet"  />
<link href="${pageContext.request.contextPath}/css/jquery.fancybox.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/cloud-zoom.css" rel="stylesheet">

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
							<div style="float: left; color: white; margin-top: 26px;">
										<span>您好,</span>
										<c:if test="${user == null}">
											<a href="login.jsp"><span style="color: white;">登录</span></a>
											<a href="register.jsp"> <span
												style="margin-left: 20px; color: white;"> 注册</span></a>
										</c:if>
										<c:if test="${user != null}">
											<c:out value="${user.username}" />
											<a href="logout.do"><span style="color: white;">
													注销</span></a>
										</c:if>
							</div>
							  <div style="margin-left:250px;">
								<ul class="nav">
								    <li><a class="home active" href="Itemlist.do">首页</a></li>
								    <li><a class="myaccount" href="UsersUpdate.jsp">个人中心</a></li>
									<li><a class="checkout" href="shopList.do">我的店铺</a></li>
									<li><a class="shoppingcart" href="showCartAllItem.do">购物车</a></li>
									<li><a class="checkout" href="orderItem.do">我的订单</a></li>
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
	
    <div class="containers" style="margin:0 auto;margin-top:20px;">
	 
	  <div  style="color:gray;font-size:15px;margin:0 auto;width:700px;">
	      <strong>订单信息</strong>
	   </div>
	   <div style="margin:0 auto;width:700px;margin-top:10px;margin-bottom:50px;">
	    <table style="margin:0 auto;border-color:#FAFFF0; " border="1">
		
		 <tr>
		    <td style="width:200px;text-align:center;height:30px;border-color:#FAFFF0;">订单编号</td>
			<td style="width:500px;text-align:center;border-color:#FAFFF0;">${order.orderNumber}</td>
		</tr>
		<tr>
		    <td style="text-align:center;height:30px;border-color:#FAFFF0;">支付方式</td>
			<td style="text-align:center;border-color:#FAFFF0;">${order.paymentMethod}</td>
		</tr>
		<tr>
		    <td style="text-align:center;height:30px;border-color:#FAFFF0;">订单状态</td>
			<td style="text-align:center;border-color:#FAFFF0;">${order.status}</td>
		</tr>
		<c:if test="${order.status=='已取消'}">
		<tr>
		    <td style="text-align:center;height:30px;border-color:#FAFFF0;">取消时间</td>
			<td style="text-align:center;border-color:#FAFFF0">${order.removeOrderTime}</td>
		</tr>
		</c:if>
		<tr>
		    <td style="text-align:center;height:30px;border-color:#FAFFF0;">下单时间</td>
			<td style="text-align:center;border-color:#FAFFF0">${order.orderTime}</td>
		</tr>
		
		</table>
	  
	   </div>
	   
	   <div  style="color:gray;font-size:15px;margin:0 auto;width:700px;">
	      <strong>收货人信息</strong>
	   </div>
	   <div style="margin:0 auto;width:700px;margin-top:10px;margin-bottom:50px;">
	    <table style="margin:0 auto;border-color:#FAFFF0; " border="1">
		
		 <tr>
		    <td style="width:200px;text-align:center;height:30px;border-color:#FAFFF0;">收货人姓名</td>
			<td style="width:500px;text-align:center;border-color:#FAFFF0;">${username}</td>
		</tr>
		<tr>
		    <td style="text-align:center;height:30px;border-color:#FAFFF0;">收货地址</td>
			<td style="text-align:center;border-color:#FAFFF0;">${order.recivingAddress}</td>
		</tr>
		</table>
	  
	   </div>
	   
	   
	    <div  style="color:gray;font-size:15px;margin:0 auto;width:700px;">
	      <strong>结算信息</strong>
	   </div>
	   <div style="margin:0 auto;width:700px;margin-top:10px;margin-bottom:50px;">
	    <table style="margin:0 auto;border-color:#FAFFF0; " border="1">
		
		 <tr>
		    <td style="width:200px;text-align:center;height:30px;border-color:#FAFFF0;">商品金额</td>
			<td style="width:500px;text-align:center;border-color:#FAFFF0;">￥${order.actulPayment}</td>
		</tr>
		</table>
	  
	   </div>
	  
	   </div>
    </div> 
	
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