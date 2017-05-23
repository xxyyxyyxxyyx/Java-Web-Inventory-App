<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Login</h2><br>
	</center>
	<form action="login">
		<table align="center">
			<tr>
				<th align="right">Username:</th>
				<td><input type="text" name="username" /></td>

			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<th align="right">Password:</th>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td><br></td>
			</tr>

			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="Login" class="btn btn-primary" /></td>
			</tr>
		</table>
	</form>
	<% String error = (String) session.getAttribute("error");
	if(error !=null){%>
	<h3 align="center"><%=error %></h3><%} %>
</body>
</html>