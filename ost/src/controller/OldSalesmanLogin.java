package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbConnect;
import model.Admin;
import model.Salesman;

/**
 * Servlet implementation class OldSalesmanLogin
 */
@WebServlet("/oldSalesmanLogin")
public class OldSalesmanLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OldSalesmanLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Salesman ob=new Salesman();
		 
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if( cookies != null ){
			for (int i = 0; i < cookies.length; i++){
				cookie = cookies[i];
				if(cookie.getName().equals("userid_salesman"))
         		{
					 
					ob.setSalmn_id(Long.parseLong(cookie.getValue()));
         		}
         		if(cookie.getName().equals("password_salesman"))
         		{
         			ob.setSalmn_password(cookie.getValue());
         		}
			}
		}
		
		HttpSession session=request.getSession(false);
		if(DbConnect.isValidSalesman(ob)){
			session.setAttribute("user", ob);
			session.setAttribute("catagory1","salesman");
			session.setAttribute("id",ob.getSalmn_id());
			 response.sendRedirect("salesman_home.jsp");
			
		}else{
			session.setAttribute("msg", "User Id or Password is not valid");
			response.sendRedirect("salesmanLogin.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Salesman ob=new Salesman();
		ob.setSalmn_id(Integer.parseInt(request.getParameter("Username")));
		ob.setSalmn_password(request.getParameter("Password"));
		HttpSession session=request.getSession();
		if(DbConnect.isValidSalesman(ob)){
			session.setAttribute("user", ob);
			session.setAttribute("catagory1","salesman");
			session.setAttribute("id",ob.getSalmn_id());
			Cookie userid_salesman = new Cookie("userid_salesman",""+ob.getSalmn_id());
			Cookie password_salesman = new Cookie("password_salesman",ob.getSalmn_password());
			userid_salesman.setMaxAge(60*60*24);
			password_salesman.setMaxAge(60*60*24);
			 response.addCookie(userid_salesman);
			 response.addCookie(password_salesman);
			response.sendRedirect("salesman_home.jsp");
		}else{
			session.setAttribute("msg", "User Id or Password is not valid");
			response.sendRedirect("salesmanLogin.jsp");
		}
	}

}
