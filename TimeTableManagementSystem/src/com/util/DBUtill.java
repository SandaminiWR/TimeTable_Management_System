package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.models.Lecture;
import com.models.Location;
import com.models.NotAvailable;
import com.models.UsrSession;
import com.models.Subject;
import com.models.editLocation;

public class DBUtill {
	
	
	private static Connection con = null;
	private static ResultSet rs = null;
	private static PreparedStatement pst = null;
	private static Statement stmt = null;
	
	private static final String url = "jdbc:mysql://localhost/tms";
	private static final String user = "root";
	private static final String passwrd = "";	 
	
	static {		
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection( url, user, passwrd);
		} catch (ClassNotFoundException e) {
			System.err.println("Exception :" +e.getMessage());
		} catch (SQLException e) {
			System.err.println("Exception :" +e.getMessage());
		}		
	}
	
	public DBUtill() {}
	
	public static Connection getConnection(){
		return con;
	}
	
	/*
	 * 
	 * Member 2
	 * 
	 * 
	 */
	 public ResultSet searchByEmpType( String searchType, int searchText ) {
		 rs = null;
		 
		 try {			
				String query = "select * from employee_details where "+searchType+"= '"+searchText+"' ";
				System.out.println(query);
				pst = con.prepareStatement(query);
				//pst.setInt(0, Integer.parseInt(id));	
				rs = pst.executeQuery(query);			
			} catch (SQLException e) {			
				e.printStackTrace();
			}		
		 
		 return rs;
	 }
	 
	 public ResultSet searchByEmpType( String searchType, String searchText ) {
		 rs = null;
		 
		 try {			
				String query = "select Employee_ID,Full_Name from employee_details where "+searchType+"= '"+searchText+"' ";
				
				pst = con.prepareStatement(query);
				//pst.setInt(0, Integer.parseInt(id));	
				rs = pst.executeQuery(query);			
			} catch (SQLException e) {			
				e.printStackTrace();
			}		
		 
		 return rs;
	 }
	 
	 
	 public ResultSet refreshEmployeeTable() {	
		 
			try {
				getConnection();
				String query = "Select * From employee_details";
				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
			return rs;			
		}
	 
	 
	 public ResultSet refreshSessionTable() {	
		 
			try {
				getConnection();
				String query = "Select * From session_details";
				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
			} catch (Exception e) {			
				System.out.println("Session Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
			return rs;			
		}
	 
	 public Lecture searchLectureById(int empID) {		
			try {
				stmt = con.createStatement();
				String sql = "select * from employee_details where Employee_ID = '"+empID+"'";
				rs = stmt.executeQuery(sql);
				
				if( rs.next() ) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String faculty = rs.getString(3);
					String department = rs.getString(4);
					String centre = rs.getString(5);
					String buiding = rs.getString(6);
					double rank = rs.getDouble(7);
					String level = rs.getString(8);
					
									
					return new Lecture( id, name, faculty, department, centre, buiding, rank, level);
					
				}
			}catch( SQLException e ) {
				System.out.println("searchLectureById");
				System.err.println("Exception :" +e.getMessage());
			}
			
			return null;
			
		}
	 
	 
	 public UsrSession searchSessionById(int sesID) {		
			try {
				stmt = con.createStatement();
				String sql = "select * from session_details where ID = '"+sesID+"'";
				rs = stmt.executeQuery(sql);
				
				if( rs.next() ) {
					int id = rs.getInt(1);
					String lecture1 = rs.getString(2);
					String lecture2 = rs.getString(3);
					String tag = rs.getString(4);
					String room= rs.getString(5);
					String maingroup = rs.getString(6);
					String subgroup = rs.getString(7);
					String subject = rs.getString(8);
					String subjectCode = rs.getString(9);
					int noOfStudent = rs.getInt(10);
					String day = rs.getString(11);
					String timeslot = rs.getString(12);
					
									
					return new UsrSession( id, lecture1, lecture2, tag, room ,subgroup,maingroup,  subject,subjectCode,noOfStudent, day , timeslot);
					
				}
			}catch( SQLException e ) {
				System.out.println("searchSessionById");
				System.err.println("Exception :" +e.getMessage());
			}
			
			return null;
			
		}
	 
	 
	 
	 //Subject
	 
	 public ResultSet searchBySubType( String searchType, String searchText ) {
		 rs = null;
		 
		 try {			
				String query = "select * from subject_details where "+searchType+"= '"+searchText+"' ";
				System.out.println(query);
				pst = con.prepareStatement(query);
				//pst.setInt(0, Integer.parseInt(id));	
				rs = pst.executeQuery(query);			
			} catch (SQLException e) {			
				e.printStackTrace();
			}		
		 
		 return rs;
	 }
	 
	 
	 public Subject searchSubjectByCode(String code) {		
			try {
				stmt = con.createStatement();
				String sql = "select * from subject_details where Subject_Code = '"+code+"'";
				rs = stmt.executeQuery(sql);
				
				if( rs.next() ) {
					String scode = rs.getString(1);
					String name = rs.getString(2);
					String offYear = rs.getString(3);
					String offSem = rs.getString(4);
					String LecHours = rs.getString(5);
					String TuteHours = rs.getString(6);
					String LabHours = rs.getString(7);
					
					
									
					return new Subject( offYear,offSem,name,scode, LecHours, TuteHours, LabHours );
					
				}
			}catch( SQLException e ) {
				System.out.println("searchLectureById");
				System.err.println("Exception :" +e.getMessage());
			}
			
			return null;
			
		}
	 
	 
	 
	 public ResultSet refreshSubjectTable() {	
		 
			try {
				getConnection();
				String query = "Select * From subject_details";
				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
			return rs;			
		}
	 
	 
	 
	 public ResultSet getLectureNames() {
		
		 try {
				getConnection();
				String query = "Select Full_Name From employee_details";				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
				
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
		 
		 
		 return rs;
		 
	 }
	 
	 public ResultSet getTags() {
			
		 try {
				getConnection();
				String query = "Select rel_tags From tags";				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
				
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
		 
		 
		 return rs;
		 
	 }
	 
	 public ResultSet getRoom() {
			
		 try {
				getConnection();
				String query = "Select RoomName From location";				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
				
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
		 
		 
		 return rs;
		 
	 }
	 
	 public ResultSet getStudentGroups() {
			
		 try {
				getConnection();
				String query = "Select G_ID,Sub_ID From stu_grp";				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
				
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
		 
		 
		 return rs;
		 
	 }
	 
	 
	 public ResultSet getSubject() {
			
		 try {
				getConnection();
				String query = "Select Subject_Name,Subject_code From subject_details";				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
				
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
		 
		 
		 return rs;
		 
	 }
	 
	 
	/*
	 * 
	 * 
	 * Member 3
	 * 
	 * 
	 */

	 public ResultSet refreshNotAvailableTable() {	
		 
			try {
				getConnection();
				String query = "Select * From NotAvailable_details";
				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
			return rs;			
		}
	 
	 public NotAvailable searchNotAvailById(int notAvai_ID) {		
			try {
				stmt = con.createStatement();
				String sql = "select * from NotAvailable_details where ID = '"+notAvai_ID+"'";
				rs = stmt.executeQuery(sql);
				
				if( rs.next() ) {
					int ID = rs.getInt(1);
					String lecture = rs.getString(2);
					String maingroup = rs.getString(3);
					String subgroup = rs.getString(4);
					int session_ID = rs.getInt(5);
					String time = rs.getString(6);
				
					
									
					return new NotAvailable( notAvai_ID, lecture, maingroup, subgroup, session_ID, time);
					
				}
			}catch( SQLException e ) {
				System.out.println("searchNotAvailById");
				System.err.println("Exception :" +e.getMessage());
			}
			
			return null;
			
		}
	 
	 
	/* public ResultSet getLectureNames() {
			
		 try {
				getConnection();
				String query = "Select Full_Name From employee_details";				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
				
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
		 
		 
		 return rs;
		 
	 }*/
	 
	 
	/* public ResultSet getStudentGroups() {
			
		 try {
				getConnection();
				String query = "Select Group_ID,Sub_Group_Id From student_group";				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
				
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
		 
		 
		 return rs;
		 
	 }*/
	 
	 
	 public ResultSet getSessionID() {
			
		 try {
				getConnection();
				String query = "Select ID From session_details";				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
				
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
		 
		 
		 return rs;
		 
	 }
	 
/*	 public ResultSet getRoom() {
			
		 try {
				getConnection();
				String query = "Select RoomName From location";				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
				
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
		 
		 
		 return rs;
		 
	 }*/

	 public editLocation searcheitLoceById(int Loc_ID) {		
			try {
				stmt = con.createStatement();
				String sql = "select * from editLocation_details where ID = '"+Loc_ID+"'";
				rs = stmt.executeQuery(sql);
				
				if( rs.next() ) {
					int ID = rs.getInt(1);
					String room = rs.getString(2);
					String day = rs.getString(3);
					String startTime = rs.getString(4);
					String endTime = rs.getString(5);
					
									
					return new editLocation( ID, room, day, startTime, endTime);
					
				}
			}catch( SQLException e ) {
				System.out.println("searcheitLoceById");
				System.err.println("Exception :" +e.getMessage());
			}
			
			return null;
			
		}
	 public ResultSet refresheditLoc() {	
		 
			try {
				getConnection();
				String query = "Select * From editLocation_details";
				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
			return rs;			
		}
	 /*
	  * 
	  * member 4
	  * 
	  */
	 
	 public ResultSet refreshAddLocationTable() {	
		 
			try {
				getConnection();
				String query = "Select * From location";
				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
			return rs;			
		}
	
	
	
	 public Location searchLocationByName(String RName) {		
			try {
				stmt = con.createStatement();
				String sql = "select * from location where RoomName = '"+RName+"'";
				rs = stmt.executeQuery(sql);
				
				if( rs.next() ) {
					String buildingNmae = rs.getString(1);
					String  roomtype = rs.getString(2);
					String roomName = rs.getString(3);
				    int capacity = rs.getInt(4);
					
					
					return new Location(buildingNmae,roomtype,roomName,capacity);
					
				}
			}catch( SQLException e ) {
				System.out.println("searchLectureById");
				System.err.println("Exception :" +e.getMessage());
			}
			
			return null;
			
		}
	
	
	  public ResultSet searchByLocationType( String searchType, String searchText ) {
		  	rs = null;
	 
			 try {			
					String query = "select * from location where "+searchType+"= '"+searchText+"' ";
					System.out.println(query);
					pst = con.prepareStatement(query);
					//pst.setInt(0, Integer.parseInt(id));	
					rs = pst.executeQuery(query);			
				} catch (SQLException e) {			
					e.printStackTrace();
				}		
			 
			 return rs;
	  }
}
