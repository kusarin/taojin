<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>管理员界面</title>
</head>

<body>
<h1>管理员界面——${manager.account}</h1>
<div>
  <table width="565" border="0">
    <tr>
      <td width="181"><div align="center">
        <h4><strong>管理员账户管理</strong></h4>
      </div></td>
      <td width="181"><div align="center">
        <a href="./lookComment.do"><h4><strong>用户留言管理</strong></h4></a>
      </div></td>
      <td width="181"><div align="center">
        <a href="./findResourceFile.do" ><h4><strong>文件资源管理</strong></h4></a>
      </div></td>
    </tr>
    <tr>
    <td colspan="3">
    <a href="addmanager.jsp"><strong>新增管理员</strong></a>
    </td>
    </tr>
    <tr>
    <td colspan="3">
    <a href="updateMpassword.jsp"><strong>修改密码</strong></a>
    </td>
    </tr>
  </table>
		
	</div>
</body>
</html>
