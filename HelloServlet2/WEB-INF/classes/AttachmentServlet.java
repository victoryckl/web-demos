import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AttachmentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {
		
		//response.setContentType("application/octet-stream");
		response.setContentType("application/x-msdownload");
		response.addHeader("Content-Disposition", "attachment;filename=aaa.txt");
		
		String text = "hello,world  " + System.currentTimeMillis();
		
		ServletOutputStream sos = response.getOutputStream();
		sos.write(text.getBytes());
		sos.close();
	}
}