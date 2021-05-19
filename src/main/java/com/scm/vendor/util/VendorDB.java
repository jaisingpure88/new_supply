package com.scm.vendor.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.scm.db.Dbconector;
import com.scm.model.Vendor;

public class VendorDB {
	public static void vendorInsert(Vendor v) throws SQLException {
		Connection con = Dbconector.mydbconnection();
		String str = "INSERT INTO Vendor (VendorName ,VendorPassword ,VendorCity)VALUES (?,?,?)";
		PreparedStatement ps = con.prepareStatement(str);
		ps.setString(1, v.getVendorName());
		ps.setString(2, v.getVendorPassword());
		ps.setString(3, v.getVendorCity());
		ps.executeUpdate();
		return;

	}
}
