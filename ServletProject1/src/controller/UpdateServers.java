package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StaffInfo;

@WebServlet(urlPatterns = { "/update/*" })
public class UpdateServers extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UpdateServers() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// lay parameter id
		String updateId = req.getParameter("id");

		// Lay thong tin nguoi dung, tu db, bang id
		String url = "jdbc:mysql://localhost:3307/project_1";
		String user_db = "trang";
		String password = "123456789";
		String sql = "SELECT * FROM project_1.employee WHERE id= ?;";

		StaffInfo staff = new StaffInfo();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user_db, password);
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, updateId);

			// luu thong tin nguoi dung vao object
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					staff.setId(rs.getInt("id"));
					staff.setName(rs.getString("name"));
					staff.setSex(rs.getString("sex"));
					staff.setPosition(rs.getString("position"));
					staff.setMarks(rs.getString("marks"));
				}
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(staff.getId());
		System.out.println(staff.getName());

		// gui thong tin nguoi dung toi update.jsp
		req.setAttribute("staff", staff);
		req.getRequestDispatcher("/view/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("vao do put");
		System.out.println(req.getParameter("staff-name"));

		// tạo object lưu thông tin vừa update
		StaffInfo staff = new StaffInfo();
		staff.setName(req.getParameter("staff-name"));
		staff.setSex(req.getParameter("staff-sex"));
		staff.setPosition(req.getParameter("staff-position"));
		staff.setMarks(req.getParameter("staff-marks"));

		// Kết nối DB, thực hiện lệnh update
		String url = "jdbc:mysql://localhost:3307/project_1";
		String user_db = "trang";
		String password = "123456789";
		String sql = "UPDATE project_1.employee SET name=?, sex=?, position=?, marks=? WHERE id=?;";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user_db, password);
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, staff.getName());
			ps.setString(2, staff.getSex());
			ps.setString(3, staff.getPosition());
			ps.setString(4, staff.getMarks());
			ps.setString(5, req.getParameter("staff-id"));
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Sendredirect tới main
		resp.sendRedirect("main");
		
	}

}
