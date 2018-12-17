package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.ClientService;

/**
 * la class DeleteServlet hérite de la class HttpServlet
 * elle utilise la méthode doGet() 
 * @author Marie_Julien
 *
 */


public class DeleteServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * La méthode doGet() de la classe DeleteServlet permet à l'utilisateur d'afficher dans la jsp les informations du client à supprimer.
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		ClientService.getInstance().deleteClient(id);
		resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
	}

}
