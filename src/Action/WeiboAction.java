package Action;

public class WeiboAction extends Action {
	private String WeiboID;
	private String WeiboPossword;
	private String WeiboContent;
	
	public WeiboAction(String WeiboID, String WeiboPassword, String WeiboContent) {
		// TODO Auto-generated constructor stub
		this.WeiboID = WeiboID;
		this.WeiboContent = WeiboContent;
		this.WeiboPossword = WeiboPassword;
		this.type = sendWeibo;
	}
	public String getInfo() {
		String Info = "WeiboID:" + WeiboID + "\n"
					+ "WeiboPossword:" + WeiboPossword + "\n"
					+ "Weibocontent:" + WeiboContent + "\n";
		return Info;

	}
	
	public void THAT() {
		
	}
}
