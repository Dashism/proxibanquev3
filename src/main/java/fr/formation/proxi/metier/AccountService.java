package fr.formation.proxi.metier;

import java.time.LocalDate;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.BankCard;
import fr.formation.proxi.metier.entity.Chequebook;
import fr.formation.proxi.metier.entity.CurrentAccount;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.BankCardDao;
import fr.formation.proxi.persistance.ChequebookDao;

/**
 * la classe AccountService definit toutes les méthodes de manipulation des
 * comptes
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
	private final AccountDao accountDao;
	private final BankCardDao cardDao;
	private final ChequebookDao chequebookDao;

	public AccountService() {
		this.accountDao = new AccountDao();
		this.cardDao = new BankCardDao();
		this.chequebookDao = new ChequebookDao();
	}

	/**
	 * Ajoute un compte � un client d�fini
	 * 
	 * @param number  Le num�ro de compte du compte � cr�er.
	 * @param balance Le solde du compte � cr�er.
	 * @param savings Si vrai, le compte � cr�er est un compte �pargne, si faux le
	 *                compte � cr�er est un compte courant.
	 * @param id      L'identifiant du client auquel le compte est rattach�.
	 */
//	public void addAccount(Integer id, String number, Float balance, String label, String openingDate, Chequebook chequebook) {
//		this.dao.create(new Account(number, balance, savings), id);
//	}
//	
	/**
	 * R�cup�re la liste des comptes d'un client d�fini.
	 * 
	 * @param id L'identifiant du client dont il faut afficher les comptes
	 * @return Renvoie la liste des comptes.
	 */
	public List<Account> getAll(Integer id) {
		return this.accountDao.readAll(id);
	}

	/**
	 * Fait un virement du compte A au compte B d'un montant choisi, si le solde du
	 * compte A est suffisant et les comptes A et B sont diff�rents.
	 * 
	 * @param compteA L'identifiant du compte � d�biter.
	 * @param compteB L'identifiant du compte � cr�diter.
	 * @param montant Le montant � virer
	 * @return Renvoie true si le virement a r�ussi, false s'il a �chou�.
	 */
	public boolean transfer(Integer compteA, Integer compteB, Float montant) {
		Account accountA = this.accountDao.read(compteA);
		Account accountB = this.accountDao.read(compteB);
		Boolean result = false;
		if (montant <= 900) {
			if (accountA.getId() != accountB.getId()) {
				if (accountA.getBalance() >= montant) {
					accountA.setBalance(accountA.getBalance() - montant);
					this.accountDao.update(accountA);
					accountB.setBalance(accountB.getBalance() + montant);
					this.accountDao.update(accountB);
					result = true;
				}
			}
		}
		return result;
	}
	
	public boolean cashWithdrawal(Integer accountId, Float amount) {
		Account account = this.accountDao.read(accountId);
		Boolean result = false;
		if ((account instanceof CurrentAccount) && (amount <= 300) && (account.getBalance() >= amount)) {
			account.setBalance(account.getBalance() - amount);
			this.accountDao.update(account);
			result = true;
		}
		return result;
	}
	
	public boolean newCard (Integer accountId, String type) {
		boolean resultOk = true;
		CurrentAccount account = (CurrentAccount) this.accountDao.read(accountId);
		if (account.getCard() != null) {
			if (account.getCard().getExpirationDate().isBefore(LocalDate.now())) {
				Integer cardId = account.getCard().getId();
				account.setCard(null);
				this.accountDao.update(account);				
				this.cardDao.delete(cardId);
			} else {
				resultOk = false;
			}
		}
		if (resultOk) {
			BankCard newCard = new BankCard();
			newCard.setExpirationDate(LocalDate.now().plusYears(2));
			newCard.setType(type);
			newCard = this.cardDao.create(newCard);
			account.setCard(newCard);
			this.accountDao.update(account);
		}
		return resultOk;
	}
	
	public boolean newChequebook (Integer accountId) {
		boolean resultOk = true;
		Account account = this.accountDao.read(accountId);
		if (account.getChequebook() != null) {
			if (account.getChequebook().getReceptionDate().isBefore(LocalDate.now().minusMonths(3))) {
				account.setChequebook(null);;
				this.accountDao.update(account);				
			} else {
				resultOk = false;
			}
		}
		if (resultOk) {
			Chequebook newChequebook = new Chequebook();
			newChequebook.setSendDate(LocalDate.now());
			newChequebook.setReceptionDate(LocalDate.now().plusDays(14));
			newChequebook = this.chequebookDao.create(newChequebook);
			account.setChequebook(newChequebook);;
			this.accountDao.update(account);
		}
		return resultOk;
	}

}
