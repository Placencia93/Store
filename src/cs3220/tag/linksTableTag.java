package cs3220.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class linksTableTag extends SimpleTagSupport {

	int count;
	String title;
	String link;
	int id;

	public linksTableTag()
	{
	}

	public void setType( int count, String title, String link, int id )
	{
		this.count = count;
		this.title = title;
		this.link = link;
		this.id = id;
	}

	@Override
	public void doTag() throws JspException, IOException
	{
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

		out.println("<div class=\"link\">");  
		out.println("<c:forEach items=\"${list}" var="list">"); 
		out.println("	<tr>	");  
		out.println("		<td>");  
		out.println("				<span id="count">${list.count}</span>	"); 			
		out.println("		</td>		");  		
		out.println("		<td>"); 
		out.println("				${list.title}	"); 				
		out.println("		</td>"); 
		out.println("		<td>"); 
		out.println("				<a href="${list.link}">${list.link}	</a>	"); 			
		out.println("		</td>"); 
		out.println("		<td>"); 
		out.println("		
		out.println("			<c:url value="Upvote" var="updateUrl">");  
		out.println("			   <c:param name="id" value="${list.id}"/>");  

		out.println("			</c:url>");  

		out.println("			<a class="btn btn-default btn-xs" href="${updateUrl}">Upvote</a>");  

		out.println("		</td>");  
		out.println("		<td>");  

		out.println("			<c:url value="Downvote" var="updateUrl">");  
		out.println("<c:param name=\"id\" value=\"${list.id}\"/>"");  

		out.println("			</c:url>");  

		out.println("			<a class="btn btn-default btn-xs" href="${updateUrl}">Downvote</a>");  

		out.println("		</td>"); 

		out.println("	</tr>");  
		out.println("</c:forEach>)");  
		out.println("</div>"); 
	}
}
