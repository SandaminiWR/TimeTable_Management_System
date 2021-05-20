package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBUtill;

public class WorkingDaysAndHoursDao {

	static Connection con = DBUtill.getConnection();
	
	public void insertworkingDays(String id, String day) throws SQLException {
		// 
		
		
		PreparedStatement pst = con.prepareStatement("insert into workingDays values(?,?)");
		pst.setString(1, id);
		pst.setString(2, day);
			
		
		pst.executeUpdate();	
	}
	
	
	/*public ArrayList<String[]> getWorkingDaysList(String id) throws SQLException {
		
		ArrayList<String[]> list = new ArrayList<String[]>();
		String query = "SELECT * FROM workingDays WHERE empID = '"+id+"' ";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rst = pst.executeQuery();
		String[] str;
		
			while( rst.next() ) {
			
				str= new String[2];
				 
				str[0] = rst.getString(1);	
				str[1] = rst.getString(2);					
				
				list.add(str);
			}
		
		return list;
	}*/
	
	
	public ArrayList<String> getWorkingDaysList(String id) throws SQLException {
		
		ArrayList<String> list = new ArrayList<String>();
		String query = "SELECT workday FROM workingDays WHERE empID = '"+id+"' ";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rst = pst.executeQuery();
		
		
			while( rst.next() ) {
								 
				String day = rst.getString(1);										
				
				list.add(day);
			}
		
		return list;
	}
	
	
	public void updateworkingDays(String id, String day) throws SQLException {
		// 
		
		
		PreparedStatement pst = con.prepareStatement("insert into workingDays values(?,?)");
		pst.setString(1, id);
		pst.setString(2, day);
			
		
		pst.executeUpdate();	
	}
	
	public void deleteworkingDays(String id) throws SQLException {
		
		PreparedStatement pst = con.prepareStatement("delete from workingDays where empID = ? ");
		pst.setString(1, id);
		
		pst.executeUpdate();		
		
	}
	
	
	
	
}
