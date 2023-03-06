package controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserInfo;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		System.out.println("login trang heo doGet");
//		Redirect to login page
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserInfo user = new UserInfo();

		// Get user name, password → set userInfo
		String userName = req.getParameter("user-name");
		user.setUserName(userName);
		user.setPassword(req.getParameter("password"));

		// confirm to DB (connect, select)
		int countUser = 0;
		String url = "jdbc:mysql://localhost:3307/project_1";
		String user_db = "trang";
		String password = "123456789";
		String sql = "SELECT * FROM project_1.user WHERE user_name=? AND password=? ;";
		try {
            
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn = DriverManager.getConnection(url, user_db, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                	countUser = countUser + 1;
                }           
            };
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		if (countUser > 0) {
			// OK: 
			System.out.println("login success");
			// redirect to main
			resp.sendRedirect("main");
		} else {
			// NG:
			System.out.println("login failure");
			// back to login (error_message)
			resp.sendRedirect("login.html");
		}

	}

}