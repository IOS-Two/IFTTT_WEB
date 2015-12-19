<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="model.Task, Action.TaskOperation, Database.DatabaseTask"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择要修改的任务</title>
</head>
<body>
	<form action = "getChooseTaskTid" method="post">
		<h1>请选择你要修改的任务</h1>
		<select id="status" name="tid">
			<%
				HttpSession session1 = request.getSession();
				String username = (String) session1.getAttribute("username");
				for (int i = 0; i < TaskOperation.taskList.size(); i++) {
					if (TaskOperation.taskList.get(i).getUsername().equals(username)) {
						Task task = TaskOperation.taskList.get(i);
						out.print("<option value=" + task.getTid() + ">" + task.getTaskName() + "</option>");
					}
				}
			%>
		</select><br>
		<input type="submit" value="确认">
	</form>
</body>
</html>