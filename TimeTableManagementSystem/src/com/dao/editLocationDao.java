package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.models.NotAvailable;
import com.models.editLocation;
import com.util.DBUtill;

public class editLocationDao {
	
	static Connection con = DBUtill.getConnection();

	public void inserteditLocation(editLocation editLocation) throws SQLException {
		// 
		System.out.println("editLocation Dao");
		PreparedStatement pst = con.prepareStatement("insert into editLocation_details values(?,?,?,?,?)");
		pst.setInt(1, editLocation.getLoc_ID());
		pst.setString(2, editLocation.getRoom());
		pst.setString(3, editLocation.getDay());
		pst.setString(4, editLocation.getStratTime());
		pst.setString(5, editLocation.getEndTime());
		
		pst.executeUpdate();	
	}
	
	
	public void updateeditLocation(editLocation editLocation) throws SQLException {		
		PreparedStatement pst = con.prepareStatement("update editLocation_details set room=?,"+"day=?,"+"startTime=?,"+" endTime=? where ID = ?");
		
		pst.setString(1, editLocation.getRoom());
		pst.setString(2, editLocation.getDay());
		pst.setString(3, editLocation.getStratTime());		
		pst.setString(4, editLocation.getEndTime());
		pst.setInt(5, editLocation.getLoc_ID());
	

		
		pst.executeUpdate();			
	}

	public void deleteNoteditLocation(int Loc_ID) throws SQLException {
		PreparedStatement pst = con.prepareStatement("delete from editLocation_details where ID = ?");
		pst.setInt( 1, Loc_ID );
		pst.executeUpdate();
		
		
	}
}
