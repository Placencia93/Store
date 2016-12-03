package Inventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddItem
 */
@WebServlet("/Store/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItem() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Item needs
		String name = request.getParameter("name") == null ? "name" : request.getParameter("name");
		String description = request.getParameter("description") == null ? "description" : request.getParameter("description");
		String quantity = request.getParameter("quantity") == null ? "0" : request.getParameter("quantity");
		String price = request.getParameter("price") == null ? "0" : request.getParameter("price");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<title>Add an Item</title>");
		out.println("</head>");
		out.println("<body>");
		//Add item form
		out.println("<form action=\"AddItem\" method=\"post\">");
		if(name.trim().isEmpty())
			out.println("<font color=\"red\">Please enter the name of the item</font><br/>");
		out.println("Name <br/>");
		out.println("<input type= \"text\"name=\"name\" value=\""+name+"\"/> <br/>");
		if(description.trim().isEmpty())
			out.println("<font color=\"red\">Please enter the desciption for the item</font><br/>");
		out.println("Description <br/>");
		out.println("<textarea rows=\"10\"columns=\"20\" name=\"description\" value=''>"+description+"</textarea> <br/>");
		if(isNumeric(quantity))
			out.println("<font color=\"red\">Only numbers below please</font><br/>");
		out.println("Quantity <br/>");
		out.println("<input type= \"text\"name=\"quantity\" value=\""+quantity+"\"> <br/>");
		if(isNumeric(price))
			out.println("<font color=\"red\">Only numbers below please</font><br/>");
		out.println("Price <br/>");
		out.println("<input type= \"text\"name=\"price\" value=\""+price+"\"> <br/><br/>");
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
		PrintWriter out = response.getWriter();
		//getting parameters & numbers
		String nameRequest = request.getParameter("name"); 
		String descriptionRequest = request.getParameter("description"); 
		String quantityRequest = request.getParameter("quantity");
		String priceRequest = request.getParameter("price");
		int check = 0;
		//checking for validation
		if(nameRequest.trim().isEmpty() || descriptionRequest.trim().isEmpty() || isNumeric(quantityRequest) || isNumeric(priceRequest)){
			check++;
		}
		if(check>0){
			request.setAttribute("name", nameRequest);
			request.setAttribute("description", descriptionRequest);
			request.setAttribute("quantity", quantityRequest);
			request.setAttribute("price", priceRequest);
			doGet(request, response);
			return;
		}
		//making the class then adding it to an array
		ArrayList<Item> items = (ArrayList<Item>) getServletContext().getAttribute("inventory");
		items.add(new Item(nameRequest,descriptionRequest,Integer.parseInt(quantityRequest),Double.parseDouble(priceRequest)));

		response.sendRedirect("../Store/Inventory");
	}

}
