package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private Connection conn = null;
	private String url="jdbc:mysql://nvc-db.c5lttagztqjo.ap-southeast-1.rds.amazonaws.com/proj1?characterEncoding=UTF-8";
	private String username="proj1";
	private String password="proj1";
	
	public Connection getConnection() {
		conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
