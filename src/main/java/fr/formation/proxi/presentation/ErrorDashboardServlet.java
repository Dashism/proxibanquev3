package fr.formation.proxi.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * la class ErrorDashboardServlet hérite de la class HttpServlet, elle utilise les
 * méthodes doGet() et doPost().
 *
 */
public class ErrorDashboardServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Méthode permettant d'accéder à error_dashboard.jsp.
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/error_dashboard.jsp").forward(req, resp);
	}

	/**
	 * Méthode permettant d'accéder à index.jsp.
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
	}
}
