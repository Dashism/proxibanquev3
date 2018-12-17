package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.AccountService;

/**
 * la class CreateAccountServlet hérite de la class HttpServlet
 * elle utilise les méthodes doGet() et doPost() 
 * @author Marie_Julien
 *
 */

public class CreateAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * La méthode doGet() de la classe createAccountServlet permet à l'utilisateur d'afficher dans le jsp 
	 * les informations recueillit sur le nouveau compte à créer
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Integer id = Integer.parseInt(req.getParameter("id"));
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/createaccount.jsp").forward(req, resp);
	}
	
	/**
	 * la méthode doPost() de la class CreateAccountServlet permet à l'utilisateur d'envoyer les informations nécessaires à la création
	 * d'un compte
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String number = req.getParameter("number");
		Float balance = Float.parseFloat(req.getParameter("balance"));
		Boolean savings = Boolean.parseBoolean(req.getParameter("savings"));
		Integer id = Integer.parseInt(req.getParameter("id"));
		AccountService.getInstance().addAccount(number, balance, savings, id);
		resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
	}

}
