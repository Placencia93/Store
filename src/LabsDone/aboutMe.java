package LabsDone;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class aboutMe
 */
@WebServlet("/Labs/AboutMe")
public class aboutMe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aboutMe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ServletContext context = this.getServletContext();
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<!-- Latest compiled and minified CSS -->");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<title><center><h1>About Me</h1></center></title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("  <div class=\"page-header\">");
		out.println("   <h1>About Me <small>CS3220 - Lab</small></h1>");
		out.println(" </div>");
		out.println(" <form action=\"AboutMe\" method=\"post\">");
	    out.println("<input type=\"text\" name=\"cin\" placeholder=\"Enter CIN\" />");
	    out.println("<input type=\"submit\" value=\"Show\" />");
	    out.println("</form>");
	    out.println("</div>");
	    out.println("</body>");
	    out.println("</html>");
	    
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cin = request.getParameter("cin");
		
		if(cin == null || cin.equals("301731890")==false){
			
		doGet(request, response);
		return;
		}
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("<div id=\"name\">");
		out.println("<div class=\"page-header\">");
		out.println("<h1>Placencia, Juan <small>CS3220</small></h1>");
		out.println("</div>");
		out.println("</div>");
		out.println("<p class=\"question 1\">");
		out.println("1. Hello, My name is Juan Placencia. My programming experience started around 2 years.");
		out.println("I found out I like to program when I was in a class from C++ programming. Since then ");
		out.println("I've programmed in three languages:C++. Java, and JavaScript, and I have haven't written");
		out.println("too many lines of code in either language except for java.");
		out.println("(Java 1000+, C++ 300, JavaScript 100)");
		out.println("</p>");
		out.println("<p class=\"Question 2\">");
		out.println(" 2. What I would like from this course would just expand my understanding of programming.");
		out.println(" If that make sense, to learn different how programming can be applied. This new found ");
		out.println(" knowledge would help me understand programming as a whole.");
		out.println(" </p>");
		out.println("<p class=\"Question 3\">");
		out.println(" 3. Something interesting about myself, huh? I'm normally relaxed person who doesn't get");
		out.println(" much, but I love to play video games. I've played them since my childhood they affected");
		out.println(" me a lot growing up. The rare times I leave school; besides college; I like to play soccer");
		out.println(" on sundays and going to the beach, but since its a good drive away. I don't go too often.");
		out.println("</p>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
