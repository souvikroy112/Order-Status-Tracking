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
 * Servlet implementation class InsertManagerDetails
 */
@WebServlet("/insertManagerDetails")
public class InsertManagerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertManagerDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Manager ob=new Manager();
		ob.setMgr_name(request.getParameter("mgr_name"));
		ob.setMgr_dob(request.getParameter("mgr_dob"));
		ob.setMgr_city(request.getParameter("mgr_city"));
		ob.setMgr_contact(request.getParameter("mgr_contact"));
		ob.setMgr_email(request.getParameter("mgr_email"));
		HttpSession session = request.getSession(false);
		if(DbConnect.newManager(ob)){
			session.setAttribute("msg", "Welcome Registration successfully done \n Your id is "+ob.getMgr_id());
		}else{
			session.setAttribute("msg", "User Id Already Taken");
		}
		response.sendRedirect("admin_home.jsp");
	}

}
