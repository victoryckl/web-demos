import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ThreadServlet extends HttpServlet implements SingleThreadModel {
	private int count = 0;

	public void service(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
		count++;
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		String text = "this is the "+count+" time to visit this servlet, Thread:"+Thread.currentThread().getName();
		System.out.println(text);
		PrintWriter out = response.getWriter();
		out.println(text);
	}
}