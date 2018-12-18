package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.AccountService;

/**
 * la class NewCardServlet hérite de la class HttpServlet, elle utilise les
 * méthodes doGet() et doPost().
 */

public class NewCardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Méthode permettant d'accéder à newCard.jsp.
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/newCard.jsp").forward(req, resp);
	}

	/**
	 * À partir de l'identifiant du compte et du type de carte choisi par
	 * l'utilisateur, renvoie vers dashboard.html si la carte a été créée et vers
	 * newCard_KO.jsp sinon.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String type = req.getParameter("card1");
		Boolean result = AccountService.getInstance().newCard(id, type);
		if (result) {
			resp.sendRedirect(this.getServletContext().getContextPath() + "/dashboard.html");
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/newCard_KO.jsp").forward(req, resp);
		}
	}
}