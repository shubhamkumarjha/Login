package com.shubham;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;

public class LoginServlet extends HttpServlet {
	
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String query="";
			String un=request.getParameter("username");
			String pw=request.getParameter("password");
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			query="Select password from login_details where username=?";
			ps= con.prepareStatement(query);
			ps.setString(1, un);
			rs=ps.executeQuery();
			if (!rs.next() ) {
				System.out.println("validation failed!");
				 RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
				 request.setAttribute("message", "Invalid username!");
			        rd.include(request, response);
			}else{
				if(rs.getString(1).equals(pw)){
					System.out.println("validation successfull!");
					HttpSession session=request.getSession();
				     session.setAttribute("username", un);
					 RequestDispatcher rd=request.getRequestDispatcher("/home.jsp"); 
				     rd.include(request, response);
				     
				}else{
					System.out.println("validation failed!");
					 RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
					 request.setAttribute("message", "Invalid password!");
				     rd.include(request, response);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
