package model;

import Trigger.Trigger;
import Action.Action;

public class Task implements Runnable{
	
	private String tid;
	private String username;
	private String taskName;
	private int status;
	private Action action;
	private Trigger trigger;
	private int thistype;
	private int thattype;
	
	private static final int INIT = -1;
	private static final int RUNNING = 1;
	private static final int FINISHED = 2;
	private static final int PAUSE = 3;
	private static final int STOPPED = 4;
	
	private static final int sendWeibo = 0;
	private static final int sendMail = 1;
	
	private static final int timeTrigger = 0;
	private static final int mailTrigger = 1;
	private static final int weiboContentTrigger = 2;
	private static final int weiboTimeTrigger = 3;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
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
		while(true) {
			if (trigger.THIS())
				action.THAT();
		}
	}

}
