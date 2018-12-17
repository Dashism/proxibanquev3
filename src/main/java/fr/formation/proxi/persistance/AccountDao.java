package fr.formation.proxi.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.persistance.MySqlConnection;
import fr.formation.proxi.persistance.SqlQueries;
import fr.formation.proxi.metier.entity.Account;


/**
 * {@InheritDoc}
 * Implémentation  pour le client de la classe Dao omportant les 4 méthodes élémentaires de
 * manipulation de données (CRUD) + readAll. 
 * @author Marie_Julien
 *
 */

public class AccountDao  implements Dao<Account>{

	private final MySqlConnection mysqlConn;

	public AccountDao() {
		this.mysqlConn = MySqlConnection.getInstance();
	}

	/**
	 * {@InheritDoc} 
	 * Crée une nouvelle entité en base de données.
	 * 
	 * @param Account le compte à créer et l'id du compte.
	 * @return  Account avec son identifiant rempli.
	 * **/
	
	
	public Account create(Account entity, Integer id) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			String query = String.format(SqlQueries.CREATE_ACCOUNT, entity.getNumber(), entity.getBalance(), entity.isSavings(), id);
			boolean success = st.execute(query, Statement.RETURN_GENERATED_KEYS); 
			if (success) {
				ResultSet rs = st.getGeneratedKeys();
				Integer accountId = rs.getInt("GENERATED_KEY");
				entity.setId(accountId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

	/**
	 * {@InheritDoc}
	 * Lit les informations d'un Client en base de données.
	 * 
	 * @param id du Client.
	 * @return Client construit à partir des informations récupérées.
	 */
	
	
	@Override
	public Account read(Integer id){
		Account account = new Account();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.READ_ACCOUNT, id));
			while(rs.next()) {
				Integer idacc = rs.getInt("id");
				Boolean savings = rs.getBoolean("savings");
				String number = rs.getString("number");
				Float  balance = rs.getFloat("balance");
				account = new Account(idacc, number, balance, savings);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return account;	
	}


	/**
	 * {@InheritDoc}
	 *  Récupère toutes les information de la table account.
	 * 
	 * @return List<Account> la liste de toutes les Account lus.
	 */
	
	
	
	public List<Account> readAll(Integer id) {
		List<Account> results = new ArrayList<>();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.READ_ALL_ACCOUNT, id));
			while(rs.next()) {
				Integer idacc = rs.getInt("id");
				Boolean savings = rs.getBoolean("savings");
				String number = rs.getString("number");
				Float  balance = rs.getFloat("balance");
				results.add(new Account(idacc, number, balance, savings));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	
	/**
	 * {@InheritDoc} 
	 * Met à jour l'Account donné dans la base de données.
	 * 
	 * @param Account à mettre à jour avec ses nouvelles informations.
	 * @return Account mis à jour.
	 */
	
	@Override
	public Account update(Account entity) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			String query = String.format(SqlQueries.UPDATE_ACCOUNT, entity.getBalance(), entity.getId());
			
			st.execute(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return entity;
	}

	/**
	 * {@InheritDoc} 
	 * Supprime définitivement un ou plusieurs paramètres de Account
	 * 
	 * @param id l'identifiant unique de l'Account à supprimer.
	 * @return boolean vrai si la suppression est un succès, sinon faux.
	 */
	
	@Override
	public boolean delete(Integer id) {
		Boolean result = false;
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			int rowsacc = st.executeUpdate(String.format(SqlQueries.DELETE_ACCOUNTS, id));
			if (rowsacc > 0) {	
				result = true;				
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	
}
