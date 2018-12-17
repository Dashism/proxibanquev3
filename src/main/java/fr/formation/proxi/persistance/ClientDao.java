package fr.formation.proxi.persistance;


import fr.formation.proxi.persistance.MySqlConnection;
import fr.formation.proxi.persistance.SqlQueries;
import fr.formation.proxi.metier.entity.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * {@InheritDoc}
 * Implémentation  pour le client de la classe Dao omportant les 4 méthodes élémentaires de
 * manipulation de données (CRUD) + readAll.
 * @author Marie_Julien
 *
 */

public class ClientDao implements Dao<Client>{
	
	
	
	private final MySqlConnection mysqlConn;

	
	
	public ClientDao() {
		this.mysqlConn = MySqlConnection.getInstance();
	}
	
	/**
	 * {@InheritDoc} 
	 * Crée une nouvelle entité en base de données.
	 * 
	 * @param Client le client à créer.
	 * @return Client avec son identifiant rempli.
	 */
	public Client create(Client entity) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			String query = String.format(SqlQueries.CREATE_CLIENT, entity.getFirstname(), entity.getLastname(), entity.getEmail(), entity.getAddress());
			boolean success = st.execute(query, Statement.RETURN_GENERATED_KEYS); 
			if (success) {
				ResultSet rs = st.getGeneratedKeys();
				Integer clientId = rs.getInt("GENERATED_KEY");
				entity.setId(clientId);
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
	public Client read(Integer id) {
		Client client = new Client();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.READ_CLIENT, id));
			while(rs.next()) {
				Integer idcli = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				client =new Client(idcli, firstname, lastname, email, address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	/**
	 * {@InheritDoc}
	 *  Récupère toutes les information de la table client.
	 * 
	 * @return List<Client> la liste de toutes les clients lus.
	 */
	
	public List<Client> readAll() {
		List<Client> results = new ArrayList<>();
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQueries.READ_ALL_CLIENT);
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				results.add(new Client(id, firstname, lastname, email, address));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	/**
	 * {@InheritDoc} 
	 * Met à jour l'entité donnée dans la base de données.
	 * 
	 * @param Client à mettre à jour avec ses nouvelles informations.
	 * @return Client mis à jour.
	 */
	
	
	@Override
	public Client update(Client entity) {
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			String queryFirstname = String.format(SqlQueries.UPDATE_CLIENT, "firstname", entity.getFirstname(), entity.getId());
			String queryLastname = String.format(SqlQueries.UPDATE_CLIENT, "lastname", entity.getLastname(), entity.getId());
			String queryEmail = String.format(SqlQueries.UPDATE_CLIENT, "email", entity.getEmail(), entity.getId());
			String queryAddress = String.format(SqlQueries.UPDATE_CLIENT, "address", entity.getAddress(), entity.getId());
			st.execute(queryFirstname);
			st.execute(queryLastname);
			st.execute(queryEmail);
			st.execute(queryAddress);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return entity;
	}

	
	/**
	 * {@InheritDoc} 
	 * Supprime définitivement un ou plusieurs paramètres du client
	 * 
	 * @param id l'identifiant unique du client à supprimer.
	 * @return boolean vrai si la suppression est un succès, sinon faux.
	 */
	
	@Override
	public boolean delete(Integer id) {
		boolean result = false;
		try {
			Statement st = this.mysqlConn.getConn().createStatement();
			int rowscli = st.executeUpdate(String.format(SqlQueries.DELETE_CLIENT, id));
			if (rowscli > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}	

}
