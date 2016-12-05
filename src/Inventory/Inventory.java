package Inventory;

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

/**
 * Servlet implementation class Inventory
 */
@WebServlet(urlPatterns={"/store/Inventory"},loadOnStartup = 1)
public class Inventory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		ArrayList<Item> inventory = new ArrayList<Item>();
		getServletContext().setAttribute("inventory", inventory);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Get a reference to the application scope
		ServletContext context = this.getServletContext();

		// Get a reference to the inventory
		ArrayList<Item> inventory = (ArrayList<Item>) context.getAttribute("inventory");



		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<!-- Latest compiled and minified CSS -->");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");			
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Inventory</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<div class=\"container\">");

		out.println("<div class=\"page-header\">");
		out.println("  <h1>Inventory <small>CS3220</small></h1>");
		out.println("</div>");
		//If there are no Items in the array list
		if(inventory.isEmpty()){
			out.println("<p><hr2> No Items have been adding</hr2></p> <br/>");
			out.println("<a class=\"btn btn-primary\" href=\"../Store/AddItem\">Add</a>");
			//else
		}else{
			//search bar
			out.println("<!doctype html><html lang=\"en-us\"><head><title>List of Users</title></head><body>");
			out.println("<form action='Inventory' method='get'><input type='text' name='query' /><input type='submit' value='search' /></form>");
			//The table
			out.println("<table class=\"table table-striped table-bordered table-hover\">");
			out.println("  <tr>");
			out.println("    <th>Name</th>");
			out.println("    <th>Description</th>");
			out.println("    <th>Quantity</th>");		
			out.println("    <th>Price</th>");
			out.println("    <th>Options</th>");
			out.println("  </tr>");

			// Print one table row <tr> for every entry in our guest book.

			for ( Item item : inventory){
				String query = request.getParameter("query");

				if (query == null || item.getName().contains(query.trim()) || item.getDescription().contains(query.trim())){
					out.println("<tr>");
					out.println("  <td>" + item.getName() + "</td>");
					out.println("  <td>" + item.getDescription() + "</td>");
					out.println("  <td>" + item.getQuantity() + "</td>");
					out.println("  <td>$ " + item.getPrice() + "</td>");
					out.println("  <td>");
					//out.println("    <a href=\"EditEntry?id=" + item.getId() + "\">Edit</a> | ");
					out.println("    <a href=\"../Store/Delete?id=" + item.getId() + "\">Delete</a>");
					out.println(" </td>");
					out.println("</tr>");
				}

			}

			out.println("</table>");
			out.println("<a class=\"btn btn-primary\" href=\"../Store/AddItem\">Add</a>");
			
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}
