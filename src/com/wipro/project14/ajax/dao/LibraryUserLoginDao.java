package com.wipro.project14.ajax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.project14.ajax.model.LibraryUserModel;
import com.wipro.project14.ajax.util.DBConnection;

public class LibraryUserLoginDao {
	
	public static boolean validateUser(LibraryUserModel lulm,String sql) throws SQLException
	
	{
	
	DBConnection db=new DBConnection();
	
	Connection con=db.getConnection();
	PreparedStatement ps = null;
	
	try {
		ps=con.prepareStatement(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	ps.setString(1,lulm.getEmail());
	ps.setString(2, lulm.getPassword());
	
	
	
	ResultSet rs=ps.executeQuery();
	
	if(rs.next())
		return true;
	else
	return false;
	
	
	
	}
	
	

}
