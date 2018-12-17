package fr.formation.proxi.metier.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representation de l'adresse d'un client
 */
@Entity
@Table(name="address")
public class Address {

	/**
	 * Identifiant technique base de donnees.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	/**
	 * Adresse principale avec numéro et nom de rue.
	 */
	@Column
	private String street;
	
	/**
	 * Addresse complémentaire (bâtiment, étages, etc.).
	 */
	@Column
	private String additionInfo;
	
	/**
	 * Code postal.
	 */
	@Column
	private String zipCode;
	
	/**
	 * Ville.
	 */
	@Column
	private String city;
	
	/**
	 * Pays.
	 */
	@Column
	private String country;

	public Address() {
	}

	public Address(Integer id, String street, String additionInfo, String zipCode, String city, String country) {
		this.id = id;
		this.street = street;
		this.additionInfo = additionInfo;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAdditionInfo() {
		return additionInfo;
	}

	public void setAdditionInfo(String additionInfo) {
		this.additionInfo = additionInfo;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
