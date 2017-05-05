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
<title>已取消订单记录</title>
<style>
.item{
    width:300px;
	text-align:center;
	height:45px;
 }
.co{
    width:100px;
	text-align:center;
	height:45px;
	
 }
.huanhang{
    width:300px;
	height:120px;	
}
.huanhang img{
   width:60px;
   height:80px;
   float:left;
   margin-left:20px;
}
.sa{
    width:100px;
	height:120px;
	text-align:center;
}
a:hover{
	text-decoration:underline;
	color:red;
}
</style>
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
											<img style="width: 20px; length: 20px"
												src="${pageContext.request.contextPath}${user.picture}">
											<c:out value="${user.username}" />
											<a href="logout.do"><span style="color: white;">
													注销</span></a>
										</c:if>
									</div>
								<div style="margin-left: 250px;">
									<ul class="nav">
										<li><a class="home active" href="Itemlist.do?page=1">首页</a></li>
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
						<form class="form-search top-search" action="searchItem.do?page=1" method="post">
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
						<li><a href="orderItem.do">我的订单</a></li>
						<li><a href="pendingPayment.do">待付款
						<c:if test="${pendingPayment!=0}">
						<sup style="color:red;font-size:12px;">${pendingPayment}</sup>
						</c:if>
						</a></li>
						<li><a href="payedGoods.do">已付款
						<c:if test="${Payment!=0}">
						<sup style="color:red;font-size:12px;">${Payment}</sup>
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
				 <strong>已取消订单记录</strong>	
				</div> 
				<div style="height:auto;width:700px;">
				<table style="height:auto;width:700px; font-size:14px;">
				    <tr style="background-color:#F5F5F5;height:auto;width:700px;">
					    <td class="co">订单编号</td>
						<td class="item">商品</td>
						<td class="co">取消时间</td>
						<td class="co">支付</td>
						<td class="co">退款状态</td>
					</tr>
				</table>
				</div>
				
				<form action="orderItem.do" method="post" name="myform">
				<c:forEach items="${pages.datas}" var="orderc">
				<div style="height:auto;width:700px;border-left:1px solid #F5F5F5;border-right:1px solid #F5F5F5;border-bottom:1px solid #F5F5F5;">
				    <table  style="font-size:12px;height:auto;width:700px;color:black;">
						<tr> 
						<td class="sa" style="border-right:1px solid #F5F5F5;">${orderc.order.orderNumber}</td>
						
	                     <td class="huanhang" style="border-right:1px solid #F5F5F5;">
	                     <c:forEach items="${orderc.orderDeatail}" var="ord">
	                     <a href="#"><img src="${pageContext.request.contextPath}${ord.item.image}"/></a> 
	                     </c:forEach>
	                     </td>
		                    <td class="sa" style="border-right:1px solid #F5F5F5;">${orderc.order.removeOrderTime}</td>
		                    <td class="sa" style="border-right:1px solid #F5F5F5;">${orderc.order.actulPayment}</td>
		                    <td class="sa">已完成</td>
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