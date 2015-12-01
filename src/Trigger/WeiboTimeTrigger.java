package Trigger;

public class WeiboTimeTrigger extends Trigger{
	private String WeiboId;
	private String during;

	public WeiboTimeTrigger(String WeiboId, String during) {
		// TODO Auto-generated constructor stub
		this.during = during;
		this.WeiboId = WeiboId;
		this.type = weiboTimeTrigger;
	}
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		String Info = "ListenedWeiboID" + WeiboId + "\n"
				+ "During:" + during + "\n";
		return Info;
	}

	@Override
	public boolean THIS() {
		// TODO Auto-generated method stub
		return false;
	}

}
