package fr.formation.proxi.metier;

import java.time.LocalDate;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.BankCard;
import fr.formation.proxi.metier.entity.Chequebook;
import fr.formation.proxi.metier.entity.CurrentAccount;
import fr.formation.proxi.metier.entity.Status;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.BankCardDao;
import fr.formation.proxi.persistance.ChequebookDao;

/**
 * la classe AccountService definit toutes les méthodes de manipulation des
 * comptes.
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
	private final AccountDao accountDao;

	/**
	 * Permet de faire appel aux méthodes de la classe BankCardDao.
	 */
	private final BankCardDao cardDao;

	/**
	 * Permet de faire appel aux méthodes de la classe ChequebookDao.
	 */
	private final ChequebookDao chequebookDao;

	public AccountService() {
		this.accountDao = new AccountDao();
		this.cardDao = new BankCardDao();
		this.chequebookDao = new ChequebookDao();
	}

	/**
	 * Récupère la liste de tous les comptes associés à un client.
	 * 
	 * @param id L'identifiant du client dont il faut afficher les comptes
	 * @return List<Account> Renvoie la liste des comptes.
	 */
	public List<Account> getAll(Integer id) {
		return this.accountDao.readAll(id);
	}

	/**
	 * Fait un virement du compte A au compte B d'un montant choisi inférieur à
	 * 900€, si le solde du compte A est suffisant et les comptes A et B sont
	 * différents.
	 * 
	 * @param compteA L'identifiant du compte à débiter.
	 * @param compteB L'identifiant du compte à créditer.
	 * @param montant Le montant à virer
	 * @return Renvoie true si le virement a réussi, false s'il a échoué.
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

	/**
	 * Crée une nouvelle carte bancaire si il n'y en a pas déjà, ou si l'actuelle
	 * est périmée.
	 * 
	 * @param accountId l'identifiant du compte auquel on va ajouté une carte.
	 * @param type      le type de carte bancaire à créer.
	 * @return boolean Vrai si la carte a été créée, faux sinon.
	 */
	public boolean newCard(Integer accountId, String type) {
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

	/**
	 * Crée un nouveau chéquier s'il n'y en a pas déjà, ou si l'actuel a été envoyé
	 * il y a plus de trois mois.
	 * 
	 * @param accountId l'identifiant du compte auquel on va ajouté un compte.
	 * @return Status un objet de la classe Status contenant le booléen de la
	 *         réussite (ou non) de la création de chéquier et le message à afficher
	 *         à l'utilisateur.
	 */
	public Status newChequebook(Integer accountId) {
		Status status = new Status();
		boolean resultOk = true;
		Account account = this.accountDao.read(accountId);
		if (account.getChequebook() != null) {
			if (account.getChequebook().getReceptionDate().isBefore(LocalDate.now().minusMonths(3))) {
				Integer chequebookId = account.getChequebook().getId();
				account.setChequebook(null);
				;
				this.accountDao.update(account);
				this.chequebookDao.delete(chequebookId);
				status.setMessage("Nouveau chéquier valable jusqu'au " + (LocalDate.now().plusMonths(3).plusWeeks(2))
						+ " en cours de distribution...");
			} else {
				resultOk = false;
				status.setValid(resultOk);
				status.setMessage("Impossible d'effectuer le retrait d'un nouveau chéquier pour ce compte avant le "
						+ (account.getChequebook().getReceptionDate().plusMonths(3)));
			}
		} else {
			status.setMessage("Premier chéquier pour ce compte en cours de distribution...");
		}
		if (resultOk) {
			Chequebook newChequebook = new Chequebook();
			newChequebook.setSendDate(LocalDate.now());
			newChequebook.setReceptionDate(LocalDate.now().plusDays(14));
			newChequebook = this.chequebookDao.create(newChequebook);
			account.setChequebook(newChequebook);
			;
			this.accountDao.update(account);
		}
		status.setValid(resultOk);
		return status;
	}

}
