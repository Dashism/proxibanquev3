package fr.formation.proxi.metier.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Representation d'un compte courant qui hérite de la classe Account, i.e. compte.
 */
@Entity
@DiscriminatorValue("CURRENT")
public class CurrentAccount extends Account {

	/**
	 * Carte bancaire associée au compte courant.
	 */
	@OneToOne
	@JoinColumn(name="card_id", referencedColumnName="id")
	private BankCard card;

	public CurrentAccount() {
	}

	public CurrentAccount(BankCard card) {
		this.card = card;
	}

	public BankCard getCard() {
		return card;
	}

	public void setCard(BankCard card) {
		this.card = card;
	}
}
