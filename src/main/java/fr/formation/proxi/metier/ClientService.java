package fr.formation.proxi.metier;

import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Address;
import fr.formation.proxi.metier.entity.Client;
//import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.ClientDao;

/**
 * La classe ClientService définit toutes les méthodes de manipulation des clients.
 */
public class ClientService {
	
	/**
	 * Permet de faire un singleton.
	 */
	public static final ClientService INSTANCE = new ClientService();

	public static ClientService getInstance() {
		return ClientService.INSTANCE;
	}
	
	/**
	 * Permet de faire appel aux méthodes de la classe ClientDao.
	 */
	private final ClientDao daoClient;
	
	public ClientService() {
		this.daoClient = new ClientDao();
	}
	
	
	/**
	 * Récupère tous les clients de la base de données.
	 * @return List<Client> Renvoie la liste de tous les clients.
	 */
	public List<Client> getAll() {
		return this.daoClient.readAll();
	}
	
	/**
	 * Récupère les informations d'un client spécifique.
	 * @param id L'identifiant du client voulu.
	 * @return Client Renvoie le client voulu.
	 */
	public Client getClient(Integer id) {
		return this.daoClient.read(id);
	}
	
	/**
	 * Met à jour les informations d'un client spécifique.
	 * @param firstname Le nouveau prénom.
	 * @param lastname Le nouveau nom de famille.
	 * @param number Le nouveau numéro de client.
	 * @param address La nouvelle adresse physique.
	 * @param birthdate La nouvelle date de naissance.
	 * @param id L'identifiant du client à modifier.
	 */
	public void updateClient(Integer id, String number, String firstname, String lastname, String birthdate, Address address,
			List<Account> accounts) {
		Client client = new Client(id, number, firstname, lastname, birthdate, address, accounts);
		this.daoClient.update(client);
	}
	
	/**
	 * Récupère un client à partir de son nom et prénom.
	 * @param firstname Le prénom du client.
	 * @param lastname Le nom du client.
	 * @return Client le client voulu.
	 */
	public Client getIdByName(String firstname, String lastname) {
		return this.daoClient.readIdByName(firstname, lastname);
	}
}
