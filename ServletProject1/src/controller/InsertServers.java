package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertServers extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	public InsertServers() {}
	  
	  @Override
	  protected void doGet(HttpServletRequest request,
           HttpServletResponse response) throws ServletException, IOException {
       response.sendRedirect("insert.html");
	  }
   
   @Override
   protected void doPost(HttpServletRequest request,
           HttpServletResponse response) throws ServletException, IOException {
       
	   this.doGet(request, response);
	   
   }
}

