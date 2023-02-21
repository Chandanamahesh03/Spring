<%@page import="dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.0/xlsx.full.min.js"></script>
<script type="text/javascript">
function export_data(){
	let data=document.getElementById('data');
	var fp=XLSX.utils.table_to_book(data,{sheet:'sheet1'});
	XLSX.write(fp,{
		bookType:'xlsx',
		type:'base64'
	});
	XLSX.writeFile(fp, 'test.xlsx');
}
</script>
<meta charset="ISO-8859-1">
<title>Result</title>

</head>
<body>

<h1>Hey this is result</h1>
<%List <User> list=(List<User>) request.getAttribute("list"); %>
<%--      <%= list %>         --%>


<table border="1" id="data">
<tr>
<th> User Name </th>
<th> User Email </th>
<th> User Mobile </th>
<th> User Password</th>
<th> User Gender </th>
<th> User Address </th>
<th>Delete</th>
<th>Edit</th>
</tr>

<%
for (User user:list)
{%>
<tr>
 <td><%=user.getName() %></td>
 <td><%=user.getEmail() %></td>
 <td><%=user.getMobile() %></td>
 <td><%=user.getPassword() %></td>
 <td><%=user.getGender() %></td>
 <td><%=user.getAddress() %></td>
 <td><a href="delete?email=<%=user.getEmail()%>"><button>Delete</button></a></td>
 <td><a href="edit.jsp?email=<%=user.getEmail()%>"><button>Edit</button> </a></td>
 
 <%-- url rewriting ? is placeholder and email is ref variable and user.getEmail is a primary key --%>
 
</tr>

<% } %>
</table>
<br>

<button onclick="window.print()">Print</button>   
<%-- INBUILT METHOD USED TO PRINT THE SHEET --%>


<button onclick="export_data()">Export</button> 
<%-- INBUILT METHOD USED TO EXPORT DATA TO EXCEL  JS CODES--%>
<br>
<br>
<%-- --%><a href="login.html"><button>Logout</button></a>
</body>
</html>