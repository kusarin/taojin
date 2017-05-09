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
<title>二手淘金网--用户登录</title>
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
					<li><a href="Itemlist.do?page=1">主页</a> <span class="divider">/</span></li>
					<li class="active">登录</li>
				</ul>
				<!-- Account Login-->
				<div class="row">
					<div class="span9">
						<h1 class="heading1">
							<span class="maintext">用户登录</span><span class="subtext">马上登录账户，享受二手淘金的乐趣！</span>
						</h1>
						<section class="newcustomer">
							<h2 class="heading2">新用户</h2>
							<div class="loginbox">
								<h4 class="heading4">
									注册新账户后就可以进行二手淘金了<br> <br> <a href="register.jsp"
										class="btn btn-orange">注册新账户</a>
								</h4>
							</div>
						</section>
						<section class="returncustomer">
							<h2 class="heading2">用户登录</h2>
							<div class="loginbox">
								<form action="login.do" method="post">
									<table>
										<tr>
											<td>用户名：</td>
											<td><input type="text" name="username" /></td>
										</tr>
										<tr>
											<td>密码：</td>
											<td><input type="password" name="password" /></td>
										</tr>
										<tr>
											<td colspan="2"><input type="submit"
												class="btn btn-orange" value="登录" /></td>
										</tr>
									</table>
								</form>
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

</body>
</html>