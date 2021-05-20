<%@ page isELIgnored="false" %>
<%@ include file="util/header.jsp"%>
<%@ include file="util/navbar.jsp"%>
<%@ include file="util/sidbar.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-md-9 col-lg-10 d-md-block bg-light sidebar collapse"
	style="float: Rigth;">


	<form action="http://localhost:8081/supplychainmanagement/VendorProduct" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Product ID:</label></td>
						<td><input type="text" name="productID" /></td>
					</tr>

					<tr>
						<td><label>VendorID</label></td>
						<td><input type="text" name="vendorID" /></td>
					</tr>

					<tr>
						<td><label>Quantity:</label></td>
						<td><input type="text" name="quantity" /></td>
					</tr>
				
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" onclick="myFunction()" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
</div>
</div>
</div>
</main>

<script>
		$(document).ready(function() {
			$('#myTable').dataTable();
		});
	</script>
<script>
function myFunction() {
  alert("Product Added Successfully");
}
</script>
</body>
<footer class="navbar navbar-expand-md navbar-dark fixed-bottom bg-dark">

</footer>