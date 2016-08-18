package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetData")
public class GetData extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//받을떄
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String age = request.getParameter("age");
		System.out.println(name + " " + addr + " " + age);
		
		response.setContentType("text/html;charset=utf-8");//보낼때
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>"+name+addr+age+"</h1>");
		out.println("<br><a href='getdata.html'>다시<a/>");
		
		out.println("</body></html>");
		out.close();
	}

}
