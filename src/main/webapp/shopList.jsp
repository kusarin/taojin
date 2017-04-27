<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./TaoJin/css/bootstrap.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./TaoJin/css/style.css" rel="stylesheet">
<link href="./TaoJin/css/flexslider.css" type="text/css" media="screen" rel="stylesheet"  />
<link href="./TaoJin/css/jquery.fancybox.css" rel="stylesheet">
<link href="./TaoJin/css/cloud-zoom.css" rel="stylesheet">
<title>Insert title here</title>
<script type="text/javascript">
function deleteone(shop_id){
if(confirm("确定要删除这条数据吗？")){
	window.location.href="delete.do?shop_id="+shop_id;
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
									<span>您好,</span> <span
										style="color: white;">${user.username}</span>
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
								<input input type="text" name="str"
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
						<li><a href="addShop.jsp">认证店铺 </a></li>
						<li><a href="#">查看记录 </a></li>
						<li><a href="addItem.jsp">商品上架 </a></li>
						<li><a href="shopItem.do">商品管理</a></li>
						<li><a href="toChange.do">店铺信息管理</a></li>
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
							<span>认证店铺</span>
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
                                    <a href="addShop.jsp">添加</a>
									<form action="shopList.do" name="myform" method="get"></form>
									<table
										style="border-left-width: 0px; border-collapse: collapse; border-right-width: 0px;"
										bordercolor="#ff6600" bgcolor="#DFFFDF" cellspacing="0"
										cellpadding="0" width="250" align="center" border="1">
										<tbody>
											<tr align="middle">
												<table width="90%" border="1" align="center">
													<thead>
														<tr>
															<td colspan="10" align="center">店铺信息管理</td>
														</tr>
													</thead>
													<tbody>

														<tr align="center">
															<td>编号</td>
															<td>用户名</td>
															<td>店名</td>
															<td>类型</td>
															<td>介绍</td>
							                                <td>审核状态</td>
							                                <td>操作</td>
														</tr>
															<tr>
																<td>${shopli.shop_id}</td>
																<td>${shopli.user_ID}</td>
																<td>${shopli.name}</td>
																<td>${shopli.type}</td>
																<td>${shopli.intro}</td>
																<td><c:if test="${shopli.status==0 }">未审核</c:if>
																    <c:if test="${shopli.status==1 }">已审核</c:if>
																    <c:if test="${shopli.status==2 }">审核未通过</c:if></td>
																<td><a href="toChange.do">查看</a>
																<a href="showItem.do">商品</a>
																<a href="addItem.jsp?shop_id=${shopli.shop_id }">添加商品</a>
																<a onclick="deleteone(${shopli.shop_id})"
																	href="javascript:void(0)">删除</a></td>

															</tr>														
													</tbody>
												</table>
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
		<span>?2017 版权所有</span> <span>鄂ICP备14003265号-2</span>
	</div>
	</footer>

												
</body>
</html>