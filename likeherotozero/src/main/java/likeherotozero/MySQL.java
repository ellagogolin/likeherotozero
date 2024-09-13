
package likeherotozero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQL {

	protected static final String host = "localhost";
	protected static final String port = "3306";
	protected static final String database = "mysql-likeherotozero";
	protected static final String username ="root";
	protected static final String password = "";
	protected static final String QUERY = "SELECT country_name, emission FROM emissionsdaten";
	
	private static Connection con;
	
	public static boolean isConnected() {
		return (con == null ? false : true);
	}
	
	public static void connect() {
		
		if(!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
				System.out.println("[MySQL] Verbunden!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public static void disconnect() {
		if(isConnected()) {
			try {
				con.close();
				System.out.println("[MySQL] Verbindung Geschlossen!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void update(String qry) {
		try {
			PreparedStatement ps = con.prepareStatement(qry);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
