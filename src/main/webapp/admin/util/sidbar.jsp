<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<body>
<main>
	<div class="container-fluid">
		<div class="row">

			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="position-sticky pt-3">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#"> <span data-feather="home"></span>
								Welcome
						</a></li>

						<li class="nav-item"><a class="nav-link" href="Admin_UserServlet"> <span
								data-feather="users"></span> Customers
						</a></li>
					</ul>

					<h6
						class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
						<span>Order Section</span> <a class="link-secondary" href="#"
							aria-label="Add a new report"> <span
							data-feather="plus-circle"></span>
						</a>
					</h6>
					<ul class="nav flex-column mb-2">
						<li class="nav-item"><a class="nav-link" href="Admin_OrderedServlet"> <span
								data-feather="file-text"></span> Orders
						</a></li>
					<!-- 	<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> Orders History
						</a></li>  -->
					</ul>
					<h6
						class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
						<span>Products Section</span> <a class="link-secondary" href="#"
							aria-label="Add a new report"> <span
							data-feather="plus-circle"></span>
						</a>
					</h6>
					<ul class="nav flex-column mb-2">
						<li class="nav-item"><a class="nav-link" href="AdminProductServlet"> <span
								data-feather="file-text"></span> Products
						</a></li>
						<li class="nav-item"><a class="nav-link" href="addProducts.jsp"> <span
								data-feather="file-text"></span> add Products
						</a></li>
					</ul>
					<h6
						class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
						<span>Vendor Section</span> <a class="link-secondary" href="#"
							aria-label="Add a new report"> <span
							data-feather="plus-circle"></span>
						</a>
					</h6>
					<ul class="nav flex-column mb-2">
						<li class="nav-item"><a class="nav-link" href="Admin_VendorServlet"> <span
								data-feather="file-text"></span> Vendor
						</a></li>
						<li class="nav-item"><a class="nav-link" href="addVendor.jsp"> <span
								data-feather="file-text"></span> add Vendor
						</a></li>

					</ul>
				</div>
			</nav>