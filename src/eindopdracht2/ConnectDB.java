package eindopdracht2;

import java.sql.*;

public class ConnectDB {

	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public ConnectDB() {
		
		try{
			Class.forName("com.mysql.jbdc.Driver");
			
			
		} catch(Exception ex) {
			System.out.println("Error: " + ex);
		}
		
	}
	
}
