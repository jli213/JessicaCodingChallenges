package oosequence;

import java.util.Date;

public class TripComponent {

	private Date start = null;
	private Date end = null;

	public TripComponent(Date startTime, Date endTime) {
		if(startTime == null || endTime == null) {
			start = startTime;
			end = endTime;
		}
		else {
			if(startTime.before(endTime)) {
				start = startTime;
				end = endTime;
			}
			else {
				start = startTime;
				end = null;
			}
		}
	}

	public TripComponent(TripComponent toCopy) {
		start = toCopy.start;
		end = toCopy.end;
	}

	public TripComponent() {
		start = new Date();
		end = new Date(start.getTime()+3600000);
		// TODO Auto-generated constructor stub
	}

	public long lengthInSeconds() {
		long time;
		if(end == null || start == null) {
			return 0;
		}
		else {
			time = end.getTime() - start.getTime();
		}
		return time/1000;
	}

	public Date getEnd() {
		// TODO Auto-generated method stub
		return end;
	}

	public Date getStart() {
		// TODO Auto-generated method stub
		return start;
	}
	
	public void setStart(Date startTime) {
		// TODO Auto-generated method stub
		if(startTime == null ||end == null) {
			start = startTime;
		}
		else {
			if(startTime.before(end)) {
				start = startTime;
			}
		}
	}

	public void setEnd(Date endTime) {
		// TODO Auto-generated method stub
		if(endTime == null || start == null) {
			end = endTime;
		}
		else {
			if(start.before(endTime)) {
				end = endTime;
			}
		}
	}



}
