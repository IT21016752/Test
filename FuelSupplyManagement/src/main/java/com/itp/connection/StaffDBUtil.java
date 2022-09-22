package com.itp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StaffDBUtil {

	public static boolean insertStaff(String FirstName, String LastName, String Age, String Address, String Email, String AccNo, String JoinedYear, String Password, String StaffType, String ContractYears, String BasicSalary, String Ot) {
		boolean isSuccess = false;
		
		//create db connection
		String url = "jdbc:mysql://localhost:3306/fuel?characterEncoding=utf8";
		String user = "root";
		String pass = "Vithya24";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			
			String sql = "insert into Staff values (0, '"+FirstName+"', '"+LastName+"', '"+Age+"', '"+Address+"', '"+Email+"', '"+AccNo+"', '"+JoinedYear+"', '"+Password+"', '"+StaffType+"', '"+ContractYears+"','"+BasicSalary+"', '"+Ot+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
}
