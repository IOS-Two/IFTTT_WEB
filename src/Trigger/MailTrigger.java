package Trigger;

public class MailTrigger extends Trigger {
	private String MailId;
	private String MailPassword;
	private String MailCount;

	public MailTrigger(String MailId, String MailPassword) {
		// TODO Auto-generated constructor stub
		this.MailId = MailId;
		this.MailPassword = MailPassword;
		this.type = mailTrigger;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		String Info = "ListenedMailID:" + MailId + "\n"
				+ "password:" + MailPassword + "\n";
		return Info;
	}

	@Override
	public boolean THIS() {
		// TODO Auto-generated method stub
		return false;
	}

}
