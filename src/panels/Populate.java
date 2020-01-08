package panels;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class Populate {

	private final String url = "jdbc:postgresql://localhost:5432/";
	private final String user = "postgres";
	private final String password = "coplas98";
	
	public List<String> populate(String query) {
		List<String> result = new LinkedList<String>();
		ResultSet rs = null;
		try(Connection conn = DriverManager.getConnection(url, user, password)){
			PreparedStatement ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				result.add(rs.getString(1));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println("Error!");
		} 
		
		return result;
		
	}
	
	public List<String> getTables(String database){
		List<String> result = new LinkedList<String>();
		ResultSet rs = null;
		String[] types = {"TABLE"};
		try(Connection conn = DriverManager.getConnection(url+database, user, password)){
			DatabaseMetaData md = conn.getMetaData();
			rs = md.getTables(null, null, "%", types);
			while(rs.next()) {
				result.add(rs.getString("TABLE_NAME"));
			}
			rs.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println("Error!");
		} 
		
		return result;
	}
	
	public List<String> query(String query){
		List<String> result = new LinkedList<String>();
		ResultSet rs = null;
		String[] types = {"TABLE"};
		try(Connection conn = DriverManager.getConnection(url, user, password)){
			PreparedStatement ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				result.add(rs.getString(1));
			}
			rs.close();
			conn.close();
		} catch(Exception e) {
			//e.printStackTrace();
			System.err.println("Error!");
		} 
		
		return result;
	}
	
	
}
