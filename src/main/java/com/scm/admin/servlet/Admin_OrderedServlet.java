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

import com.scm.admin.util.AdminOrderedDbUtil;
import com.scm.admin.util.AdminProductDbUtil;
import com.scm.model.Ordered;
import com.scm.model.Product;

/**
 * Servlet implementation class Admin_OrderedServlet
 */
//@WebServlet("orders")
public class Admin_OrderedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Admin_OrderedServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private AdminOrderedDbUtil adminOrderedDbUtil;
	@Resource(name = "jdbc/supplychainmanagement")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			adminOrderedDbUtil = new AdminOrderedDbUtil(dataSource);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			listOrdered(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listOrdered(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Ordered> ordered = adminOrderedDbUtil.getOrdered();
		request.setAttribute("Ordered_LIST", ordered);

		RequestDispatcher dispatcher = request.getRequestDispatcher("admin/orders.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
