import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.net.URL;

//编译命令 javac -encoding UTF-8 ChineseServlet.java
public class ChineseServlet extends HttpServlet {
	public void service(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
		
		//response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//response.setLocale(new java.util.Locale("zh", "CN"));
		
		PrintWriter out = response.getWriter();
		out.println("6 <u>你好</u>");
	}
}