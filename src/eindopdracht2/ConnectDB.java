package eindopdracht2;

import java.sql.*;

public class ConnectDB {

	public Connection con;
	
	public void createConnection(String databasename, String username, String password) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + databasename + username + password);
			try {
				if(!con.isClosed()) {
					System.out.println("Connection succesful.");
				}
			} catch(SQLException e) {
				System.out.println(e);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void getData() {
		try {
			if(!con.isClosed()) {
				Statement statement = con.createStatement();
				String query = "select * from namen";
				ResultSet results = statement.executeQuery(query);
				while(results.next()) {
					Persoonlijst.listModel.addElement(results.getString(2) + " " + results.getString(3));
				}
			}
			
		}catch (Exception e) {
				System.out.println(e);
			}
		}
	
	public void insertData(String voornaam, String achternaam) {
		try {
			if(!con.isClosed()) {
				Statement statement = con.createStatement();
				String query = String.format("insert into persoonlijst (Voornaam,Achternaam) values ('%s','%s')",voornaam,achternaam);
				statement.executeUpdate(query);
				System.out.println("Insert complete!");
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	}
	

