<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>参考售价</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.mn.js"></script>

<script>
	function s(){
		 var s=$("#code").find('option:selected').text();
			$.ajax({
				url : "getRefPrice.do",
				type : "get",
				data : "typel=" + s,
				contentType : "application/json;charset=utf-8",
				dataType : "json",
				error : function(data) {
					alert("获取失败");
				},
				success : function(data) {
					
					var pr=document.getElementsByName("price");
					for(var i=0;i<data.length;i++){
						pr[i].value=""+data[i].toFixed(3);
					}
					//window.location.reload();

				}
			});
		

	}
</script>

</head>
<body>
	<select id="code" name="typel">
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
			<option value="音响">音响</option>
			<option value="耳机">耳机</option>
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
	</select>
	<input type="text"  placeholder="最低价" value="" readonly="readonly" name="price">
    <span>-</span>
	<input type="text"  placeholder="平均价" value="" readonly="readonly" name="price">
	<span>-</span>
	<input type="text"  placeholder="最高价" value="" readonly="readonly" name="price">
	<span>-</span>
	<input type="button" onclick="s()" value="获取参考售价">
	
</body>
</html>