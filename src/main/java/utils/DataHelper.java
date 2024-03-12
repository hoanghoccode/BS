package utils;
import java.sql.*;

public class DataHelper {
	public final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://localhost:3306/sasa";
	// Database credentials
	public final static String USER = "root";
	public final static String PASS = "10112004";
		
	// SQL connection
	static Connection conn = null;
	// SQL command
	static Statement stmt = null;
		
	public static Connection getConnection() {
		// Register JDBC driver
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Open a connection
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return conn;
		}
		
	}
}
