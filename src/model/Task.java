package model;

import Trigger.TimeTrigger;
import Trigger.Trigger;

import java.io.IOException;

import javax.mail.MessagingException;

import Action.Action;

public class Task implements Runnable {

	private int tid;
	private String username;
	private String taskName;
	private int status;
	private Action action;
	private Trigger trigger;
	private int thistype;
	private int thattype;
	private String thatId; // weiboid mailid
	private String thatPass; // weibopassword mailpassword
	private String thatContent; // weibocontent mailcontent
	private String thatRec; // mailRec
	private String thatSub; // mailSub
	private String thisstr1; // Date weiboid mailid weiboid
	private String thisstr2; // time weibocontent mailpassword duringTime

	private static final int INIT = -1;
	private static final int RUNNING = 1;
	private static final int STOP= 2;
	private static final int PAUSE = 3;


	private static final int sendWeibo = 0;
	private static final int sendMail = 1;

	private static final int timeTrigger = 0;
	private static final int mailTrigger = 1;
	private static final int weiboContentTrigger = 2;
	private static final int weiboTimeTrigger = 3;

	public Task(int tid, String username, String taskname) {
		// TODO Auto-generated constructor stub
		this.tid = tid;
		this.username = username;
		this.taskName = taskname;
		this.status = RUNNING;
	}

	public String getInfo() {
		String Info = "Taskname:" + taskName + "\n" + "user:" + username + "\n" + "status:" + status + "\n"
				+ trigger.getInfo() + action.getInfo();
		return Info;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Trigger getTrigger() {
		return trigger;
	}

	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}

	public int getThistype() {
		return thistype;
	}

	public void setThistype(int thistype) {
		this.thistype = thistype;
	}

	public int getThattype() {
		return thattype;
	}

	public void setThattype(int thattype) {
		this.thattype = thattype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (status == RUNNING) {
				try {
					if (trigger.THIS()) {
						action.THAT();
						if (this.trigger instanceof TimeTrigger) {
							status = STOP;
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
