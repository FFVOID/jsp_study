package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String result;

		if (n1.equals("person") && n2.equals("1234")) {
			result = n1 + " 님 반갑습니다";
		} else {
			result = "로그인실패";
		}

		out.append("<!doctype html>"
				+ "<html>" 
				+ "<head>"
				+ "<title>계산기</title>"
				+ "</head>"
				+ "<body>")
		.append("<h2>로그인 서블릿</h2>")
		.append("<hr>")
		.append(result)
		.append("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
