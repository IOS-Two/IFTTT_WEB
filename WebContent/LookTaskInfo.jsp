<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Task, Action.TaskOperation"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function showSelect() {
		var obj = document.getElementById("taskname");
		var index = obj.selectedIndex;
		for (var i = 0; i < obj.length; i++) {
			if (i == index) {
				document.getElementById("" + i).style.display = "block";
			} else
				document.getElementById("" + i).style.display = "none";
		}

	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<select id="taskname" name="taskname" onchange="showSelect()">
			<%
				for (int i = 0; i < TaskOperation.taskList.size(); i++) {
			%>
			<option value=i>
				<%
					out.print(TaskOperation.taskList.get(i).getTaskName());
				%>
			</option>
			<%
				}
			%>
		</select>
		<%
			for (int i = 0; i < TaskOperation.taskList.size(); i++) {
				String temp = String.valueOf(i);
				if (i == 0) {
		%>
		<div id=<%=temp%> style="display: block">
			<p>
				<%
					out.println(TaskOperation.taskList.get(i).getInfo());
				%>
			</p>
		</div>
		<%
			} else {
		%>
		<div id=<%=temp%> style="display: none">
			<p>
				<%
					out.println(TaskOperation.taskList.get(i).getInfo());
				%>
			</p>
		</div>
		<%
			}
			}
		%>
		<select id="status" name="status">
		<option value=1>开始</option>
		<option value=2>暂停</option>
		<option value=3>停止</option>
		<option value=4>删除</option>
		</select>
		<br>
		<input type="submit" name="submit"><br>
	</form>
</body>
</html>