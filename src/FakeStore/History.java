package FakeStore;

import java.io.IOException;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;

import

javax.servlet.ServletConfig;

import javax.servlet.ServletContext;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import FakeStore.HistoryEntry;

@WebServlet("/Store/History")
public class History extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {

		super.init(config);

		try {

			Class.forName("com.mysql.jdbc.Driver");

		}

		catch (ClassNotFoundException e) {

			throw new ServletException(e);

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

	{
		List<HistoryEntry> history = new ArrayList<HistoryEntry>();

		Connection c = null;

		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu70";
			String username = "cs3220stu70";
			String password = "812!xL1B";

			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from History ");

			while (rs.next()) {

				HistoryEntry entry = new HistoryEntry(rs.getString("name"), rs.getInt("quantity"),
						rs.getDouble("price"), rs.getInt("id"));

				history.add(entry);

			}
		}

		catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}

		request.setAttribute("history", history);
		request.getRequestDispatcher("/WEB-INF/Transaction.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
