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
						<form action="searchItem.do?page=1" method="post">
							<div style="margin-top: 10px;">
								<input type="text" name="str" class="input-medium search-query"
									placeholder="搜索你想要的二手"
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
						<c:if test="${shop.shop_id==null }"><li><a href="addShop.jsp">认证店铺 </a></li></c:if>
						<li><a href="shopList.do">查看记录 </a></li>
						<li><a href="addItem.jsp">商品上架 </a></li>
						<li><a href="shopItem.do?page=1">商品管理</a></li>
						<li><a href="toChange.do">店铺信息管理</a></li>
						<li><a href="waittingDeGoods.do?shop_id=${shop.shop_id}&flag=0">订单管理</a>
						<ul><a href="alreadyReGoods.do?shop_id=${shop.shop_id}&flag=1">已处理</a></ul>
						<ul><a href="waittingDeGoods.do?shop_id=${shop.shop_id}&flag=0">未处理</a></ul></li>
					</ul>
				</div>
				<div class="sidewidt"></div>

				</aside>
				<!-- Sidebar End-->
				<div class="span9">
					<!-- Blog start-->
					<section id="latestblog">
					<div class="blogdetail">
						<h2 class="heading2">
							<span>修改店铺基本信息</span>
						</h2>
						<div class="blogicons">
							<div class="pull-left"></div>
						</div>
						<ul class="margin-none">
							<li class="listblcok">
								<div class="mb20">
									<section class="leavecomment">
									<h2 class="heading2">
										<span>店铺基本信息</span>
									</h2>
									<h1 align="center">店铺信息修改</h1>
									<div align="center">
										<form id="myform" action="doChange.do?id=${shop.shop_id}" enctype="multipart/form-data" method="post">
											<table>
											
												<input type="hidden" value="${shop.shop_id}" name="Shop_id" />
												<tr>
													<div class="control-group">
													<td>name</td>
													<div class="controls">
													<td><input type="text" name="name"
														value="${shop.name }" id="name"></td>
													</div>
													</div>
												</tr>
												<tr>
													<div class="control-group">
													<td>type</td>
													<div class="controls">
													<td><input type="text" name="type"
														value="${shop.type}" id="type"></td>
													</div>
													</div>
												</tr>
												<tr>
													<div class="control-group">
													<td>intro</td>
													<div class="controls">
													<td><input type="text" name="intro"
														value="${shop.intro}" id="intro"></td>
													</div>
													</div>
													</tr>
													<tr>
													<div class="control-group">
														<td>店铺图片:</td>
														<div class="controls">
															<td><p>注意：上传的图片名中不能包含中文</p></td>
														</div>
													</div>
												</tr>
												<tr>
													<div class="control-group">
														<td></td>
														<div class="controls">
															<td><input type="file" name="file" id="file" accept="image/*" /></td>
														</div>
													</div>
												</tr>
											</table>
											<input type="submit" value="修改" /> <input type="button"
												value="返回" onclick="javaScript:history.back(-1)" />
										</form>
									</div>
									<!-- 推荐部分-->
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