package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet(urlPatterns = "/WelcomeServlet",
initParams =
{
	@WebInitParam(name = "pagename", value = "Welcome"),
	@WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"),
    @WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/employee"),
    @WebInitParam(name = "username", value = "root"),
    @WebInitParam(name = "password", value = "Pnc@23012000")
})
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			response.setContentType("text/html");
			ServletConfig config=getServletConfig();
			String pn=config.getInitParameter("pagename1");
			
			PrintWriter out= response.getWriter();
			String name=getInitParameter("pagename");
			out.print("<h1><center>"+name+"</center></h1><br>");
			String k=(String)request.getAttribute("j");
			
			Cookie ck[]=request.getCookies();
			String uname1=ck[0].getValue();
			String lname1=ck[1].getValue();
			out.print("<center>");
			out.print("<br><h1>"+"Welcome User::"+uname1+" "+lname1+"</h1>");
			out.print("</center>");
			
			
			out.println("<br><br>");
			out.println("<center>This is Employee Data from DB</center><br><br>");
			try 
	        {  
				ServletContext context=getServletContext();
				try {
				Class.forName(context.getInitParameter("driver")); 
				Connection con = DriverManager.getConnection(getInitParameter("url"),getInitParameter("username"),getInitParameter("password"));  
	            Statement stmt = con.createStatement();  
	            ResultSet rs = stmt.executeQuery("select * from employee");  
	            out.println("<center>");
	            out.println("<table border=1 width=50% height=50%>");  
	            out.println("<tr><th>EmpId</th><th>EmpName</th><th>Salary</th><tr>");  
	            while (rs.next()) 
	            {  
	                String n = rs.getString("empid");  
	                String nm = rs.getString("empname");  
	                int s = rs.getInt("sal");   
	                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");   
	            }  
	            out.println("</table></center>");  
	            out.println("</html></body>");  
	            con.close();  
	           } 
				catch(Exception e) {
	        	   out.println("Unable to load Driver");
	        	   }
	           }
	            catch (Exception e) 
	           {  
	            out.println("error");  
	        }
			out.println("<html><body><br><center><a href='ByeServlet'>BYE</a></center></body></html>");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
