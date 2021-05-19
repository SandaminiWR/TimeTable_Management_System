package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.models.Lecture;
import com.models.Session;
import com.models.Subject;

public class DBUtill {
	
	
	private static Connection con = null;
	private static ResultSet rs = null;
	private static PreparedStatement pst = null;
	private static Statement stmt = null;
	
	private static final String url = "jdbc:mysql://localhost:3306/tms";
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
	 
	 
	 public Session searchSessionById(int sesID) {		
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
					
									
					return new Session( id, lecture1, lecture2, tag, room ,maingroup, subgroup, subject,subjectCode,noOfStudent, day , timeslot);
					
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
				String query = "Select Related_Tags From tag";				
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
				String query = "Select Group_ID,Sub_Group_Id From student_group";				
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
				String query = "Select Subject_Code,Subject_Name From subject_details";				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
				
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
		 
		 
		 return rs;
		 
	 }

}
