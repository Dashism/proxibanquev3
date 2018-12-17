package fr.formation.proxi.metier;

import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.persistance.AccountDao;

/**
 * la classe AccountService definit toutes les méthodes de manipulation des comptes
 * 
 * @author Marie_Julien
 *
 */

public class AccountService {
	
	/**
	 * Permet de faire un singleton.
	 */
	public static final AccountService INSTANCE = new AccountService();
	
	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}
	
	
	
	/**
	 * Permet de faire appel aux m�thodes de la classe AccountDao.
	 */
	private final AccountDao dao;

	public AccountService() {
		this.dao = new AccountDao();
	}
	
	/**
	 * Ajoute un compte � un client d�fini
	 * @param number Le num�ro de compte du compte � cr�er.
	 * @param balance Le solde du compte � cr�er.
	 * @param savings Si vrai, le compte � cr�er est un compte �pargne, si faux le compte � cr�er est un compte courant.
	 * @param id L'identifiant du client auquel le compte est rattach�.
	 */
	public void addAccount(String number, Float balance, Boolean savings, Integer id) {
		this.dao.create(new Account(number, balance, savings), id);
	}
	
	/**
	 * R�cup�re la liste des comptes d'un client d�fini.
	 * @param id L'identifiant du client dont il faut afficher les comptes
	 * @return Renvoie la liste des comptes.
	 */
	public List<Account> getAll(Integer id) {
		return this.dao.readAll(id);
	}

	/**
	 * Fait un virement du compte A au compte B d'un montant choisi, si le solde du compte A est suffisant et les comptes A et B sont diff�rents.
	 * @param compteA L'identifiant du compte � d�biter.
	 * @param compteB L'identifiant du compte � cr�diter.
	 * @param montant Le montant � virer
	 * @return Renvoie true si le virement a r�ussi, false s'il a �chou�.
	 */
	public boolean transfer(Integer compteA, Integer compteB, Float montant) {	
		Account accountA  = this.dao.read(compteA);
		Account accountB  = this.dao.read(compteB);
		Boolean result = false;
		if (accountA.getId()!=accountB.getId()) {
			if (accountA.getBalance() >= montant) {
				accountA.setBalance(accountA.getBalance() - montant);
				this.dao.update(accountA);
				accountB.setBalance(accountB.getBalance() + montant);
				this.dao.update(accountB);
				result = true;
			}
		}
		return result;
		
	}


}
