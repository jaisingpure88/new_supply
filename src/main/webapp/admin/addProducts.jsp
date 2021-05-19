<%@ include file="util/header.jsp"%>
<%@ include file="util/navbar.jsp"%>
<%@ include file="util/sidbar.jsp"%>

<%
String ErrorMessage = "";
if (session.getAttribute("ERROR") != null) {
	ErrorMessage = (String) session.getAttribute("ERROR");
	session.removeAttribute("ERROR");
}
%>


			<div class="col-md-8 col-lg-10 d-md-block bg-light sidebar collapse" style="float: left;">
			

				<form action="addProducts" method="GET">
					<div>
						<h3>Add Products</h3>
						<br />
						<hr>

						<div class="mb-3">
							<label class="form-label">Product Name</label> <input type="text"
								name="ProductName" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Description</label> <input type="text"
								name="Description" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Price</label> <input type="text"
								name="Price" class="form-control">
						</div>


						<button type="submit" class="btn btn-primary">Submit</button>
				</form>


			</div>
		

