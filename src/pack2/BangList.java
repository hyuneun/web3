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

@WebServlet("/BangList")
public class BangList extends HttpServlet {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
			pstmt = conn.prepareStatement("select * from guest order by code");
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
			System.out.println("asd");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		try {

			rs = pstmt.executeQuery();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html><body><table border='1'>");
			while (rs.next()) {
				out.println("<tr><td>" + rs.getString("code") + "</td><td>"
						+ rs.getString("name") + "</td></tr><tr><td colspan='2'>" 
						+ rs.getString("subject") + "</td></tr><tr><td colspan='2'>"
						+ rs.getString("content") + "</td></tr>");
			}

			out.println("</table></body></html>");
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
