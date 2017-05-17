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
 * Servlet implementation class UpdateSalesmanDetails
 */
@WebServlet("/updateSalesmanDetails")
public class UpdateSalesmanDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSalesmanDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Salesman ob=new Salesman();
		ob.setSalmn_id(Long.parseLong(request.getParameter("salmn_id")));
		ob.setSalmn_name(request.getParameter("salmn_name"));
		ob.setSalmn_dob(request.getParameter("salmn_dob"));
		ob.setSalmn_city(request.getParameter("salmn_city"));
		ob.setSalmn_contact(request.getParameter("salmn_contact"));
		ob.setSalmn_email(request.getParameter("salmn_email"));
		HttpSession session = request.getSession(false);
		if(DbConnect.updateSalesman(ob)){
			session.setAttribute("msg", "update occur successful");
			session.setAttribute("salmn_id",ob.getSalmn_id());
			session.setAttribute("salmn_name",ob.getSalmn_name());
			session.setAttribute("salmn_dob",ob.getSalmn_dob());
			session.setAttribute("salmn_city",ob.getSalmn_city());
			session.setAttribute("salmn_contact",ob.getSalmn_contact());
			session.setAttribute("salmn_email",ob.getSalmn_email());
		}else{
			session.setAttribute("msg", "update did not occur successful");
		}
		response.sendRedirect("manager_salesman_update.jsp");
	}

}
