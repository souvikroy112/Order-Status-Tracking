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
 * Servlet implementation class NewSalesmanValidity
 */
@WebServlet("/newSalesmanValidity")
public class NewSalesmanValidity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewSalesmanValidity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Salesman ob=new Salesman();
		ob.setSalmn_id(Integer.parseInt(request.getParameter("username_salesman")));
		ob.setSalmn_dob(request.getParameter("date_salesman"));
		HttpSession session=request.getSession();
		if(DbConnect.isValidNewSalesman(ob)){
			session.setAttribute("user", ob);
			session.setAttribute("catagory","manager");
			session.setAttribute("id",ob.getSalmn_id());
			response.sendRedirect("new_Salesman_login.jsp");
		}else{
			session.setAttribute("msg", "User Id or date of birth is not valid");
			response.sendRedirect("salesmanLogin.jsp");
		}
	}

}
