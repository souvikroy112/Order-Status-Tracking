package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbConnect;
import model.Manager;

/**
 * Servlet implementation class ManagerView
 */
@WebServlet("/managerView")
public class ManagerView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Manager ob=new Manager();
		ob.setMgr_id(Long.parseLong(request.getParameter("manager_id")));
		HttpSession session = request.getSession(false);
		
		ArrayList<Manager> al=DbConnect.getManagerDetails(ob);
		if(al==null || al.size()==0)
		{
			session.setAttribute("msg", "Invalid Employee Id");
		}
		else
		{
			for(Manager d:al)
			{
				session.setAttribute("mgr_id",d.getMgr_id());
				session.setAttribute("mgr_name",d.getMgr_name());
				session.setAttribute("mgr_dob",d.getMgr_dob());
				session.setAttribute("mgr_city",d.getMgr_city());
				session.setAttribute("mgr_contact",d.getMgr_contact());
				session.setAttribute("mgr_email",d.getMgr_email());
			}
		}
		response.sendRedirect("admin_manager_view.jsp");
	}

}
