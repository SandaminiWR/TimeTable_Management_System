package com.models;

public class UsrSession {

	private int session_ID;
	private String lecture1;
	private String lecture2;
	private String tag;
	private String room;
	private String subgroup;
	private String maingroup;
	private String sub;
	private String subCode;
	private int noOfStudent;
	private String day;
	private String timeslot;
	
	
	
	
	public UsrSession() {}
		
	/**
	 * @param session_ID
	 * @param lecture1
	 * @param lecture2
	 * @param tag
	 * @param room
	 * @param subgroup
	 * @param maingroup
	 * @param sub
	 * @param subCode
	 * @param noOfStudent
	 * @param day
	 * @param timeslot
	 */
	public UsrSession(int session_ID, String lecture1, String lecture2, String tag, String room, String subgroup,
			String maingroup, String sub, String subCode, int noOfStudent, String day, String timeslot) {
		super();
		this.session_ID = session_ID;
		this.lecture1 = lecture1;
		this.lecture2 = lecture2;
		this.tag = tag;
		this.room = room;
		this.subgroup = subgroup;
		this.maingroup = maingroup;
		this.sub = sub;
		this.subCode = subCode;
		this.noOfStudent = noOfStudent;
		this.day = day;
		this.timeslot = timeslot;
	}

	
	
	/**
	 * @param session_ID
	 * @param lecture1
	 * @param tag
	 * @param room
	 * @param subgroup
	 * @param maingroup
	 * @param sub
	 * @param subCode
	 * @param noOfStudent
	 * @param day
	 * @param timeslot
	 */
	public UsrSession(int session_ID, String lecture1, String tag, String room, String subgroup, String maingroup,
			String sub, String subCode, int noOfStudent, String day, String timeslot) {
		super();
		this.session_ID = session_ID;
		this.lecture1 = lecture1;
		this.tag = tag;
		this.room = room;
		this.subgroup = subgroup;
		this.maingroup = maingroup;
		this.sub = sub;
		this.subCode = subCode;
		this.noOfStudent = noOfStudent;
		this.day = day;
		this.timeslot = timeslot;
	}



	/**
	 * @return the session_ID
	 */
	public int getSession_ID() {
		return session_ID;
	}

	/**
	 * @return the lecture
	 */
	public String getLecture1() {
		return lecture1;
	}
	
	public String getLecture2() {
		return lecture2;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}


		
	/**
	 * @return the sub
	 */
	public String getSub() {
		return sub;
	}
	/**
	 * @return the noOfStudent
	 */
	public int getNoOfStudent() {
		return noOfStudent;
	}
	
	
	/**
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * @return the subgroup
	 */
	public String getSubgroup() {
		return subgroup;
	}

	/**
	 * @return the maingroup
	 */
	public String getMaingroup() {
		return maingroup;
	}

	/**
	 * @return the subCode
	 */
	public String getSubCode() {
		return subCode;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}


	/**
	 * @return the timeslot
	 */
	public String getTimeslot() {
		return timeslot;
	}


	/**
	 * @param room the room to set
	 */
	public void setRoom(String room) {
		this.room = room;
	}

	/**
	 * @param subgroup the subgroup to set
	 */
	public void setSubgroup(String subgroup) {
		this.subgroup = subgroup;
	}

	/**
	 * @param maingroup the maingroup to set
	 */
	public void setMaingroup(String maingroup) {
		this.maingroup = maingroup;
	}

	/**
	 * @param subCode the subCode to set
	 */
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * @param timeslot the timeslot to set
	 */
	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}

	/**
	 * @param session_ID the session_ID to set
	 */
	public void setSession_ID(int session_ID) {
		this.session_ID = session_ID;
	}
	/**
	 * @param lecture the lecture to set
	 */
	public void setLecture1(String lecture) {
		this.lecture1 = lecture;
	}
	
	public void setLecture2(String lecture) {
		this.lecture2 = lecture;
	}
	
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}




	
	/**
	 * @param sub the sub to set
	 */
	public void setSub(String sub) {
		this.sub = sub;
	}
	/**
	 * @param noOfStudent the noOfStudent to set
	 */
	public void setNoOfStudent(int noOfStudent) {
		this.noOfStudent = noOfStudent;
	}
	
	
	
	
	
	
	
	
	
}
