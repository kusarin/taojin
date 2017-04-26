<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	window.onload = function() {
		var error = "${requestScope.error}";
		if (error != "" && error != null && typeof (error) != "undefined") {
			alert(error);
		}
	}
</script>
<title>二手淘金网--添加资源文件</title>
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
									<h3>
										<span>二手淘金交易网——管理员界面</span>
									</h3>
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
				<li>文件资源管理<span class="divider">/</span></li>
				<li>新增文件</li>
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
					</ul>
				</div>
				<div class="sidewidt"></div>
				</aside>
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
									<h2 class="heading2">
										<span>新增文件</span>
									</h2>
									<section class="leavecomment">
									<form action="addRF.do" method="post" enctype="multipart/form-data">
										<fieldset>
											<div class="control-group">
												<div class="controls">
													<label class="control-label">文件</label>
													<input type="file" name="file" accept= "*"/>
												</div>
											</div>
											<div class="controls">
												<input type="submit" value="新增" class="btn btn-orange"
													style="width: 200px" />
											</div>
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
