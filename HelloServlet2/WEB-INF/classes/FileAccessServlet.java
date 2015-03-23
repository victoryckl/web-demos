import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Properties;

public class FileAccessServlet extends HttpServlet {
	public void service(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
		FileInputStream fis = new FileInputStream("my.properties");
		Properties props = new Properties();
		props.load(fis);
		
		PrintWriter out = response.getWriter();
		out.println("database="+props.getProperty("database"));
		out.println("username="+props.getProperty("username"));
		out.println("password="+props.getProperty("password"));
		
		fis.close();
	}
}