package controller;

import java.io.IOException;
//import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;


//@WebServlet(urlPatterns="/signup")
//@WebInitParam(name="cbranch",value="raj")
public class Signup extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		String cname= getServletConfig().getInitParameter("cname");
		String cbranch= getServletConfig().getInitParameter("cbranch");
	
	 User user = new User ();
	 
	 user.setName(req.getParameter("name"));
	 user.setAddress(req.getParameter("address"));
	 user.setEmail(req.getParameter("email"));
	 user.setGender(req.getParameter("gender"));
	 user.setMobile(Long.parseLong(req.getParameter("mobile")));
	 user.setPassword(req.getParameter("password"));
	 
	 UserDao userdao = new UserDao();
	 try
	 {
		 userdao.save(user); 
		 resp.getWriter().print("<h1> Account Created Sucessfully in " + cname + "," + cbranch + "</h1>");
		 req.getRequestDispatcher("Login.html").include(req, resp);
	 }
	 catch (Exception e)
	 {
		 resp.getWriter().print("<h1> Email already Exists</h1>");
		 req.getRequestDispatcher("signup.html").include(req, resp);
	}	 
	}
	
}
