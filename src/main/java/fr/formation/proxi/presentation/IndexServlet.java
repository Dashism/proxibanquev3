package fr.formation.proxi.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.ClientService;
import fr.formation.proxi.metier.entity.Client;

/**
 * la class IndexrServlet hérite de la class HttpServlet
 * elle utilise les méthode doGet()
 * @author Marie_Julien
 *
 */

public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * La méthode doGet() de la classe IndexServlet permet à l'utilisateur d'afficher dans lea jsp les informations sur les clients de la table client.
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<Client> clients = ClientService.getInstance().getAll();
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
	}
	
	/**
	 * la méthode doPost() de la class EditServlet permet à l'utilisateur d'envoyer les informations nécessaires à la modification 
	 * du client à modifier.
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(req, resp);
	}
}
