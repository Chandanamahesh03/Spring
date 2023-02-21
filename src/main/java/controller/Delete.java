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

@WebServlet("/delete")
public class Delete extends HttpServlet
{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");   
//	email is not mandatory whatever v gave in the result.jsp v have to mention here
	
	UserDao dao= new UserDao();
	
	User user=dao.find(email);
//	email is 23 th line reference variable
	
	dao.delete(user);
//	23rd line user reference variable 
	
	List<User> list=dao.fetchAll();
	req.setAttribute("list",list);
	req.getRequestDispatcher("result.jsp").forward(req, resp);
}
}


