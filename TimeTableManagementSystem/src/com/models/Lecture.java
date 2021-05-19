package com.models;

public class Lecture extends User {

	
	public static final byte PROFESSOR  			=  1;
	public static final byte ASSISTANT_PROFESSOR    =  2;
	public static final byte SENIOR_LECTUREER_HG    =  3;	
	public static final byte SENIOR_LECTUREER 	    =  4;
	public static final byte LECTUREER   			=  5;
	public static final byte ASSISTANT_LECTUREER 	=  6;	
	
	
	/**
	 * 
	 */
	public Lecture() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param empID
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param faculty
	 * @param department
	 * @param center
	 * @param building
	 * @param level
	 * @param rank
	 */
	public Lecture(int empID, String firstName, String lastName, String password, String faculty, String department,
			String center, String building, String level, double rank ) {
		
		super(empID, firstName, lastName, password, faculty, department, center, building, level, rank);
		// TODO Auto-generated constructor stub
	}
	
	public Lecture(int empID, String fullname, String faculty, String department,
			String center, String building, double rank, String level) {
		
		super(empID, fullname, faculty, department, center, building, rank, level);
		// TODO Auto-generated constructor stub
	}
	

}
