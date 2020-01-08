package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	private final String url = "jdbc:postgresql://127.0.0.1:5432/test";
	private final String user = "postgres";
	private final String password = "coplas98";
	
	private boolean isConnected = false;
	
	private Connection conn = null;
	
	public void connect() throws ClassNotFoundException {
		try {
			//Nu mai trebuie incarcarea driver-ului cu Class.forName("org.postgresql.Driver);, se face automat in postgresql
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("Connected.");
			listDownAllDatabases();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Connection failed.");
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//List all databases on server
	private void listDownAllDatabases() {
        try {
            PreparedStatement ps = conn
                    .prepareStatement("SELECT datname FROM pg_database WHERE datistemplate = false;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String []args) throws SQLException, ClassNotFoundException {
		
		Test t = new Test();
		t.connect();
		
		
	}
		
}
