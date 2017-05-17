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
 * Servlet implementation class InsertSalesmanDetails
 */
@WebServlet("/insertSalesmanDetails")
public class InsertSalesmanDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSalesmanDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Salesman ob=new Salesman();
		//Manager ob1=new Manager();
		ob.setSalmn_name(request.getParameter("salmn_name"));
		ob.setSalmn_dob(request.getParameter("salmn_dob"));
		ob.setSalmn_city(request.getParameter("salmn_city"));
		ob.setSalmn_contact(request.getParameter("salmn_contact"));
		ob.setSalmn_email(request.getParameter("salmn_email"));
		ob.setSalmn_zone_id(Long.parseLong(request.getParameter("zone")));
		HttpSession session = request.getSession(false);
		if(DbConnect.newSalesman(ob,Long.parseLong(session.getAttribute("id").toString()))){
			session.setAttribute("msg_salesman_add", "Welcome Registration successfully done.Your id is "+ob.getSalmn_id());
		}else{
			session.setAttribute("msg_salesman_add", "User Id Already Taken");
		}
		response.sendRedirect("manager_home.jsp");
	}

}
