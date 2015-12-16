package Trigger;

import java.util.Calendar;
import java.util.Date;

public class TimeTrigger extends Trigger{

	private Calendar time;
	private String time1;
	private String date;
	public TimeTrigger(String Date, String Time) {
		// TODO Auto-generated constructor stub
		this.type = timeTrigger;
		this.date = Date;
		this.time1 = Time;
		String[] dataDivide = date.split("-");
		String[] timeDicide = time1.split(":");
		int year = Integer.parseInt(dataDivide[0]);
		int month = Integer.parseInt(dataDivide[1]);
		int day = Integer.parseInt(dataDivide[2]);
		int hour = Integer.parseInt(timeDicide[0]);
		int minute = Integer.parseInt(timeDicide[1]);
		int second = Integer.parseInt(timeDicide[2]);
		this.time.set(year, month - 1, day, hour, minute, second);
		
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
		Date time1 = this.time.getTime();
		if (now.compareTo(time1) >= 0) {
			return true;
		}
		return false;
	}

}
