<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
</head>
<body>
	<h1>
		<%
			HttpSession session1 = request.getSession();
			String username = (String) session1.getAttribute("username");
			out.println("Welcome " + username);
		%>
	</h1>
	<a href="/IFTTT/TaskManagement.jsp"> 任务管理</a>
	<a href="/IFTTT/PersonalInfo.jsp"> 个人信息</a>
	<a href="/IFTTT/MessageManagement.jsp"> 信息管理</a>
</body>
</html>