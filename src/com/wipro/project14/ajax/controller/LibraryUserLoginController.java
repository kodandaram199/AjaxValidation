package com.wipro.project14.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.project14.ajax.dao.LibraryUserLoginDao;
import com.wipro.project14.ajax.model.LibraryUserModel;


@WebServlet("/LibraryUserLoginController")
public class LibraryUserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("username");
		String password=request.getParameter("password");
		
		LibraryUserModel lulm=new LibraryUserModel();
		
		lulm.setEmail(email);
		lulm.setPassword(password);
		
		String sql="select * from tbl_librabry_profile where email=? and password=?";
		boolean isExist = false;
		try {
			isExist=LibraryUserLoginDao.validateUser(lulm,sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		if(isExist)
			out.println("Hello");
		else
		out.println("Soory");
		
	}

}
