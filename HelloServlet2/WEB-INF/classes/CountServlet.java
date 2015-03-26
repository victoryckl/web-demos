import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.util.Properties;

public class CountServlet extends HttpServlet {
	private long flag = 0;
	
	public void doGet(HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		//设置浏览器不要缓存此图片
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		flag++;
		System.out.println("doGet:" + flag);
		
		ServletOutputStream sos = response.getOutputStream();
		
		BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		//g.setColor(Color.BLACK);
		//g.fillRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		g.setFont(new Font(null, Font.ITALIC|Font.BOLD, 18));
		
		String value = getAccessCount(request);
		int len = value.length();
		//最大访问次数不能超过9999999
		if (len > 7) {
			value = "9999999";
		} else {
			String tmp = "";
			for (int i=0; i<7-len; i++) {
				tmp = tmp + "0";
			}
			value = tmp + value;
		}
		
		g.drawString(value, 0, 18);
		//结束图形的绘制过程，完成图像
		g.dispose();
		
		ImageIO.write(image, "JPEG", sos);
		sos.close();
	}
	
	private String getAccessCount(HttpServletRequest request) {
		//得到应用页面的URL地址，并以此作为访问次数的检索关键字
		String pageKey = request.getHeader("referer");
		if (pageKey == null) {
			System.err.println("pageKey is null");
			return "0";
		}
		
		Properties settings = new Properties();
		//count.txt等内部文件最好保存在WEB-INF目录中
		String countFilePath = getServletContext().getRealPath("/count.txt");
		try {
			//下面的语句没有使用close方法关闭流，有缺陷
			settings.load(new FileInputStream(countFilePath));
		} catch (Exception e) {
			log("load:" + e.getMessage());
		}
		
		String count = "0";
		try {
			count = settings.getProperty(pageKey);
			if (count == null) {
				count = "0";
			}
			int c = Integer.parseInt(count)+1;
			count = new Integer(c).toString();
			settings.put(pageKey, count);
			
			settings.store(new FileOutputStream(countFilePath), "the page is accessed:");
		} catch (Exception e) {
			log("store:" + e.getMessage());
		}
		return count;
	}
}