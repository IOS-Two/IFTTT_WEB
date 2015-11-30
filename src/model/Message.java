package model;

import java.util.Date;

public class Message {
	private String sourceid;
	private String receiveid;
	private String content;
	private boolean isAdminMessage;
	private Date time;

	public String getSourceid() {
		return sourceid;
	}

	public void setSourceid(String sourceid) {
		this.sourceid = sourceid;
	}

	public String getReceiveid() {
		return receiveid;
	}

	public void setReceiveid(String receiveid) {
		this.receiveid = receiveid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isAdminMessage() {
		return isAdminMessage;
	}

	public void setAdminMessage(boolean isAdminMessage) {
		this.isAdminMessage = isAdminMessage;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
