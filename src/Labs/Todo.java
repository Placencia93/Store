package Labs;

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

import Labs.TodoEntry;

@WebServlet("/Labs/Todo")
public class Todo extends HttpServlet {

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
		List<TodoEntry> todos = new ArrayList<TodoEntry>();
		List<TodoEntry> archived = new ArrayList<TodoEntry>();
		int todoCounter = 0;
		Connection c = null;
		try
		{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu70";
			String username = "cs3220stu70";
			String password = "812!xL1B";

			c = DriverManager.getConnection( url, username, password );
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "select * from todo" );

			while( rs.next() )
			{
				if(rs.getString("state").equals("archived")){
					TodoEntry entry = new TodoEntry( rs.getInt( "id" ),rs.getString( "description" ), rs.getString( "state" ) );
					archived.add(entry);

				}else{
					TodoEntry entry = new TodoEntry( rs.getInt( "id" ),rs.getString( "description" ), rs.getString( "state" ) );
					if(rs.getString("state").equals("notdone")){
						todoCounter++;
					}
					todos.add( entry );
				}
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

		request.setAttribute("remaining", todoCounter);
		request.setAttribute( "todos", todos );
		request.setAttribute("archived", archived);
		request.getRequestDispatcher( "/WEB-INF/Todo.jsp" ).forward(
				request, response );
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get the user input
		String description = request.getParameter( "description" );
		//String track = "notdone"; //request.getParameter( "message" );

		Connection c = null;
		try
		{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu70";
			String username = "cs3220stu70";
			String password = "812!xL1B";

			String sql = "insert into todo (description, state) values (?, 'notdone')";

			c = DriverManager.getConnection( url, username, password );
			PreparedStatement pstmt = c.prepareStatement( sql );
			pstmt.setString( 1, description );
			//pstmt.setString( 2, track );
			pstmt.executeUpdate();
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

		// send the user back
		response.sendRedirect( "Todo" );
	}
}
