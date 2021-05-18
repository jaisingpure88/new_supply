<%@ page isELIgnored="false" %>
<%@ include file="util/header.jsp"%>
<%@ include file="util/navbar.jsp"%>
<%@ include file="util/sidbar.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-md-9 col-lg-10 d-md-block bg-light sidebar collapse"
	style="float: Rigth;">


	<div class="table-responsive">
		<table id="myTable" id="example" class="display" width="100%"
			cellspacing="0" class="table table-striped">

			<thead>
			<tr>
				<th>User ID</th>
				<th>User Name</th>
				<th>User City</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="tempUser" items="${User_LIST}">
				<tr>
					<td>${tempUser.userID }</td>
					<td>${tempUser.userName }</td>
					<td>${tempUser.userCity }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

	</div>
</div>
</div>
</div>
</main>

<script>
		$(document).ready(function() {
			$('#myTable').dataTable();
		});
	</script>

</body>
<footer class="navbar navbar-expand-md navbar-dark fixed-bottom bg-dark">

</footer>