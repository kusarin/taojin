<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./TaoJin/css/bootstrap.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./TaoJin/css/style.css" rel="stylesheet">
<link href="./TaoJin/css/flexslider.css" type="text/css" media="screen"
	rel="stylesheet" />
<link href="./TaoJin/css/jquery.fancybox.css" rel="stylesheet">
<link href="./TaoJin/css/cloud-zoom.css" rel="stylesheet">
<style>
.itemimage {
	width: 150px;
	height: 100px;
	float: left;
}
</style>

<!-- 弹窗设置点 -->
<script type="text/javascript">
	window.onload = function() {
		var error = "${requestScope.error}";
		if (error != "" && error != null && typeof (error) != "undefined") {
			alert(error);
		}
	}
</script>
<!-- 缺少部分：图片上传+获取店铺ID -->

<title>商品管理</title>
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
								<input type="text" name="str"
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
		<section id="product">
		<div class="container">
			<!--  breadcrumb -->
			<ul class="breadcrumb">
				<li><a href="#">Home</a> <span class="divider">/</span></li>
				<li class="active">Blog</li>
			</ul>
			<div class="row">
				<!-- Sidebar Start-->
				<aside class="span3">
				<div class="sidewidt">
					<h2 class="heading2">
						<span>店铺管理</span>
					</h2>
					<ul class="nav nav-list categories">
						<li><a href="blog.html">认证店铺 </a></li>
						<li><a href="查看记录.html">查看记录 </a></li>
						<li><a href="addItem.jsp">商品上架 </a></li>
						<li><a href="shopItem.do">商品管理</a></li>
						<li><a href="店铺基本信息.html">店铺信息管理</a></li>
					</ul>
				</div>

				</aside>
				<!-- Sidebar End-->
				<div class="span9">
					<!-- Blog start-->
					<section id="latestblog">
					<div class="blogdetail">
						<h2 class="heading2">
							<span>商品管理</span>
						</h2>
						<ul class="margin-none">
							<li class="listblcok">
								<div class="mb20">
									<section class="leavecomment">
									<div align="center">

										<tbody>
											<tr align="middle">
												<table width="90%" border="1" align="center">
													<thead>
														<tr>
															<td colspan="10" align="center">在售商品</td>
														</tr>
													</thead>
													<tbody>

														<tr align="center">
															<td>商品图片</td>
															<td>商品名称</td>
															<td>商品数量</td>
															<td>商品价格</td>
															<td>商品状态</td>
															<td>商品管理操作</td>
														</tr>
														<c:forEach items="${shopItem}" var="i">

															<tr>
																<td><img class="itemimage"
																	src=${pageContext.request.contextPath}${i.image}></td>
																<td>${i.name}</td>
																<td>${i.number}</td>
																<td>${i.price}</td>
																<td>在售</td>
																<td><a href="showchangeItem.do?id=${i.item_id}">修改商品信息</a>
																	<a href="updownItem.do?id=${i.item_id}">下架商品</a>
															</tr>
														</c:forEach>
														<c:forEach items="${shopItem2}" var="m">
															<tr>
																<td><img class="itemimage"
																	src=${pageContext.request.contextPath}${m.image}></td>
																<td>${m.name}</td>
																<td>${m.number}</td>
																<td>${m.price}</td>
																<td>已下架</td>
																<td><a href="showchangeItem.do?id=${m.item_id}">修改商品信息</a>
																	<a href="updownItem.do?id=${m.item_id}">上架商品</a>
															</tr>

														</c:forEach>

													</tbody>
												</table>
												</form>
									</div>
									</section>
								</div>
							</li>
						</ul>
					</div>
					</section>
				</div>
			</div>
		</div>
		</section>
	</div>

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
		<span>©2017 版权所有</span> <span>鄂ICP备14003265号-2</span>
	</div>
	</footer>
</body>
</html>