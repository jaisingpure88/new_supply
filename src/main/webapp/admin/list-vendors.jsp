<%@ page isELIgnored="false" %>
<%@ include file="util/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

<title>User</title>
</head>
<body style="padding-top:60px;">
	<table id="myTable" id="example" class="display" width="100%"
		cellspacing="0" class="table table-striped">

		<thead>
			<tr>
	<th>Vendor ID</th>
	<th>Vendor Name</th>
	<th>Vendor City</th>
	<th>Remove</th>
</tr>
		</thead>
		<tbody>
			<c:forEach var="tempVendor" items="${Vendor_LIST}">
			<c:url var="deleteLink" value="Admin_VendorServlet">
				<c:param name="command" value="DELETE"></c:param>
				<c:param name="vrndorID" value="${tempVendor.vrndorID}"></c:param>
			</c:url>
			<tr>
				<td>${tempVendor.vrndorID}</td>
				<td>${tempVendor.vendorName}</td>
				<td>${tempVendor.vendorCity}</td>
				<td><a href="${deleteLink}">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
<script>
 
$(document).ready(function(){
    $('#myTable').dataTable();
});
</script>

  
</body>
<footer class="navbar navbar-expand-md navbar-dark fixed-bottom bg-dark">

</footer>
</html>