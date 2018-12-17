package fr.formation.proxi.metier.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Representation d'un compte bancaire generique.
 */
@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "savings")
public class Account {

	/**
	 * Identifiant technique base de donnees.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	/**
	 * Identifiant metier, numero du compte sur 13 chiffres.
	 */
	@Column
	private String number;

	/**
	 * Stockage du solde actuel de ce compte en euros.
	 */
	@Column
	private Float balance;
	
	/**
	 * Libellé du compte.
	 */
	@Column
	private String label;
	
	/**
	 * Date d'ouverture du compte.
	 */
	@Column
	private String openingDate;
	
	/**
	 * Chéquier associé au compte.
	 */
	@OneToOne
	@JoinColumn(name="chequebook_id", referencedColumnName="id")
	private Chequebook chequebook;

	public Account() {
		this.balance = 0F;
	}

	public Account(Integer id, String number, Float balance, String label, String openingDate, Chequebook chequebook) {
		this.id = id;
		this.number = number;
		this.balance = balance;
		this.label = label;
		this.openingDate = openingDate;
		this.chequebook = chequebook;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	public Chequebook getChequebook() {
		return chequebook;
	}

	public void setChequebook(Chequebook chequebook) {
		this.chequebook = chequebook;
	}

}
