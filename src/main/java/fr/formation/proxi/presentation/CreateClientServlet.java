package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.ClientService;

/**
 * la class CreateClientServlet hérite de la class HttpServlet
 * elle utilise les méthodes doGet() et doPost() 
 * @author Marie_Julien
 *
 */

public class CreateClientServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * La méthode doGet() de la classe createCLientServlet permet à l'utilisateur d'afficher dans le jsp 
	 * les informations recueillit sur le nouveau client à créer
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/createclient.jsp").forward(req, resp);
	}
	
	/**
	 * la méthode doPost() de la class CreateClientServlet permet à l'utilisateur d'envoyer les informations nécessaires à la création
	 * du client
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String lastname = req.getParameter("lastname");
		String firstname = req.getParameter("firstname");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		ClientService service = ClientService.getInstance();
		service.addClient(firstname, lastname, email, address);
		resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
	}

}
