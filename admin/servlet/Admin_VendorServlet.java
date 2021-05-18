package com.scm.admin.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.scm.admin.util.AdminVendorDbUtil;
import com.scm.model.Vendor;

/**
 * Servlet implementation class Admin_VendorServlet
 */
public class Admin_VendorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_VendorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private AdminVendorDbUtil adminVendorDbUtil;
    @Resource(name="jdbc/supplychainmanagement")
    private DataSource dataSource;
    
    @Override
  	public void init() throws ServletException {
  		// TODO Auto-generated method stub
  		super.init();
  		try {
  			adminVendorDbUtil = new AdminVendorDbUtil(dataSource);
  		} catch (Exception e) {
  			// TODO: handle exception
  			throw new ServletException(e);
  		}
  	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String theCommand = request.getParameter("command");
			
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			switch (theCommand) {
			case "LIST":
				listVendors(request,response);
				break;
//			case "ADD":
//				addStudent(request,response);
//				break;
			case "DELETE":
 				deleteVendor(request,response);
				break;
			default:
				listVendors(request,response);
				break;
			}
			
			
			listVendors(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String theVendorId = request.getParameter("vrndorID");
		adminVendorDbUtil.deleteVendor(theVendorId);
		listVendors(request,response);
	}

	private void listVendors(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Vendor> vendors = adminVendorDbUtil.getVendors();
		request.setAttribute("Vendor_LIST", vendors);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin/list-vendors.jsp");
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
