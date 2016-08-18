package pack2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Bang")
public class Bang extends HttpServlet {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
			pstmt = conn.prepareStatement("insert into guest(name,subject,content) values(?,?,?)");
		} catch (Exception e) {
			System.out.println("디비연결실패" + e);
		}
	}


	public void destroy() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		System.out.println(name + " " + subject + " " + content);
		
		try {
			pstmt.setString(1, name);
			pstmt.setString(2, subject);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
			
			//response.sendRedirect("bang.html");//링크로 들어가기 스크립트의 location과 같은기능
			response.setContentType("text/html;charset=utf-8");
			
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h2>" + name +"님 등록완료 </h2>");
			out.println("<br><a href='bang.html'>새글입력</a>");
			out.println("<br><a href='BangList'>글내용보기</a>");
			out.println("</body></html>");
			out.close();
		} catch (Exception e) {
			
		}
		
	}

}




