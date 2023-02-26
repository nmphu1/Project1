package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StaffInfo;

@WebServlet(urlPatterns = { "/main" })
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MainServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("main get");

		// get list_staff_officer
		List<StaffInfo> listStaffInfo = new ArrayList<StaffInfo>();

		String url = "jdbc:mysql://localhost:3307/project_1";
		String user_db = "trang";
		String password = "123456789";
		String sql = "SELECT * FROM project_1.employee;";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user_db, password);
			PreparedStatement ps = conn.prepareStatement(sql);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					StaffInfo staff = new StaffInfo();
					staff.setId(rs.getInt("id"));
					staff.setName(rs.getString("name"));
					staff.setSex(rs.getString("sex"));
					staff.setPosition(rs.getString("position"));
					staff.setMarks(rs.getString("marks"));

					listStaffInfo.add(staff);
				}
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		


		// send list_staff_officer to main.jsp
		request.setAttribute("list_staff", listStaffInfo);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/main.jsp");
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}
}
