package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbConnect;
import model.Product;

/**
 * Servlet implementation class UpdateProductDetails
 */
@WebServlet("/updateProductDetails")
public class UpdateProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product ob=new Product();
		ob.setP_id(Long.parseLong(request.getParameter("p_id")));
		ob.setP_name(request.getParameter("p_name"));
		ob.setDescription(request.getParameter("description"));
		ob.setPrice(Long.parseLong(request.getParameter("price")));
		ob.setCatagory(request.getParameter("catagory"));
		HttpSession session = request.getSession(false);
		if(DbConnect.updateProduct(ob)){
			session.setAttribute("msg", "update occur successful");
			session.setAttribute("p_id",ob.getP_id());
			session.setAttribute("p_name",ob.getP_name());
			session.setAttribute("description",ob.getDescription());
			session.setAttribute("price",ob.getPrice());
			session.setAttribute("catagory",ob.getCatagory());
		}else{
			session.setAttribute("msg", "update did not occur successful");
		}
		response.sendRedirect("manager_product_update.jsp");
	}

}
