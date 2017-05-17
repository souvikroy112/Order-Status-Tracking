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
import model.Zone;

/**
 * Servlet implementation class DistributorSignUp
 */
@WebServlet("/distributorSignUp")
public class DistributorSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributorSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Distributor ob=new Distributor();
		Zone zone=new Zone();
		ob.setDis_name(request.getParameter("name"));
		ob.setDis_city(request.getParameter("city"));
		ob.setDis_password(request.getParameter("Password"));
		ob.setDis_mobile(request.getParameter("Mobile"));
		zone.setZone_id(Long.parseLong(request.getParameter("zone")));
		HttpSession session = request.getSession(false);
		if(DbConnect.newDistributor(ob,zone)){
			session.setAttribute("msg_dis_signup", "Welcome Registration successfully done.Your id is "+ob.getDis_id());
		}else{
			session.setAttribute("msg_dis_signup", "Incorrect details.<br>Please try again.");
		}
		response.sendRedirect("distributor_login.jsp");
	}

}
