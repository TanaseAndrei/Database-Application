package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	private String url = "jdbc:postgresql://localhost:5432/movies";
	private final String user = "postgres";
	private final String password = "coplas98";
	
	private Connection conn = null;
	
	public Connection connect() {
		try {
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("Connected.");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Connection failed.");
		}
		return conn;
	}
	
	public void query() throws SQLException {
		
		String query = "INSERT INTO movie VALUES ( 6,'test',2000,'Nu stiu')";
        Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
	}
	
	public static void main(String []args) throws SQLException {
		Test t = new Test();
		t.connect();
		t.query();
	}
		
}
