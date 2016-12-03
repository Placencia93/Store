package MidTerm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Inventory.Item;

/**
 * Servlet implementation class MidTermLogIn
 */
//@WebServlet("/MidTerm/MidTermLogIn")
@WebServlet(urlPatterns={"/MidTerm/MidTermLogIn"},loadOnStartup = 1)
public class MidTermLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
        
        ArrayList<String> userNames = new ArrayList<String>();
		getServletContext().setAttribute("user", userNames);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		//get there name
		out.println("<form action=\"MidTermLogIn\" method=\"post\">");
		
		out.println("Before you take the quiz. Please Enter your name below. <br/>");
		out.println("If you don't want to use your name, just click the button. <br/>");
		out.println("<input type= \"text\"name=\"name\" value=' '/> <br/>");
		
		//button
		out.println("<input type=\"submit\" value=\"Take Quiz\" />");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getting name of user
		String nameRequest = request.getParameter("name")+" "; 
		
		int check = 0;
		if(nameRequest.trim().isEmpty()){
			check++;
		}
		if(check>0){
			nameRequest = "Friend";
		}
		//making the class then adding it to an array
		ArrayList<String> userNames = (ArrayList<String>) getServletContext().getAttribute("user");
		userNames.add(nameRequest);

		response.sendRedirect("../MidTerm/MidtermQuiz");
		//doGet(request, response);
		
	}

}
