package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbConnect;
import model.Distributor;

/**
 * Servlet implementation class UpdateStatusDistributor
 */
@WebServlet("/updateStatusDistributor")
public class UpdateStatusDistributor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatusDistributor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Distributor ob=new Distributor();
		ob.setDis_id(Long.parseLong(request.getParameter("dis_id")));
		ob.setDis_status(request.getParameter("status"));
		HttpSession session = request.getSession(false);
		//System.out.print(session.getAttribute("id"));
		if(DbConnect.updateStatusDistributor(ob)){
			session.setAttribute("msg", "password change is successful");
		}else{
			session.setAttribute("msg", "password cahnge did not occur successful");
		}
		response.sendRedirect("admin_home.jsp");
	}

}
