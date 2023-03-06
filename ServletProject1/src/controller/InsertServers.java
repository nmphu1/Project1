package controller;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StaffInfo;

@WebServlet(urlPatterns = { "/insert" })
public class InsertServers extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public InsertServers() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/insert.jsp");
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ok");
		System.out.println(request.getParameter("staff-name"));
		System.out.println(request.getParameter("staff-sex"));
		System.out.println(request.getParameter("staff-position"));
		System.out.println(request.getParameter("staff-marks"));
		
		
		StaffInfo staff = new StaffInfo();
		staff.setName(request.getParameter("staff-name"));
		staff.setSex(request.getParameter("staff-sex"));
		staff.setPosition(request.getParameter("staff-position"));
		staff.setMarks(request.getParameter("staff-marks"));
	
		// ket noi database, insert thong tin nhan vien den database
		String url = "jdbc:mysql://localhost:3307/project_1";
		String user_db = "trang";
		String password = "123456789";
		String sql = "INSERT INTO project_1.employee (name, sex, position, marks) VALUES (?, ?, ?, ?);";
		try {
            
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn = DriverManager.getConnection(url, user_db, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			
            ps.setString(1, staff.getName());
            ps.setString(2, staff.getSex());
            ps.setString(3, staff.getPosition());
            ps.setString(4, staff.getMarks());
            ps.executeUpdate();
            
            // redirect to main
            response.sendRedirect("main");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
}
