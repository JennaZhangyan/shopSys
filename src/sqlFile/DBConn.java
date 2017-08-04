package sqlFile;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DBConn {
	public static Connection getConn() {
		Connection conn=null;
// 		MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
//		String url = "jdbc:mysql://127.0.0.1:3306/select_test";
		String url = "jdbc:mysql://127.0.0.1:3306/shop_management";
		
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
