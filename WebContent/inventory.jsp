<%@ page language="java" import=" java.util.*, com.example.inventory.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet" />
</head>
<body>
<%!
	public void jspInit(){
	Controller controller = new Controller();
}
%>
<%
		ArrayList<Inventory> inventories = (ArrayList<Inventory>) request.getAttribute("database");
	%>
	<form action="controller">
		<table class="table">
			<tr>
				<td>
					<h3>Product Name</h3> <input name="name" class="form-control" />
				</td>
				<td>
					<h3>Qty</h3> <input name="qty" class="form-control" />
				</td>
				<td>
					<h3>Price</h3> <input name="price" class="form-control" />
				</td>
				<td>
					<h3><br> </h3>
					<button class="btn btn-success" name="action" value="create">Add</button>
				</td>
			</tr>
		</table>

	<h1>Inventory</h1>

		<table class="table">
			<tr>
				<td><h4>
						<b>Product Name</b>
					</h4></td>
				<td>
					<h4>
						<b>Qty</b>
					</h4>
				</td>
				<td>
					<h4>
						<b>Price</b>
					</h4>
				</td>
				<td>
					<h4>
						<b>Total</b>
					</h4>
				</td>
				<td>
					<h4>
						<b>Edit</b>
					</h4>
				</td>

			</tr>
			<%
				if (inventories != null) {
					for (Inventory inventory : inventories) {
			%>
			<tr>
				<td><%=inventory.getName()%></td>
				<td><%=inventory.getQty()%></td>
				<td><%=inventory.getPrice()%></td>
				<td><%=inventory.getTotal()%></td>
				<td><a href="controller?action=remove&id=<%=inventory.getId()%>"
					class="btn btn-danger"> Delete</a> <button
					name="id" value=<%=inventory.getId()%>
					class="btn btn-warning"> Update</button></td>
			</tr>
			<%
				}
				}
			%>
		</table>

	</form>


<a href="controller?action=logout" class="btn btn-danger">Log Out</a>
</body>
</html>