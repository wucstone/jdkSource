package com.wucstone.base.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestPreparedStatement {
	
	
	public static void main(String[] args) {
		
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		Connection conn=null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.26:1521:tarena","openlab","open123");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("");
			ps.setString(1, "");
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
