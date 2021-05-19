<%@ include file="util/header.jsp"%>
<%@ include file="util/navbar.jsp"%>
<%@ include file="util/sidbar.jsp"%>
<%@ page  import="com.scm.admin.servlet.*" %>

	
			<div class="col-md-8 col-lg-10 d-md-block bg-light sidebar collapse" style="float: left;">

				<form action="vendorRegister" method="post">
					<div>
						<h3>Vendor Register</h3>
					</div>
					<div class="mb-3">
						<label class="form-label">Name</label> <input type="text"
							name="VendorName" class="form-control">
					</div>
					<div class="mb-3">
						<label class="form-label">City</label> <input type="text"
							name="VendorCity" class="form-control">
						
					</div>
					<div class="mb-3">
						<label class="form-label">Password</label> <input type="password"
							name="VendorPassword" class="form-control">
					</div>
					<button type="submit" class="btn btn-primary"><a href="success.jsp">Vendor Added</a></button>

					

				</form>



			</div>


