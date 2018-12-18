package fr.formation.proxi.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.AccountService;
import fr.formation.proxi.metier.ClientService;
import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.entity.CurrentAccount;
import fr.formation.proxi.metier.entity.SavingsAccount;

/**
 * la class AccountlistServlet hérite de la class HttpServlet
 * elle utilise les méthodes doGet() et doPost() 
 * @author Marie_Julien
 *
 */

public class TransferServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * La méthode doGet() de la classe AccountListServlet permet à l'utilisateur d'afficher dans le jsp 
	 * les informations sur les compte d'un client choisit avec son id
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Client client = (Client) req.getSession().getAttribute("client");
		List<Account> accounts = client.getAccounts();
		req.setAttribute("accounts", accounts);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/transfer.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strAmount = req.getParameter("amount");
		Integer compteADebiter = Integer.parseInt(req.getParameter("account1")); 
		Integer compteACrediter = Integer.parseInt(req.getParameter("account2")); 
		if (strAmount.equals("")) {
			req.setAttribute("errorEmpty", "Veuillez remplir le formulaire.");
			this.doGet(req, resp);
		} else {
			Float amount = Float.parseFloat(strAmount);
			if (amount > 900) {
				req.setAttribute("errorTooHigh", "Montant trop élevé.");
				this.doGet(req, resp);
			} else {
				AccountService service = AccountService.getInstance();
				service.transfer(compteADebiter, compteACrediter, amount);
				resp.sendRedirect(this.getServletContext().getContextPath() + "/dashboard.html");
			}
		}
	}
}
