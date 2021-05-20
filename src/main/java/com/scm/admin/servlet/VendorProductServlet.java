package com.scm.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.scm.model.AddVendorProduct;
import com.scm.model.VendorProduct;


/**
 * Servlet implementation class VendorProductServlet
 */
@WebServlet("/VendorProduct")
public class VendorProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private VendorProductDbUtil vendorProductDbUtil;
	@Resource(name = "jdbc/supplychainmanagement")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			vendorProductDbUtil = new VendorProductDbUtil(dataSource);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	try {
		String theCommand = request.getParameter("command");
		
		// if the command is missing, then default to listing students
		if (theCommand == null) {
			theCommand = "LIST";
		}
		
		// route to the appropriate method
		switch (theCommand) {
		
		case "LIST":
			listVendorProducts(request, response);
			break;
			
		case "ADD":
			addVendorProduct(request, response);
			break;
			
		case "LOAD":
			loadProduct(request, response);
			break;
			
		case "UPDATE":
			updateProduct(request, response);
			break;
			
		default:
			listVendorProducts(request, response);
		}	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// read student info from form data
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				int productID =  Integer.parseInt(request.getParameter("productID"));
//				String lastName = request.getParameter("lastName");
//				String email = request.getParameter("email");
				
				// create a new student object
				VendorProduct theProduct = new VendorProduct(quantity,productID);
				
				// perform update on database
				vendorProductDbUtil.updateProduct(theProduct);
				
				// send them back to the "list students" page
				listVendorProducts(request, response);
	}

	private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// read student id from form data
		String theProductId = request.getParameter("productID");
		
		// get student from database (db util)
		VendorProduct theProduct = vendorProductDbUtil.getProduct(theProductId);
		
		// place student in the request attribute
		request.setAttribute("THE_PRODUCT", theProduct);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("vendor/update-product-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addVendorProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int productID = Integer.parseInt(request.getParameter("productID"));
		int vendorID = Integer.parseInt(request.getParameter("vendorID"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));	
		
		
		// create a new student object
		AddVendorProduct theVendor = new AddVendorProduct(vendorID,productID,quantity);
		
		// add the student to the database
		vendorProductDbUtil.addVendorProduct(theVendor);
				
		// send back to main page (the student list)
		listVendorProducts(request, response);
	}

	private void listVendorProducts(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<VendorProduct> vendorproducts = vendorProductDbUtil.getVendorProducts();
		request.setAttribute("VendorProduct_LIST", vendorproducts);

		RequestDispatcher dispatcher = request.getRequestDispatcher("vendor/home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
