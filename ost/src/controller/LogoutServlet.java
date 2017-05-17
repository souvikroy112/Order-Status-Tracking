package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		if(session!=null){
			if(session.getAttribute("catagory1").toString().equals("admin"))
			{
				session.invalidate();
				 Cookie userid_admin = new Cookie("userid_admin", null);
				 Cookie password_admin = new Cookie("password_admin", null);
				 userid_admin.setMaxAge(0);
				 password_admin.setMaxAge(0);
			     response.addCookie(userid_admin);
			     response.addCookie(password_admin);
				response.sendRedirect("admin_login.jsp");
			}
			else if(session.getAttribute("catagory1").toString().equals("manager"))
			{
				session.invalidate();
				Cookie userid_admin = new Cookie("userid_manager", null);
				 Cookie password_admin = new Cookie("password_manager", null);
				 userid_admin.setMaxAge(0);
				 password_admin.setMaxAge(0);
			     response.addCookie(userid_admin);
			     response.addCookie(password_admin);
				response.sendRedirect("manager_login.jsp");
			}
			else if(session.getAttribute("catagory1").toString().equals("salesman"))
			{
				session.invalidate();
				Cookie userid_admin = new Cookie("userid_salesman", null);
				 Cookie password_admin = new Cookie("password_salesman", null);
				 userid_admin.setMaxAge(0);
				 password_admin.setMaxAge(0);
			     response.addCookie(userid_admin);
			     response.addCookie(password_admin);
				response.sendRedirect("salesmanLogin.jsp");
			}
			else if(session.getAttribute("catagory1").toString().equals("distributor"))
			{
				session.invalidate();
				Cookie userid_admin = new Cookie("userid_distributor", null);
				 Cookie password_admin = new Cookie("password_distributor", null);
				 userid_admin.setMaxAge(0);
				 password_admin.setMaxAge(0);
			     response.addCookie(userid_admin);
			     response.addCookie(password_admin);
				response.sendRedirect("distributor_login.jsp");
			}
			
		}
		else
		{
			response.sendRedirect("admin_login.jsp");
		}
		
		
		
		
		
		
		
		
		
		
	}

}
