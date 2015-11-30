<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function showWeiboThat() {
		document.getElementById("WeiboThat").style.display = "block";
		document.getElementById("MailThat").style.display = "none";
	}
	function showMailThat() {
		document.getElementById("WeiboThat").style.display = "none";
		document.getElementById("MailThat").style.display = "block";
	}
	function showTimeThis() {
		document.getElementById("TimeTriggerThis").style.display = "block";
		document.getElementById("WeiboTriggerThis").style.display = "none";
		document.getElementById("MailTriggerThis").style.display = "none";
		document.getElementById("WeiboTimeTriggerThis").style.display = "none";
	}
	function showMailThis() {
		document.getElementById("TimeTriggerThis").style.display = "none";
		document.getElementById("WeiboTriggerThis").style.display = "none";
		document.getElementById("MailTriggerThis").style.display = "block";
		document.getElementById("WeiboTimeTriggerThis").style.display = "none";
	}
	function showWeiboThis() {
		document.getElementById("TimeTriggerThis").style.display = "none";
		document.getElementById("WeiboTriggerThis").style.display = "block";
		document.getElementById("MailTriggerThis").style.display = "none";
		document.getElementById("WeiboTimeTriggerThis").style.display = "none";
	}
	function showWeiboTimeThis() {
		document.getElementById("TimeTriggerThis").style.display = "none";
		document.getElementById("WeiboTriggerThis").style.display = "none";
		document.getElementById("MailTriggerThis").style.display = "none";
		document.getElementById("WeiboTimeTriggerThis").style.display = "block";
	}
</script>
<style type="text/css">
div#container {
	width: 800px
}

div#header {
	background-color: #99bbbb;
}

div#menu {
	background-color: #ffff99;
	height: 430px;
	width: 130px;
	float: left;
}

div#content {
	background-color: #EEEEEE;
	height: 400px;
	width: 670px;
	float: left;
}

div#ThisThatChoose {
	height: 400px;
	width: 200px;
	float: left;
}

div#This {
	height: 400px;
	width: 200px;
	float: left;
}

div#That {
	height: 400px;
	width: 200px;
	float: left;
}

div#button {
	height: 30px;
	width: 670px;
	float: right;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TaskManangement</title>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>
				<%
					HttpSession session1 = request.getSession();
					String username = (String) session1.getAttribute("username");
					out.println(username + "的任务管理");
				%>
			</h1>
		</div>
		<div id="menu">
			<ul>
				<li><a href="#">新建任务</a></li>
				<li><a href="#">查看任务</a></li>
				<li><a href="#">修改任务</a></li>
			</ul>
		</div>
		<div id="content">
			<form method="post" action="getTask">
				<div id="ThisThatChoose">
					任务名:<br> <input type="text" name="taskname" id="taskname">
					<h3>THIS</h3>
					<input type="radio" value=0 checked="checked" name="this"
						id="timeTrigger" onchange="showTimeThis()"> 定时发送<br>
					<input type="radio" value=1 name="this" id="MailTrigger"
						onchange="showMailThis()"> 收到邮件<br> <input
						type="radio" value=2 name="this" id="WeiboTrigger"
						onchange="showWeiboThis()"> 微博内容<br> <input
						type="radio" value=3 name="this" id="WeiboTimeTrigger"
						onchange="showWeiboTimeThis()"> 微博持续时间未发<br>
					<h3>THAT</h3>
					<input type="radio" checked="checked" name="that" id="MailAction"
						onchange="showMailThat()" value=1> 邮件<br> <input
						type="radio" name="that" id="WeiboAction"
						onchange="showWeiboThat()" value=0> 微博<br>
				</div>
				<div id="This">
					<h3>THIS:</h3>
					<div id="TimeTriggerThis" style="display: block">
						日期：<br> <input type="text" name="Date" id="Date"> <br>
						时间：<br> <input type="text" name="Time" id="Time"> <br>
					</div>
					<div id="MailTriggerThis" style="display: none">
						邮箱：<br> <input type="text" name="MailId1" id="MailId1">
						<br> 密码：<br> <input type="password" name="MailPass1"
							id="MailPass1"> <br>
					</div>
					<div id="WeiboTriggerThis" style="display: none">
						微博ID：<br> <input type="text" name="WeiboId1" id="WeiboId1">
						<br> 内容：<br>
						<textarea rows="10" cols="23" name="weiboPattern"
							id="weiboPattern"> </textarea>
						<br>
					</div>
					<div id="WeiboTimeTriggerThis" style="display: none">
						微博ID：<br> <input type="text" name="WeiboId2" id="WeiboId2">
						<br> 持续时间:<br> <input type="text" name="during"
							id="during"> <br>
					</div>
				</div>
				<div id="That">
					<h3>THAT:</h3>
					<div id="WeiboThat" style="display: block">
						微博账户：<input type="text" name="weiboid" id="weiboid"><br>
						微博密码：<input type="password" name="weibopassword"
							id="weibopassword"><br> 微博内容:
						<textarea rows="10" cols="30" name="weibocontent"
							id="weibocontent">
						</textarea>
						<br>
					</div>
					<div id="MailThat" style="display: none">
						收件人：<input type="text" name="Mailrec" id="Mailrec"><br>
						主题：<br> <input type="text" name="Mailsub" id="Mailsub"><br>
						微博内容:
						<textarea rows="10" cols="30" name="Mailcontent" id="Mailcontent">
						</textarea>
						<br>
					</div>
				</div>
				<div id="button">
					<input type="submit" value="确认"> <input type="reset"
						value="取消">
				</div>
			</form>
		</div>
	</div>
</body>
</html>