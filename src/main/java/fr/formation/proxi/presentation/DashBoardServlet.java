package fr.formation.proxi.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.entity.CurrentAccount;
import fr.formation.proxi.metier.entity.SavingsAccount;

/**
 * la class DashBoardServlet hérite de la class HttpServlet, elle utilise la
 * méthode doGet().
 *
 */

public class DashBoardServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Méthode permettant d'afficher dans la jsp les comptes du client choisi à l'index.
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Client client = (Client) req.getSession().getAttribute("client");
		List<Account> accounts = client.getAccounts();
		List<CurrentAccount> currentAccounts = new ArrayList<>();
		List<SavingsAccount> savingsAccounts = new ArrayList<>();
		for (Account account : accounts) {
			if (account instanceof CurrentAccount) {
				CurrentAccount curaccount = (CurrentAccount) account;
				currentAccounts.add(curaccount);
			} else {
				SavingsAccount savaccount = (SavingsAccount) account;
				savingsAccounts.add(savaccount);
			}
		}
		req.setAttribute("currentAccounts", currentAccounts);
		req.setAttribute("savingsAccounts", savingsAccounts);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(req, resp);
	}
}
