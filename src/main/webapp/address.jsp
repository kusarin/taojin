<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
	window.onload = function() {
		var error = "${requestScope.error}";
		if (error != "" && error != null && typeof (error) != "undefined") {
			alert(error);
		}
	}
</script>
<script type="text/javascript">
	function deleteone(addressid){
		if(confirm("确定要删除这条数据吗？")){
			window.location.href="deleteAddress.do?addressid="+addressid;
		}
	}
</script>
<title>二手淘金网--信息更改</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./TaoJin/css/bootstrap.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./TaoJin/css/style.css" rel="stylesheet">
<link href="./TaoJin/css/flexslider.css" type="text/css" media="screen"
	rel="stylesheet" />
<link href="./TaoJin/css/jquery.fancybox.css" rel="stylesheet">
<link href="./TaoJin/css/cloud-zoom.css" rel="stylesheet">
<!-- fav -->
<link rel="shortcut icon" href="assets/ico/favicon.html">
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
					<li><a href="Itemlist.do">主页</a> <span class="divider">/</span></li>
					<li class="active">收货地址</li>
				</ul>
				<div class="row">
					<!-- Sidebar Start-->
					<aside class="span3">
						<div class="sidewidt">
							<h2 class="heading2">
								<span>我的个人中心</span>
							</h2>
							<ul class="nav nav-list categories">
								<li><a href="category.html">我的帐户信息 </a>
									<ul>
										<li><a href="UsersUpdate.jsp">修改个人信息 </a></li>
										<li><a href="changepw.jsp">更改密码</a></li>
										<li><a href="address.jsp">更改/添加我的地址</a></li>
									</ul> <a href="category.html">我的订单 </a>
									<ul>
										<li><a href="product.html">查看历史订单</a></li>
										<li><a href="product.html">待付款</a></li>
										<li><a href="product.html">待发货</a></li>
										<li><a href="product.html">待收货</a></li>
										<li><a href="product.html">待评价</a></li>
										<li><a href="product.html">退款/售后</a></li>
									</ul></li>
								<li><a href="category.html">商品信息管理</a></li>

								<li><a href="category.html">店铺信息管理</a></li>
							</ul>
						</div>
						<div class="sidewidt"></div>
					</aside>
					<!-- Sidebar End-->

					<div class="span9">
						<!-- Blog start-->
						<section id="latestblog">
							<div class="blogdetail">
								<div class="blogicons">
									<div class="pull-left"></div>
								</div>
								<ul class="margin-none">
									<li class="listblcok">
										<div class="mb20">
											<section class="leavecomment">
												<h2 class="heading2">
													<span>我的收货地址</span>
												</h2>
												<form action="addressList.do" method="post"
													class="form-horizontal commentform2" novalidate>
													<fieldset>
														<table width="90%" border="1" align="center">
															<thead>
																<tr>
																	<td colspan="10" align="center">收货地址</td>
																</tr>
															</thead>
															<tbody>
																<c:forEach items="${addressList}" var="i">
																	<tr>
																		<td>${i.addr}</td>
																		<td><a onclick="deleteone(${i.addressid})"
																			href="javascript:void(0)">删除</a></td>
																		<td><a
																			href="toupdateAddress.do?addressid=${i.addressid}">修改</a></td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>
													</fieldset>
												</form>
											</section>
										</div>
										<div class="mb20">
											<section class="leavecomment">
												<h2 class="heading2">
													<span>添加收货地址</span>
												</h2>
												<form action="addAddress.do" method="post"
													class="form-horizontal commentform2" novalidate>
													<fieldset>
														<input type="hidden" name="user_ID"
															value="${user.user_ID}" />
														<div class="control-group">
															<label class="control-label">输入要添加的新地址： </label>
															<div class="controls">
																<input type="text" style="width: 500px" name="addr"
																	id="addr" />
															</div>
														</div>
														<div class="controls">
															<input type="submit" id="submit_id" value="添加新地址"
																class="btn btn-orange" onclick="return check()">
														</div>
														<script>
															function check() {
																var addr = document
																		.getElementById("addr").value;
																if (addr == null
																		|| addr == '') {
																	alert("新添加地址不能为空");
																	return false;
																	}
																}
														</script>
													</fieldset>
												</form>
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
	<footer style="margin-top: 100px">
		<img src="${pageContext.request.contextPath}/image/footer-tri.png"
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
			<span>?2017 版权所有</span>
		</div>
	</footer>
	<!-- javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/respond.min.js"></script>
	<script src="js/application.js"></script>
	<script src="js/bootstrap-tooltip.js"></script>
	<script defer src="js/jquery.fancybox.js"></script>
	<script defer src="js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="js/jquery.tweet.js"></script>
	<script src="js/cloud-zoom.1.0.2.js"></script>
	<script type="text/javascript" src="js/jquery.validate.js"></script>
	<script type="text/javascript"
		src="js/jquery.carouFredSel-6.1.0-packed.js"></script>
	<script type="text/javascript" src="js/jquery.mousewheel.min.js"></script>
	<script type="text/javascript" src="js/jquery.touchSwipe.min.js"></script>
	<script type="text/javascript"
		src="js/jquery.ba-throttle-debounce.min.js"></script>
	<script defer src="js/custom.js"></script>
</body>
</html>