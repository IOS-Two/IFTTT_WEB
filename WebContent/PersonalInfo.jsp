<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Database.DatabaseAccount, model.Account"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PersonalInfo</title>
</head>
<body>
	<h1>个人信息</h1>
	<%
		HttpSession session2 = request.getSession();
		String username = (String)session2.getAttribute("username");
		String password = (String)session2.getAttribute("password");
		Account a = DatabaseAccount.search(new Account(username, password,""));
		int money = a.getMoney();
		int level = a.getLevel();
	%>
	<!-- form action="modifyPersonalInfo" method = "post" -->
	username:<input id="username" name="username" type="text" value = <%=username %>><br>
	<% out.print("money:" + money); %><br>
	<% out.print("level:" + level); %><br>
	
</body>
</html>