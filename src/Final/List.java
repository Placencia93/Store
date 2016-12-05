package Final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Final.ListEntry;


@WebServlet("/Final/List")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public List() {
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
		ArrayList<ListEntry> list = new ArrayList<ListEntry>();
		
		Connection c = null;
		try
		{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu70";
			String username = "cs3220stu70";
			String password = "812!xL1B";

			c = DriverManager.getConnection( url, username, password );
			Statement stmt = c.createStatement();
			String sql = "select * from list order by count desc, title asc";
			ResultSet rs = stmt.executeQuery(sql);

			while( rs.next() )
			{
				
					ListEntry entry = new ListEntry( rs.getInt("id"),rs.getString( "title" ),rs.getString( "link" ),rs.getInt( "count" ) );
									
					list.add( entry );
				
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

		
		request.setAttribute( "list", list );
		request.getRequestDispatcher( "/WEB-INF/List.jsp" ).forward(request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
