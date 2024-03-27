package com.lec.ex01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertMain {

	final static String DRV = "oracle.jdbc.OracleDriver";
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String USR = "hr";
	final static String PWD = "hr";

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		
		String sql = "insert into employees("				
		        + "   EMPLOYEE_ID    "
		        + " , FIRST_NAME     "
		        + " , LAST_NAME      "
		        + " , EMAIL          "
		        + " , PHONE_NUMBER   "
		        + " , HIRE_DATE      "
		        + " , JOB_ID         "
		        + " , SALARY         "
		        + " , COMMISSION_PCT "
		        + " , MANAGER_ID     "
		        + " , DEPARTMENT_ID) "
		        + " values(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			
			Class.forName(DRV);
			conn = DriverManager.getConnection(URL, USR, PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1000);
			pstmt.setString(2, "흥민");
			pstmt.setString(3, "손");
			pstmt.setString(4, "sonny@gmail.com");
			pstmt.setString(5, "010.1111.2222");
			pstmt.setString(6, "2024.01.01");
			pstmt.setString(7, "FI_ACCOUNT");
			pstmt.setInt(8, 10000);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 108);
			pstmt.setInt(11, 100);
			
			int row = pstmt.executeUpdate(); // 수정된 행갯수를 리턴
			System.out.println("employees 테이블에 " + row + " 건이 성공적으로 추가 되었습니다!!");
			
		} catch (Exception e) {
			System.out.println("DB연결실패!!!");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// dummy
			}
		}		
		
	}

}
