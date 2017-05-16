<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理员界面</title>
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
		<section id="product">
			<div class="container">
				<!--  breadcrumb -->
				<ul class="breadcrumb">
					<li>管理员界面 <span class="divider">/</span></li>
					<li class="active">账号相关</li>
				</ul>
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
							    <li style="margin-top: 10px;cursor:pointer;"onclick="s()">销售分类排行榜</li>
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
										<div class="mb20" align="center">
											<section class="leavecomment">
												<h2 class="heading2">
													<span>欢迎你！管理员${manager.account}！</span>
												</h2>
													<div class="control-group">
														<label class="control-label"><a href="addmanager.jsp"><button class="btn btn-orange" style="width :200px">新增管理员</button></a> 
														</label>
													</div>
													<div class="control-group">
														<label class="control-label"><a href="updateMpassword.jsp"><button class="btn btn-orange" style="width :200px">修改密码</button></a> 
														</label>
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
		<span>©2017 版权所有</span> <span>鄂ICP备14003265号-2</span>
	</div>
	</footer>
</body>
</html>
