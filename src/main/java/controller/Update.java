package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/update")
public class Update extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	
	 User user = new User ();
	 user.setId(Integer.parseInt(req.getParameter("id")));
	 user.setName(req.getParameter("name"));
	 user.setAddress(req.getParameter("address"));
	 user.setEmail(req.getParameter("email"));
	 user.setGender(req.getParameter("gender"));
	 user.setMobile(Long.parseLong(req.getParameter("mobile")));
	 user.setPassword(req.getParameter("password"));
	 
	 UserDao dao = new UserDao();
	 dao.updateUser(user);
	 
	 List<User> list=dao.fetchAll();
	 
		req.setAttribute("list",list);
		req.getRequestDispatcher("result.jsp").forward(req, resp);
	
}
}
