<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./TaoJin/css/bootstrap.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./TaoJin/css/style.css" rel="stylesheet">
<link href="./TaoJin/css/flexslider.css" type="text/css" media="screen" rel="stylesheet"  />
<link href="./TaoJin/css/jquery.fancybox.css" rel="stylesheet">
<link href="./TaoJin/css/cloud-zoom.css" rel="stylesheet">
<title>Insert title here</title>
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
									<span>您好,</span> <a href="login.jsp"><span
										style="color: white;">登录</span></a> <a href="register.jsp"> <span
										style="margin-left: 20px; color: white;">注册</span></a>
								</div>
								<div style="margin-left: 250px;">
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
						<form action="searchItem.do" method="post">
							<div style="margin-top: 10px;">
								<input input type="text" name="str"
									class="input-medium search-query" placeholder="搜索你想要的二手"
									style="height: 20px; width: 100; border: 4px solid #FFA07A">
								<input type="submit" value="搜索"
									style="height: 30px; width: 40; background-color: #FFA07A; border: 4px solid #FFA07A;">
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</header>
	<!-- Header End -->

	<div id="maincontainer">
<div class="flush">
        <form action="">
		<table style="border-left-width: 0px; border-collapse: collapse; border-right-width: 0px;"bordercolor="#ff6600" bgcolor="#DFFFDF" cellspacing="0" cellpadding="0" width="250" align="center" border="1">
		<thead>
		<tr><th style="text-align: center;">店铺名</th>
		</tr></thead>
		<c:forEach items="${search }" var="c">
		<tr id="${c.shop_id }">
		<td>${c.name }</td>
		</tr>
		</c:forEach>
		</table></form>
</div></div>
<!-- 推荐部分-->
	<section id="related" class="row">
		<div class="container">
			<h1 class="heading1">
				<a href="lookshopItem.do?shopid=${lookitem.shop_id}"><span
					class="maintext">同店铺商品</span></a><span class="subtext"> 走过路过错过</span>
			</h1>
			<ul class="thumbnails">
				<c:forEach items="${looklist}" var="i">
					<li class="span3"><a class="prdocutname"
						href="lookItem.do?id=${i.item_id}"
						style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 200px">${i.name}</a>
						<div class="thumbnail">
							<a href="lookItem.do?id=${i.item_id}"><img class="itemimage"
								src=${pageContext.request.contextPath}${i.image}></a>
							<div class="pricetag">
								<br>
								<div class="price">
									<div class="pricenew">
										<div class="price" style="float: left; margin-top: 20px">
											<p>¥${i.price}</p>
										</div>
									</div>
								</div>
							</div>
						</div></li>
				</c:forEach>
			</ul>
		</div>
	</section>
	<!--footer-->
	<footer style="margin-top:100px"> <img
		src="${pageContext.request.contextPath}/image/footer-tri.png"
		style="width: 100%;">
	<div
		style="margin: 0px 0px 10px; text-align: center; padding-top: 10px;">

		<span>友情链接/</span> <a href="http://www.nwpu.edu.cn/" target="_top"
			class="links">西北工业大学</a>

	</div>
	<div style="text-align: center; margin-bottom: 10px;">
		<a id="fd_footer" href="addComment.jsp">产品意见反馈</a>
	</div>
	<div style="text-align: center; margin-bottom: 10px;">
		<span>2017 版权所有</span> <span>鄂ICP备14003265号-2</span>
	</div>
	</footer>
</body>
</html>