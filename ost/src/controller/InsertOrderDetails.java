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
import model.Order;
import model.Product;

/**
 * Servlet implementation class InsertOrderDetails
 */
@WebServlet("/insertOrderDetails")
public class InsertOrderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertOrderDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Order ob=new Order();
		Product ob1=new Product();
		Distributor ob2=new Distributor();
		ob1.setP_id(Long.parseLong(request.getParameter("product_id")));
		ob2.setDis_id(Long.parseLong(request.getParameter("distributor_id")));
		ob1.setPrice(Long.parseLong(request.getParameter("product_price")));
		ob.setUnit(Long.parseLong(request.getParameter("quantity")));
		HttpSession session = request.getSession(false);
		if(DbConnect.newOrder(ob,ob1,ob2)){
			session.setAttribute("msg", "Your order id is "+ob.getOrder_id());
		}else{
			session.setAttribute("msg", "Incorrect details");
		}
		response.sendRedirect("insertOrder.jsp");
	}

}
