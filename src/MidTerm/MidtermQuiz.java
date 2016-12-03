package MidTerm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Inventory.Item;

/**
 * Servlet implementation class MidtermQuiz
 */
//@WebServlet(urlPatterns={"/MidTerm/MidtermQuiz"},loadOnStartup = 1)
@WebServlet("/MidTerm/MidtermQuiz")
public class MidtermQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MidtermQuiz() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Get a reference to the application scope
		ServletContext context = this.getServletContext();

		// Get a reference to the inventory
		ArrayList<String> userNames = (ArrayList<String>) getServletContext().getAttribute("user");

		//Getting number for the problems using random class
		Random r = new Random();
		int add_1 = r.nextInt(100);
		int add_2 = r.nextInt(100);
		int sub_1 = r.nextInt(100);
		int sub_2 = r.nextInt(100);
		int mult_1 = r.nextInt(100);
		int mult_2 = r.nextInt(100);
		int div_1 = r.nextInt(100);
		int div_2 = r.nextInt(div_1);
		int count_ = 0;

		int add1 = request.getParameter("add1") == null ? add_1 : Integer.getInteger(request.getParameter("add1"));
		int add2 = request.getParameter("add2") == null ? add_2 : Integer.getInteger(request.getParameter("add2"));
		int sub1 = request.getParameter("sub1") == null ? sub_1 : Integer.getInteger(request.getParameter("sub1"));
		int sub2 = request.getParameter("sub2") == null ? sub_2 : Integer.getInteger(request.getParameter("sub2"));
		int mult1 = request.getParameter("mult1") == null ? mult_1 : Integer.getInteger(request.getParameter("mult1"));
		int mult2 = request.getParameter("mult2") == null ? mult_2 : Integer.getInteger(request.getParameter("mult2"));
		int div1 = request.getParameter("add1") == null ? div_1 : Integer.getInteger(request.getParameter("div1"));
		int div2 = request.getParameter("div2") == null ? div_2 : Integer.getInteger(request.getParameter("div2"));
		int count = request.getParameter("count") == null ? count_ : Integer.getInteger(request.getParameter("count"));


		//Making the sticky keys
		int additionAnswer = request.getParameter("additionAnswer") == null ? 0 : Integer.getInteger(request.getParameter("additionAnswer"));
		int subtractAnswer = request.getParameter("subtractAnswer") == null ? 0 : Integer.getInteger(request.getParameter("subtractAnswer"));
		int multiplyAnswer = request.getParameter("multiplyAnswer") == null ? 0 : Integer.getInteger(request.getParameter("multiplyAnswer"));
		int divisionAnswer = request.getParameter("divisionAnswer") == null ? 0 : Integer.getInteger(request.getParameter("divisionAnswer"));

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<!-- Latest compiled and minified CSS -->");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");			
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Midterm</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<div class=\"container\">");

		out.println("<div class=\"page-header\">");
		out.println("  <h1>Quiz <small>MidTerm</small></h1>");
		out.println("</div>");

		out.println("<p><Strong> Hello "+userNames.get(userNames.size()-1)+", below is the quiz, Good Luck ^_^</Strong></p>");

		out.println("<form action=\"MidtermQuiz\" method=\"post\">");
		//add problem
		out.print(" Question 1: What is "+add1+" + "+add2+" ? </br>");
		//if(Integer.parseInt(request.getParameter("add_answer")) == additionAnswer){
		out.println("<font color=\"green\" Correct ^_^></br>");
		//}
		out.println("<input type=\"text\" name=\"additionAnswer\" value=\""+additionAnswer+"\" /></br>  ");
		//sub problem
		out.print(" Question 2: What is "+sub1+" - "+sub2+" ? </br>");
		//if(Integer.parseInt(request.getParameter("sub_answer")) == additionAnswer){
		out.println("<font color=\"green\" Correct ^_^></br>");
		//}
		out.println("<input type=\"text\" name=\"subtractAnswer\" value=\""+subtractAnswer+"\" /> </br>     ");
		//mult problem
		out.print(" Question 3: What is "+mult1+" * "+mult2+" ?</br>");
		//if(Integer.parseInt(request.getParameter("mult_answer")) == additionAnswer){
		out.println("<font color=\"green\" Correct ^_^></br>");
		//}
		out.println("<input type=\"text\" name=\"multiplyAnswer\" value=\""+multiplyAnswer+"\"/>  </br>     ");
		//div problem
		out.print(" Question 4: What is "+div1+" / "+div2+" ? </br>");
		//if(Integer.parseInt(request.getParameter("div_answer")) == additionAnswer){
		out.println("<font color=\"green\" Correct ^_^></br>");
		//	}
		out.println("<input type=\"text\" name=\"divisionAnswer\" value=\""+divisionAnswer+"\"/>  </br>    ");
		out.println("<input type=\"submit\" value=\"Check Answers\" />");
		out.println("</form>");

		out.println("</table>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 0;
		//user answers
		int userAdd = Integer.parseInt(request.getParameter("additionAnswer"));
		int userSub = Integer.parseInt(request.getParameter("subtractAnswer"));
		int userMult = Integer.parseInt(request.getParameter("multiplyAnswer"));
		int userDiv = Integer.parseInt(request.getParameter("divisionAnswer"));

		int addd1 = Integer.parseInt(request.getParameter("add1"));
		int addd2 = Integer.parseInt(request.getParameter("add2"));
		int subb1 = Integer.parseInt(request.getParameter("sub1"));
		int subb2 = Integer.parseInt(request.getParameter("sub2"));
		int multt1 = Integer.parseInt(request.getParameter("mult1"));
		int multt2 = Integer.parseInt(request.getParameter("mult2"));
		int divv1 = Integer.parseInt(request.getParameter("div1"));
		int divv2 = Integer.parseInt(request.getParameter("div2"));
		//Getting the correct answers
		int add_answer = addd1 + addd2;
		int sub_answer = subb1 - subb2;
		int mult_answer = multt1 * multt2;
		int div_answer = divv1 / divv2;
		//Checking their work
		if(userAdd == add_answer)
			count++;
		if(userSub == sub_answer)
			count++;
		if(userMult == mult_answer)
			count++;
		if(userDiv == div_answer)
			count++;

		request.setAttribute("additionAnswer", userAdd);
		request.setAttribute("subtractAnswer", userSub);
		request.setAttribute("multiplyAnswer", userMult);
		request.setAttribute("divisionAnswer", userDiv);
		request.setAttribute("add1", addd1);
		request.setAttribute("add2", addd2);
		request.setAttribute("sub1", subb1);
		request.setAttribute("sub2", subb2);
		request.setAttribute("mult1", multt1);
		request.setAttribute("mult2", multt2);
		request.setAttribute("div1", divv1);
		request.setAttribute("div2", divv2);
		request.setAttribute("count", count);
		request.setAttribute("count", count);

		doGet(request, response);
	}

}
