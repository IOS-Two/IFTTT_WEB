package Trigger;

import java.util.Date;

public class TimeTrigger extends Trigger{

	Date time;
	public TimeTrigger(Date time) {
		// TODO Auto-generated constructor stub
		this.type = timeTrigger;
		this.time = time;
	}
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		
		return null;
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
