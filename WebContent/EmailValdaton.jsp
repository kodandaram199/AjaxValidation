<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.Connection,java.sql.DriverManager,java.sql.SQLException,com.wipro.project14.ajax.util.DBConnection,java.sql.PreparedStatement,java.sql.ResultSet" %>

<%
DBConnection dbc=new DBConnection();
		
		Connection con=dbc.getConnection();
		
		String email=request.getParameter("email");
		
		String sql="select * from tbl_librabry_profile where email=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1,email);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
		    out.print("Email already Exists");
		}
		
		    
		
		
		
%>
</body>
</html>