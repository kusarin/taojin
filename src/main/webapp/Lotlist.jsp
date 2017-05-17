<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.left {
	width: 175px;
	heigh: auto;
	float: left;
	margin-left: 20px;
}

.right {
	width: auto;
	heigh: auto;
	margin-top: 20px;
}

.itemimage {
	width: 300px;
	height: 175px;
	float: left;
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
	color: orange;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.textprice {
	font-size: 20px;
	color: red;
}
</style>


<title>拍卖品列表</title>
<link href="./css/itemlist.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./TaoJin/css/style.css" rel="stylesheet">
<link href="./TaoJin/css/flexslider.css" type="text/css" media="screen"
	rel="stylesheet" />
<link href="./TaoJin/css/jquery.fancybox.css" rel="stylesheet">
<script type="text/javascript">
	window.onload = function() {
		var error = "${requestScope.error}";
		if (error != "" && error != null && typeof (error) != "undefined") {
			alert(error);
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
	<div class="left">
		<h3 style="color: red">&nbsp拍卖品：</h3>
	</div>
	<div class="right" style="margin-left: 275px">
		<c:forEach items="${Lotlist}" var="i">
			<li class="span3">
				<div>
					<table border="1">
						<thead>
							<tr>
								<td><a href="lookLot.do?id=${i.lot_id}" target=${i.lot_id}>
										<img class="itemimage"
										src=${pageContext.request.contextPath}${i.image}>
								</a></td>
							</tr>
							<tr>
								<td><a href="lookLot.do?id=${i.lot_id}" target=${i.lot_id}><p
											class="textname" style="height: 20px; width: 200px">${i.name}</p></a>
									<a href="lookLot.do?id=${i.lot_id}" class="textprice"
									target=${i.lot_id}>拍卖品类型:${i.typel} </a> <br>
									<a href="lookLot.do?id=${i.lot_id}" target=${i.lot_id}><p
											class="textdetail" style="height: 20px; width: 275px"
											title=${i.detail}>${i.detail}</p></a></td>
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
	<form action="Lotlist.do" method="post">
		<!-- 上一页 按钮 -->
		<div align="center">
			<c:choose>
				<c:when test="${page != 1}">
					<a href="Lotlist.do?page=${page-1}"><input type="button"
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
						<a href="Lotlist.do?page=${pn}"><U>${pn}</U></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<!-- 下一页 按钮 -->
			<c:choose>
				<c:when test="${page != totalPage}">
					<a href="Lotlist.do?page=${page+1}"> <input type="button"
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
	<footer style="margin-bottom:0"> <img
		src="${pageContext.request.contextPath}/image/footer-tri.png"
		style="width: 100%;">
	<div
		style="margin: 0px 0px 10px; text-align: center; padding-top: 10px;">

		<span>友情链接/</span> <a href="http://www.nwpu.edu.cn/" target="_top"
			class="links">西北工业大学</a>

	</div>
	<div style="text-align: center; margin-bottom: 10px;">
		<a id="fd_footer" href="addComment.jsp">产品意见反馈</a> <a
			href="mlogin.jsp" target="_top">产品管理</a>
	</div>
	<div style="text-align: center; margin-bottom: 10px;">
		<span>©2017 版权所有</span> <span>鄂ICP备14003265号-2</span>
	</div>
	</footer>
</body>
</html>