package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Test1D")
public class Test1D extends HttpServlet {
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 HttpSession session = req.getSession(false);//읽기만 하기때문에
		if(session == null) return;
		ArrayList<TEST1_DTO> glist = (ArrayList<TEST1_DTO>)session.getAttribute("list");
		if(glist == null) return;
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><script type='text/javascript'>window.onload = function(){location.href='TEST1.html'}</script><body>");
		out.println("</body></html>");
		//session.invalidate(); //해당 클라이언트의 모든 세션삭제
		session.removeAttribute("list");//특정세션 키값만 제거
		out.close();
}

}
