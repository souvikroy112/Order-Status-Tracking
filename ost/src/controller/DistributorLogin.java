package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbConnect;
import model.Distributor;

/**
 * Servlet implementation class DistributorLogin
 */
@WebServlet("/distributorLogin")
public class DistributorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributorLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Distributor ob=new Distributor();
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if( cookies != null ){
			for (int i = 0; i < cookies.length; i++){
				cookie = cookies[i];
				if(cookie.getName().equals("userid_distributor"))
         		{
					 
					ob.setDis_id(Long.parseLong(cookie.getValue()));
         		}
         		if(cookie.getName().equals("password_distributor"))
         		{
         			ob.setDis_password(cookie.getValue());
         		}
			}
		}
		
		HttpSession session=request.getSession(false);
		ArrayList<Distributor> al=DbConnect.isValidDistributor(ob);
		for(Distributor d:al)
		{
			if(d.getDis_status().equals("active"))
			{
				session.setAttribute("user", ob);
				session.setAttribute("catagory1","distributor");
				session.setAttribute("id",ob.getDis_id());
				response.sendRedirect("distributor_home.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Distributor ob=new Distributor();
		ob.setDis_id(Long.parseLong(request.getParameter("Username")));
		ob.setDis_password(request.getParameter("Password"));
		HttpSession session=request.getSession();
		/*if(DbConnect.isValidDistributor(ob)){
			session.setAttribute("user", ob);
			session.setAttribute("catagory1","Distributor");
			session.setAttribute("id",ob.getDis_id());
			response.sendRedirect("admin_home.jsp");
		}else{
			session.setAttribute("msg", "User Id or Password is not valid");
			response.sendRedirect("admin_login.jsp");
		}*/
		ArrayList<Distributor> al=DbConnect.isValidDistributor(ob);
		if(al==null || al.size()==0)
		{
			session.setAttribute("msg", "Username or password is invalid");
			response.sendRedirect("distributor_login.jsp");
		}
		else
		{
			for(Distributor d:al)
			{
				if(d.getDis_status().equals("inactive"))
				{
					session.setAttribute("msg","Your account is "+d.getDis_status());
					response.sendRedirect("distributor_login.jsp");
				}
				else if(d.getDis_status().equals("rejected"))
				{
					session.setAttribute("msg","Your account is "+d.getDis_status());
					response.sendRedirect("distributor_login.jsp");
					
				}
				else if(d.getDis_status().equals("active"))
				{
					session.setAttribute("user", ob);
					session.setAttribute("catagory1","distributor");
					session.setAttribute("id",ob.getDis_id());
					Cookie userid_distributor = new Cookie("userid_distributor",""+ob.getDis_id());
					Cookie password_distributor = new Cookie("password_distributor",ob.getDis_password());
					userid_distributor.setMaxAge(60*60*24);
					password_distributor.setMaxAge(60*60*24);
					response.addCookie(userid_distributor);
					response.addCookie(password_distributor);
					response.sendRedirect("distributor_home.jsp");
				}
				else
				{
					session.setAttribute("msg","Your account is "+d.getDis_status());
					response.sendRedirect("distributor_login.jsp");
					
				}
			}
		}
	}

}
