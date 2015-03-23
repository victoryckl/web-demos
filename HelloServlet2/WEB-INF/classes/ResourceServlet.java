import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.net.URL;

public class ResourceServlet extends HttpServlet {
	public void service(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		URL url = getServletContext().getResource("/WEB-INF/classes/my.properties");
		out.println(url.toString()+"<br/>");
		
		InputStream ips = getServletContext().getResourceAsStream("/WEB-INF/classes/my.properties");
		//InputStream ips = getClass().getResourceAsStream("/my.properties");
		
		Properties props = new Properties();
		props.load(ips);
		
		out.println("database="+props.getProperty("database")+"<br/>");
		out.println("username="+props.getProperty("username")+"<br/>");
		out.println("password="+props.getProperty("password")+"<br/>");
		
		ips.close();
	}
}