<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
	window.onload = function() {
		var error = "${requestScope.error}";
		if (error != "" && error != null && typeof (error) != "undefined") {
			alert(error);
		}
	}
</script>
<title>二手淘金网在线咨询</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./TaoJin/css/bootstrap.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./TaoJin/css/style.css" rel="stylesheet">
<link href="./TaoJin/css/flexslider.css" type="text/css" media="screen"
	rel="stylesheet" />
<link href="./TaoJin/css/jquery.fancybox.css" rel="stylesheet">
<link href="./TaoJin/css/cloud-zoom.css" rel="stylesheet">
<link rel="shortcut icon" href="assets/ico/favicon.html">
<link href="./css/shopSearch.css" rel="stylesheet">
<script type="text/javascript">
	function setTab(name, m, n) {
		for (var i = 1; i <= n; i++) {
			var menu = document.getElementById(name + i);
			var showDiv = document.getElementById("cont_" + name + "_" + i);
			menu.className = i == m ? "on" : "";
			showDiv.style.display = i == m ? "block" : "none";
		}
	}
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.mn.js"></script>

<script type="text/javascript">
var content;
function send(){
	var con = document.getElementById("content");
	var	content = con.value;
	content = content.replace(/\n/g,"<br>&nbsp&nbsp").replace(/\s/g,"&nbsp&nbsp");
	content = encodeURIComponent(content);
	if(content.length==0){
		alert("内容不能空！");
		con.focus();
	}else{
		$.ajax({
			url: "sendMassage.do",
			data: "content="+content,
			success: function(msg){
				alert(1);
				eval("result="+msg);
				con.value="";
			}
		});
		$.ajax({
			data: "num="+massageNumber,
			url: "loadData.do",
			success: function(msg){
				eval("res="+msg);
				//当前信息总数
				massageNumber=parseInt(res.massageNumber);
				//当前信息
				massages+=res.massage;
			}
		});
	}
}

function sendbykey(event){
	//得到当前事件对象
	var event=window.event||event;
	//当按下enter时触发
	if(event.keyCode==13){
	 	send();
	}else if(event.ctrlKey&&event.keyCode==13){
	//	var con = document.getElementById("content");
	//	content = content+con.value+"<br>";
	}
}

//window.onunload =function exit_confirm(){
function exit_confirm(){
	var sure = window.confirm("确定退出聊天室吗！");
	if(sure == true){
		 exit();
	}
	else if(sure == false){
		return false;
		//event.returnValue=false;
	}
}

function exit(){
	$.ajax({
		url: "exit.do",
		data: "",
		success: function(msg){
			window.location.href = "chat_login.jsp";
		}
		
	});
}
</script>
<style type="text/css">
body{
	background:  #ECF3F6;
	font: 13px normal;
	color: green;
}

table {
	width: 100%;
	height: 100%;
	border: 1px solid #BED6E0;
}

td {border: 1px solid #BED6E0;}

input {width: 60px;border-color: #BED6E0;background-color: #EFF4F7}
</style>
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
	<center>
	<div style="width: 900px;height: 500px">
		<table cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td background="image/b.jpg" height="41" style="border: 0">
						&nbsp;二手淘金交易网在线咨询
					</td>
				</tr>
				<tr>
					<td background="image/a.jpg" height="29" align="left">
						&nbsp;欢迎！${sessionScope.username }
					</td>
				</tr>
				<tr style="width: 100%;height: 430px">
					<td style="border: 0" height="430px" width="100%">
						<table cellpadding="0" cellspacing="10" style="border: 0;">
							<tbody>
								<tr >
									<td style="border: 0;">
										<iframe src="chat_show.jsp" name="chat" width="710px" height="350px">
										</iframe>
									</td>
									<td rowspan="3" style="border: 0;">
										<iframe src="users.jsp" name="users" width="100%" height="505px">
										</iframe>
									</td>
								</tr>
								
								<tr>
									<td align="left">
										<textarea rows="5" id="content" style="width: 710px;height: 100px; border: 0;" onkeydown="sendbykey(event)"></textarea>
										
									</td>
								</tr>
								<tr>
									<td height="30px" align="right" style="border: 0px;">
										<input type="button" value="发送" onclick="send()">
										<input type="button" value="关闭" onclick="exit_confirm()">
									</td>
								</tr>
								
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	</center>
	<!--footer-->
	<footer style="margin-top: 100px">
		<img src="${pageContext.request.contextPath}/image/footer-tri.png"
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
			<span>?2017 版权所有</span>
		</div>
	</footer>
</body>
</html>