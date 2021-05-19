package com.models;

import java.time.LocalTime;

public class Subject {
	
	private String offeredYear;
	private String offeredSem;
	private String SubName;
	private String SubCode;
	private String Lechrs;
	private String Tutehrs;
	private String Labhrs;
	
	public Subject(String offeredYear, String offeredSem, String subName, String subCode, String lechrs, String tutehrs,
			String labhrs) {
		super();
		this.offeredYear = offeredYear;
		this.offeredSem = offeredSem;
		SubName = subName;
		SubCode = subCode;
		Lechrs = lechrs;
		Tutehrs = tutehrs;
		Labhrs = labhrs;
	}
	
	public String getOfferedYear() {
		return offeredYear;
	}
	
	public String getOfferedSem() {
		return offeredSem;
	}
	
	public String getSubName() {
		return SubName;
	}
	
	public String getSubCode() {
		return SubCode;
	}
	
	
	public String getLechrs() {
		return Lechrs;
	}
	
	
	public String getTutehrs() {
		return Tutehrs;
	}
	
	
	public String getLabhrs() {
		return Labhrs;
	}
	
	
	public void setOfferedYear(String offeredYear) {
		this.offeredYear = offeredYear;
	}
	
	
	public void setOfferedSem(String offeredSem) {
		this.offeredSem = offeredSem;
	}
	
	
	public void setSubName(String subName) {
		SubName = subName;
	}
	
	public void setSubCode(String subCode) {
		SubCode = subCode;
	}
	
	
	public void setLechrs(String lechrs) {
		Lechrs = lechrs;
	}
	
	
	public void setTutehrs(String tutehrs) {
		Tutehrs = tutehrs;
	}
	
	
	public void setLabhrs(String labhrs) {
		Labhrs = labhrs;
	}
	
	

	

	
	

}
