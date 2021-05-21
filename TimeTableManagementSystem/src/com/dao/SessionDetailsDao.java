package com.dao;

import java.sql.*;
import java.util.ArrayList;

import com.models.UsrSession;
import com.util.DBUtill;


public class SessionDetailsDao {
	
	Connection con = DBUtill.getConnection();
	
	
	public ArrayList<UsrSession> getSessions(){
		
		
		
		String query = "select * from session_details";
		
		ArrayList<UsrSession> list = new ArrayList<>();
		Statement st;
		try {
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				UsrSession obj = new UsrSession();
				obj.setId(rs.getInt(1));
				obj.setFirstLec(rs.getString(2));
				obj.setSecondLec(rs.getString(3));
				obj.setTag(rs.getString(4));
				obj.setMainGroup(rs.getString(6));
				obj.setSubGroup(rs.getString(7));
				obj.setSubGroup(rs.getString(8));
				obj.setSubjectCode(rs.getString(9));
				obj.setNoOfStudents(rs.getInt(10));
				obj.setDay(rs.getString(11));
				obj.setDuration(rs.getString(12));
				
				list.add(obj);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	}
	
	public UsrSession getSessionByID(int id) {
		
		
		
		String query = "select * from session_details where id = '"+id+"' ";
		UsrSession obj = new UsrSession();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				obj.setId(rs.getInt(1));
				obj.setFirstLec(rs.getString(2));
				obj.setSecondLec(rs.getString(3));
				obj.setTag(rs.getString(4));
				obj.setMainGroup(rs.getString(6));
				obj.setSubGroup(rs.getString(7));
				obj.setSubGroup(rs.getString(8));
				obj.setSubjectCode(rs.getString(9));
				obj.setNoOfStudents(rs.getInt(10));
				obj.setDay(rs.getString(11));
				obj.setDuration(rs.getString(12));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
				
	}

}
