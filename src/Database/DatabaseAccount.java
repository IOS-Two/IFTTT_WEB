package Database;

import com.mysql.jdbc.PreparedStatement;
import model.Account;
import java.sql.*;

public class DatabaseAccount {
	
	public static void insert(Account account) {
		
		try {

			java.sql.Connection connect = DatabaseCommon.connect();
			System.out.println("Success connect Mysql server!");
			Statement stmt = connect.createStatement();
			String username = account.getUsername();
			String password = account.getPassword();
			String r1 = "insert into Account values('" + username + "' " + "," + "'" + password + "'" + ");";
			stmt.execute(r1);
			stmt.close();
			connect.close();

		} catch (Exception e) {

			System.out.print("get data error!");
			e.printStackTrace();

		}
	}

	public static Account search(Account account) {
		try {  
			java.sql.Connection connect = DatabaseCommon.connect();
			System.out.println("Success connect Mysql server!");
			String username = "'" + account.getUsername() + "'";
			String password = "'" + account.getPassword() + "'";
			String Squery = "select * from Account where username = " + username + " and " + "passwords = " + password
					+ ";";
			PreparedStatement pstmt;
			pstmt = (PreparedStatement)connect.prepareStatement(Squery);
			ResultSet rs = pstmt.executeQuery();
			int num = 0;
			while (rs.next()) {
	            num++;
	        }
			System.out.println(num);
			if (num == 0) {
				System.out.println("False");
				pstmt.close();
				connect.close();
				return null;
			}
			pstmt.close();
			connect.close();
			
			return new Account(username, password);

		} catch (Exception e) {

			System.out.print("get data error!");
			e.printStackTrace();
			return null;

		}
	}
	
	public static Account searchByName(Account account) {
		try {  
			java.sql.Connection connect = DatabaseCommon.connect();
			System.out.println("Success connect Mysql server!");
			String username = "'" + account.getUsername() + "'";
			String Squery = "select * from Account where username = " + username
					+ ";";
			PreparedStatement pstmt;
			pstmt = (PreparedStatement)connect.prepareStatement(Squery);
			ResultSet rs = pstmt.executeQuery();
			int num = 0;
			while (rs.next()) {
	            num++;
	        }
			System.out.println(num);
			if (num == 0) {
				System.out.println("False");
				pstmt.close();
				connect.close();
				return null;
			}
			pstmt.close();
			connect.close();
			
			return new Account(username, "");

		} catch (Exception e) {

			System.out.print("get data error!");
			e.printStackTrace();
			return null;

		}
	}
	
}
