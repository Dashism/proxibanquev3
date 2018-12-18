package fr.formation.proxi.persistance;

/**
 * La class SqlQueries crée les requetes SQL sous format string pour pouvoir être utilisées 
 * dans le code JAVA
 * 
 * @author Marie_Julien
 *
 */


public class JpqlQueries {

	public static final String SELECT_CLIENT_BY_NAME = "SELECT c FROM Client c WHERE c.firstname = :firstname and c.lastname = :lastname";
	public static final String SELECT_ALL_CARD = "SELECT c FROM Card c";
	public static final String SELECT_ALL_CLIENT= "SELECT c FROM Client c";
	public static final String SELECT_ALL_ACCOUNT = "SELECT c FROM Account c";
	public static final String SELECT_ALL_ACCOUNT_FROM_CLIENT = "SELECT c FROM Account c WHERE c.client_id = :client_id";
	public static final String SELECT_ALL_CHEQUEBOOK = "SELECT c FROM Chequebook c";
}
