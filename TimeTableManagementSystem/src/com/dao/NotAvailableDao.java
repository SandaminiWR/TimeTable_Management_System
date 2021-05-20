package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.models.NotAvailable;
import com.util.DBUtill;

public class NotAvailableDao {
	
	

static Connection con = DBUtill.getConnection();

	public void insertNotAvailable(NotAvailable NotAvailable) throws SQLException {
		// 
		System.out.println("NotAvailable Dao");
		PreparedStatement pst = con.prepareStatement("insert into NotAvailable_details values(?,?,?,?,?,?)");
		pst.setInt(1, NotAvailable.getNotAvai_ID());
		pst.setString(2, NotAvailable.getLecture());
		pst.setString(3, NotAvailable.getMaingroup());
		pst.setString(4, NotAvailable.getSubgroup());
		pst.setInt(5, NotAvailable.getSession_ID());
		pst.setString(6, NotAvailable.getTime());
		
		pst.executeUpdate();	
	}
	

	
	public void deleteNotAvailable(int NotAvai_ID) throws SQLException {
		PreparedStatement pst = con.prepareStatement("delete from NotAvailable_details where ID = ?");
		pst.setInt( 1, NotAvai_ID );
		pst.executeUpdate();
		
		
	}
	 

}
