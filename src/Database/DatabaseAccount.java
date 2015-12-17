package Database;

import com.mysql.jdbc.PreparedStatement;
import model.Account;
import java.sql.*;

public class DatabaseAccount {

	public static void insert(Account account) {

		try {
			
			java.sql.Connection connect = DatabaseCommon.connect();
			System.out.println("from insert Success connect Mysql server!");
			Statement stmt = connect.createStatement();
			String username = account.getUsername();
			String password = account.getPassword();
			String email = account.getEmailaddress();
			String r1 = "insert into Account values(1003,'" + username + "' " + "," + "'" + password + "'" + ",'"
					+ email + "'" + ",10,1);";
			System.out.println(r1);
			stmt.execute(r1);
			stmt.close();
			connect.close();

		} catch (Exception e) {

			System.out.print("from insert get data error!");
			e.printStackTrace();

		}
	}

	public static Account search(Account account) {
		try {
			java.sql.Connection connect = DatabaseCommon.connect();
			System.out.println("from search Success connect Mysql server!");
			String username = "'" + account.getUsername() + "'";
			String password = "'" + account.getPassword() + "'";
			String email = "'" + account.getEmailaddress() + "'";
			String Squery = "select * from Account where username = " + username + " and " + "passwords = " + password
					+ ";";
			PreparedStatement pstmt;
			pstmt = (PreparedStatement) connect.prepareStatement(Squery);
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

			return new Account(username, password, email);

		} catch (Exception e) {

			System.out.print("from search get data error!");
			e.printStackTrace();
			return null;

		}
	}

	public static Account searchByName(Account account) {
		try {
			java.sql.Connection connect = DatabaseCommon.connect();
			System.out.println("from searchByName Success connect Mysql server!");
			String username = "'" + account.getUsername() + "'";
			String email = "'" + account.getEmailaddress() + "'";
			String Squery = "select * from Account where username = " + username + ";";
			PreparedStatement pstmt;
			pstmt = (PreparedStatement) connect.prepareStatement(Squery);
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

			return new Account(username, "", email);

		} catch (Exception e) {

			System.out.print("from searchByName get data error!");
			e.printStackTrace();
			return null;

		}
	}

}
