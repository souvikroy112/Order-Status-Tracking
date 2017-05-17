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
 * Servlet implementation class ProductDelete
 */
@WebServlet("/productDelete")
public class ProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product ob=new Product();
		ob.setP_id(Long.parseLong(request.getParameter("product_id")));
		HttpSession session = request.getSession(false);
		if(DbConnect.deleteProduct(ob)){
			session.setAttribute("msg_product_delete", "Product is deleted successfully");
		}else{
			session.setAttribute("msg_product_delete", "Product is not deleted successfully");
		}
		response.sendRedirect("manager_home.jsp");
	}

}
