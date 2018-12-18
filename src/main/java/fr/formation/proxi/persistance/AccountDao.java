package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.entity.Account;

public class AccountDao extends AbstractDao<Account> {

	private static final AccountDao INSTANCE = new AccountDao();
	
	public static AccountDao getInstance() {
		return AccountDao.INSTANCE;
	}
	
	@Override
	public Account read(Integer id) {
		return this.read(id, new Account());
	}

	public List<Account> readAll(Integer id) {
		List<Account> accounts = new ArrayList<>();
		TypedQuery<Account> query = this.em
				.createQuery(JpqlQueries.SELECT_ALL_ACCOUNT_FROM_CLIENT, Account.class);
		query.setParameter("client_id", id);
		accounts.addAll(query.getResultList());
		return accounts;
	}

	@Override
	public List<Account> readAll() {
		List<Account> accounts = new ArrayList<>();
		TypedQuery<Account> query = this.em
				.createQuery(JpqlQueries.SELECT_ALL_ACCOUNT, Account.class);
		accounts.addAll(query.getResultList());
		return accounts;
	}

}
