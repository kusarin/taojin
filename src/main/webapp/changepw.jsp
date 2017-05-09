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
<title>二手淘金网--修改密码</title>
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
					<li class="active">个人中心</li>
				</ul>
				<div class="row">
					<!-- Sidebar Start-->
					<aside class="span3">
						<div class="sidewidt">
							<h2 class="heading2">
								<span>我的个人中心</span>
							</h2>
							<ul class="nav nav-list categories">
								<li><a href="UsersUpdate.jsp">修改个人信息 </a></li>
								<li><a href="changepw.jsp">更改密码</a></li>
								<li><a href="addressList.do">更改/添加我的地址</a></li>
								<li><a href="orderItem.do">我的订单 </a></li>
								<li><a href="shopList.do">店铺信息管理</a></li>
							</ul>
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
													<span>修改个人信息</span>
												</h2>
												<form action="changepw.do" method="post"
													class="form-horizontal commentform2" novalidate>
													<fieldset>
														<input type="hidden" name="user_ID"
															value="${user.user_ID}" /><input type="hidden"
															name="username" value="${user.username}" /><input
															type="hidden" name="tele" value="${user.tele}" /> <input
															type="hidden" name="email" value="${user.email}" /> <input
															type="hidden" name="ID" value="${user.ID}" /><input
															type="hidden" name="picture" value="${user.picture}" /><input
															type="hidden" name="name" value="${user.name}" /> <input
															type="hidden" name="idPhoto" value="${user.idPhoto}" />
														<div class="control-group">
															<label class="control-label">原密码 </label>
															<div class="controls">
																<input type="password" id="fwpw" />
															</div>
														</div>
														<div class="control-group">
															<label class="control-label">新密码</label>
															<div class="controls">
																<input type="password" name="password" id="pw1" />
															</div>
														</div>
														<div class="control-group">
															<label class="control-label">请重复输入新密码</label>
															<div class="controls">
																<input type="password" id="pw2" />
															</div>
														</div>
														<div class="control-group">

															<div class="controls"></div>
														</div>
														<div class="controls">
															<input type="submit" id="submit_id" value="确认提交"
																class="btn btn-orange" onclick="return check()">
															<input type="reset" value="重新输入" class="btn">
														</div>
														<script>
															function check() {
																var fwpw = document
																		.getElementById("fwpw").value;
																var pw1 = document
																		.getElementById("pw1").value;
																var pw2 = document
																		.getElementById("pw2").value;
																if (fwpw == null
																		|| pw1 == null
																		|| pw2 == null
																		|| fwpw == ''
																		|| pw1 == ''
																		|| pw2 == '') {
																	alert("请将信息完善后再进行提交");
																	return false;
																} else if (fwpw != "${user.password}") {
																	alert("原密码错误");
																	return false;
																} else if (pw1 != pw2) {
																	alert("两次密码不同，请重新输入");
																	return false;
																} else if (fwpw == pw2) {
																	alert("新密码与原密码相同");
																	return false;
																}
																alert("修改完成");
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