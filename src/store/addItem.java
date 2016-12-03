package store;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Inventory.Item;
import store.inventoryEntry;


@WebServlet("/store/addItem")
public class addItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public addItem() {
        super();
        
    }

    public void init( ServletConfig config ) throws ServletException
	{
		super.init( config );

		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
		}
		catch( ClassNotFoundException e )
		{
			throw new ServletException( e );
		}
	}

	protected void doGet( HttpServletRequest request,
			HttpServletResponse response ) throws ServletException, IOException
	{
		List<inventoryEntry> shoppingCart = new ArrayList<inventoryEntry>();
		
		String id = request.getParameter("id");
		
		Connection c = null;
		try
		{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu70";
			String username = "cs3220stu70";
			String password = "812!xL1B";

			c = DriverManager.getConnection( url, username, password );
			Statement stmt = c.createStatement();
			String sql = "select * from inventory where id=2";
			ResultSet rs = stmt.executeQuery(sql);

			while( rs.next() )
			{
				
					inventoryEntry entry = new inventoryEntry( rs.getString( "name" ),rs.getString( "desciption" ), rs.getInt( "quantity" ),rs.getDouble("price"),rs.getInt("id") );
									
					shoppingCart.add( entry );
				
			}
		}

		catch( SQLException e )
		{
			throw new ServletException( e );
		}
		finally
		{
			try
			{
				if( c != null ) c.close();
			}
			catch( SQLException e )
			{
				throw new ServletException( e );
			}
		}

		
		request.setAttribute( "shoppingCart", shoppingCart );
		request.getRequestDispatcher( "/WEB-INF/store.jsp" ).forward(request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
