package Final;

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


@WebServlet("/Final/AddLink")
public class AddLink extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public AddLink() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get the user input
		String title = request.getParameter( "title" );
		String link = request.getParameter("url");

		if(!title.trim().isEmpty() && !link.trim().isEmpty()){
			Connection c = null;
			try
			{
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu70";
				String username = "cs3220stu70";
				String password = "812!xL1B";

				String sql = "insert into list (title, link, count) values (?, ?,'0')";

				c = DriverManager.getConnection( url, username, password );
				PreparedStatement pstmt = c.prepareStatement( sql );
				pstmt.setString( 1, title );
				pstmt.setString( 2, link );
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
		}

		// send the user back
		response.sendRedirect( "List" );

	}

}
