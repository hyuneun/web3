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


@WebServlet("/Test")
public class Test extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bun = request.getParameter("bun");
		String name = request.getParameter("name");
		String kor = request.getParameter("kor");
		String eng = request.getParameter("eng");
		
		//System.out.println(name  + " " + price);
		HttpSession session = request.getSession(true);
		ArrayList<TEST1_DTO> glist = (ArrayList<TEST1_DTO>)session.getAttribute("list");
		if(glist == null){
			glist = new ArrayList<TEST1_DTO>();//없을경우(첫상품) 상품정보를 담을 컬렉션생성
		}
		glist.add(new TEST1_DTO(bun, name, kor, eng));
		session.setAttribute("list", glist);//세션에 상품이 컬렉션에담겨 저장
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		//out.println("<br>[<a href='shop.html'>계속쇼핑</a>]");
		//out.println("[<a href='Buy'>결제하기</a>]");
		out.println("<p><table style='text-align: center;' width='80%' border='1'>");
		out.println("<tr><th>번호</th><th>이름</th><th>국어</th><th>영어</th><th>총점</th></tr>");
		int tot=0;
		int tot2=0;
		for (int i = 0; i < glist.size(); i++) {
			TEST1_DTO goods = glist.get(i);
			tot = Integer.parseInt(goods.getEng()) + Integer.parseInt(goods.getKor());
			out.println("<tr><td>" + goods.getBun() + "</td>");
			out.println("<td>" + goods.getName() + "</td>");
			out.println("<td>" + goods.getKor() + "</td>");
			out.println("<td>" + goods.getEng() + "</td>");
			out.println("<td>" + tot + "</td></tr>");
			tot2++;
		}
		out.println("</table>");
		out.println("인원수 : " + tot2);
		out.println("<br><a href='TEST1.html'>새로입력</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<form action='Test1D'><input type='submit' value='세션삭제'></form>");
		out.println("</body></html>");
		out.close();
	}

}
