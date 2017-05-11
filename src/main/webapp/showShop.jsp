<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.left {
	width: 130px;
	heigh: auto;
	float: left;
	margin-top: 20px;
	margin-left: 20px;
}

.right {
	width: auto;
	heigh: auto;
	margin-top: 20px;
	margin-left: 149px;
}

.itemimage {
	width: 300px;
	height: 175px;
	float: left;
}
.textshopname {
	font-size: 30px;
	color: red;
}
.textname {
	font-size: 20px;
	color: black;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.textdetail {
	font-size: 15px;
	color:orange;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.textprice {
	font-size: 20px;
	color: red;
}
</style>
<link href="./css/shopSearch.css" rel="stylesheet">
<!-- 弹窗设置点 -->
<script type="text/javascript">
	window.onload = function() {
		var error = "${requestScope.error}";
		if (error != "" && error != null && typeof (error) != "undefined") {
			alert(error);
		}
	}
	function setTab(name,m,n){ 
		for( var i=1;i<=n;i++){ 
		var menu = document.getElementById(name+i); 
		var showDiv = document.getElementById("cont_"+name+"_"+i); 
		menu.className = i==m ?"on":""; 
		showDiv.style.display = i==m?"block":"none"; 
		} 
</script>
<title> ${shopinfo.name}</title>
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
								<input type="text" name="str" class="input-medium search-query"
									placeholder="搜索你想要的二手"
									style="height: 20px; width: 100; border: 4px solid #FFA07A">
								<input type="submit" value="搜索"
									style="height: 30px; width: 40; background-color: #FFA07A; border: 4px solid #FFA07A;">
							</div>
						</form>
						</div>
						<div id="cont_tow_2" class="one">
						<form action="searchShop.do?page=1" method="post">
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
		</div>
	</div>
	</header>
	<!-- Header End -->
	
	
	<div class="left">
			<p class="textshopname" style="height: 40px; width: 200px"> ${shopinfo.name}</p>
			<p class="textdetail" style="height: 40px; width: 200px"> ${shopinfo.intro}</p>
		</div>
	

<div style="margin-left: 250px;">
<h1 style="color:orange">${error0}</h1>
	<c:forEach items="${showshopItem}" var="i">
		<li class="span3">
				<div>
					<table border="1">
						<thead>
							<tr>
								<td><a href="lookshopItem.do?shopid=${c.shop_id}&page=1" target=${c.shop_id}> <img
										class="shopimage"
										src=${pageContext.request.contextPath}${c.image}>
								</a></td>
							</tr>
							<tr>
								<td><a href="lookshopItem.do?shopid=${c.shop_id}&page=1"><p
											class="textname" style="height: 20px; width: 200px">${c.name}</p></a>
								</td>
							</tr>
						</thead>
					</table>
					<br>
				</div>
			</li>
	</c:forEach>
	</div>
	<!-- 页码显示部分 -->
	<div style="width: 500px">&nbsp</div>
	<form action="lookshopItem.do?shopid=${shopinfo.shop_id}" method="post">
		<!-- 上一页 按钮 -->
		<div align="center">
			<c:choose>
				<c:when test="${page != 1}">
					<a href="lookshopItem.do?shopid=${shopinfo.shop_id}&page=${page-1}"><input type="button"
						name="lastPage" value="上一页" class="btn btn-orange" /></a>
				</c:when>
				<c:otherwise>
					<input type="button" disabled="true" name="lastPage" value="上一页"
						class="btn btn-orange" />
				</c:otherwise>
			</c:choose>
			<!-- 页数列表 -->
			<c:forEach items="${pageList}" var="pn">
				<c:choose>
					<c:when test="${pn == page}">${pn}</c:when>
					<c:otherwise>
						<a href="lookshopItem.do?shopid=${shopinfo.shop_id}&page=${pn}"><U>${pn}</U></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<!-- 下一页 按钮 -->
			<c:choose>
				<c:when test="${page != totalPage}">
					<a href="lookshopItem.do?shopid=${shopinfo.shop_id}&page=${page+1}"> <input type="button"
						name="nextPage" value="下一页" class="btn btn-orange" />
					</a>
				</c:when>
				<c:otherwise>
					<input type="button" disabled="true" name="nextPage" value="下一页"
						class="btn btn-orange" />
				</c:otherwise>
			</c:choose>
			<!-- 跳转点 -->
			&nbsp共${totalPage}页 &nbsp <input type="text" name="page" id="jump"
				value=1 style="width: 30px"
				onkeyup="this.value=this.value.replace(/\D/g,'')"
				onafterpaste="this.value=this.value.replace(/\D/g,'')" /> <input
				type="submit" value="跳转" />
		</div>
	</form>
	
	
	
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
		<span>©2017 版权所有</span> <span>鄂ICP备14003265号-2</span>
	</div>
	</footer>
</body>
</html>