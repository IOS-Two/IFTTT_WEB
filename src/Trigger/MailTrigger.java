package Trigger;

public class MailTrigger extends Trigger {
	private String MailId;
	private String MailPassword;
	private String MailCount;

	public MailTrigger(String MailId, String MailPassword) {
		// TODO Auto-generated constructor stub
		this.MailId = MailId;
		this.MailPassword = MailPassword;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean THIS() {
		// TODO Auto-generated method stub
		return false;
	}

}
