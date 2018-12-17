package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * la class AccountlistServlet hérite de la class HttpServlet elle utilise les
 * méthodes doGet() et doPost()
 * 
 * @author Marie_Julien
 *
 */

public class RetraitCBServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * La méthode doGet() de la classe AccountListServlet permet à l'utilisateur
	 * d'afficher dans le jsp les informations sur les compte d'un client choisit
	 * avec son id
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/retraitCB.jsp").forward(req, resp);
	}
}