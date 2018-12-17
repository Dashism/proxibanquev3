package fr.formation.proxi.metier.entity;

/**
 * Représentation d'un compte bancaire générique.
 */
public class Account {

	/**
	 * Identifiant technique base de données.
	 */
	private Integer id;

	/**
	 * Identifiant métier, numéro du compte sur 9 chiffres.
	 */
	private String number;

	/**
	 * Stockage du solde actuel de ce compte en €.
	 */
	private Float balance;

	/**
	 * Si vrai, c'est un compte épargne, sinon c'est un compte courant.
	 */
	private boolean savings;

	public Account() {
		this.savings = false;
		this.balance = 0F;
	}

	public Account(String number, Float balance) {
		this();
		this.number = number;
		this.balance = balance;
	}

	public Account(String number, Float balance, boolean savings) {
		this(number, balance);
		this.savings = savings;
	}
	
	public Account(Integer id, String number, Float balance, boolean savings) {
		this(number, balance);
		this.id = id;
		this.savings = savings;
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

	public boolean isSavings() {
		return savings;
	}

	public void setSavings(boolean savings) {
		this.savings = savings;
	}

}
