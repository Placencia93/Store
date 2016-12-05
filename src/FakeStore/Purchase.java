package FakeStore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Store/Purchase")
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Purchase() {
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
	
		Connection c = null;
		try
		{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu70";
			String username = "cs3220stu70";
			String password = "812!xL1B";

			c = DriverManager.getConnection( url, username, password );
			Statement stmt1 = c.createStatement();
			ResultSet rs1 = stmt1.executeQuery( "select * from Checkout" );

			while( rs1.next() )
			{

				inventoryEntry entry = new inventoryEntry( rs1.getString( "name" ),rs1.getString( "desciption" ), rs1.getInt( "quantity" ),rs1.getDouble("price"),rs1.getInt("id") );

				String sqll = "insert into History (name, desciption,quantity,price ) values (?,?,?,?)";
				PreparedStatement pstmt2 = c.prepareStatement( sqll );
				pstmt2.setString( 1, entry.getName() );
				pstmt2.setString( 2, entry.getDescription() );
				pstmt2.setString( 3, entry.getQuantity()+"" );
				pstmt2.setString( 4, entry.getPrice()+"" );
				pstmt2.executeUpdate();
				
				String sqlll = "delete from Checkout";
				PreparedStatement pstmt3 = c.prepareStatement( sqlll );
				pstmt3.executeUpdate();
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


		
		request.getRequestDispatcher( "StorePage" ).forward(request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doGet(request, response);
	}

}
