package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/kbs.mbc")
public class servletGo extends HttpServlet {
	int num;
	MyClass cla;
	public void init(ServletConfig config) throws ServletException {
		num = 0;
		cla = new MyClass();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		num++;
//		System.out.println(num);
//		
//		Thread th = Thread.currentThread();
//		System.out.println(th);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>poketmon Go수행</h1>");
		int a = 10, b =20;
		out.print(a + " " + b);
		int c = a+b;
		out.println(c + "__");
		out.println(calc(a,b));
		Calendar cal = Calendar.getInstance();
		out.println("<br>" + cal.get(Calendar.YEAR) + "년");
		//MyClass cla = new MyClass(); 여따쓰면 매번 만들어야됨
		String res = cla.msg("홍길동");
		out.println(res);
		cla.display(21, out);
		out.println("</body></html>");
		out.close();
	}
	
	private int calc(int m, int n) {
		return m + n;
		
	}

}
