package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.models.Lecture;
import com.models.Subject;
import com.util.DBUtill;

public class SubjectDao {
	
	static Connection con = DBUtill.getConnection();
	
	public void insertSubject(Subject subject) throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement pst = con.prepareStatement("insert into subject_details values(?,?,?,?,?,?,?)");
		pst.setString(1, subject.getSubCode());
		pst.setString(2, subject.getSubName());
		pst.setString(3, subject.getOfferedYear());
		pst.setString(4, subject.getOfferedSem());
		pst.setString(5, subject.getLechrs());
		pst.setString(6, subject.getTutehrs());
		pst.setString(7, subject.getLabhrs());
		
		pst.executeUpdate();	
	}
	
	public void updateSubject(Subject subject) throws SQLException {		
		PreparedStatement pst = con.prepareStatement("update subject_details set Subject_Code=?,"+"Subject_Name=?,"+"Offered_Year=?,"+"Offered_Semester=?,"+"Lecture_Hours=?,"+"Tute_Hours=?,"+"Lab_Hours=? where Subject_Code = ?");
		
		
		pst.setString(1,subject.getSubCode());		
		pst.setString(2, subject.getSubName());
		pst.setString(3, subject.getOfferedYear());
		pst.setString(4, subject.getOfferedSem());
		pst.setString(5, subject.getLechrs());
		pst.setString(6, subject.getLabhrs());
		pst.setString(7, subject.getTutehrs());
		pst.setString(8,subject.getSubCode());	
				
		pst.executeUpdate();			
	}
	
	

	public void deleteSubject(String code) throws SQLException {
		PreparedStatement pst = con.prepareStatement("delete from subject_details where Subject_Code = ?");
		pst.setString( 1, code );
		pst.executeUpdate();
		
		
	}

}
