package com.scm.admin.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;
import com.scm.model.AddVendorProduct;
import com.scm.model.Product;
import com.scm.model.VendorProduct;

public class VendorProductDbUtil {
	private DataSource dataSource;
	
	public VendorProductDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<VendorProduct> getVendorProducts() throws Exception{
		List<VendorProduct> vendorproducts = new ArrayList<VendorProduct>();
		
		Connection myConn= null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
		myConn = dataSource.getConnection();
		
		String sql ="SELECT vendorproduct.ProductID,vendorproduct.Qunatity,product.ProductName,product.ProductPrice\r\n"
				+ "FROM product\r\n"
				+ "INNER JOIN vendorproduct ON vendorproduct.ProductID=product.ProductID";
		myStmt = myConn.createStatement();
		
		myRs = myStmt.executeQuery(sql);
		
		while(myRs.next()) {
			int productId =myRs.getInt("ProductID");
			String productName = myRs.getString("ProductName");
			String productPrice = myRs.getString("ProductPrice");
			int quantity = myRs.getInt("Qunatity");
		
			VendorProduct tempVendorProduct = new VendorProduct(productId,productName,productPrice,quantity);
			
			vendorproducts.add(tempVendorProduct);
		}
		
		return vendorproducts;
	}
	finally {
		close(myConn,myStmt,myRs);
	}
}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		// TODO Auto-generated method stub
		try {
			if(myRs != null) {
				myRs.close();
			}
			if(myStmt !=null) {
				myStmt.close();
			}
			if(myConn !=null) {
				myConn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void addVendorProduct(AddVendorProduct theVendor) throws SQLException {
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			
			String sql = "insert into vendorproduct "
					   + "(VendorID, ProductID,Qunatity) "
					   + "values (?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setInt(1, theVendor.getVendorID());
			myStmt.setInt(2, theVendor.getProductID());
			myStmt.setInt(3, theVendor.getQunatity());
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public VendorProduct getProduct(String theProductId) throws Exception {
		// TODO Auto-generated method stub
		VendorProduct theProduct = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int productId;
		
		try {
			// convert student id to int
			productId = Integer.parseInt(theProductId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from vendorproduct where ProductID=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, productId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				int vendorID = myRs.getInt("VendorID");
				int productID = myRs.getInt("ProductID");
				int quantity = myRs.getInt("Qunatity");
				
				// use the studentId during construction
				theProduct = new VendorProduct(vendorID, productID, quantity);
			}
			else {
				throw new Exception("Could not find Product id: " + productId);
			}				
			
			return theProduct;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateProduct(VendorProduct theProduct) throws SQLException {
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			
			String sql = "update vendorproduct "
					+ "set Qunatity=? "
					+ "where ProductID=?";
		
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, theProduct.getQuantity());
			myStmt.setInt(2, theProduct.getProductID());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	

	
}
