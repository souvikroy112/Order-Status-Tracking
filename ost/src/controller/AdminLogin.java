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

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin ob=new Admin();
		 
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if( cookies != null ){
			for (int i = 0; i < cookies.length; i++){
				cookie = cookies[i];
				if(cookie.getName().equals("userid_admin"))
         		{
					 
					ob.setAdmin_id(Long.parseLong(cookie.getValue()));
         		}
         		if(cookie.getName().equals("password_admin"))
         		{
         			ob.setPassword(cookie.getValue());
         		}
			}
		}
		
		HttpSession session=request.getSession(false);
		if(DbConnect.isValid(ob)){
			session.setAttribute("user", ob);
			session.setAttribute("catagory1","admin");
			session.setAttribute("id",ob.getAdmin_id());
			 response.sendRedirect("admin_home.jsp");
			
		}else{
			session.setAttribute("msg", "User Id or Password is not valid");
			response.sendRedirect("admin_login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin ob=new Admin();
		 
		ob.setAdmin_id(Integer.parseInt(request.getParameter("Username")));
		ob.setPassword(request.getParameter("Password"));
		
		HttpSession session=request.getSession();
		if(DbConnect.isValid(ob)){
			session.setAttribute("user", ob);
			session.setAttribute("catagory1","admin");
			session.setAttribute("id",ob.getAdmin_id());
			Cookie userid_admin = new Cookie("userid_admin",""+ob.getAdmin_id());
			Cookie password_admin = new Cookie("password_admin",ob.getPassword());
			 userid_admin.setMaxAge(60*60*24);
			 password_admin.setMaxAge(60*60*24);
			 response.addCookie(userid_admin);
			 response.addCookie(password_admin);
			response.sendRedirect("admin_home.jsp");	
		}else{
			session.setAttribute("msg", "User Id or Password is not valid");
			response.sendRedirect("admin_login.jsp");
		}
	}

}
