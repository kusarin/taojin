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
</head>
<body>
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
									<span>您好,</span> <a href="login.jsp"><span
										style="color: white;">登录</span></a> <a href="register.jsp"> <span
										style="margin-left: 20px; color: white;">注册</span></a>
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
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
		$('.all-sort-list > .item').hover(
				function() {
					var eq = $('.all-sort-list > .item').index(this), //获取当前滑过是第几个元素
					h = $('.all-sort-list').offset().top, //获取当前下拉菜单距离窗口多少像素
					s = $(window).scrollTop(), //获取游览器滚动了多少高度
					i = $(this).offset().top, //当前元素滑过距离窗口多少像素
					item = $(this).children('.item-list').height(), //下拉菜单子类内容容器的高度
					sort = $('.all-sort-list').height(); //父类分类列表容器的高度

					if (item < sort) { //如果子类的高度小于父类的高度
						if (eq == 0) {
							$(this).children('.item-list').css('top', (i - h));
						} else {
							$(this).children('.item-list').css('top',
									(i - h) + 1);
						}
					} else {
						if (s > h) { //判断子类的显示位置，如果滚动的高度大于所有分类列表容器的高度
							if (i - s > 0) { //则 继续判断当前滑过容器的位置 是否有一半超出窗口一半在窗口内显示的Bug,
								$(this).children('.item-list').css('top',
										(s - h) + 2);
							} else {
								$(this).children('.item-list').css('top',
										(s - h) - (-(i - s)) + 2);
							}
						} else {
							$(this).children('.item-list').css('top', 3);
						}
					}

					$(this).addClass('hover');
					$(this).children('.item-list').css('display', 'block');
				}, function() {
					$(this).removeClass('hover');
					$(this).children('.item-list').css('display', 'none');
				});

		$('.item > .item-list > .close').click(function() {
			$(this).parent().parent().removeClass('hover');
			$(this).parent().hide();
		});
	</script>
	<!-- 商品类型选择区域 end-->

	<div class="right" style="margin-left: 275px">
		<h1 style="color: orange">${error0}</h1>
		<c:forEach items="${shoplist}" var="c">
			<li class="span3">
				<div>
					<table border="1">
						<thead>
							<tr>
								<td><a href="lookItem.do?id=${c.shop_id}"> <img
										class="itemimage"
										src=${pageContext.request.contextPath}${i.image}>
								</a></td>
							</tr>
							<tr>
								<td><a href="lookItem.do?id=${c.shop_id}"><p
											class="textname" style="height: 20px; width: 200px">${c.name}</p></a>
									<a href="lookItem.do?id=${c.shop_id}" class="textprice">商品价格:
										¥ ${c.intro}</a> <br> <a href="lookItem.do?id=${c.shop_id}"><p
											class="textdetail" style="height: 20px; width: 275px">${c.intro}</p></a>
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
	<form action="searchShop.do" method="post">
		<input type="hidden" name="str" value=${search}>
		<!-- 上一页 按钮 -->
		<div align="center">
			<c:choose>
				<c:when test="${page != 1}">
					<a href="searchItem2.do?str=${search}&page=${page-1}"><input type="button"
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
						<a href="searchItem2.do?str=${search}&page=${pn}"><U>${pn}</U></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<!-- 下一页 按钮 -->
			<c:choose>
				<c:when test="${page != totalPage}">
					<a href="searchItem2.do?str=${search}&page=${page+1}"> <input type="button"
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
		<span>2017 版权所有</span> <span>鄂ICP备14003265号-2</span>
	</div>
	</footer>
</body>
</html>