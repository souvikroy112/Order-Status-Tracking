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
 * Servlet implementation class InsertProductDetails
 */
@WebServlet("/insertProductDetails")
public class InsertProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product ob=new Product();
		ob.setP_name(request.getParameter("product_title"));
		ob.setDescription(request.getParameter("product_decription"));
		ob.setPrice(Long.parseLong(request.getParameter("product_price")));
		ob.setCatagory(request.getParameter("product_catagory"));
		HttpSession session = request.getSession(false);
		if(DbConnect.newProduct(ob)){
			session.setAttribute("msg_product_add", "Product is registered successfully. Product id is "+ob.getP_id());
		}else{
			session.setAttribute("msg_product_add", "Product Id Already Taken");
		}
		response.sendRedirect("manager_home.jsp");
	}

}
