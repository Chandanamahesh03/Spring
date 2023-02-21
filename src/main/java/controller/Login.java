
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;
//@WebServlet("/Login")
//@WebInitParam(name="cbranch", value="banglore")
public class Login extends HttpServlet
{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	String cname= getServletConfig().getInitParameter("cname");
	String cbranch= getServletConfig().getInitParameter("cbranch");

	
String Email = req.getParameter("email");
String Password = req.getParameter("password");

UserDao dao = new UserDao();
User user = dao.find(Email);
if (user==null)
{
	resp.getWriter().print("<h1>Invalid Password </h1>");
	req.getRequestDispatcher("Login.html").include(req, resp);
}
else
{
	if(user.getPassword().equals(Password))
	{
		
		
////		resp.sendRedirect("http://www.youtube.com");
//		resp.getWriter().print("<h1>Login Success</h1>" + cname+ " "+ cbranch);
//		
//		List<User> list = dao.fetchAll();		
//	    for(User u:list)
//	    {
//	    resp.getWriter().print("<h1>UserName : "+u.getName()+ "</h1>");	
//	    resp.getWriter().print("<h1>UserEmail : "+u.getEmail() + "</h1>");
//	    resp.getWriter().print("<h1>UserPhoneno : "+u.getMobile()+ "</h1>");
//	    resp.getWriter().print("<h1>Usergender : "+u.getGender()+ "</h1>");
//	    resp.getWriter().print("<h1>UserAddress : "+u.getAddress()+ "</h1>");
//	    resp.getWriter().print("------------------------------");
//	    }
//	    
//	    resp.getWriter().print("<h1>----------------------<h1>");
//	    
//	    resp.getWriter().print("<table border=\"1\">"
//	    		+ "<tr>"
//	    		+ "<th> User Name </th>"
//	    		+ "<th> User Email </th>"
//	    		+ "<th> User Mobile </th>"
//	    		+ "<th> User Password </th>"
//	    		+ "<th> User Address </th>"
//	    		+ "</tr>");
//	    	
//	    		for(User u:list)
//	    		{
//	    			resp.getWriter().print(
//	    					"<tr><th>"+u.getName()+"</th>"
//	    					+"<th>"+u.getEmail()+"</th>"
//	    					+"<th>"+u.getGender()+"</th>"
//	    					+"<th>"+u.getMobile()+"</th>"
//	    					+"<th>"+u.getAddress()+"</th>"
//	    					+"</tr>");
//	    		}
//	    		resp.getWriter().print("</table>");
		
        List<User> list = dao.fetchAll();

        req.setAttribute("list", list);
		req.getRequestDispatcher("result.jsp").forward(req, resp);
	    		 
	}
	else 
	{
		resp.setContentType("text/html");
		resp.getWriter().print("<h1> Invalid password</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
}
}
}
