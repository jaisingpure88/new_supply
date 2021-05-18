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
import com.scm.model.Vendor;


public class AdminVendorDbUtil {
	private DataSource dataSource;
	
	public AdminVendorDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Vendor> getVendors() throws Exception{
		List<Vendor> vendors = new ArrayList<Vendor>();
		
		Connection myConn= null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
		myConn = dataSource.getConnection();
		
		String sql ="select * from vendor";
		myStmt = myConn.createStatement();
		
		myRs = myStmt.executeQuery(sql);
		
		while(myRs.next()) {
			int vendorId =myRs.getInt("VrndorID");
			String vendorName = myRs.getString("VendorName");
			String vendorCity = myRs.getString("VendorCity");
		
			Vendor tempVendor = new Vendor(vendorId,vendorName,vendorCity);
			
			vendors.add(tempVendor);
		}
		
		return vendors;
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

	public void deleteVendor(String theVendorId) throws SQLException {
		// TODO Auto-generated method stub
		Connection myConn= null;
		PreparedStatement myStmt = null;
		try {
			int vendorId = Integer.parseInt(theVendorId);
			
			myConn = dataSource.getConnection();
			
			String sql = "delete from vendor where VrndorID=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, vendorId);
			
			myStmt.execute();
		} finally {
			// TODO: handle finally clause
			close(myConn,myStmt,null);
		}
	}
}
