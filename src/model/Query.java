package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.LinkedList;
import java.util.List;

/*
 * This is the Controller class
 */
public class Query {

	private final String url = "jdbc:postgresql://localhost:5432/";
	private final String user = "postgres";
	private final String password = "coplas98";
	
	public List<String> query(String query){
		List<String> result = new LinkedList<String>();
		ResultSet rs = null;
		try(Connection conn = DriverManager.getConnection(url, user, password)){
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSetMetaData md = ps.getMetaData();
			//int numberOfColumns
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
