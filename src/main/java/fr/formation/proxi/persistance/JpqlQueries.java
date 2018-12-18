package fr.formation.proxi.persistance;

/**
 * La class SqlQueries crée les requetes SQL sous format string pour pouvoir être utilisées 
 * dans le code JAVA
 * 
 * @author Marie_Julien
 *
 */


public class JpqlQueries {

	public static final String READ_ALL_CLIENT = "SELECT * FROM client;";
	public static final String READ_CLIENT = "SELECT * FROM client WHERE id=%s;";
	public static final String READ_ALL_ACCOUNT = "SELECT * FROM account where id_client = %s;";
	public static final String UPDATE_CLIENT = "UPDATE client SET %s = '%s' WHERE id=%s;";
	public static final String UPDATE_ACCOUNT = "UPDATE account SET balance=%s WHERE id=%s;";
	public static final String CREATE_CLIENT = "INSERT INTO client VALUES (null, '%s', '%s', '%s', '%s');";
	public static final String CREATE_ACCOUNT = "INSERT INTO account VALUES (null, '%s', %s, %s, %s);";
	public static final String DELETE_ACCOUNTS = "DELETE FROM Account WHERE id_client=%s;";
	public static final String DELETE_CLIENT = "DELETE FROM Client WHERE id=%s;";
	public static final String READ_ACCOUNT = "SELECT * FROM account where id= %s;";
	public static final String SELECT_CLIENT_BY_NAME = "SELECT c FROM Client c WHERE c.firstname = :firstname and c.lastname = :lastname";
	public static final String SELECT_ALL_CARD = "SELECT c FROM Card c";
}
