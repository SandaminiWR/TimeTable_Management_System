package com.models;

public class NotAvailable {
	
	private int notAvai_ID;
	private String lecture;
	private String maingroup;
	private String subgroup;
	private int session_ID;
	private String time;
	
	
	
	
	public NotAvailable() {
		super();
		// 
	}

	public NotAvailable(int notAvai_ID, String lecture, String maingroup, String subgroup, int session_ID,
			String time) {
		super();
		this.notAvai_ID = notAvai_ID;
		this.lecture = lecture;
		this.maingroup = maingroup;
		this.subgroup = subgroup;
		this.session_ID = session_ID;
		this.time = time;
	}
	
	public int getNotAvai_ID() {
		return notAvai_ID;
	}
	public void setNotAvai_ID(int notAvai_ID) {
		this.notAvai_ID = notAvai_ID;
	}
	public String getLecture() {
		return lecture;
	}
	public void setLecture(String lecture) {
		this.lecture = lecture;
	}
	public String getMaingroup() {
		return maingroup;
	}
	public void setMaingroup(String maingroup) {
		this.maingroup = maingroup;
	}
	public String getSubgroup() {
		return subgroup;
	}
	public void setSubgroup(String subgroup) {
		this.subgroup = subgroup;
	}
	public int getSession_ID() {
		return session_ID;
	}
	public void setSession_ID(int session_ID) {
		this.session_ID = session_ID;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	
	
	
}
