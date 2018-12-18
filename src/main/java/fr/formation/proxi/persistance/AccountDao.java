package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.entity.Account;

/**
 * Hérite de AbstractDao, avec l'entité fixée à Account.
 */
public class AccountDao extends AbstractDao<Account> {

	/**
	 * Déclaration d'un singleton (instance unique) privé.
	 */
	private static final AccountDao INSTANCE = new AccountDao();

	/**
	 * @return AccountDao l'instance unique (singleton).
	 */
	public static AccountDao getInstance() {
		return AccountDao.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Account read(Integer id) {
		return this.read(id, new Account());
	}

	/**
	 * Lecture de tous les comptes d'un client à partir de son identifiant
	 * 
	 * @param id L'identifiant du client.
	 * @return List<Account> la liste des comptes du client construite à partir des
	 *         informations récupérées.
	 */
	public List<Account> readAll(Integer id) {
		List<Account> accounts = new ArrayList<>();
		TypedQuery<Account> query = this.em.createQuery(JpqlQueries.SELECT_ALL_ACCOUNT_FROM_CLIENT, Account.class);
		query.setParameter("client_id", id);
		accounts.addAll(query.getResultList());
		return accounts;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Account> readAll() {
		List<Account> accounts = new ArrayList<>();
		TypedQuery<Account> query = this.em.createQuery(JpqlQueries.SELECT_ALL_ACCOUNT, Account.class);
		accounts.addAll(query.getResultList());
		return accounts;
	}

}
