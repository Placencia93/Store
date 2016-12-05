package FakeStore;

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


@WebServlet("/Store/AddItemToStore")
public class AddItemToStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddItemToStore() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the user input
				String name = request.getParameter( "name" );
				String description = request.getParameter("description");
				String price = request.getParameter("price");
				String quantity = request.getParameter("quantity");

					Connection c = null;
					try
					{
						String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu70";
						String username = "cs3220stu70";
						String password = "812!xL1B";

						String sql = "insert into inventory (name, desciption, quantity,price) values (?, ?,?,?)";

						c = DriverManager.getConnection( url, username, password );
						PreparedStatement pstmt = c.prepareStatement( sql );
						pstmt.setString( 1, name );
						pstmt.setString( 2, description );
						pstmt.setString( 3, quantity );
						pstmt.setString( 4, price );
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
				response.sendRedirect( "ManagerPage" );
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
