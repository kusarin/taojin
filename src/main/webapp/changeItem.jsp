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

<title>修改商品</title>
</head>
<body>
	<!-- Header Start -->
	<header>
	<div class="headerstrip">
		<div class="container">
			<div class="row">
				<div class="span12">
					<a href="index-2.html" class="logo pull-left"><img
						src="img/logo.png" alt="SimpleOne" title="SimpleOne"></a>
					<!-- Top Nav Start -->
					<div class="pull-left">
						<div class="navbar" id="topnav">
							<div class="navbar-inner">
								<ul class="nav">
									<li><a class="home active" href="#">Home</a></li>
									<li><a class="myaccount" href="#">My Account</a></li>
									<li><a class="shoppingcart" href="#">Shopping Cart</a></li>
									<li><a class="checkout" href="#">CheckOut</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- Top Nav End -->
					<div class="pull-right">
						<form class="form-search top-search">
							<input type="text" class="input-medium search-query"
								placeholder="Search Here…">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="headerdetails">
			<div class="pull-left">
				<ul class="nav language pull-left">
					<li class="dropdown hover"><a href="#" class="dropdown-toggle"
						data-toggle="">US Doller <b class="caret"></b></a>
						<ul class="dropdown-menu currency">
							<li><a href="#">US Doller</a></li>
							<li><a href="#">Euro </a></li>
							<li><a href="#">British Pound</a></li>
						</ul></li>
					<li class="dropdown hover"><a href="#" class="dropdown-toggle"
						data-toggle="">English <b class="caret"></b></a>
						<ul class="dropdown-menu language">
							<li><a href="#">English</a></li>
							<li><a href="#">Spanish</a></li>
							<li><a href="#">German</a></li>
						</ul></li>
				</ul>

			</div>
			<div class="pull-right">
				<ul class="nav topcart pull-left">
					<li class="dropdown hover carticon "><a href="#"
						class="dropdown-toggle"> Shopping Cart <span
							class="label label-orange font14">1 item(s)</span> - $589.50 <b
							class="caret"></b></a>
						<ul class="dropdown-menu topcartopen ">
							<li><table>
									<tbody>
										<tr>
											<td class="image"><a href="product.html"><img
													width="50" height="50" src="img/prodcut-40x40.jpg"
													alt="product" title="product"></a></td>
											<td class="name"><a href="product.html">MacBook</a></td>
											<td class="quantity">x&nbsp;1</td>
											<td class="total">$589.50</td>
											<td class="remove"><i class="icon-remove"></i></td>
										</tr>
										<tr>
											<td class="image"><a href="product.html"><img
													width="50" height="50" src="img/prodcut-40x40.jpg"
													alt="product" title="product"></a></td>
											<td class="name"><a href="product.html">MacBook</a></td>
											<td class="quantity">x&nbsp;1</td>
											<td class="total">$589.50</td>
											<td class="remove"><i class="icon-remove "></i></td>
										</tr>
									</tbody>
								</table>
								<table>
									<tbody>
										<tr>
											<td class="textright"><b>Sub-Total:</b></td>
											<td class="textright">$500.00</td>
										</tr>
										<tr>
											<td class="textright"><b>Eco Tax (-2.00):</b></td>
											<td class="textright">$2.00</td>
										</tr>
										<tr>
											<td class="textright"><b>VAT (17.5%):</b></td>
											<td class="textright">$87.50</td>
										</tr>
										<tr>
											<td class="textright"><b>Total:</b></td>
											<td class="textright">$589.50</td>
										</tr>
									</tbody>
								</table>
								<div class="well pull-right buttonwrap">
									<a class="btn btn-orange" href="#">View Cart</a> <a
										class="btn btn-orange" href="#">Checkout</a>
								</div></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div id="categorymenu">
			<nav class="subnav">
			<ul class="nav-pills categorymenu">
				<li><a class="active" href="index-2.html">Home</a>
					<div>
						<ul>
							<li><a href="index2.html">Home Style 2</a></li>
							<li><a href="index3.html">Home Style 3</a></li>
							<li><a href="index4.html">Home Style 4</a></li>
							<li><a href="index5.html">Home Style 5</a></li>
							<li><a href="index6.html">Home Style 6</a></li>
							<li><a href="index-2.html">Home Style 1</a></li>
						</ul>
					</div></li>
				<li><a href="product.html">Products</a>
					<div>
						<ul>
							<li><a href="product.html">Product style 1</a></li>
							<li><a href="product2.html">Product style 2</a></li>
							<li><a href="#"> Women's Accessories</a></li>
							<li><a href="#">Men's Accessories <span
									class="label label-success">Sale</span>
							</a></li>
							<li><a href="#">Dresses </a></li>
							<li><a href="#">Shoes <span class="label label-warning">(25)</span>
							</a></li>
							<li><a href="#">Bags <span class="label label-info">(new)</span>
							</a></li>
							<li><a href="#">Sunglasses </a></li>
						</ul>
						<ul>
							<li><img src="img/proudctbanner.jpg" alt="" title="">
							</li>
						</ul>
					</div></li>
				<li><a href="category.html">Categories</a></li>
				<li><a href="shopping-cart.html">Shopping Cart</a></li>
				<li><a href="checkout.html">Checkout</a></li>
				<li><a href="compare.html">Compare</a></li>
				<li><a href="blog.html">Blog</a>
					<div>
						<ul>
							<li><a href="blog.html">Blog page</a></li>
							<li><a href="bloglist.html">Blog List VIew</a></li>
						</ul>
					</div></li>
				<li><a href="myaccount.html">My Account</a>
					<div>
						<ul>
							<li><a href="myaccount.html">My Account</a></li>
							<li><a href="login.html">Login</a></li>
							<li><a href="register.html">Register</a></li>
							<li><a href="wishlist.html">Wishlist</a></li>
						</ul>
					</div></li>
				<li><a href="features.html">Features</a></li>
				<li><a href="contact.html">Contact</a></li>
			</ul>
			</nav>
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
						<li><a href="blog.html">认证店铺 </a></li>
						<li><a href="查看记录.html">查看记录 </a></li>
						<li><a href="addItem.jsp">商品上架 </a></li>
						<li><a href="shopItem.do?shopid=1">商品管理</a></li>
						<li><a href="店铺基本信息.html">店铺信息管理</a></li>
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
							<span>修改商品信息</span>
						</h2>
						<ul class="margin-none">
							<li class="listblcok">
								<div class="mb20">
									<section class="leavecomment">
									<div align="center">
										<form action="changeItem.do?id=${change.item_id}"
											method="post" enctype="multipart/form-data">
											<table>
												<tr>
													<div class="control-group">
														<td>商品名称:</td>
														<div class="controls">
															<td><input type="text" name="name"
																value=${change.name}></td>
														</div>
													</div>
												</tr>
												<tr>
													<div class="control-group">
														<div class="controls">
															<td>商品原本类型:</td>
															<td>>${change.typeh}> ${change.typel}</td>
														</div>
													</div>
												</tr>
												<tr>
													<div class="control-group">
														<td>商品类型选择:</td>
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
																value=${change.number
																}
																onkeyup="value=value.replace(/[^(\d)]/g,'')" /></td>
														</div>
													</div>
												</tr>
												<tr>
													<div class="control-group">
														<td>商品价格:¥</td>
														<div class="controls">
															<td><input type="text" name="price"
																value=${change.price } /></td>
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
															<td><input type="text" name="image"
																value=${change.image } /></td>
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
															<td><input type="text" name="detail"
																value=${change.detail } /></td>
														</div>
													</div>
												</tr>
											</table>
											<input type="submit" value="确认修改" value=${change.image } />
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
	<footer style="margin-top:20px"> <img
		src="${pageContext.request.contextPath}/image/footer-tri.png"
		style="width: 100%;">
	<div
		style="margin: 0px 0px 10px; text-align: center; padding-top: 10px;">

		<span>友情链接/</span> <a href="http://www.nwpu.edu.cn/" target="_top"
			class="links">西北工业大学</a>

	</div>
	<div style="text-align: center; margin-bottom: 10px;">
		<a id="fd_footer" href="addComment.jsp">产品意见反馈</a> <a
			href="http://www.2shoujie.com/joinUs" target="_top">加入我们</a>
	</div>
	<div style="text-align: center; margin-bottom: 10px;">
		<span>©2017 版权所有</span> <span>鄂ICP备14003265号-2</span>
	</div>
	</footer>
	</form>
	</div>
</body>
</html>