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
var shu=0;
//信息
var massages="";
var massagepro="";
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

function loadMassage(){
	$.ajax({
		data: "num="+massageNumber,
		url: "loadData.do",
		success: function(msg){
			eval("res="+msg);
			//当前信息总数
			massageNumber=parseInt(res.massageNumber);
			//当前信息
			massages+=res.massage;
			document.body.innerHTML="无新消息";
			show_push();
		}
	});
}

function show_push(){
	massagepro = res.massage;
	massages+=res.massage;
	if(massagepro != massages)
		{
		document.body.innerHTML="有未读新消息";
		}
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