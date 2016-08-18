package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {         //HttpServlet 추상클래스
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //System.out.println("success");
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
	   out.println("<html><body>");
	   out.println("<h1>두부공작소</h1>");
	   out.println("</body></html>");
	   out.close();
   }

}