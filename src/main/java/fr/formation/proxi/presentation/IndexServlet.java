package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.ClientService;
import fr.formation.proxi.metier.entity.Client;

/**
 * la class IndexServlet hérite de la class HttpServlet, elle utilise les
 * méthodes doGet() et doPost().
 */

public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Méthode permettant d'accéder à index.jsp.
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
	}

	/**
	 * À partir des informations rentrées par l'utilisateur, renvoie vers
	 * dashboard.html si le client existe, ou vers error_dashboard.jsp s'il n'y
	 * aucun client ou deux clients à ce nom.
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("lastname");
		String firstname = null;
		String lastname = null;

		if (name.contains(" ")) {
			try {
				String[] split = name.split(" ");
				lastname = split[0];
				firstname = split[1];
			} catch (ArrayIndexOutOfBoundsException e) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/error_dashboard.jsp").forward(req, resp);
			}

			Client client = ClientService.getInstance().getIdByName(firstname, lastname);
			if (client == null) {
				client = ClientService.getInstance().getIdByName(lastname, firstname);
				if (client == null) {
					this.getServletContext().getRequestDispatcher("/WEB-INF/views/error_dashboard.jsp").forward(req,
							resp);
				} else {
					req.getSession().setAttribute("client", client);
					resp.sendRedirect(this.getServletContext().getContextPath() + "/dashboard.html");
				}
			} else {
				req.getSession().setAttribute("client", client);
				resp.sendRedirect(this.getServletContext().getContextPath() + "/dashboard.html");
			}

		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/error_dashboard.jsp").forward(req, resp);
		}

	}
}
