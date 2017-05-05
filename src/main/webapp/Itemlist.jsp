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


<title>商品列表</title>
<link href="./css/itemlist.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./TaoJin/css/style.css" rel="stylesheet">
<link href="./TaoJin/css/flexslider.css" type="text/css" media="screen"
	rel="stylesheet" />
<link href="./TaoJin/css/jquery.fancybox.css" rel="stylesheet">
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
				</div>
			</div>
		</div>
	</div>
	</header>
	<!-- Header End -->

	<!-- 商品类型选择区域 start-->
	<div class="left">
		<div class="all-sort-list">
			<div class="item">
				<h3>
					<span>·</span><a href="ItemType1.do?typeh=动漫&page=1">动漫</a>、<a
						href="ItemType1.do?typeh=游戏&page=1">游戏</a>、<a
						href="ItemType1.do?typeh=乐器&page=1">乐器</a>
				</h3>
				<div class="item-list clearfix">
					<div class="close">x</div>
					<div class="subitem">
						<dl class="fore1">
							<dt>
								<a href="ItemType1.do?typeh=动漫&page=1">动漫</a>
							</dt>
							<dd>
								<em> <a href="ItemType2.do?typeh=动漫&typel=漫画原本&page=1">漫画原本</a></em><em>
									<a href="ItemType2.do?typeh=动漫&typel=读者手绘&page=1">读者手绘</a>
								</em><em> <a href="ItemType2.do?typeh=动漫&typel=cos女装&page=1">cos女装</a></em><em>
									<a href="ItemType2.do?typeh=动漫&typel=cos男装&page=1">cos男装</a>
								</em><em> <a href="ItemType2.do?typeh=动漫&typel=动漫手办&page=1">动漫手办</a></em>
							</dd>
						</dl>
						<dl class="fore2">
							<dt>
								<a href="ItemType1.do?typeh=游戏&page=1">游戏</a>
							</dt>
							<dd>
								<em> <a href="ItemType2.do?typeh=游戏&typel=游戏账号&page=1">游戏账号</a></em><em>
									<a href="ItemType2.do?typeh=游戏&typel=游戏点卡&page=1">游戏点卡</a>
								</em><em> <a href="ItemType2.do?typeh=游戏&typel=游戏装备&page=1">游戏装备</a></em><em>
									<a href="ItemType2.do?typeh=游戏&typel=游戏金币&page=1">游戏金币</a>
								</em><em> <a href="ItemType2.do?typeh=游戏&typel=实体盘&page=1">实体盘</a></em>
							</dd>
						</dl>
						<dl class="fore3">
							<dt>
								<a href="ItemType1.do?typeh=乐器&page=1">乐器</a>
							</dt>
							<dd>
								<em> <a href="ItemType2.do?typeh=乐器&typel=吉他&page=1">吉他</a></em><em>
									<a href="ItemType2.do?typeh=乐器&typel=萨克斯&page=1">萨克斯</a>
								</em><em> <a href="ItemType2.do?typeh=乐器&typel=口琴&page=1">口琴</a></em><em>
									<a href="ItemType2.do?typeh=乐器&typel=笛子&page=1">笛子</a>
								</em><em> <a href="ItemType2.do?typeh=乐器&typel=手风琴&page=1">手风琴</a></em>
							</dd>
						</dl>
					</div>
				</div>
			</div>
			<div class="item">
				<h3>
					<span>·</span><a href="ItemType1.do?typeh=数码用品&page=1">数码用品</a>、<a
						href="ItemType1.do?typeh=电脑&page=1">电脑</a>
				</h3>
				<div class="item-list clearfix">
					<div class="close">x</div>
					<div class="subitem">
						<dl class="fore1">
							<dt>
								<a href="ItemType1.do?typeh=数码用品&page=1">数码用品</a>
							</dt>
							<dd>
								<em> <a href="ItemType2.do?typeh=数码用品&typel=手机&page=1">手机</a></em><em>
									<a href="ItemType2.do?typeh=数码用品&typel=平板电脑&page=1">平板电脑</a>
								</em><em> <a href="ItemType2.do?typeh=数码用品&typel=游戏主机&page=1">游戏主机</a></em><em>
									<a href="ItemType2.do?typeh=数码用品&typel=数码相机&page=1">数码相机</a>
								</em>
							</dd>
						</dl>
						<dl class="fore2">
							<dt>
								<a href="ItemType1.do?typeh=电脑&page=1">电脑</a>
							</dt>
							<dd>
								<em> <a href="ItemType2.do?typeh=电脑&typel=笔记本电脑&page=1">笔记本电脑</a></em><em>
									<a href="ItemType2.do?typeh=电脑&typel=音响&page=1">音响</a>
								</em><em> <a href="ItemType2.do?typeh=电脑&typel=耳机&page=1">耳机</a></em><em>
									<a href="ItemType2.do?typeh=电脑&typel=手柄&page=1">手柄</a>
								</em><em> <a href="ItemType2.do?typeh=电脑&typel=其他外设&page=1">其他外设</a></em>
							</dd>
						</dl>
					</div>
				</div>
			</div>
			<div class="item">
				<h3>
					<span>·</span><a href="ItemType1.do?typeh=运动&page=1">运动</a>、<a
						href="ItemType1.do?typeh=户外健身&page=1">户外健身</a>
				</h3>
				<div class="item-list clearfix">
					<div class="close">x</div>
					<div class="subitem">
						<dl class="fore1">
							<dt>
								<a href="ItemType1.do?typeh=运动&page=1">运动</a>
							</dt>
							<dd>
								<em> <a href="ItemType2.do?typeh=运动&typel=篮球&page=1">篮球</a></em><em>
									<a href="ItemType2.do?typeh=运动&typel=足球&page=1">足球</a>
								</em><em> <a href="ItemType2.do?typeh=运动&typel=羽毛球用具&page=1">羽毛球用具</a></em><em>
									<a href="ItemType2.do?typeh=运动&typel=网球用具&page=1">网球用具</a>
								</em><em> <a href="ItemType2.do?typeh=运动&typel=其他器材&page=1">其他器材</a></em>
							</dd>
						</dl>
						<dl class="fore2">
							<dt>
								<a href="ItemType1.do?typeh=户外健身&page=1">户外健身</a>
							</dt>
							<dd>
								<em> <a href="ItemType2.do?typeh=户外健身&typel=登山用具&page=1">登山用具</a></em><em>
									<a href="ItemType2.do?typeh=户外健身&typel=军迷用具&page=1">军迷用具</a>
								</em><em> <a href="ItemType2.do?typeh=户外健身&typel=骑行装备&page=1">骑行装备</a></em><em>
									<a href="ItemType2.do?typeh=户外健身&typel=帐篷用具&page=1">帐篷用具</a>
								</em><em> <a href="ItemType2.do?typeh=户外健身&typel=其他用具&page=1">其他用具</a></em>
							</dd>
						</dl>
					</div>
				</div>
			</div>
			<div class="item">
				<h3>
					<span>·</span><a href="ItemType1.do?typeh=学习&page=1">学习</a>、<a
						href="ItemType1.do?typeh=服装&page=1">服装</a>
				</h3>
				<div class="item-list clearfix">
					<div class="close">x</div>
					<div class="subitem">
						<dl class="fore1">
							<dt>
								<a href="ItemType1.do?typeh=学习&page=1">学习</a>
							</dt>
							<dd>
								<em> <a href="ItemType2.do?typeh=学习&typel=少儿英语&page=1">少儿英语</a></em><em>
									<a href="ItemType2.do?typeh=学习&typel=小学教学&page=1">小学教学</a>
								</em><em> <a href="ItemType2.do?typeh=学习&typel=初中教学&page=1">初中教学</a></em><em>
									<a href="ItemType2.do?typeh=学习&typel=高中教学&page=1">高中教学</a>
								</em><em> <a href="ItemType2.do?typeh=学习&typel=考研辅导&page=1">考研辅导</a></em><em>
									<a href="ItemType2.do?typeh=学习&typel=托福雅思&page=1">托福雅思</a>
								</em>
							</dd>
						</dl>
						<dl class="fore2">
							<dt>
								<a href="ItemType1.do?typeh=服装&page=1">服装</a>
							</dt>
							<dd>
								<em> <a href="ItemType2.do?typeh=服装&typel=男装&page=1">男装</a></em><em>
									<a href="ItemType2.do?typeh=服装&typel=女装&page=1">女装</a>
								</em><em> <a href="ItemType2.do?typeh=服装&typel=正装&page=1">正装</a></em><em>
									<a href="ItemType2.do?typeh=服装&typel=运动装系列&page=1">运动装系列</a>
								</em><em> <a href="ItemType2.do?typeh=服装&typel=学士服系列&page=1">学士服系列</a></em>
							</dd>
						</dl>
					</div>
				</div>
			</div>
			<div class="item bo">
				<h3>
					<span>·</span><a href="ItemType1.do?typeh=其他商品&page=1">其他商品</a>
				</h3>
				<div class="item-list clearfix">
					<div class="close">x</div>
					<div class="subitem">
						<dl class="fore1">
							<dt>
								<a href="ItemType1.do?typeh=其他商品&page=1">其他商品</a>
							</dt>
							<dd>
								<em> <a href="ItemType2.do?typeh=其他商品&typel=其他商品&page=1">其他商品</a></em>
							</dd>
						</dl>
					</div>
				</div>
			</div>
		</div>
		<p>${show}</p>
		<p>${typeh}</p>
		<p>${typel}</p>

	</div>

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
		<c:forEach items="${itemlist}" var="i">
			<li class="span3">
				<div>
					<table border="1">
						<thead>
							<tr>
								<td><a href="lookItem.do?id=${i.item_id}" target=${i.item_id}> <img
										class="itemimage"
										src=${pageContext.request.contextPath}${i.image}>
								</a></td>
							</tr>
							<tr>
								<td><a href="lookItem.do?id=${i.item_id}" target=${i.item_id}><p
											class="textname" style="height: 20px; width: 200px">${i.name}</p></a>
									<a href="lookItem.do?id=${i.item_id}" class="textprice" target=${i.item_id}>商品价格:
										¥ ${i.price}</a> <br> <a href="lookItem.do?id=${i.item_id}" target=${i.item_id}><p
											class="textdetail" style="height: 20px; width: 275px" title=${i.detail}>${i.detail}</p></a>
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
	<form action="Itemlist.do" method="post">
		<!-- 上一页 按钮 -->
		<div align="center">
			<c:choose>
				<c:when test="${page != 1}">
					<a href="Itemlist.do?page=${page-1}"><input type="button"
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
						<a href="Itemlist.do?page=${pn}"><U>${pn}</U></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<!-- 下一页 按钮 -->
			<c:choose>
				<c:when test="${page != totalPage}">
					<a href="Itemlist.do?page=${page+1}"> <input type="button"
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