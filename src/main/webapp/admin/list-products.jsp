<%@ page isELIgnored="false" %>
<%@ include file="util/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<body style="padding-top: 60px;">
	<table id="myTable" id="example" class="display" width="100%"
		cellspacing="0" class="table table-striped">

		<thead>
			<tr>
				<th scope="col">Product ID</th>
				<th scope="col">Product Name</th>
				<th scope="col">Product Description</th>
				<th scope="col">Product Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tempProduct" items="${Product_LIST}">
				<tr>
					<td>${tempProduct.productID}</td>
					<td>${tempProduct.productName}</td>
					<td>${tempProduct.productDisc}</td>
					<td>${tempProduct.productPrice}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		$(document).ready(function() {
			$('#myTable').dataTable();
		});
	</script>


</body>
<footer class="navbar navbar-expand-md navbar-dark fixed-bottom bg-dark">

</footer>

</html>

