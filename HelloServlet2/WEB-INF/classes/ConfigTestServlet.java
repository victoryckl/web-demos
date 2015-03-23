import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class ConfigTestServlet extends HttpServlet {
	public void service(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		
		out.println("Servlet Name: "+getServletName()+"<br/>");
		Enumeration e = getInitParameterNames();
		out.println("Servlet 初始化参数: <br/>");
		while(e.hasMoreElements()) {
			String key = (String)e.nextElement();
			String value = getInitParameter(key);
			out.println("&nbsp;&nbsp;"+key+"="+value+"<br/>");
		}
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("/");
		out.println("current Webapp's localpath: " + path + "<br/>");
		
		out.println("</html>");
	}
}