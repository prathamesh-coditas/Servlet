	package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/LoginServlet",
name="Login",
initParams = {
        @WebInitParam(name = "pagename", value = "Login"),
    })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step1
		response.setContentType("text/html");
		//step2
		PrintWriter out= response.getWriter();
		//step3
		

		String pn=getInitParameter("pagename");
		out.print("<h1><center>"+pn+"</center></h1><br>");
		
		
		String name= request.getParameter("uname");
		String pwd= request.getParameter("pwd");
		if(name.equals(pwd)) {
			out.print("<form action='WelcomeServlet'>");
			out.print("<center>");
			out.print("<input type='hidden' name='uname' value='"+name+"'>");
			out.print("<input type='submit' value='go'>");
			out.print("</center>");
			out.print("</form>");
			out.println("<center>Welcome to Login Page::"+name+"</center>");}
		else {
			out.println("</center>");
			out.print("!!! Credentials are not matched!!!!");
			out.print("</center>");
		}	
		out.println("<br><center><a href='WelcomeServlet'>Welcome<br> Click Here to see data</a>"+"</center>");
		
		
		
	  
    }  
		
		

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
