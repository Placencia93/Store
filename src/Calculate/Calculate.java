package Calculate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculate
 */
@WebServlet("/Calculate/Calculate")
public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext context = this.getServletContext();


		// TODO Auto-generated method stub
		response.setContentType("text/html");

		// Attendance parameters
		double possible_attendance = request.getParameter("possible_attendance") == null ? 100 : Double.parseDouble(request.getParameter("possible_attendance"));
		double my_attendance = request.getParameter("my_attendance") == null ? 0 : Double.parseDouble(request.getParameter("my_attendance"));
		double f_attendence = request.getParameter("f_attendence") == null ? 0 : Double.parseDouble(request.getParameter("f_attendence"));
		//HW&Labs Parameters
		double possible_hwlabs = request.getParameter("possible_hwlabs") == null ? 265 : Double.parseDouble(request.getParameter("possible_hwlabs"));
		double my_hwlabs = request.getParameter("my_hwlabs") == null ? 0 : Double.parseDouble(request.getParameter("my_hwlabs"));
		double f_HWandLabs = request.getParameter("f_HWandLabs") == null ? 0 : Double.parseDouble(request.getParameter("f_HWandLabs"));
		//Quizs Parameters
		double possible_quizes = request.getParameter("possible_quizes") == null ? 250 : Double.parseDouble(request.getParameter("possible_quizes"));
		double my_quizes = request.getParameter("my_quizes") == null ? 0 : Double.parseDouble(request.getParameter("my_quizes"));
		double f_Quizes = request.getParameter("f_Quizes") == null ? 0 : Double.parseDouble(request.getParameter("f_Quizes"));
		//Midterm Parameters
		double possible_midterm = request.getParameter("possible_midterm") == null ? 100 : Double.parseDouble(request.getParameter("possible_midterm"));
		double my_midterm = request.getParameter("my_midterm") == null ? 0 : Double.parseDouble(request.getParameter("my_midterm"));
		double f_Midterm = request.getParameter("f_Midterm") == null ? 0 : Double.parseDouble(request.getParameter("f_Midterm"));
		//Final Parameters
		double possible_final = request.getParameter("possible_final") == null ? 100 : Double.parseDouble(request.getParameter("possible_final"));
		double my_final = request.getParameter("my_final") == null ? 0 : Double.parseDouble(request.getParameter("my_final"));
		double f_Final = request.getParameter("f_Final") == null ? 0 : Double.parseDouble(request.getParameter("f_Final"));
		//Total Parameters
		double total = request.getParameter("total") == null ? 0 : Double.parseDouble(request.getParameter("total"));

		PrintWriter out = response.getWriter();

		out.println("");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<title>Grade Calculator</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<form action=\"Calculate\" method=\"post\">");

		out.println("Attendance: <input type=\"text\" name=\"possible_attendance\" value=\""+possible_attendance+"\" />  <input type=\"text\" name=\"my_attendance\"value=\""+my_attendance+"\"/> - "+request.getAttribute("f_attendence")+" / 5% <br />");
		out.println("HW & Labs:  <input type=\"text\" name=\"possible_hwlabs\" value=\""+possible_hwlabs+"\" />          <input type=\"text\" name=\"my_hwlabs\"    value=\""+my_hwlabs+"\" />    - "+request.getAttribute("f_HWandLabs")+"  / 20% <br />");
		out.println("Quizes:     <input type=\"text\" name=\"possible_quizes\" value=\""+possible_quizes+"\"/>           <input type=\"text\" name=\"my_quizes\"    value=\""+my_quizes+"\" />    - "+request.getAttribute("f_Quizes")+" / 25%  <br />");
		out.println("Midterm:    <input type=\"text\" name=\"possible_midterm\" value=\""+possible_midterm+"\"/>         <input type=\"text\" name=\"my_midterm\"   value=\""+my_midterm+"\" />   - "+request.getAttribute("f_Midterm")+" / 25% <br />");
		out.println("Final:      <input type=\"text\" name=\"possible_final\" value=\""+possible_final+"\"/>             <input type=\"text\" name=\"my_final\"     value=\""+my_final+"\" />     - "+request.getAttribute("f_Final")+" / 25%   <br />");
		out.println("Total:      "+request.getAttribute("total")+" / 100%   <br />");
		out.println("<input type=\"submit\" value=\"Calculate\" />");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String p_Attendence = request.getParameter("possible_attendance");
		String p_HWandLabs = request.getParameter("possible_hwlabs");

		String p_Quizes = request.getParameter("possible_quizes");
		String p_Midterm = request.getParameter("possible_midterm");

		String p_Final = request.getParameter("possible_final");
		String m_Attendence = request.getParameter("my_attendance");

		String m_HWandLabs = request.getParameter("my_hwlabs");
		String m_Quizes = request.getParameter("my_quizes");

		String m_Midterm = request.getParameter("my_midterm");
		String m_Final = request.getParameter("my_final");

		double f_Attendance = Double.parseDouble(m_Attendence)/Double.parseDouble(p_Attendence)*.05*100;
		double f_HWandLabs = Double.parseDouble(m_HWandLabs)/Double.parseDouble(p_HWandLabs)*.20*100;
		double f_Quizes = Double.parseDouble(m_Quizes)/Double.parseDouble(p_Quizes)*.25*100;
		double f_Midterm = Double.parseDouble(m_Midterm)/Double.parseDouble(p_Midterm)*.25*100;
		double f_Final = Double.parseDouble(m_Final)/Double.parseDouble(p_Final)*.25*100;
		double total = f_Attendance+f_HWandLabs+f_Quizes+f_Midterm+f_Final;

		//Final Values
		request.setAttribute("f_attendence", Math.floor(f_Attendance*100)/100); 
		request.setAttribute("f_HWandLabs", Math.floor(f_HWandLabs*100)/100);
		request.setAttribute("f_Quizes", Math.floor(f_Quizes*100)/100);
		request.setAttribute("f_Midterm", Math.floor(f_Midterm*100)/100);
		request.setAttribute("f_Final", Math.floor(f_Final*100)/100);
		request.setAttribute("total", Math.floor(total*100)/100);

		//return last values
		request.setAttribute("possible_attendance", p_Attendence);
		request.setAttribute("my_attendance", m_Attendence);

		request.setAttribute("possible_hwlabs", p_HWandLabs);
		request.setAttribute("my_hwlabs", m_HWandLabs);

		request.setAttribute("possible_quizes", p_Quizes);
		request.setAttribute("my_quizes", m_Quizes);

		request.setAttribute("possible_midterm", p_Midterm);
		request.setAttribute("my_midterm", m_Midterm);

		request.setAttribute("possible_final", p_Final);
		request.setAttribute("my_final", m_Final);
		
		doGet(request, response);

		/*out.println(f_Attendance);
		out.println(f_HWandLabs);
		out.println(f_Quizes);
		out.println(f_Midterm);
		out.println(f_Final);
		out.println(total);*/

	}

}
