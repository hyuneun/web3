package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieLogin")
public class CookieLogin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		//쿠기가 없는경우 로그인 화면 출력
		String id = null;
		String pwd = null;
		try {
			Cookie[] cookies = request.getCookies(); //클라이언트 컴의 모든 쿠키읽기
			for (int i = 0; i < cookies.length; i++) {
				String name = cookies[i].getName();
				if(name.equals("id")){
					id = URLDecoder.decode(cookies[i].getValue(),"utf-8");
				}
				if(name.equals("pwd")){
					pwd = URLDecoder.decode(cookies[i].getValue(),"utf-8");
				}
				
			}
		} catch (Exception e) {
			
		}
		
		if(id != null && pwd != null){
			out.println(id + "님은 쿠키를 통해 로그인 한 상태입니다");
			out.println("</body></html>");
			out.close();
			return;
		}
		
		out.println("*** 로그인 ***");
		out.println("<form method='post'>");
		out.println("id : <input type='text' name='id'><br>");
		out.println("pwd : <input type='text' name='pwd'><br>");
		out.println("<input type='submit' value='전송'><br>");
		out.println("</form>");
		
		out.println("</body></html>");
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(id.equals("aa") && pwd.equals("11")){
			//System.out.println("로긴 성공");
			id = URLEncoder.encode(id,"utf-8");
			Cookie idcook = new Cookie("id", id);
			idcook.setMaxAge(60*60*24*365);//쿠키 1년간보관
			
			pwd = URLEncoder.encode(pwd,"utf-8");
			Cookie pwdcook = new Cookie("pwd", pwd);
			pwdcook.setMaxAge(60*60*24*365);//쿠키 1년간보관
			
			response.addCookie(idcook); //클라이언트에 저장
			response.addCookie(pwdcook);
			out.println("로긴 성공");
			
		}else{
			//System.out.println("로긴 실패");
			out.println("로긴 실패");
		}
			
		out.println("</body></html>");
		out.close();
	}

}
