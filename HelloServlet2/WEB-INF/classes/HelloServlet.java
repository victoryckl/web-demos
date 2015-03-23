import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
	public void service(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<p style=\"font-size:20px\">web-demos\\HelloServlet2\\WEB-INF\\classes\\HelloServlet.java</p>");
		out.println("<marquee>"+new java.util.Date()+"</marquee>");
		out.println(this.getClass().getClassLoader().getClass().getName());
		out.println("</html>");
	}
}