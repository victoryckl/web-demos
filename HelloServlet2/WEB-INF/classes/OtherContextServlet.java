import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OtherContextServlet extends HttpServlet {
	public void service(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		ServletContext rootCtx = getServletContext().getContext("/");
		if (rootCtx != null) {
			out.println(rootCtx.getRealPath(""));
		} else {
			out.println("getContext failed!");
		}
	}
}