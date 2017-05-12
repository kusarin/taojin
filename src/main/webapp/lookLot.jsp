<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="refresh" content="20">
<meta charset="utf-8">
<title>${lookLot.name}</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="./TaoJin/css/bootstrap.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./TaoJin/css/style.css" rel="stylesheet">
<link href="./TaoJin/css/flexslider.css" type="text/css" media="screen"
	rel="stylesheet" />
<link href="./TaoJin/css/jquery.fancybox.css" rel="stylesheet">
<link href="./TaoJin/css/cloud-zoom.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<!-- fav -->
<link rel="shortcut icon" href="assets/ico/favicon.html">
<style>
.itemimage {
	width: 275px;
	height: 150px;
	float: left;
}

.price {
	float: left;
	color: red;
}

.textshop {
	font-size: 18px;
	color: orange;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.mn.js"></script>
<script>
	function minus() {
		var num = document.getElementById("mp");
		var value = parseInt(num.value);
		var total = document.getElementById("total");
		var itemprice = document.getElementById("itemprice");
		var unitPrice = document.getElementById("unitPrice");
		var actulpayment = document.getElementById("actulpayment");
		var ac = document.getElementById("ac");
		if (value > 1) {
			num.value = value - 1;
			total.innerHTML = num.value;
			itemprice.innerHTML = "" + parseFloat(unitPrice.value)
					* parseInt(num.value);
			actulpayment.innerHTML = itemprice.innerHTML;
			ac.innerHTML = actulpayment.innerHTML;
		}
	}
</script>
<!-- 弹窗设置点 -->
<script type="text/javascript">
	window.onload = function() {
		var error = "${requestScope.error}";
		if (error != "" && error != null && typeof (error) != "undefined") {
			alert(error);
		}

	}

	function setTab(name, m, n) {
		for (var i = 1; i <= n; i++) {
			var menu = document.getElementById(name + i);
			var showDiv = document.getElementById("cont_" + name + "_" + i);
			menu.className = i == m ? "on" : "";
			showDiv.style.display = i == m ? "block" : "none";
		}
	}
</script>
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
							<form action="searchLot.do?page=1" method="post">
								<div style="margin-top: 10px;">
									<input input type="text" name="str"
										class="input-medium search-query" placeholder="搜索想要的二手拍卖品"
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
				<!-- Product Details-->
				<div class="row">
					<!-- Left Image-->
					<div class="span5">
						<tr>
							<br>
							<td><img
								src=${pageContext.request.contextPath}${lookLot.image}></td>
						</tr>

					</div>

					<!-- 右侧-->
					<div class="span7">
						<div class="row">
							<div class="span7">
								<h1 class="productname">
									<span class="bgnone">拍卖品：${lookLot.name}</span>
								</h1>
								<div class="productprice">
									<font size=4>${timeLast}</font>
								</div>
								<br>
								<div class="productprice">
									<font size=4>拍卖品起拍价:¥${lookLot.startprice}</font>
								</div>
								<br>
								<div class="productprice">
									<font size=4>拍卖品一口价:¥${lookLot.maxprice}</font>
								</div>
								<br>
								<div class="productprice">
									<font size=4>拍卖品当前价格:¥${lookLot.nowprice}</font>
								</div>
								<br>
								<div class="productprice">
									<font size=4>当前出价人:${us.username}</font> <br>
								</div>
								<br>
								<div class="productprice">
									<font size=4>拍卖品介绍:${lookLot.detail}</font> <br>
								</div>
								<br>
							</div>

							<!-- 出价区域 -->
							<form action="auction.do?id=${lookLot.lot_id}" method="post">
								
								<div style="margin-top: 10px; margin-left: 30px;">
									<input type="text" name="yourprice"
										onkeyup="value=value.replace(/[^\d.]/g,'')"
										class="input-medium search-query" placeholder="输入你的价格"
										style="height: 20px; width: 100; border: 4px solid #FFA07A">
									<input type="submit" value="出价"
										style="height: 30px; width: 40; background-color: #FFA07A; border: 4px solid #FFA07A;">
								</div>
								<div class="receiver">
									<div class="info">
										<br>&nbsp<strong>收货地址预选</strong>
									</div>
									<div class="receiverInfo" id="receive">
										<c:forEach items="${address}" var="adr">
											<input type="radio" name="addr" value="${adr.addr}"
												onclick="checadr()">
											<sapn>&nbsp ${adr.addr}</sapn>
											<br>
										</c:forEach>
									</div>
								</div>
							</form>
							<!-- 出价区域 end-->

							<div class="span7">
								<ul class="productpagecart">
									<li><a class="cart" href="sureLot.do?lot_id=${lookLot.lot_id}">一口价购买</a></li>
								</ul>
							</div>
						</div>
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
			<span>©2017 版权所有</span> <span>鄂ICP备14003265号-2</span>
		</div>
	</footer>
</body>
</html>
