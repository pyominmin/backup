package com.lec.ex02_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnector {

	
	public static Connection getConnection() {
		
		String DRV = "oracle.jdbc.OracleDriver";
		String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USR = "hr";
		String PWD = "hr";
		try {
			Class.forName(DRV);
			return DriverManager.getConnection(URL, USR, PWD);			
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} catch (Exception e2) {
			// dummy
		}			
	}	
}

















