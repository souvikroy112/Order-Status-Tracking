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
import model.Salesman;

/**
 * Servlet implementation class SalesmanView
 */
@WebServlet("/salesmanView")
public class SalesmanView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesmanView() {
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
		
		ArrayList<Salesman> al=DbConnect.getSalesmanDetails(ob);
		if(al==null || al.size()==0)
		{
			session.setAttribute("msg", "Invalid Employee Id");
		}
		else
		{
			for(Salesman d:al)
			{
				session.setAttribute("salmn_id",d.getSalmn_id());
				session.setAttribute("salmn_name",d.getSalmn_name());
				session.setAttribute("salmn_dob",d.getSalmn_dob());
				session.setAttribute("salmn_city",d.getSalmn_city());
				session.setAttribute("salmn_contact",d.getSalmn_contact());
				session.setAttribute("salmn_email",d.getSalmn_email());
			}
		}
		response.sendRedirect("manager_salesman_view.jsp");
	}

}
