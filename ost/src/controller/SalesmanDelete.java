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
 * Servlet implementation class SalesmanDelete
 */
@WebServlet("/salesmanDelete")
public class SalesmanDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesmanDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Salesman ob=new Salesman();
		ob.setSalmn_id(Long.parseLong(request.getParameter("salesman_id")));
		HttpSession session = request.getSession(false);
		if(DbConnect.deleteSalasman(ob)){
			session.setAttribute("msg_salesman_delete", "salesman is deleted successfully");
		}else{
			session.setAttribute("msg_salesman_delete", "salesman is not deleted successfully");
		}
		response.sendRedirect("manager_home.jsp");
	}

}
