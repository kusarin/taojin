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
<link href="./css/shopSearch.css" rel="stylesheet">
<script type="text/javascript">
	function setTab(name, m, n) {
		for ( var i = 1; i <= n; i++) {
			var menu = document.getElementById(name + i);
			var showDiv = document.getElementById("cont_" + name + "_" + i);
			menu.className = i == m ? "on" : "";
			showDiv.style.display = i == m ? "block" : "none";
		}
	}
	function key(s) {
		if(s==1){
			var k=document.getElementById("key");
			k.style.display='block';
			 var k1=document.getElementById("key1");
			 k1.style.display='none';
		}
		 if(s==2){
			 var k1=document.getElementById("key1");
			 k1.style.display='block'; 
			 var k=document.getElementById("key");
			 k.style.display='none';
		 }
	}
	function ch(){
		var k=document.getElementById("key");
		k.style.display='none';
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
											style="height: 20px; width: 100; border: 4px solid #FFA07A" onclick="key(1)" onchange="ch()">
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
											style="height: 20px; width: 100; border: 4px solid #FFA07A"
											onclick="key(2)" onchange="ch()"> <input type="submit" value="搜索"
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
	<div id="key" style="width: 183px; border: 1px solid gray; height: auto;float:right;margin-right:140px;border-top: 1px solid #FFA07A;display:none;">
		<c:forEach items="${keyw}" var="k">
		
		
		<p style="width: 180px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;"><a href="searchItem.do?page=1&str=${k.keyWord}">${k.keyWord}</a></p>
     
      </c:forEach>	
    </div>
    
<div id="key1" style="width: 183px; border: 1px solid gray; height: auto;float:right;margin-right:140px;border-top: 1px solid #FFA07A;display:none;">
		<c:forEach items="${keyw}" var="k">
		<p style="width: 180px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;"><a href="searchShop.do?page=1&str=${k.keyWord}">${k.keyWord}</a></p>
         </c:forEach>	
    </div>

	
</body>
</html>