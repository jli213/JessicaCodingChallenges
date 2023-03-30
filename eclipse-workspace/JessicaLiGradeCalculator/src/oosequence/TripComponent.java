package oosequence;

import java.util.Date;

public class TripComponent {

	private Date start = null;
	private Date end = null;

	public TripComponent(Date startDate, Date endDate) {
		if(startDate == null || endDate == null) {
			start = startDate;
			end = endDate;
		}
		else {
			if(startDate.before(endDate)) {
				start = startDate;
				end = endDate;
			}
			else {
				start = startDate;
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


	public String getEnd() {
		// TODO Auto-generated method stub
		if(end == null) {
			return "";
		}
		
		return end.toString();
	}

	public String getStart() {
		// TODO Auto-generated method stub
		if(start == null) {
			return "";
		}
		return start.toString();
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
	

	protected long lengthInSeconds() {
		long time;
		if(end == null || start == null) {
			return 0;
		}
		else {
			time = end.getTime() - start.getTime();
		}
		return time/1000;
	}
	
	protected boolean isBefore(TripComponent otherComponent) {
		if(start.before(otherComponent.start)) {
			return true;
		}
		else {
			return false;
		}
	}

	protected boolean overlapsWith(TripComponent otherComponent) {
		// TODO Auto-generated method stub
		if(otherComponent.start == null || otherComponent.end== null||
				end == null || start == null) { 
			return false;
		}
		if(end.getTime()>otherComponent.start.getTime()
				&& end.getTime()<otherComponent.end.getTime()) {
			return true;
			
		}
		else if(start.getTime()>otherComponent.start.getTime()
				&& start.getTime()<otherComponent.end.getTime()) {
			return true;
			
		}
		else if(start.getTime()<otherComponent.start.getTime()
				&& otherComponent.end.getTime()< end.getTime()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	



}
