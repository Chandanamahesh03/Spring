<%@page import="dto.User"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("id")==null)
{
	response.getWriter().print("<h1>Invalid Session Login again</h1>");
	request.getRequestDispatcher("login.html").include(request, response);
}

else{
	
}
%>
<%String email=request.getParameter("email"); 
UserDao dao=new UserDao();
User user=dao.find(email);

%>
<form action="update" method="post">
<input type="text" name="id" value="<%=user.getId()%>"  hidden="hidden"> <br> 
Name : <input type="text" name="name" value="<%=user.getName()%>"> <br> <br>
Phno : <input type="text" name="mobile" value="<%= user.getMobile()%>"> <br><br>
Email : <input type="text" name="email" value="<%=user.getEmail()%>"     readonly="readonly"> <br><br>
Password :<input type="password" name="password" <%=user.getPassword()%> ><br><br>
      
<%
if (user.getGender().equals("male")){%>
Gender : 
<input type="radio" value="male" name="gender" checked="checked">MALE
<input type="radio" value="female" name="gender">FEMALE 
<%}else{ %>
Gender : <input type="radio" value="male" name="gender">MALE
         <input type="radio" value="female" name="gender" checked="checked">FEMALE 
         <% }%>
         <br><br>
Address : <textarea rows="5" cols="20" name="address" value="<%=user.getAddress()%>"></textarea> <br>

 <button>Update</button>  <button type="reset">Cancel</button>         

</body>
</html>