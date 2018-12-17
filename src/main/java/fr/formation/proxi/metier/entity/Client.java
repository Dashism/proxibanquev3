package fr.formation.proxi.metier.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Représentation d'un client de la banque.
 */
@Entity
@Table(name = "client")
public class Client {

	/**
	 * Définition de l'identifiant JPA correspondant à la clé primaire en SQL.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	/**
	 * Identifiant metier, numero du client sur 8 chiffres.
	 */
	@Column
	private String number;

	/**
	 * Prénom du client.
	 */
	@Column
	private String firstname;

	/**
	 * Nom de famille du client.
	 */
	@Column
	private String lastname;

	/**
	 * Date de naissance du client.
	 */
	@Column
	private String birthdate;

	/**
	 * Adresse du client.
	 */
	@OneToOne
	@JoinColumn(name="address_id", referencedColumnName="id")
	private String address;

	/**
	 * Liste des comptes du client.
	 */
	@OneToMany
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private List<Account> accounts;

	public Client() {
		this.accounts = new ArrayList<>();
	}

	public Client(Integer id, String number, String firstname, String lastname, String birthdate, String address,
			List<Account> accounts) {
		this.id = id;
		this.number = number;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.address = address;
		this.accounts = accounts;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account getAccountById(Integer searchId) {
		Account result = null;
		for (Account a : this.accounts) {
			if (a.getId().equals(searchId)) {
				result = a;
				break;
			}
		}
		return result;
	}

}