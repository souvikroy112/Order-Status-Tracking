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
import model.Manager;

/**
 * Servlet implementation class OldManagerLogin
 */
@WebServlet("/oldManagerLogin")
public class OldManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OldManagerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Manager ob=new Manager();
		 
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if( cookies != null ){
			for (int i = 0; i < cookies.length; i++){
				cookie = cookies[i];
				if(cookie.getName().equals("userid_manager"))
         		{
					 
					ob.setMgr_id(Long.parseLong(cookie.getValue()));
         		}
         		if(cookie.getName().equals("password_manager"))
         		{
         			ob.setMgr_password(cookie.getValue());
         		}
			}
		}
		
		HttpSession session=request.getSession(false);
		if(DbConnect.isValidManager(ob)){
			session.setAttribute("user", ob);
			session.setAttribute("catagory1","manager");
			session.setAttribute("id",ob.getMgr_id());
			 response.sendRedirect("manager_home.jsp");
			
		}else{
			session.setAttribute("msg", "User Id or Password is not valid");
			response.sendRedirect("manager_login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Manager ob=new Manager();
		ob.setMgr_id(Integer.parseInt(request.getParameter("Username")));
		ob.setMgr_password(request.getParameter("Password"));
		HttpSession session=request.getSession();
		if(DbConnect.isValidManager(ob)){
			session.setAttribute("user", ob);
			session.setAttribute("catagory1","manager");
			session.setAttribute("id",ob.getMgr_id());
			Cookie userid_manager = new Cookie("userid_manager",""+ob.getMgr_id());
			Cookie password_manager = new Cookie("password_manager",ob.getMgr_password());
			userid_manager.setMaxAge(60*60*24);
			password_manager.setMaxAge(60*60*24);
			 response.addCookie(userid_manager);
			 response.addCookie(password_manager);
			response.sendRedirect("manager_home.jsp");
		}else{
			session.setAttribute("msg", "User Id or Password is not valid");
			response.sendRedirect("manager_login.jsp");
		}
	}

}
