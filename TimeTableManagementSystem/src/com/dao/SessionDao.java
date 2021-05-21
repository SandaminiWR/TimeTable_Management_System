package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.models.UsrSession;
import com.util.DBUtill;

public class SessionDao {
	
static Connection con = DBUtill.getConnection();
	
	public void insertSession(UsrSession session) throws SQLException {
		// 
		System.out.println("session Dao");
		PreparedStatement pst = con.prepareStatement("insert into session_details values(?,?,?,?,?,?,?,?,?,?,?,?)");
		pst.setInt(1, session.getSession_ID());
		pst.setString(2, session.getLecture1());
		pst.setString(3, session.getLecture2());
		pst.setString(4, session.getTag());
		pst.setString(5, session.getRoom());
		pst.setString(6, session.getMaingroup());
		pst.setString(7, session.getSubgroup());
		pst.setString(8, session.getSub());
		pst.setString(9, session.getSubCode());
		pst.setInt(10, session.getNoOfStudent());
		pst.setString(11, session.getDay());
		pst.setString(12, session.getTimeslot());
		pst.executeUpdate();	
	}
	
	
	public void InsertSession(UsrSession session) throws SQLException {
		// 
	
		PreparedStatement pst = con.prepareStatement("insert into session_details (ID,First_Lecture,Tag,room,Main_Group,Sub_Group,Subject,Subject_code,No_Of_Student,Day,Time_slot) values(?,?,?,?,?,?,?,?,?,?,?)");
		pst.setInt(1, session.getSession_ID());
		pst.setString(2, session.getLecture1());
		pst.setString(3, session.getTag());
		pst.setString(4, session.getRoom());
		pst.setString(5, session.getMaingroup());
		pst.setString(6, session.getSubgroup());
		pst.setString(7, session.getSub());
		pst.setString(8, session.getSubCode());
		pst.setInt(9, session.getNoOfStudent());
		pst.setString(10, session.getDay());
		pst.setString(11, session.getTimeslot());
		pst.executeUpdate();	
	}
	
	
	
	public void updateSession(UsrSession session) throws SQLException {		
		PreparedStatement pst = con.prepareStatement("update session_details set First_Lecture=?,"+"Second_Lecture=?,"+"Tag=?,"+" room=?,"+" Main_Group=?,"+"Sub_Group=?,"+" Subject=?,"+"Subject_code=?,"+"No_Of_Student=?,"+"Day=?,"+"Time_slot=? where ID = ?");
		
		pst.setString(1, session.getLecture1());
		pst.setString(2, session.getLecture2());
		pst.setString(3, session.getTag());		
		pst.setString(4, session.getRoom());
		pst.setString(5, session.getMaingroup());
		pst.setString(6, session.getSubgroup());
		pst.setString(7, session.getSub());
		pst.setString(8, session.getSubCode());
		pst.setInt(9, session.getNoOfStudent());
		pst.setString(10, session.getDay());
		pst.setString(11, session.getTimeslot());
		pst.setInt(12, session.getSession_ID());
		
		pst.executeUpdate();			
	}
	
	public void updateSessionu(UsrSession session) throws SQLException {		
		PreparedStatement pst = con.prepareStatement("update session_details set First_Lecture=?,"+"Tag=?,"+" room=?,"+" Main_Group=?,"+"Sub_Group=?,"+" Subject=?,"+"Subject_code=?,"+"No_Of_Student=?,"+"Day=?,"+"Time_slot=? where ID = ?");
		
		pst.setString(1, session.getLecture1());		
		pst.setString(2, session.getTag());		
		pst.setString(3, session.getRoom());
		pst.setString(4, session.getMaingroup());
		pst.setString(5, session.getSubgroup());
		pst.setString(6, session.getSub());
		pst.setString(7, session.getSubCode());
		pst.setInt(8, session.getNoOfStudent());
		pst.setString(9, session.getDay());
		pst.setString(10, session.getTimeslot());
		pst.setInt(11, session.getSession_ID());
		
		pst.executeUpdate();			
	}
	
	
	public void deleteSession(int Session_ID) throws SQLException {
		PreparedStatement pst = con.prepareStatement("delete from session_details where ID = ?");
		pst.setInt( 1, Session_ID );
		pst.executeUpdate();
		
		
	}


}
