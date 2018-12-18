package fr.formation.proxi.persistance;

/**
 * La class JpqlQueries crée les requetes SQL sous format string pour pouvoir être utilisées 
 * dans le code JAVA.
 */
public class JpqlQueries {

	/**
	 * Récupère le client à partir de son prénom et nom de famille.
	 */
	public static final String SELECT_CLIENT_BY_NAME = "SELECT c FROM Client c WHERE c.firstname = :firstname and c.lastname = :lastname";
	
	/**
	 * Récupère toutes les cartes bancaires.
	 */
	public static final String SELECT_ALL_CARD = "SELECT c FROM Card c";
	
	/**
	 * Récupère tous les clients.
	 */
	public static final String SELECT_ALL_CLIENT= "SELECT c FROM Client c";
	
	/**
	 * Récupère tous les comptes.
	 */
	public static final String SELECT_ALL_ACCOUNT = "SELECT c FROM Account c";
	
	/**
	 * Récupère tous les comptes d'un client à partir de l'identifiant client.
	 */
	public static final String SELECT_ALL_ACCOUNT_FROM_CLIENT = "SELECT c FROM Account c WHERE c.client_id = :client_id";
	
	/**
	 * Récupère tous les chéquiers.
	 */
	public static final String SELECT_ALL_CHEQUEBOOK = "SELECT c FROM Chequebook c";
}
