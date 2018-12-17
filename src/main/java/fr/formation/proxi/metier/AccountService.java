package fr.formation.proxi.metier;

import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.persistance.AccountDao;

/**
 * la classe AccountService definit toutes les mÃ©thodes de manipulation des comptes
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
	 * Permet de faire appel aux méthodes de la classe AccountDao.
	 */
	private final AccountDao dao;

	public AccountService() {
		this.dao = new AccountDao();
	}
	
	/**
	 * Ajoute un compte à un client défini
	 * @param number Le numéro de compte du compte à créer.
	 * @param balance Le solde du compte à créer.
	 * @param savings Si vrai, le compte à créer est un compte épargne, si faux le compte à créer est un compte courant.
	 * @param id L'identifiant du client auquel le compte est rattaché.
	 */
	public void addAccount(String number, Float balance, Boolean savings, Integer id) {
		this.dao.create(new Account(number, balance, savings), id);
	}
	
	/**
	 * Récupère la liste des comptes d'un client défini.
	 * @param id L'identifiant du client dont il faut afficher les comptes
	 * @return Renvoie la liste des comptes.
	 */
	public List<Account> getAll(Integer id) {
		return this.dao.readAll(id);
	}

	/**
	 * Fait un virement du compte A au compte B d'un montant choisi, si le solde du compte A est suffisant et les comptes A et B sont différents.
	 * @param compteA L'identifiant du compte à débiter.
	 * @param compteB L'identifiant du compte à créditer.
	 * @param montant Le montant à virer
	 * @return Renvoie true si le virement a réussi, false s'il a échoué.
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
