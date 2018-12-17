package fr.formation.proxi.metier.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representation d'un chequier.
 */
@Entity
@Table(name="chequebook")
public class Chequebook {

	/**
	 * Identifiant technique base de donnees.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	/**
	 * Date d'envoi du chequier.
	 */
	@Column
	private LocalDate sendDate;
	
	/**
	 * Date de reception du chequier.
	 */
	@Column
	private LocalDate receptionDate;

	public Chequebook() {
	}

	public Chequebook(Integer id, LocalDate sendDate, LocalDate receptionDate) {
		this.id = id;
		this.sendDate = sendDate;
		this.receptionDate = receptionDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getSendDate() {
		return sendDate;
	}

	public void setSendDate(LocalDate sendDate) {
		this.sendDate = sendDate;
	}

	public LocalDate getReceptionDate() {
		return receptionDate;
	}

	public void setReceptionDate(LocalDate receptionDate) {
		this.receptionDate = receptionDate;
	}
}
