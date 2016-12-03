package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name") == null ? "0" : request.getParameter("name");
		
		out.println("");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<title>Add an Item</title>");
		out.println("</head>");
		out.println("<body>");
		//Add item form
		out.println("<form action=\"test\" method=\"post\">");
		if(isNumeric(name))
			out.println("<font color=\"red\">Please re-enter the name</font><br/>");
		out.println("Name <br/>");
		out.println("<input type= \"textarea\"name=\"name\" value=\""+name+"\"/> <br/>");
		
		//button
		out.println("<input type=\"submit\" value=\"Add\" />");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");

	}

	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return true;  
	  }  
	  return false;  
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//getting parameters & numbers
				String nameRequest = request.getParameter("name"); 
				int check = 0;
				//checking for validation
			//	if(nameRequest.trim().isEmpty()==false){
			//		request.setAttribute("name_V","invalid");
			//		check++;
			//	}
				if(nameRequest.trim().isEmpty()){
					request.setAttribute("name", nameRequest);
					doGet(request, response);
					return;
				}
		
		doGet(request, response);
	}

}
