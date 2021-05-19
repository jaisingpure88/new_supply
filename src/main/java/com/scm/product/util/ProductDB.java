package com.scm.product.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.scm.db.Dbconector;
import com.scm.model.Product;

public class ProductDB {
	static Connection con = null;
	public static void productInsert(Product p) throws SQLException {
		con = Dbconector.mydbconnection();
		String str = "INSERT INTO Product (ProductName,ProductDisc,ProductPrice)VALUES (?,?,?)";
		PreparedStatement ps = con.prepareStatement(str);
		ps.setString(1,p.getProductName());
		ps.setString(2,p.getProductDisc());
		ps.setInt(3,p.getProductPrice());
		ps.executeUpdate();
		return;

		}
}