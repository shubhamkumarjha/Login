package com.shubham;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	Connection con=null;
	PreparedStatement ps=null;
	int rs;	
	
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String query="";
			String un=request.getParameter("username");
			String pw=request.getParameter("password");
			String email=request.getParameter("email");
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			query="Insert into login_details values(?,?,?)";
			ps=con.prepareStatement(query);
			ps.setString(1, un);
			ps.setString(2, pw);
			ps.setString(3, email);
			rs=ps.executeUpdate();
			if(rs!=0){
				RequestDispatcher rd= request.getRequestDispatcher("/login.jsp");
				request.setAttribute("message", "Registered Successfully");
				rd.include(request, response);
			}else{
				RequestDispatcher rd= request.getRequestDispatcher("/register.jsp");
				request.setAttribute("message", "Registeration Unsuccessfully");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
