package Action;

public class MailAction extends Action {
	private String MailId;
	private String Mailpass;
	private String Mailrec;
	private String Mailsub;
	private String Mailcontent;

	public MailAction(String MailId, String Mailpass, String Mailrec, String Mailcontent, String Mailsub) {
		// TODO Auto-generated constructor stub
		this.MailId = MailId;
		this.Mailpass = Mailpass;
		this.Mailrec = Mailrec;
		this.Mailcontent = Mailcontent;
		this.Mailsub = Mailsub;
		this.type = sendMail;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		String Info = "MailID:" + MailId + "\n" 
				+ "Mailpass:" + Mailpass + "\n"
				+ "Mailrec:" + Mailrec + "\n"
				+ "Mailsub:" + Mailsub + "\n"
				+ "Mailcontent:" + Mailcontent + "\n";
		return Info;
	}

	@Override
	public void THAT() {
		// TODO Auto-generated method stub

	}

}
