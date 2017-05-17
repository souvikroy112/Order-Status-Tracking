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
 * Servlet implementation class ChangePasswordNewManager
 */
@WebServlet("/changePasswordNewManager")
public class ChangePasswordNewManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordNewManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Manager ob=new Manager();
		ob.setMgr_password(request.getParameter("Password"));
		HttpSession session = request.getSession(false);
		//System.out.print(session.getAttribute("id"));
		ob.setMgr_id(Long.parseLong(""+session.getAttribute("id")));
		if(DbConnect.updateNewManagerPassword(ob)){
			session.setAttribute("msg", "password change is successful");
		}else{
			session.setAttribute("msg", "password cahnge did not occur successful");
		}
		response.sendRedirect("manager_login.jsp");
	}

}
