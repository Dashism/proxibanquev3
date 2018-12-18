package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.entity.Client;

/**
 * Hérite de AbstractDao, avec l'entité fixée à Client.
 */
public class ClientDao extends AbstractDao<Client> {
	
	/**
	 * Déclaration d'un singleton (instance unique) privé.
	 */
	private static final ClientDao INSTANCE = new ClientDao();
	
	/**
	 * @return ClientDao l'instance unique (singleton).
	 */
	public static ClientDao getInstance() {
		return ClientDao.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Client read(Integer id) {
		return this.read(id, new Client());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Client> readAll() {
		List<Client> clients = new ArrayList<>();
		TypedQuery<Client> query = this.em
				.createQuery(JpqlQueries.SELECT_ALL_CLIENT, Client.class);
		clients.addAll(query.getResultList());
		return clients;
	}

	/**
	 * Lecture d'un client par son nom et prénom.
	 * @param firstname Le prénom du client.
	 * @param lastname Le nom de famille du client.
	 * @return Client le client construit à partir des informations récupérées.
	 */
	public Client readIdByName(String firstname, String lastname) {
		Client result = null;
		TypedQuery<Client> query = this.em.createQuery(JpqlQueries.SELECT_CLIENT_BY_NAME, Client.class);
		query.setParameter("firstname", firstname);
		query.setParameter("lastname", lastname);
		try {
			result = query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			System.out.println("Pas de client avec ces parametres.");
		}
		return result;
	}
}
