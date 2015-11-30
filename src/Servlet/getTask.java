package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.DatabaseAccount;
import Trigger.Trigger;
import model.Account;

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
		HttpSession session1 = request.getSession();
		String username = (String) session1.getAttribute("username");
		String password = (String) session1.getAttribute("password");
		System.out.println(username + " " + password);
		Account temp = new Account(username, password);
		Account account = DatabaseAccount.search(temp);
		int thistype = Integer.parseInt((String) request.getParameter("this"));
		int thattype = Integer.parseInt((String) request.getParameter("that"));
		System.out.println(thistype + " " + thattype);
		getTrigger(request, thistype);
		doGet(request, response);
	}

	protected Trigger getTrigger(HttpServletRequest request, int thistype) {
		Trigger trigger = null;
		if (thistype == 0) {
			String Date = request.getParameter("Date");
			String Time = request.getParameter("Time");
			System.out.println(Date);
			System.out.println(Time);
		} else if (thistype == 1) {
			String MailID = request.getParameter("MailId1");
			String Mailpass = request.getParameter("MailPass1");
			System.out.println(MailID);
			System.out.println(Mailpass);
		} else if (thistype == 2) {
			String WeiboId = request.getParameter("WeiboId1");
			String WeiboPattern = request.getParameter("weiboPattern");
			System.out.println(WeiboId);
			System.out.println(WeiboPattern);
		} else {
			String WeiboId = request.getParameter("WeiboId2");
			String during = request.getParameter("during");
			System.out.println(WeiboId);
			System.out.println(during);
		}
		return trigger;
	}

}
