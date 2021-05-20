package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.models.Lecture;
import com.util.DBUtill;

public class EmployeeDao {

	static Connection con = DBUtill.getConnection();
	
	public void insertEmployee(Lecture lecture) throws SQLException {
		// 
		System.out.println("lecture Dao");
		PreparedStatement pst = con.prepareStatement("insert into employee_details values(?,?,?,?,?,?,?,?)");
		pst.setInt(1, lecture.getEmpID());
		pst.setString(2, lecture.getFullname());
		pst.setString(3, lecture.getFaculty());
		pst.setString(4, lecture.getDepartment());
		pst.setString(5, lecture.getCenter());
		pst.setString(6, lecture.getBuilding());
		pst.setDouble(7, lecture.getRank());
		pst.setString(8, lecture.getLevel());
		
		pst.executeUpdate();	
	}
	
	
	
	public void updateEmployee(Lecture lecture) throws SQLException {		
		PreparedStatement pst = con.prepareStatement("update employee_details set Employee_ID=?,"+"Full_Name=?,"+"Faculty=?,"+"Department=?,"+"Center=?,"+"Buiding=?,"+"Rank=?,"+"Level=? where Employee_ID = ?");
		
		pst.setInt(1, lecture.getEmpID());
		pst.setString(2,lecture.getFullname());		
		pst.setString(3, lecture.getFaculty());
		pst.setString(4, lecture.getDepartment());
		pst.setString(5, lecture.getCenter());
		pst.setString(6, lecture.getBuilding());
		pst.setDouble(7, lecture.getRank());
		pst.setString(8, lecture.getLevel());
		pst.setInt(9, lecture.getEmpID());
		
		
		pst.executeUpdate();			
	}
	
	
	public void deleteEmployee(int employeeID) throws SQLException {
		PreparedStatement pst = con.prepareStatement("delete from employee_details where Employee_ID = ?");
		pst.setInt( 1, employeeID );
		pst.executeUpdate();
		
		
	}

}
