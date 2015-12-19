<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="model.Task, Action.TaskOperation, Database.DatabaseTask"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Look task list</title>
</head>
<body>
	<form action=TaskController method="post">
	<%
		HttpSession session2 = request.getSession();
		String username = (String) session2.getAttribute("username");
		out.print("<h1>"+ username + "的任务查看控制"+"</h1>");
		for (int i = 0; i < TaskOperation.taskList.size(); i ++) {
			if (TaskOperation.taskList.get(i).getUsername().equals(username)) {
				Task task = TaskOperation.taskList.get(i);
				out.print("<input type=\"radio\" value="+task.getTid() + " name=\"task\">");
				out.print(task.getInfo()+ "<br>");
			}
		}
	%>
		<select id="status" name="status">
		<option value=1>开始</option>
		<option value=3>暂停</option>
		<option value=2>停止</option>
		<option value=100>删除</option>
		</select>
		<a href=''><input type='submit' value='确定'></input></a><br>
	</form>
</body>
</html>