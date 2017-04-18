<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 弹窗设置点 -->
<script type="text/javascript">
	window.onload = function() {
		var error = "${requestScope.error}";
		if (error != "" && error != null && typeof (error) != "undefined") {
			alert(error);
		}
	}
</script>
<title>商品列表</title>
<link href="./TaoJin/css/bootstrap.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./TaoJin/css/style.css" rel="stylesheet">
<link href="./TaoJin/css/flexslider.css" type="text/css" media="screen"
	rel="stylesheet" />
<link href="./TaoJin/css/jquery.fancybox.css" rel="stylesheet">
<link href="./TaoJin/css/cloud-zoom.css" rel="stylesheet">
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
									<span>您好,</span> <a href="#"><span style="color: white;">登录</span></a>
									<a href="#"> <span style="margin-left: 20px; color: white;">注册</span></a>
								</div>
								<div style="margin-left: 250px;">
									<ul class="nav">
										<li><a class="home active" href="Itemlist.do">首页</a></li>
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
						<form action="searchItem.do" method="post">
							<input input type="text" name="str"
								style="width: auto; border: 4px solid #FFA07A"><input
								type="submit" value="搜索"
								style="height: 40px; width: auto; background-color: #FFA07A; border: 4px solid #FFA07A;">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</header>
	<!-- Header End -->
	
	<c:forEach items="${itemlist}" var="i">
		<li class="span4">
			<div class="thumbnail">
			<a class="prdocutname" href="lookItem.do?id=${i.item_id}">${i.name}</a>
				<span class="sale tooltip-test">Sale</span> <a href="lookItem.do?id=${i.item_id}">
				<p>><img src=${pageContext.request.contextPath}${i.image}></p></a>
			</div> 
			<div class="pricetag">
			<a href="lookItem.do?id=${i.item_id}">${i.detail}</a>
				<div class="price">
					<div class="pricenew">
						<a href="lookItem.do?id=${i.item_id}">${i.price}</a>
					</div>
				</div>
			</div>
		</li>
	</c:forEach>

	<!--footer-->
	<footer style="margin-top:20px"> <img
		src="${pageContext.request.contextPath}/image/footer-tri.png"
		style="width: 100%;">
	<div
		style="margin: 0px 0px 10px; text-align: center; padding-top: 10px;">

		<span>友情链接/</span> <a href="http://www.nwpu.edu.cn/" target="_top"
			class="links">西北工业大学</a>

	</div>
	<div style="text-align: center; margin-bottom: 10px;">
		<a id="fd_footer" href="javascript:;">产品意见反馈</a> <a
			href="http://www.2shoujie.com/joinUs" target="_top">加入我们</a>
	</div>
	<div style="text-align: center; margin-bottom: 10px;">
		<span>©2017 版权所有</span> <span>鄂ICP备14003265号-2</span>
	</div>
	</footer>
</body>
</html>