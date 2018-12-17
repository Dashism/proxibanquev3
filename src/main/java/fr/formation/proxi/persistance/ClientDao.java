package fr.formation.proxi.persistance;

import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.entity.Client;

public class ClientDao extends AbstractDao<Client> {

	@Override
	public Client read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Client readIdByName(String firstname, String lastname) {
		Client result1 = null;
		Client result2 = null;
		TypedQuery<Client> query1 = this.em.createQuery(JpqlQueries.SELECT_CLIENT_BY_NAME, Client.class);
		query1.setParameter("firstname", firstname);
		query1.setParameter("lastname", lastname);
		result1 = query1.getSingleResult();
		TypedQuery<Client> query2 = this.em.createQuery(JpqlQueries.SELECT_CLIENT_BY_NAME, Client.class);
		query2.setParameter("firstname", lastname);
		query2.setParameter("lastname", firstname);
		result2 = query2.getSingleResult();
		if (result1 != null && result2 != null) {
			return null;
		} else if (result1 != null && result2 == null) {
			return result1;
		} else if (result1 == null && result2 != null) {
			return result2;
		} else {
			return null;
		}
	}
}
