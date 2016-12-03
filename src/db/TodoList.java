package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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

//import cs3220.db.TodoEntries;

@WebServlet("/db/Todo")
public class TodoList extends HttpServlet {
	private static final long serialVersionUID1 = 1L;

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
	        List<TodoEntries> entries = new ArrayList<TodoEntries>();
	        Connection c = null;
	        try
	        {
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu70";
	            String username = "cs3220stu70";
	            String password = "812!xL1B";

	            c = DriverManager.getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( "select * from TodoList" );

	            while( rs.next() )
	            {
	            	TodoEntries entry = new TodoEntries( rs.getInt( "id" ),rs.getString( "post" ), rs.getInt( "track" ) );
	                entries.add( entry );
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

	        request.setAttribute( "entries", entries );
	        request.getRequestDispatcher( "/WEB-INF/Todo.jsp" ).forward(
	            request, response );
	    }

	    protected void doPost( HttpServletRequest request,
	        HttpServletResponse response ) throws ServletException, IOException
	    {
	        doGet( request, response );
	    }

}
