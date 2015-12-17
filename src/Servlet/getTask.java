package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Action.Action;
import Action.MailAction;
import Action.TaskOperation;
import Action.WeiboAction;
import Database.DatabaseAccount;
import Trigger.MailTrigger;
import Trigger.TimeTrigger;
import Trigger.Trigger;
import Trigger.WeiboContentTrigger;
import Trigger.WeiboTimeTrigger;
import model.Account;
import model.Task;

/**
 * Servlet implementation class getTask
 */
@WebServlet("/getTask")
public class getTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session1 = request.getSession();
		String username = (String) session1.getAttribute("username");
		String password = (String) session1.getAttribute("password");
		System.out.println(username + " " + password);

		Account temp = new Account(username, password, "");
		Account account = DatabaseAccount.search(temp);
		int thistype = Integer.parseInt((String) request.getParameter("this"));
		int thattype = Integer.parseInt((String) request.getParameter("that"));
		Task task = getTaskInfo(request, thistype, thattype, username);
		System.out.println(task.hashCode());
		System.out.println(task.getInfo());
		TaskOperation.addTask(task);

		doGet(request, response);
	}

	protected Trigger getTrigger(HttpServletRequest request, int thistype) {
		Trigger trigger = null;
		if (thistype == 0) {
			String Date = request.getParameter("Date");
			String Time = request.getParameter("Time");
			trigger = new TimeTrigger(Date, Time);
		} else if (thistype == 1) {
			String MailID = request.getParameter("MailId1");
			String Mailpass = request.getParameter("MailPass1");
			trigger = new MailTrigger(MailID, Mailpass);
		} else if (thistype == 2) {
			String WeiboId = request.getParameter("WeiboId1");
			String WeiboPattern = request.getParameter("weiboPattern");
			trigger = new WeiboContentTrigger(WeiboId, WeiboPattern);
		} else {
			String WeiboId = request.getParameter("WeiboId2");
			String during = request.getParameter("during");
			trigger = new WeiboTimeTrigger(WeiboId, during);
		}
		return trigger;
	}

	protected Action getAction(HttpServletRequest request, int thattype) {
		Action action = null;
		if (thattype == 0) {
			String WeiboID = request.getParameter("weiboid");
			String weibopassword = request.getParameter("weibopassword");
			String weiboContent = request.getParameter("weibocontent");
			action = new WeiboAction(WeiboID, weibopassword, weiboContent);
		} else {
			String MailId = request.getParameter("MailId");
			String MailPass = request.getParameter("Mailpass");
			String MailRec = request.getParameter("Mailrec");
			String Mailsub = request.getParameter("Mailsub");
			String MailContent = request.getParameter("Mailcontent");
			action = new MailAction(MailId, MailPass, MailRec, MailContent, Mailsub);
		}
		return action;
	}

	protected Task getTaskInfo(HttpServletRequest request, int thistype, int thattype, String username) {
		String taskName = request.getParameter("taskname");
		Task task = new Task(0, username, taskName);
		task.setThistype(thistype);
		task.setThattype(thattype);
		task.setAction(getAction(request, thattype));
		task.setTrigger(getTrigger(request, thistype));
		task.setTid(task.hashCode());
		return task;
	}
}
