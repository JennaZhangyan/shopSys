package sqlFile;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DBConn {
	public static Connection getConn() {
		Connection conn=null;
		String url = "jdbc:mysql://127.0.0.1:3306/select_test";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,"root","0213");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
}
