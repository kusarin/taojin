<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<!-- 弹窗设置点 -->
<script type="text/javascript">
	window.onload = function() {
		var error = "${requestScope.error}";
		if (error != "" && error != null && typeof (error) != "undefined") {
			alert(error);
		}
	}
</script>
<!-- 缺少部分：图片上传+获取店铺ID -->

<title>商品上架</title>
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
										<a href="logout.do"><span style="color: white;"> 注销</span></a>
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
							<span>商品上架</span>
						</h2>
						<ul class="margin-none">
							<li class="listblcok">
								<div class="mb20">
									<section class="leavecomment">
									<div align="center">
										<form action="addItem.do" method="post"
											enctype="multipart/form-data">
											<table>
												<input type="hidden" value="2" name="Shop_id" />
												<tr>
													<div class="control-group">
														<td>商品名称:</td>
														<div class="controls">
															<td><input type="text" name="name"></td>
														</div>
													</div>
												</tr>
												<tr>
													<div class="control-group">
														<td>商品类型:</td>
														<div class="controls">
															<td><select id="code" name="typel">
																	<optgroup label="---动漫------------">
																		<option value="漫画原本">漫画原本</option>
																		<option value="读者手绘">读者手绘</option>
																		<option value="cos女装">cos女装</option>
																		<option value="cos男装">cos男装</option>
																		<option value="动漫手办">动漫手办</option>
																	</optgroup>
																	<optgroup label="---游戏------------">
																		<option value="游戏账号">游戏账号</option>
																		<option value="游戏点卡">游戏点卡</option>
																		<option value="游戏装备">游戏装备</option>
																		<option value="游戏金币">游戏金币</option>
																		<option value="实体盘">实体盘</option>
																	</optgroup>
																	<optgroup label="---乐器------------">
																		<option value="吉他">吉他</option>
																		<option value="萨克斯">萨克斯</option>
																		<option value="口琴">口琴</option>
																		<option value="笛子">笛子</option>
																		<option value="手风琴">手风琴</option>
																	</optgroup>
																	<optgroup label="---数码用品--------">
																		<option value="手机">手机</option>
																		<option value="平板电脑">平板电脑</option>
																		<option value="游戏主机">游戏主机</option>
																		<option value="数码相机">数码相机</option>
																	</optgroup>
																	<optgroup label="---电脑------------">
																		<option value="笔记本电脑">笔记本电脑</option>
																		<option value="音响">耳机</option>
																		<option value="手柄">手柄</option>
																		<option value="其他外设">其他外设</option>
																	</optgroup>
																	<optgroup label="---运动------------">
																		<option value="篮球">篮球</option>
																		<option value="足球">足球</option>
																		<option value="羽毛球用具">羽毛球用具</option>
																		<option value="网球用具">网球用具</option>
																		<option value="其他器材">其他器材</option>
																	</optgroup>
																	<optgroup label="---户外健身--------">
																		<option value="登山用具">登山用具</option>
																		<option value="军迷用具">军迷用具</option>
																		<option value="骑行装备">骑行装备</option>
																		<option value="帐篷用具">帐篷用具</option>
																		<option value="其他用具">其他用具</option>
																	</optgroup>
																	<optgroup label="---学习------------">
																		<option value="少儿英语">少儿英语</option>
																		<option value="小学教学">小学教学</option>
																		<option value="初中教学">初中教学</option>
																		<option value="高中教学">高中教学</option>
																		<option value="考研辅导">考研辅导</option>
																		<option value="托福雅思">托福雅思</option>
																	</optgroup>
																	<optgroup label="---服装------------">
																		<option value="男装">男装</option>
																		<option value="女装">女装</option>
																		<option value="正装">正装</option>
																		<option value="运动装系列">运动装系列</option>
																		<option value="学士服系列">学士服系列</option>
																	</optgroup>
																	<optgroup label="---其他商品--------">
																		<option value="其他商品">其他商品</option>
																	</optgroup>
															</select></td>
														</div>
													</div>
												</tr>
												<tr>
													<div class="control-group">
														<td>商品数量:</td>
														<div class="controls">
															<td><input type="text" name="number"
																onkeyup="value=value.replace(/[^(\d)]/g,'')" /></td>
														</div>
													</div>
												</tr>
												<tr>
													<div class="control-group">
														<td>商品价格:¥</td>
														<div class="controls">
															<td><input type="text" name="price" /></td>
														</div>
													</div>
												</tr>
												<tr>
													<div class="control-group">
														<td>商品图片:</td>
														<div class="controls">
															<td><p>注意：上传的图片名中不能包含中文</p></td>
														</div>
													</div>
												</tr>
												<tr>
													<div class="control-group">
														<td></td>
														<div class="controls">
															<td><input type="file" name="file" accept="image/*" /></td>
														</div>
													</div>
												</tr>
												<tr>
													<div class="control-group">
														<td>商品描述:</td>
														<div class="controls">
															<td><input type="text" name="detail" /></td>
														</div>
													</div>
												</tr>
											</table>
											<input type="submit" value="确认上架" />
										</form>
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
		<a id="fd_footer" href="addComment.jsp">产品意见反馈</a>
	</div>
	<div style="text-align: center; margin-bottom: 10px;">
		<span>©2017 版权所有</span> <span>鄂ICP备14003265号-2</span>
	</div>
	</footer>
</body>
</html>
