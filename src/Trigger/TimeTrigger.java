package Trigger;

import java.util.Date;

public class TimeTrigger extends Trigger{

	private Date time;
	private String time1;
	private String date;
	public TimeTrigger(String Date, String Time) {
		// TODO Auto-generated constructor stub
		this.type = timeTrigger;
		this.date = Date;
		this.time1 = Time;
	}
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		String Info = "ListenedDate:" + date + "\n"
				+ "Time:" + time1 + "\n";
		return Info;
	}

	@Override
	public boolean THIS() {
		// TODO Auto-generated method stub
		Date now = new Date();
		if (now.compareTo(time) >= 0) {
			return true;
		}
		return false;
	}

}
