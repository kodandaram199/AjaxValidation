package com.wipro.project14.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;

import com.wipro.project14.ajax.dao.LibraryUserDao;
import com.wipro.project14.ajax.model.LibraryUserModel;
import com.wipro.project14.ajax.util.DBConnection;

/**
 * Servlet implementation class LibraryUserController
 */
@WebServlet("/LibraryUserController")
public class LibraryUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String dob1=request.getParameter("dob");
		
		DateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
		
		Date convertedDate=null;
		String formattedDate;
        try {
			convertedDate =(Date) formatter.parse(dob1);
			formattedDate = formatter.format(convertedDate);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        java.sql.Date dateOfBirth=new java.sql.Date(convertedDate.getTime());
        
        
        
		String gender=request.getParameter("gender");
		String occupation=request.getParameter("occupation");
		String city=request.getParameter("gender");
		String mobile=request.getParameter("mobile");
		Double mobile1=Double.parseDouble(mobile);
		
		LibraryUserModel libraryusermodel=new LibraryUserModel();
		
		libraryusermodel.setName(name);
		libraryusermodel.setEmail(email);
		libraryusermodel.setDob(dateOfBirth);
		libraryusermodel.setGender(gender);
		libraryusermodel.setOccupation(occupation);
		libraryusermodel.setPassword(password);
		libraryusermodel.setCity(city);
		libraryusermodel.setMobile(mobile1);
		
		
		String sql="insert into tbl_librabry_profile values(null,?,?,?,?,?,?,?,?)";
		boolean inserted = false;
		
		
		try {
			
			inserted=LibraryUserDao.insertLibraryUser(libraryusermodel, sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(inserted)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			out.println("not");
		}
		
		
		
		
		
		
		
		
	}

}
