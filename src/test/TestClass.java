package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestClass {

	private final String url = "jdbc:postgresql://localhost:5432/test";
	private final String user = "postgres";
	private final String password = "coplas98";
	
	private boolean isConnected = false;

	public void connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		TestClass tc = new TestClass();
		tc.connect();
		
	}
	
	
}
