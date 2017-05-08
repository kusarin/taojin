<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
 <title>订单评价</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
 
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sureOrder.css"/>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/flexslider.css" type="text/css" media="screen" rel="stylesheet"  />
<link href="${pageContext.request.contextPath}/css/jquery.fancybox.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/cloud-zoom.css" rel="stylesheet">
</head>
<script>
function commit(){
	 var addr=document.getElementsByName("score");
	 var sc=document.getElementById("sc").value;
	  var i=-1;
	 
	  for( var j=0;j<addr.length;j++){
		  if(addr[j].checked){
			  i++;
			  break;
		  }
	  }
	  if(i==-1 || sc.length==0){
		  alert("请选择评论");
		  return;
	  }else{
		  document.myform.action="commitEval.do";
	    	 // $(".myform")
	       document.myform.submit();
	  }
}
</script>
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
						<form class="form-search top-search" action="searchItem.do?page=1" method="post">
							<input type="text" class="input-medium search-query"
								placeholder="搜索你想要的二手"/ style="border:4px solid #FFA07A;">
								<input type="submit" value="搜索"
								style="height:42px;width:auto;background-color:#FFA07A;margin-left:-4px;border:4px solid #FFA07A;"/>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</header>
	<!-- Header End -->
	
<div class="containers">

<form action="" name="myform" method="post">

<div style="margin-top:30px;height:auto;">
<div style="float:left; margin-left:390px;">
   <img src="${pageContext.request.contextPath}${it.image}" style="width:100px;height:120px;">
   <p style="width:100px;height:90px;overflow:hidden;text-overflow:ellipsis;white-space: nowrap;">${it.name}</p>
</div>
<input type="hidden" name="itemId" value="${it.item_id}">
<div style="margin-left:550px;margin-top:20px; width:50px;">
<input type="radio" name="score" value="5"><img src="image/3.jpg" style="margin-top:-30px;margin-left:20px;"/> 
<input type="radio" name="score" value="3" style="margin-top:-93px;margin-left:130px;"><img src="image/2.jpg" style="margin-top:-120px;margin-left:150px;"/>
<input type="radio" name="score" value="1" style="margin-top:-167px;margin-left:250px;"><img src="image/1.jpg" style="margin-top:-200px;margin-left:270px;"/>
</div>
<div style="margin-left:550px;margin-top:-60px; width:100px;">
     <p>评论内容：</p>
	 <input type="text" id="sc" name="content" placeholder="分享你的感受" style="height:100px;width:500px;">
</div>
</div>
<div style="margin-top:20px;margin-left:550px;">
<input type="button" value="提交" style="width:150px;height:40px;" onclick="commit()">
</div>
</form>
</div>
<!-- footer-->	
	<footer style="margin-top:20px">
       <img  src="image/footer-tri.png" style="width:100%;">
            <div style="margin: 0px 0px 10px;text-align:center;padding-top:10px;">
			 
             <span>友情链接/</span>
                <a href="http://www.nwpu.edu.cn/" target="_top" class="links">西北工业大学</a>
				
            </div>
            <div style="text-align:center;margin-bottom:10px;">
               <a id="fd_footer" href="javascript:;">产品意见反馈</a>
               <a href="http://www.2shoujie.com/joinUs" target="_top">加入我们</a>
            </div>
        <div style="text-align:center;margin-bottom:10px;">
            <span>?2017   版权所有</span>
            <span>鄂ICP备14003265号-2</span>
        </div>
    </footer>
 </body>
</html>