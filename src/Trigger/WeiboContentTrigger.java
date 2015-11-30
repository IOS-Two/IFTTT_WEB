package Trigger;

public class WeiboContentTrigger extends Trigger{

	private String WeiboId;
	private String pattern;
	public WeiboContentTrigger(String WeiboId, String pattern) {
		// TODO Auto-generated constructor stub
		this.WeiboId = WeiboId;
		this.pattern = pattern;
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
