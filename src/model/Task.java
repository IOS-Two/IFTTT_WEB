package model;

import Trigger.Trigger;
import Action.Action;

public class Task implements Runnable{
	
	private int tid;
	private String username;
	private String taskName;
	private int status;
	private Action action;
	private Trigger trigger;
	private int thistype;
	private int thattype;
	private String thatId;
	private String thatPass;
	private String thatContent;
	private String thatRec;
	private String thatSub;
	private String thisDate;
	private String thisTime;
	private String thisDuring;
	private String thisId;
	private String thisPass;
	
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

	public Task(int tid, String username, String taskname) {
		// TODO Auto-generated constructor stub
		this.tid = tid;
		this.username = username;
		this.taskName = taskname;
		this.status = INIT;
	}
	
    public String getInfo () {
    	String Info = "Taskname:" + taskName + "\n"
    			+ "user:" + username + "\n"
    			+ "status:" + status + "\n"
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
		while(true) {
			if (trigger.THIS())
				action.THAT();
		}
	}

	public String getThatId() {
		return thatId;
	}

	public void setThatId(String thatId) {
		this.thatId = thatId;
	}

	public String getThatPass() {
		return thatPass;
	}

	public void setThatPass(String thatPass) {
		this.thatPass = thatPass;
	}

	public String getThatContent() {
		return thatContent;
	}

	public void setThatContent(String thatContent) {
		this.thatContent = thatContent;
	}

	public String getThatRec() {
		return thatRec;
	}

	public void setThatRec(String thatRec) {
		this.thatRec = thatRec;
	}

	public String getThatSub() {
		return thatSub;
	}

	public void setThatSub(String thatSub) {
		this.thatSub = thatSub;
	}

	public String getThisDate() {
		return thisDate;
	}

	public void setThisDate(String thisDate) {
		this.thisDate = thisDate;
	}

	public String getThisTime() {
		return thisTime;
	}

	public void setThisTime(String thisTime) {
		this.thisTime = thisTime;
	}

	public String getThisDuring() {
		return thisDuring;
	}

	public void setThisDuring(String thisDuring) {
		this.thisDuring = thisDuring;
	}

	public String getThisId() {
		return thisId;
	}

	public void setThisId(String thisId) {
		this.thisId = thisId;
	}

	public String getThisPass() {
		return thisPass;
	}

	public void setThisPass(String thisPass) {
		this.thisPass = thisPass;
	}

}
