package fr.formation.proxi.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * la class MySqlConnection de créer une seule et unique connexion à notre base de donnée 
 * via l'utilisation du Singleton INSTANCE
 * 
 * @author Marie_Julien
 *
 */

public class MySqlConnection {

private static final MySqlConnection INSTANCE = new MySqlConnection();
	
	public static MySqlConnection getInstance() {
		return MySqlConnection.INSTANCE;
	}

	private Connection conn;
	
	
	/**
	 * le constructeur MySqlConnection charge le driver à l'aide de la méthode forname() 
	 * etrenvoie une connexion à l'aide de la méthode getconnection
	 */
	
	public MySqlConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxibanquev2?serverTimezone=Europe/Paris", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * la méthode getConn() permet d'établir la connexion.
	 * @return Connection
	 */
	
	public Connection getConn() {
		return conn;
	}
	
	
}
