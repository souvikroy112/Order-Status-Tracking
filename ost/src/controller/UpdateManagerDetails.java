package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbConnect;
import model.Manager;

/**
 * Servlet implementation class UpdateManagerDetails
 */
@WebServlet("/updateManagerDetails")
public class UpdateManagerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateManagerDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Manager ob=new Manager();
		ob.setMgr_id(Long.parseLong(request.getParameter("mgr_id")));
		ob.setMgr_name(request.getParameter("mgr_name"));
		ob.setMgr_dob(request.getParameter("mgr_dob"));
		ob.setMgr_city(request.getParameter("mgr_city"));
		ob.setMgr_contact(request.getParameter("mgr_contact"));
		ob.setMgr_email(request.getParameter("mgr_email"));
		HttpSession session = request.getSession(false);
		if(DbConnect.updateManager(ob)){
			session.setAttribute("msg", "update occur successful");
			session.setAttribute("mgr_id",ob.getMgr_id());
			session.setAttribute("mgr_name",ob.getMgr_name());
			session.setAttribute("mgr_dob",ob.getMgr_dob());
			session.setAttribute("mgr_city",ob.getMgr_city());
			session.setAttribute("mgr_contact",ob.getMgr_contact());
			session.setAttribute("mgr_email",ob.getMgr_email());
		}else{
			session.setAttribute("msg", "update did not occur successful");
		}
		response.sendRedirect("admin_manager_update.jsp");
	}

}
