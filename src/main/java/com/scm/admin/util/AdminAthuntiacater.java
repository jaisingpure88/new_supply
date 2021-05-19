package com.scm.admin.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.scm.db.Dbconector;

public class AdminAthuntiacater {

	static Connection con =null;
	public static boolean validate(String adminName, String adminPassword) throws SQLException {
	boolean status=false;
	con=Dbconector.mydbconnection();
	String s="select * from userreg where AdminName=? and AdminPassword=?";
	PreparedStatement ps = con.prepareStatement(s);
	ps.setString(1,adminName);
	ps.setString(2,adminPassword);
	ResultSet rs=ps.executeQuery();
	status=rs.next();
	return status;
	}

}
