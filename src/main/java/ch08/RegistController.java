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
	
    @Override
	public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	
    	service = new RegistService();
	}

	public RegistController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String view = "";
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/rcontroller?action=list").forward(request, response);
		} else {
			switch(action) {
			case "list":view = list(request,response); break;
			case "info":view = info(request,response); break;
			}
			
			getServletContext().getRequestDispatcher("/ch08/" + view).forward(request, response);
		}
	}

	private String info(HttpServletRequest request, HttpServletResponse response) {
		Regist r = service.find(request.getParameter("id"));
		
		request.setAttribute("r", r);
		return "registInfo.jsp";
	}
	
	private String list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Regist> regists = service.findAll();
		request.setAttribute("regists", regists);
		return "registList.jsp";
	}
}
