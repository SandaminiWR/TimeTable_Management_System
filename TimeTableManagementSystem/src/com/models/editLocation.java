package com.models;

import javax.swing.JComboBox;

public class editLocation {
	
	private int loc_ID;
	private String room;
	private String day;
	private String stratTime;
	private String endTime;
	
	
	
	
	
	public editLocation() {
		super();
		// 
	}


	public editLocation(int loc_ID, String room, String day, String stratTime, String endTime) {
		super();
		this.loc_ID = loc_ID;
		this.room = room;
		this.day = day;
		this.stratTime = stratTime;
		this.endTime = endTime;
	}
	
	
	public int getLoc_ID() {
		return loc_ID;
	}
	public void setLoc_ID(int loc_ID) {
		this.loc_ID = loc_ID;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getStratTime() {
		return stratTime;
	}
	public void setStratTime(String stratTime) {
		this.stratTime = stratTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	


}
