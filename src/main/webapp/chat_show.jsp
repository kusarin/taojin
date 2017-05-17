<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.mn.js"></script>
<script type="text/javascript">
//信息总数
var massageNumber=0;
//信息
var massages="";
var id;
var isScroll=false;
//加载信息
window.onload=function(){
	window.setInterval(function(){
		loadMassage();
		if(!isScroll){
		 	scroll();
		 }
	},1000);
}
//自动滚动
function scroll(){
	isScroll=true;
	id = window.setInterval(function(){
		window.scrollTo(0,document.body.offsetHeight);
	},500);
}
//停止滚动
window.onscroll=function(){
	isScroll=false;
	window.clearInterval(id);
}

function loadMassage(){
	$.ajax({
			data: "num="+massageNumber,
			url: "loadData.do",
			success: function(msg){
				eval(msg);
				//当前信息总数

				massageNumber=parseInt(msg.massageNumber);
				//当前信息
				massages+=msg.massage;
				document.body.innerHTML=massages;
			}
		});
}
</script>

<style type="text/css">
body {
	font-size: 12px;
	margin: 0px;
	line-height: 18px;
	padding-left: 5px;
}
</style>
	</head>
<body>
</body>
</html>