package com;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import java.sql.*;
import java.util.Formatter;
import java.io.IOException;

public class CustomTagDemo extends SimpleTagSupport {
	  Connection c1;
      Statement state;
      ResultSet rs;
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out=getJspContext().getOut();
        out.println("<center><h3 style='color:red',background-color:yellow;  background-image: url('Coditas.jpg');'>My Name is Aditya</center>");
        out.println("<br>");
        out.println("<center>");
      
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "Pnc@23012000");
            System.out.println("Connected to database\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
        	state = c1.createStatement();
            String fetch = "select * from emp.employee where name='Aditya'";
            rs = state.executeQuery(fetch);
            Formatter fmt = new Formatter();
            out.println("<table border='1'> ");
            out.println("<tr> <th>id</th><th>name</th><th>designation</th><th>doj</th><th>exp</th><th>salary</th><th>status</th><th>city</th></tr>");
            while (rs.next()) {
            	
                out.println("<tr><td>"+rs.getString(1)+"</td><td>"+ rs.getString(2)+"</td><td>"+ rs.getString(3)+"</td><td>"+ rs.getString(4)+"</td><td>"+ rs.getString(5)+" Years"+"</td><td>"+rs.getString(6)+"</td><td>" +rs.getString(7)+"</td><td>" +rs.getString(8)+"</td></tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
    

