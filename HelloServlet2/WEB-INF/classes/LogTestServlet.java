import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogTestServlet extends HttpServlet {
	public void service(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
		log("LogTestServlet is running.");
		try {
			int x = 3/0;
		} catch (Exception e) {
			log("LogTestServlet happen exception", e);
		}
	}
}