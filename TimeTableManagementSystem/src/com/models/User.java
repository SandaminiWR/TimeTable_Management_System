package com.models;

public class User {
	
	
	private int empID;
	private String firstName;
	private String lastName;
	private String fullname;
	//private String email;
	//private String phoneNumber;
	private String password;
	private String faculty;
	private String department;
	private String center;
	private String building;
	private String level;
	private double rank;
	
	
	
	public User() {}



	public User(int empID, String firstName, String lastName, String password, String faculty, String department,
			String center, String building, String level, double rank) {
		//super();
		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.faculty = faculty;
		this.department = department;
		this.center = center;
		this.building = building;
		this.level = level;
		this.rank = rank;
	}
	

	/**
	 * @param empID
	 * @param fullname
	 * @param faculty
	 * @param department
	 * @param center
	 * @param building
	 * @param rank
	 */
	public User(int empID, String fullname, String faculty, String department, String center, String building,
			double rank, String level) {
		super();
		this.empID = empID;
		this.fullname = fullname;
		this.faculty = faculty;
		this.department = department;
		this.center = center;
		this.building = building;
		this.rank = rank;
		this.level = level;
	}



	/**
	 * @param empID
	 * @param firstName
	 * @param lastName
	 * @param faculty
	 * @param department
	 * @param center
	 * @param building
	 * @param level
	 * @param rank
	 */
	public User(int empID, String fullname, String faculty, String department, String center,
			String building, String level, double rank) {
		super();
		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.faculty = faculty;
		this.department = department;
		this.center = center;
		this.building = building;
		this.level = level;
		this.rank = rank;
	}



	/**
	 * @return the empID
	 */
	public int getEmpID() {
		return empID;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}



	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @return the faculty
	 */
	public String getFaculty() {
		return faculty;
	}



	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}



	/**
	 * @return the center
	 */
	public String getCenter() {
		return center;
	}



	/**
	 * @return the building
	 */
	public String getBuilding() {
		return building;
	}



	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}



	/**
	 * @return the rank
	 */
	public double getRank() {
		return rank;
	}

	


	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}



	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	/**
	 * @param empID the empID to set
	 */
	public void setEmpID(int empID) {
		this.empID = empID;
	}



	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @param faculty the faculty to set
	 */
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}



	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}



	/**
	 * @param center the center to set
	 */
	public void setCenter(String center) {
		this.center = center;
	}



	/**
	 * @param building the building to set
	 */
	public void setBuilding(String building) {
		this.building = building;
	}



	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}



	/**
	 * @param rank the rank to set
	 */
	public void setRank(double rank) {
		this.rank = rank;
	}
	
	
	
	
	

}
