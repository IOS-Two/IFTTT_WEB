package Database;

import com.mysql.jdbc.PreparedStatement;
import model.Account;
import java.sql.*;

public class DatabaseAccount {
	public static void insert(Account account) {
		try {
			/*
			 * TODO:userid在数据库中需有一个全局变量,money和level初值10和1 这里先使用一个固定值来完成初步功能
			 */
			int userid = getUserid();
			java.sql.Connection connect = DatabaseCommon.connect();
			System.out.println("From insert Success connect Mysql server!");
			Statement stmt = connect.createStatement();
			String username = account.getUsername();
			String password = account.getPassword();
			String email = account.getEmailaddress();

			String r1 = "insert into Account values(" + userid + ",'" + username + "' " + "," + "'" + password + "'"
					+ ",'" + email + "'" + ",10,1);";
			stmt.executeUpdate("Update static set userNumber=userNumber+1,usercount=usercount+1;");
			System.out.println(r1);
			stmt.execute(r1);
			stmt.close();
			connect.close();

		} catch (Exception e) {
			System.out.print("From insert get data error!");
			e.printStackTrace();

		}
	}

	public static int getUserid() {
		try {
			java.sql.Connection connect = DatabaseCommon.connect();
			System.out.println("Ready to get userid!");
			Statement st;
			st = connect.createStatement();
			ResultSet rs = st.executeQuery("select * from static");
			rs.next();
			int userid = rs.getInt("userNumber") + 1001;
			System.out.println(userid);
			st.close();
			connect.close();
			rs.close();
			return userid;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("get ID error!");
			e.printStackTrace();
			return -1;
		}
	}

	public static Account search(Account account) {
		try {
			java.sql.Connection connect = DatabaseCommon.connect();
			System.out.println("From search Success connect Mysql server!");
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
			System.out.print("From search get data error!");
			e.printStackTrace();
			return null;
		}
	}

	public static Account searchByName(Account account) {
		try {
			java.sql.Connection connect = DatabaseCommon.connect();
			System.out.println("From searchByName Success connect Mysql server!");
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

			System.out.print("From searchByName get data error!");
			e.printStackTrace();
			return null;

		}
	}

	// 根据username删除一个用户
	public static void deleteAccount(String username) {
		try {
			java.sql.Connection connect = DatabaseCommon.connect();
			String sql = "delete from account where username= '" + username + "';";
			PreparedStatement pstmt;
			pstmt = (PreparedStatement) connect.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.executeUpdate("Update static set usercount=usercount-1;");
			pstmt.close();
			connect.close();
		} catch (Exception e) {
			System.out.print("Delete Account error!");
			e.printStackTrace();
		}
	}
}
