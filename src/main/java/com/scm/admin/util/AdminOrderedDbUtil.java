package com.scm.admin.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;
import com.scm.model.Ordered;
import com.scm.model.Product;

public class AdminOrderedDbUtil {
	private DataSource dataSource;
	
	public AdminOrderedDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Ordered> getOrdered() throws Exception{
		List<Ordered> ordered = new ArrayList<Ordered>();
		
		Connection myConn= null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
		myConn = dataSource.getConnection();
		
		String sql ="SELECT userproduct.ProductID,product.ProductName, userproduct.Quantity, userproduct.TotalPrice,userproduct.OrderdDate,userproduct.DliverDate,euser.UserName\r\n"
				+ "FROM userproduct\r\n"
				+ "INNER JOIN product ON userproduct.ProductID=product.ProductID\r\n"
				+ "INNER JOIN euser ON userproduct.UserID=euser.UserID\r\n"
				+ "WHERE userproduct.Orderd=1;";
		myStmt = myConn.createStatement();
		
		myRs = myStmt.executeQuery(sql);
		
		while(myRs.next()) {
			int productId =myRs.getInt("ProductID");
			String productName = myRs.getString("ProductName");
			String userName = myRs.getString("UserName");
			int totalPrice = myRs.getInt("TotalPrice");
			String orderedDate = myRs.getString("OrderdDate");
			String deliverDate = myRs.getString("DliverDate");
			
		
			Ordered tempOrdered = new Ordered(productId,productName,userName,totalPrice,orderedDate,deliverDate);
			
			ordered.add(tempOrdered);
		}
		
		return ordered;
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



	
}
