package Database;

import java.sql.DriverManager;

public class DatabaseCommon {
	public static java.sql.Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/ifttt", "root",
					"");
			System.out.println("from connect Success connect Mysql server!");
			return connect;
		} catch (Exception e) {
			System.out.print("from connect get data error!");
			e.printStackTrace();

		}
		return null;
	}
}
