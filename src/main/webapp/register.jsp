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
<title>二手淘金网--用户注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./TaoJin/css/bootstrap.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./TaoJin/css/style.css" rel="stylesheet">
<link href="./TaoJin/css/flexslider.css" type="text/css" media="screen"
	rel="stylesheet" />
<link href="./TaoJin/css/jquery.fancybox.css" rel="stylesheet">
<link href="./TaoJin/css/cloud-zoom.css" rel="stylesheet">
<link href="./css/shopSearch.css" rel="stylesheet">
<script type="text/javascript">
	function setTab(name, m, n) {
		for (var i = 1; i <= n; i++) {
			var menu = document.getElementById(name + i);
			var showDiv = document.getElementById("cont_" + name + "_" + i);
			menu.className = i == m ? "on" : "";
			showDiv.style.display = i == m ? "block" : "none";
		}
	}
</script>
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
											<li><a class="myaccount" href="UsersUpdate.do">个人中心</a></li>
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
							<div class="tab">
								<ul>
									<li id="tow1" class="on" onclick='setTab("tow",1,3)'>商品</li>
									<li id="tow2" onclick='setTab("tow",2,3)'>店铺</li>
								</ul>
							</div>
							<div class="tabList">
								<div id="cont_tow_1" class="one block">
									<form action="searchItem.do?page=1" method="post">
										<div style="margin-top: 10px;">
											<input type="text" name="str"
												class="input-medium search-query" placeholder="搜索你想要的二手"
												style="height: 20px; width: 100; border: 4px solid #FFA07A">
											<input type="submit" value="搜索"
												style="height: 30px; width: 40; background-color: #FFA07A; border: 4px solid #FFA07A;">
										</div>
									</form>
								</div>
								<div id="cont_tow_2" class="one">
									<form action="searchShop.do?page=1" method="post">
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
			</div>
		</div>
	</header>
	<!-- Header End -->
	<div id="maincontainer">
		<section id="product">
			<form action="addUser.do" method="post" class="form-horizontal">
				<div class="container">
					<!--  breadcrumb -->
					<ul class="breadcrumb">
						<li><a href="Itemlist.do?page=1">主页</a> <span class="divider">/</span></li>
						<li class="active">注册</li>
					</ul>
					<div class="row">
						<!-- Register Account-->
						<div class="span9">
							<h1 class="heading1">
								<span class="maintext">注册新用户</span><span class="subtext"></span>
							</h1>
							<h3 class="heading3">个人信息</h3>
							<div class="registerbox">
								<fieldset>
									<div class="control-group">
										<input type="hidden" name="picture" value="/image/dislogo.jpg" />
										<label class="control-label"><span class="red">*</span>
											帐号:</label>
										<div class="controls">
											<input type="text" class="input-xlarge" name="username">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"> Email:</label>
										<div class="controls">
											<input type="text" class="input-xlarge" name="email">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"> 电话号码:</label>
										<div class="controls">
											<input type="text" class="input-xlarge" name="tele">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"> 真实姓名:</label>
										<div class="controls">
											<input type="text" class="input-xlarge" name="name">
										</div>
									</div>
								</fieldset>
							</div>
							<h3 class="heading3">密码</h3>
							<div class="registerbox">
								<fieldset>
									<h3 class="heading3"></h3>
									<div class="registerbox">
										<fieldset>
											<div class="control-group">
												<label class="control-label"><span class="red">*</span>
													密码:</label>
												<div class="controls">
													<input type="password" class="input-xlarge" name="password"
														id="pwd1">
												</div>
											</div>
											<div class="control-group">
												<label class="control-label"><span class="red">*</span>
													确认密码::</label>
												<div class="controls">
													<input type="password" class="input-xlarge" id="pwd2">
												</div>
											</div>
										</fieldset>
									</div>
									<script>
										function check() {
											var pwd1 = document
													.getElementById("pwd1").value;
											var pwd2 = document
													.getElementById("pwd2").value;
											if (pwd1 != pwd2) {
												alert("两次密码不同，请重新输入");
												return false;
											}
										}
									</script>
									<div class="pull-right">
										<label class="checkbox inline"> </label>
										请仔细确认所输入信息--------------- &nbsp; <input type="Submit"
											class="btn btn-orange" value="完成注册" id="register"
											onclick="return check()">
									</div>
								</fieldset>
							</div>
							<div class="clearfix"></div>
							<br>
						</div>
					</div>
				</div>
			</form>
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