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
 * Servlet implementation class NewManagerValidity
 */
@WebServlet("/newManagerValidity")
public class NewManagerValidity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewManagerValidity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Manager ob=new Manager();
		ob.setMgr_id(Integer.parseInt(request.getParameter("username_manager")));
		ob.setMgr_dob(request.getParameter("date_maneger"));
		HttpSession session=request.getSession();
		if(DbConnect.isValidNewManager(ob)){
			session.setAttribute("user", ob);
			session.setAttribute("catagory","manager");
			session.setAttribute("id",ob.getMgr_id());
			response.sendRedirect("New_manage_login.jsp");
		}else{
			session.setAttribute("msg", "User Id or date of birth is not valid");
			response.sendRedirect("manager_login.jsp");
		}
	}

}
