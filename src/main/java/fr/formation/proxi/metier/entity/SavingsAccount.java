package fr.formation.proxi.metier.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Representation d'un compte épargne qui hérite de la classe Account.
 */
@Entity
@DiscriminatorValue("SAVINGS")
public class SavingsAccount extends Account {

}