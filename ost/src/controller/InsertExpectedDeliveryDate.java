package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbConnect;
import model.Order;

/**
 * Servlet implementation class InsertExpectedDeliveryDate
 */
@WebServlet("/insertExpectedDeliveryDate")
public class InsertExpectedDeliveryDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertExpectedDeliveryDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order ob=new Order();
		HttpSession session = request.getSession(false);
		//System.out.print(session.getAttribute("id"));
		ob.setOrder_id(Long.parseLong(request.getParameter("order_id")));
		ob.setExpected_delivery(request.getParameter("expected_date"));
		ob.setSalm_id_order(Long.parseLong(request.getParameter("salesman_id_order")));
		if(DbConnect.updateExpectedOrderDate(ob)){
			session.setAttribute("msg", "update is successful");
		}else{
			session.setAttribute("msg", "update is not successful");
		}
		response.sendRedirect("salesman_home.jsp");
	}

}
