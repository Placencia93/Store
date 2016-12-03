

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Assignments
 */
@WebServlet("/Assignments")
public class Assignments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Assignments() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<!-- Latest compiled and minified CSS -->");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");

			out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Placencia, Juan - CS3220</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<div class=\"container\">");
		out.println("<h1>Assignments <small>CS3220 - Placencia, Juan</small></h1>");

		out.println("<h3>About Me <small>Lab 1</small></h3>");
		out.println("<p>");
		out.println("<a target=\"_blank\" href=\"http://cs3.calstatela.edu:8080/cs3220stu70/Labs/AboutMe\">");
			out.println("	My About Me Page");
		out.println("</a>");
		out.println("</p>");

		out.println("<h3>Calculate <small>Lab 2</small></h3>");
		out.println("<p>");
		out.println("<a target=\"_blank\" href=\"http://cs3.calstatela.edu:8080/cs3220stu70/homework/calculate\">");
			out.println("Calculator Page");
		out.println("</a>");
		out.println("</p>");

		out.println("<h3>Login <small>Lab 3</small></h3>");
		out.println("<p>");
		out.println("<a target=\"_blank\" href=\"http://cs3.calstatela.edu:8080/cs3220stu100/Labs/AboutMe\">");
			out.println("Login Page");
		out.println("</a>");
		out.println("	</p>");

		out.println("<h3>Midterm <small>Part 2</small></h3>");
		out.println("<p>");
		out.println("<a target=\"_blank\" href=\"http://cs3.calstatela.edu:8080/cs3220stu70/MidTerm/MidTermLogIn\">");
			out.println("	Midterm Part 2 Page");
		out.println("	</a>");
		out.println("</p>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
