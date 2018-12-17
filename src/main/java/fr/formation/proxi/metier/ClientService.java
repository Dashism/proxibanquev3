package fr.formation.proxi.metier;

import java.util.List;

import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.ClientDao;

/**
 * La classe ClientService définit toutes les méthodes de manipulation des clients.
 * @author Marie_Julien
 *
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
	private final ClientDao dao;
	/**
	 * Permet de faire appel aux méthodes de la classe AccountDao.
	 */
	private final AccountDao daoAcc;

	public ClientService() {
		this.dao = new ClientDao();
		this.daoAcc = new AccountDao();
	}
	
	/**
	 * Ajoute un client à la base de données.
	 * @param firstname Le prénom du client.
	 * @param lastname Le nom de famille du client.
	 * @param email L'adresse mail du client.
	 * @param address L'adresse physique du client.
	 */
	public void addClient(String firstname, String lastname, String email, String address) {
		this.dao.create(new Client(firstname, lastname, email, address));
	}
	
	/**
	 * Récupère tous les clients de la base de données
	 * @return Renvoie la liste de tous les clients.
	 */
	public List<Client> getAll() {
		return this.dao.readAll();
	}
	
	/**
	 * Récupère les informations d'un client spécifique.
	 * @param id L'identifiant du client voulu.
	 * @return Renvoie le client voulu.
	 */
	public Client getClient(Integer id) {
		return this.dao.read(id);
	}
	
	/**
	 * Met à jour les informations d'un client spécifique.
	 * @param firstname Le nouveau prénom.
	 * @param lastname Le nouveau nom de famille.
	 * @param email La nouvelle adresse mail.
	 * @param address La nouvelle adresse physique.
	 * @param id L'identifiant du client à modifier.
	 */
	public void updateClient(String firstname, String lastname, String email, String address, Integer id) {
		Client client = new Client(id, firstname, lastname, email, address);
		this.dao.update(client);
	}
	
	/**
	 * Supprime un client spécifique.
	 * @param id L'identifiant du client à supprimer.
	 */
	public void deleteClient(Integer id) {
		if (AccountService.getInstance().getAll(id).size()!=0) {
			this.daoAcc.delete(id);
		}
		this.dao.delete(id);
	}

}
