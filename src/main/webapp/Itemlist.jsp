<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.left {
	width: 130px;
	heigh: auto;
	float: left;
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
											<c:out value="${user.username}" />
										</c:if>
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
	</header>
	<!-- Header End -->

	<form action="ItemType.do" method="post">

		<br>
	</form>


	<!-- 商品类型选择区域 start-->
	<div class="left">
		<div class="all-sort-list">
		<div class="item">
				<h3>
					<span>·</span><a href="ItemType1.do?typeh=动漫">动漫</a>、<a href="ItemType1.do?typeh=游戏">游戏</a>、<a href="ItemType1.do?typeh=乐器">乐器</a>
				</h3>
				<div class="item-list clearfix">
					<div class="close">x</div>
					<div class="subitem">
						<dl class="fore1">
							<dt>
								<a href="ItemType1.do?typeh=动漫">动漫</a>
							</dt>
							<dd>
								<em>
								<a href="ItemType2.do?typeh=动漫&typel=漫画原本">漫画原本</a></em><em>
								<a href="ItemType2.do?typeh=动漫&typel=读者手绘">读者手绘</a></em><em>
								<a href="ItemType2.do?typeh=动漫&typel=cos女装">cos女装</a></em><em>
								<a href="ItemType2.do?typeh=动漫&typel=cos男装">cos男装</a></em><em>
								<a href="ItemType2.do?typeh=动漫&typel=动漫手办">动漫手办</a></em>
							</dd>
						</dl>
						<dl class="fore2">
							<dt>
								<a href="ItemType1.do?typeh=游戏">游戏</a>
							</dt>
							<dd>
								<em>
								<a href="ItemType2.do?typeh=游戏&typel=游戏账号">游戏账号</a></em><em>
								<a href="ItemType2.do?typeh=游戏&typel=游戏点卡">游戏点卡</a></em><em>
								<a href="ItemType2.do?typeh=游戏&typel=游戏装备">游戏装备</a></em><em>
								<a href="ItemType2.do?typeh=游戏&typel=游戏金币">游戏金币</a></em><em>
								<a href="ItemType2.do?typeh=游戏&typel=实体盘">实体盘</a></em>
							</dd>
						</dl>
						<dl class="fore3">
							<dt>
								<a href="ItemType1.do?typeh=乐器">乐器</a>
							</dt>
							<dd>
								<em>
								<a href="ItemType2.do?typeh=乐器&typel=吉他">吉他</a></em><em>
								<a href="ItemType2.do?typeh=乐器&typel=萨克斯">萨克斯</a></em><em>
								<a href="ItemType2.do?typeh=乐器&typel=口琴">口琴</a></em><em>
								<a href="ItemType2.do?typeh=乐器&typel=笛子">笛子</a></em><em>
								<a href="ItemType2.do?typeh=乐器&typel=手风琴">手风琴</a></em>
							</dd>
						</dl>
					</div>
				</div>
			</div>
			<div class="item">
				<h3>
					<span>·</span><a href="ItemType1.do?typeh=数码用品">数码用品</a>、<a href="ItemType1.do?typeh=电脑">电脑</a>
				</h3>
				<div class="item-list clearfix">
					<div class="close">x</div>
					<div class="subitem">
						<dl class="fore1">
							<dt>
								<a href="ItemType1.do?typeh=数码用品">数码用品</a>
							</dt>
							<dd>
								<em>
								<a href="ItemType2.do?typeh=数码用品&typel=手机">手机</a></em><em>
								<a href="ItemType2.do?typeh=数码用品&typel=平板电脑">平板电脑</a></em><em>
								<a href="ItemType2.do?typeh=数码用品&typel=游戏主机">游戏主机</a></em><em>
								<a href="ItemType2.do?typeh=数码用品&typel=数码相机">数码相机</a></em>
							</dd>
						</dl>
						<dl class="fore2">
							<dt>
								<a href="ItemType1.do?typeh=电脑">电脑</a>
							</dt>
							<dd>
								<em>
								<a href="ItemType2.do?typeh=电脑&typel=笔记本电脑">笔记本电脑</a></em><em>
								<a href="ItemType2.do?typeh=电脑&typel=音响">音响</a></em><em>
								<a href="ItemType2.do?typeh=电脑&typel=耳机">耳机</a></em><em>
								<a href="ItemType2.do?typeh=电脑&typel=手柄">手柄</a></em><em>
								<a href="ItemType2.do?typeh=电脑&typel=其他外设">其他外设</a></em>
							</dd>
						</dl>
					</div>
				</div>
			</div>
			<div class="item">
				<h3>
					<span>·</span><a href="ItemType1.do?typeh=运动">运动</a>、<a href="ItemType1.do?typeh=户外健身">户外健身</a>
				</h3>
				<div class="item-list clearfix">
					<div class="close">x</div>
					<div class="subitem">
						<dl class="fore1">
							<dt>
								<a href="ItemType1.do?typeh=运动">运动</a>
							</dt>
							<dd>
								<em>
								<a href="ItemType2.do?typeh=运动&typel=篮球">篮球</a></em><em>
								<a href="ItemType2.do?typeh=运动&typel=足球">足球</a></em><em>
								<a href="ItemType2.do?typeh=运动&typel=羽毛球用具">羽毛球用具</a></em><em>
								<a href="ItemType2.do?typeh=运动&typel=网球用具">网球用具</a></em><em>
								<a href="ItemType2.do?typeh=运动&typel=其他器材">其他器材</a></em>
							</dd>
						</dl>
						<dl class="fore2">
							<dt>
								<a href="ItemType1.do?typeh=户外健身">户外健身</a>
							</dt>
							<dd>
								<em>
								<a href="ItemType2.do?typeh=户外健身&typel=登山用具">登山用具</a></em><em>
								<a href="ItemType2.do?typeh=户外健身&typel=军迷用具">军迷用具</a></em><em>
								<a href="ItemType2.do?typeh=户外健身&typel=骑行装备">骑行装备</a></em><em>
								<a href="ItemType2.do?typeh=户外健身&typel=帐篷用具">帐篷用具</a></em><em>
								<a href="ItemType2.do?typeh=户外健身&typel=其他用具">其他用具</a></em>
							</dd>
						</dl>
					</div>
				</div>
			</div>
			<div class="item">
				<h3>
					<span>·</span><a href="ItemType1.do?typeh=学习">学习</a>、<a href="ItemType1.do?typeh=服装">服装</a>
				</h3>
				<div class="item-list clearfix">
					<div class="close">x</div>
					<div class="subitem">
						<dl class="fore1">
							<dt>
								<a href="ItemType1.do?typeh=学习">学习</a>
							</dt>
							<dd>
								<em>
								<a href="ItemType2.do?typeh=学习&typel=少儿英语">少儿英语</a></em><em>
								<a href="ItemType2.do?typeh=学习&typel=小学教学">小学教学</a></em><em>
								<a href="ItemType2.do?typeh=学习&typel=初中教学">初中教学</a></em><em>
								<a href="ItemType2.do?typeh=学习&typel=高中教学">高中教学</a></em><em>
								<a href="ItemType2.do?typeh=学习&typel=考研辅导">考研辅导</a></em><em>
								<a href="ItemType2.do?typeh=学习&typel=托福雅思">托福雅思</a></em>
							</dd>
						</dl>
						<dl class="fore2">
							<dt>
								<a href="ItemType1.do?typeh=服装">服装</a>
							</dt>
							<dd>
								<em>
								<a href="ItemType2.do?typeh=服装&typel=男装">男装</a></em><em>
								<a href="ItemType2.do?typeh=服装&typel=女装">女装</a></em><em>
								<a href="ItemType2.do?typeh=服装&typel=正装">正装</a></em><em>
								<a href="ItemType2.do?typeh=服装&typel=运动装系列">运动装系列</a></em><em>
								<a href="ItemType2.do?typeh=服装&typel=学士服系列">学士服系列</a></em>
							</dd>
						</dl>
					</div>
				</div>
			</div>
			<div class="item bo">
				<h3>
					<span>·</span><a href="ItemType1.do?typeh=其他商品">其他商品</a>
				</h3>
				<div class="item-list clearfix">
					<div class="close">x</div>
					<div class="subitem">
						<dl class="fore1">
							<dt>
								<a href="ItemType1.do?typeh=其他商品">其他商品</a>
							</dt>
							<dd>
								<em>
								<a href="ItemType2.do?typeh=其他商品&typel=其他商品">其他商品</a></em>
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
	
	<div style="margin-left: 250px;">
		<h1 style="color: orange">${error0}</h1>
		<c:forEach items="${itemlist}" var="i">
			<li class="span3">
				<table border="1">
					<thead>
						<tr>
							<td>
								<div>
									<a href="lookItem.do?id=${i.item_id}"> <img
										class="itemimage"
										src=${pageContext.request.contextPath}${i.image}>
									</a>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div>
									<a href="lookItem.do?id=${i.item_id}"><p class="textname"
											style="height: 20px; width: 200px">${i.name}</p></a> <a
										href="lookItem.do?id=${i.item_id}" class="textprice">商品价格:
										¥ ${i.price}</a>
								</div> <br>
								<div>
									<a href="lookItem.do?id=${i.item_id}"><p class="textdetail"
											style="height: 20px; width: 275px">${i.detail}</p></a>
								</div>
							</td>
						</tr>
					</thead>
				</table> <br>
			</li>
		</c:forEach>
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
		<a id="fd_footer" href="addComment.jsp">产品意见反馈</a> <a
			href="mlogin.jsp" target="_top">产品管理</a>
	</div>
	<div style="text-align: center; margin-bottom: 10px;">
		<span>©2017 版权所有</span> <span>鄂ICP备14003265号-2</span>
	</div>
	</footer>
</body>
</html>