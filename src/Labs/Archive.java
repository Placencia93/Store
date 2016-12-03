package Labs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Archive
 */
@WebServlet("/Labs/Archive")
public class Archive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Archive() {
        super();
        
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	       Connection c = null;
	       try
	       {
	       	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu70";
	           String username = "cs3220stu70";
	           String password = "812!xL1B";

	           String sql = "update todo set state = 'archived' where state = 'done'";

	           c = DriverManager.getConnection( url, username, password );
	           PreparedStatement pstmt = c.prepareStatement( sql );
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
