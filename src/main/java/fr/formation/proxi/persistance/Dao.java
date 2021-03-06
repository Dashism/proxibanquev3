package fr.formation.proxi.persistance;

import java.util.List;

/**
 * Définition d'une interface comportant les 4 méthodes élémentaires de
 * manipulation de données (CRUD) + readAll.
 * 
 * @param <T> classe qui représente le type de données manipulé par le DAO.
 */
public interface Dao<T> {
	
	/**
	 * Crée une nouvelle entité en base de données.
	 * 
	 * @param entity l'entité à créer.
	 * @return T l'entité avec son identifiant rempli.
	 */
	public T create(T entity);

	/**
	 * Lit les informations d'une entite de BDD
	 * 
	 * @param id l'identifiant d'une entite en base de donnees
	 * @return T l'entité construite à partir des informations recuperees
	 * 
	 */
	public T read(Integer id);

	/**
	 * Recupere toutes les entités (lignes) d'une table
	 * 
	 * @return List<T> la liste de toutes les entites lues.
	 */
	public List<T> readAll();

	/**
	 * met à jour l'entite donne dans la BDD
	 * 
	 * @param entity l'entite à mettre a jour avec les nouvelles informations
	 * @return l'entite mise à jour
	 */
	public T update(T entity);
	
	/**
	 * Supprime définitivement une entité de la base de données.
	 * 
	 * @param id l'identifiant unique de l'entité.
	 * @return boolean vrai si la suppression est un succès, sinon faux.
	 */
	public boolean delete(Integer id);
}
