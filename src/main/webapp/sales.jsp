<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/bootstrap-responsive.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/flexslider.css"
	type="text/css" media="screen" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/jquery.fancybox.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/cloud-zoom.css"
	rel="stylesheet">
<title>管理员界面</title>
<style>
.item {
	width: 300px;
	text-align: center;
	height: 45px;
}

.co {
	width: 80px;
	text-align: center;
	height: 45px;
}

.orderNumber {
	width: 300px;
	text-align: center;
	height: 45px;
}

.buyer1 {
	width: 80px;
	text-align: center;
	height: 45px;
}

.buyer {
	width: 80px;
	text-align: center;
	height: 45px;
}

.buyer1 a p {
	width: 80px;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}

.huanhang {
	width: 300px;
	height: 120px;
}

.huanhang img {
	width: 100px;
	height: 120px;
}

.huanhang p {
	word-break: break-all;
	width: 200px;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}

.sa {
	width: 80px;
	height: 120px;
	text-align: center;
}

a:hover {
	text-decoration: underline;
	color: red;
}
</style>
<script>
	function s() {
		if (document.getElementById("uu").style.display == "block") {

			document.getElementById("uu").style.display = "none";

		}

		else {
			document.getElementById("uu").style.display = "block";
		}
	}
	function mouseUp(x) {
		document.getElementById('a' + x).style.color = "red";
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
									<span><h3>二手淘金交易网——管理员界面</h3></span>
								</div>
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
	
			<div class="container">
				<!--  breadcrumb -->
				<ul class="breadcrumb">
					<li>管理员界面 <span class="divider">/</span></li>
					<li class="active">账号相关</li>
				</ul>
				<div style="float:left;">
				<div class="row">
					<!-- Sidebar Start-->
					<aside class="span3">
						<div class="sidewidt">
							<h2 class="heading2">
								<span>管理员功能</span>
							</h2>
						<ul class="nav nav-list categories">
							<li><a class="managerInterface" href="managerInterface.jsp">管理员账户管理</a></li>
								<li><a class="SRmanage" href="./lookSR.do?page=1">店铺认证管理</a></li>
								<li><a class="userManage" href="./userManage.do?page=1">用户信息管理</a></li>
								<li><a class="shopManage" href="./shopManage.do?page=1">店铺信息管理</a></li>
								<li><a class="itemManage" href="./itemManage.do?page=1">商品信息管理</a></li>
								<li><a class="comment" href="./lookComment.do?page=1">用户留言管理</a></li>
								<li><a class="RFmanage" href="./findResourceFile.do?page=1">文件资源管理</a></li>
							    <li style="margin-top: 10px;color:red;cursor:pointer;"onclick="s()">销售分类排行榜</li>
								<div id="uu" style="display: none;">
									<ul>

										<li><a href="getSalesRanking.do?typeh=动漫"
											style="text-decoration: none; color: black;"
											onmouseup="mouseUp(1)" id="a1">动漫</a></li>
										<li><a href="getSalesRanking.do?typeh=游戏"
											style="text-decoration: none; color: black;"
											onmouseup="mouseUp(2)" id="a2">游戏</a></li>
										<li><a href="getSalesRanking.do?typeh=乐器"
											style="text-decoration: none; color: black;"
											onmouseup="mouseUp(3)" id="a3">乐器</a></li>
										<li><a href="getSalesRanking.do?typeh=数码用品"
											style="text-decoration: none; color: black;"
											onmouseup="mouseUp(4)" id="a4">数码用品</a></li>
										<li><a href="getSalesRanking.do?typeh=电脑"
											style="text-decoration: none; color: black;"
											onmouseup="mouseUp(5)" id="a5">电脑</a></li>
										<li><a href="getSalesRanking.do?typeh=运动"
											style="text-decoration: none; color: black;"
											onmouseup="mouseUp(6)" id="a6">运动</a></li>
										<li><a href="getSalesRanking.do?typeh=户外健身"
											style="text-decoration: none; color: black;"
											onmouseup="mouseUp(7)" id="a7">户外健身</a></li>
										<li><a href="getSalesRanking.do?typeh=学习"
											style="text-decoration: none; color: black;"
											onmouseup="mouseUp(8)" id="a8">学习</a></li>
										<li><a href="getSalesRanking.do?typeh=服装"
											style="text-decoration: none; color: black;"
											onmouseup="mouseUp(9)" id="a9">服装</a></li>
										<li><a href="getSalesRanking.do?typeh=其他商品"
											style="text-decoration: none; color: black;"
											onmouseup="mouseUp(10)" id="a10">其他商品</a></li>
									</ul>
								</div>

						</ul>
					</div>
				</aside>
			</div>
			</div>
			<!-- Sidebar End-->
			<div class="span9" style="float: left; margin-top: 20px;">
			   <div style="height: auto; width: 900px;">
				<table
					style="height: auto; width: 900px; font-size: 14px; color: black; border-color: #F5F5F5;"
					border="1px">
					<tr align="center" style="background-color: #FAFFF0;">
						<td style="border-color: #F5F5F5; height: 40px; width: 100px;">排行</td>
						<td style="border-color: #F5F5F5; width: 200px;">商品名称</td>
						<td style="border-color: #F5F5F5; width: 100px;">商品交易额</td>

					</tr>
					<c:forEach items="${sales}" var="ss">
						<tr align="center">
							<td style="border-color: #F5F5F5; height: 35px;">${ss.ranking}</td>
							<td style="border-color: #F5F5F5;">${ss.itemName}</td>
							<td style="border-color: #F5F5F5;">${ss.salesAmount}</td>

						</tr>
					</c:forEach>
				</table>
				</div>
			</div>
		</div>
	</div>
	<!--footer-->
	<footer style="margin-top: 20px">
		<img src="${pageContext.request.contextPath}/image/footer-tri.png"
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