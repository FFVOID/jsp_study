package ch08;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rcontroller")
public class RegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	RegistService service;
	
	//프로그램 실행 후 최초로 request가 들어왔을때 딱 한번만 실행이된다
    @Override
	public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	//따라서 객체도 프로그램 실행시 딱 한번만 생성이된다(자원을 아끼기위해 한번만생성)
    	service = new RegistService();
	}

	public RegistController() {
        super();
    }
	
	//service = get(주소에 매개변수), post방식으로 오는 모든 request 데이터를 처리할수있다
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); //action 파라메터의 값을 얻어온다
		String view = "";
		
		//1. 주소에 따라 어떤 페이지를 보여줄지 지정
		if(action == null) {// 2.페이지에 맞는 데이터를 view페이지로 전달해준다(포워딩)
			getServletContext().getRequestDispatcher("/rcontroller?action=list").forward(request, response);
		} else {
			switch(action) {
			case "list":view = list(request,response); break;
			case "info":view = info(request,response); break;
			}
			
			getServletContext().getRequestDispatcher("/ch08/" + view).forward(request, response);
		}
	}
	
	//model인 RegistService한테 데이터 요청(메소드를 실행해서)
	private String info(HttpServletRequest request, HttpServletResponse response) {
		Regist r = service.find(request.getParameter("id"));
		//setAttribute 키,밸류 형태로 request 객체에 저장
		request.setAttribute("r", r);
		return "registInfo.jsp";
	}
	
	private String list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Regist> regists = service.findAll();
		request.setAttribute("regists", regists);
		return "registList.jsp";
	}
}
