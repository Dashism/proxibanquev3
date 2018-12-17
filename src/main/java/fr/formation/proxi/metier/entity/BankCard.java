package fr.formation.proxi.metier.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representation d'une carte bancaire.
 */
@Entity
@Table(name="bankcard")
public class BankCard {

	/**
	 * Identifiant technique base de donnees.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	/**
	 * Date d'expiration de la carte.
	 */
	@Column
	private LocalDate expirationDate;
	
	/**
	 * Identifiant metier, numero de la carte sur 16 chiffres.
	 */
	@Column
	private String number;
	
	/**
	 * Type de carte bancaire, soit Visa Electron soit Visa Premier.
	 */
	@Column
	private String type;
	
	public BankCard() {
	}

	public BankCard(Integer id, LocalDate expirationDate, String number, String type) {
		this.id = id;
		this.expirationDate = expirationDate;
		this.number = number;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

