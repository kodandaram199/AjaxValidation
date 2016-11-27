package com.wipro.project14.ajax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wipro.project14.ajax.model.LibraryUserModel;
import com.wipro.project14.ajax.util.DBConnection;

public class LibraryUserDao {
	
	public  static boolean insertLibraryUser(LibraryUserModel libraryusermodel,String sql) throws SQLException
	{
		DBConnection db=new DBConnection();
		
		Connection con =db.getConnection();
		PreparedStatement ps=null;
		int i=0;
		
		try {
			ps=con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ps.setString(1, libraryusermodel.getEmail());
		ps.setString(2, libraryusermodel.getPassword());
		ps.setString(3, libraryusermodel.getName());
		ps.setDate(4, libraryusermodel.getDob());
		ps.setString(5, libraryusermodel.getGender());
		ps.setString(6, libraryusermodel.getOccupation());
		ps.setString(7, libraryusermodel.getCity());
		ps.setDouble(8, libraryusermodel.getMobile());
		
		i=ps.executeUpdate();
		
		if(i>0)
		{
			return true;
		}
		
		return false;
	}

}
