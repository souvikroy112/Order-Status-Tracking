package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbConnect;
 
import model.Salesman;

/**
 * Servlet implementation class ChangePasswordNewSalesman
 */
@WebServlet("/changePasswordNewSalesman")
public class ChangePasswordNewSalesman extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordNewSalesman() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Salesman ob=new Salesman();
		ob.setSalmn_password(request.getParameter("Password"));
		HttpSession session = request.getSession(false);
		//System.out.print(session.getAttribute("id"));
		ob.setSalmn_id(Long.parseLong(""+session.getAttribute("id")));
		if(DbConnect.updateNewSalesmanPassword(ob)){
			session.setAttribute("msg", "password change is successful");
		}else{
			session.setAttribute("msg", "password cahnge did not occur successful");
		}
		response.sendRedirect("salesmanLogin.jsp");
	}

}
