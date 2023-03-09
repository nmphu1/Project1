package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/delete/*" })
public class DeleteServers extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DeleteServers() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Chạy tới trang delete.jsp
		String deleteId = req.getParameter("id");
		req.setAttribute("deleteId", deleteId);
		req.getRequestDispatcher("/view/delete.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String deleteId = req.getParameter("staff-id");
		// ket noi db
		String url = "jdbc:mysql://localhost:3307/project_1";
		String user_db = "trang";
		String password = "123456789";
		String sql = "DELETE FROM project_1.employee WHERE id= ?;";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user_db, password);
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, deleteId);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// toi main
		resp.sendRedirect("main");
	}

}
