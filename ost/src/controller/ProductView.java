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
import model.Product;

/**
 * Servlet implementation class ProductView
 */
@WebServlet("/productView")
public class ProductView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductView() {
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
		
		ArrayList<Product> al=DbConnect.getProductDetails(ob);
		if(al==null || al.size()==0)
		{
			session.setAttribute("msg", "Invalid Product Id");
		}
		else
		{
			for(Product d:al)
			{
				session.setAttribute("p_id",d.getP_id());
				session.setAttribute("p_name",d.getP_name());
				session.setAttribute("description",d.getDescription());
				session.setAttribute("price",d.getPrice());
				session.setAttribute("catagory",d.getCatagory());
			}
		}
		response.sendRedirect("manager_product_view.jsp");
	}

}
