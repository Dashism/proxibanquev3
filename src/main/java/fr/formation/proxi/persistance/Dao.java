package fr.formation.proxi.persistance;


/**
 * Définition d'une interface comportant les 4 méthodes élémentaires de
 * manipulation de données (CRUD) + readAll.
 * 
 * @param <T> classe qui représente le type de données manipulé par le DAO.
 */
public interface Dao<T> {
	
	
	/**
	 * Lit les informations d'une entité en base de données.
	 * 
	 * @param id l'identifiant unique de l'entité.
	 * @return T l'entité construite à partir des informations récupérées.
	 */
	public T read(Integer id);
	
	
	/**
	 * Met à jour l'entité donnée dans la base de données.
	 * 
	 * @param entity l'entité à mettre à jour avec ses nouvelles informations.
	 * @return T l'entité mise à jour.
	 */
	public T update(T entity);
	
	/**
	 * Supprime définitivement une entité de la base de données.
	 * 
	 * @param id l'identifiant unique de l'entité à supprimer.
	 * @return boolean vrai si la suppression est un succès, sinon faux.
	 */
	public boolean delete(Integer id);


}
