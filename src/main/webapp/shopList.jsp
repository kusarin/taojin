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
<link href="./TaoJin/css/flexslider.css" type="text/css" media="screen"
	rel="stylesheet" />
<link href="./TaoJin/css/jquery.fancybox.css" rel="stylesheet">
<link href="./TaoJin/css/cloud-zoom.css" rel="stylesheet">
<link href="./css/shopSearch.css" rel="stylesheet">
<title>店铺信息</title>
<script type="text/javascript">
function deleteone(shop_id){
if(confirm("确定要删除这条数据吗？")){
	window.location.href="delete.do?shop_id="+shop_id;
}
}
function setTab(name,m,n){ 
	for( var i=1;i<=n;i++){ 
	var menu = document.getElementById(name+i); 
	var showDiv = document.getElementById("cont_"+name+"_"+i); 
	menu.className = i==m ?"on":""; 
	showDiv.style.display = i==m?"block":"none"; 
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
										<a href="logout.do"><span style="color: white;"> 注销</span></a>
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
		<div class="container">
			<!--  breadcrumb -->
			<ul class="breadcrumb">
				<li><a href="#">店铺管理</a> <span class="divider">/</span></li>
				<li class="active">店铺信息</li>
			</ul>
			<div class="row">
				<!-- Sidebar Start-->
				<aside class="span3">
				<div class="sidewidt">
					<h2 class="heading2">
						<span>店铺管理</span>
					</h2>
					<ul class="nav nav-list categories">
						<c:if test="${shopli.shop_id==null }">
							<li><a href="addShop.jsp">认证店铺 </a></li>
						</c:if>
						<li><a href="shopList.do">查看记录 </a></li>
						<li><a href="addItem.jsp">商品上架 </a></li>
						<li><a href="shopItem.do?page=1">商品管理</a></li>
						<li><a href="toChange.do">店铺信息管理</a></li>
						<li><a
							href="waittingDeGoods.do?shop_id=${shopli.shop_id}&flag=0">订单管理</a>
							<ul>
								<a href="alreadyReGoods.do?shop_id=${shopli.shop_id}&flag=1">已处理</a>
							</ul>
							<ul>
								<a href="waittingDeGoods.do?shop_id=${shopli.shop_id}&flag=0">未处理</a>
							</ul></li>
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
										<span>店铺基本信息<c:if test="${shopli.status==0 }">(待审核)</c:if> <c:if
																	test="${shopli.status==1 }">(审核通过)</c:if> <c:if
																	test="${shopli.status==2 }">(审核未通过)</c:if></span>
									</h2>
									<c:if test="${shopli.status!=0}">
										<a href="addShop.jsp">申请填写</a>
									</c:if>
									<form action="shopList.do" name="myform" method="get"></form>
									<table
										style="border-left-width: 0px; border-collapse: collapse; border-right-width: 0px;"
										bordercolor="#ff6600" bgcolor="#DFFFDF" cellspacing="0"
										cellpadding="0" width="250" align="center" border="1">
										<tbody>
											<tr align="middle">
												<table width="90%" align="center">
													<tbody>
														<tr>
															<td><label class="control-label">店铺图片</label></td>
															<td><img style="width: 100px; length: 100px"
																src="${pageContext.request.contextPath}${shopli.image}"></td>
														</tr>
														<tr>
															<td width="30%"><label class="control-label">店铺名</label></td>
															<td width="70%">${shopli.name}</td>
														</tr>
														<tr>
															<td><label class="control-label">店主编号</label></td>
															<td>${shopli.user_ID}</td>
														</tr>
														<tr>
															<td><label class="control-label">店铺类型</label></td>
															<td>${shopli.type}</td>
														</tr>
														<tr>
															<td><label class="control-label">店铺介绍</label></td>
															<td>${shopli.intro}</td>
														</tr>
													</tbody>
												</table>
												<br>
												<ul class="productpagecart">
												<li><a href="toChange.do" >修改信息</a></li>
												<c:if test="${shopli.status==1 }">
												<li><a a href="shopItem.do?page=1" >店铺商品</a></li>
												<li><a href="addItem.jsp?shop_id=${shopli.shop_id }" >添加商品</a></li>
												</c:if>
													</ul>
												<!--footer-->
												<footer style="margin-top:100px"> <img
													src="${pageContext.request.contextPath}/image/footer-tri.png"
													style="width: 100%;">
												<div
													style="margin: 0px 0px 10px; text-align: center; padding-top: 10px;">

													<span>友情链接/</span> <a href="http://www.nwpu.edu.cn/"
														target="_top" class="links">西北工业大学</a>

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