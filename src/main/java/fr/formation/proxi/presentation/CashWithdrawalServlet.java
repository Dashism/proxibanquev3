package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.AccountService;

/**
 * la class CashWithdrawalServlet hérite de la class HttpServlet, elle utilise les
 * méthodes doGet() et doPost().
 */

public class CashWithdrawalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Méthode permettant d'accéder à cashWithdrawal.jsp.
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/cashWithdrawal.jsp").forward(req, resp);
	}
	
	/**
	 * Méthode renvoyant vers dashboard.html si le retrait a été effectué, ou
	 * bouclant sur cashWithdrawal.jsp si le montant saisi est trop important.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strId = req.getParameter("id");
		Integer id = Integer.parseInt(strId);
		String strAmount = req.getParameter("amount");
		if (strAmount.equals("")) {
			req.setAttribute("error", "Veuillez remplir le formulaire.");
			this.doGet(req, resp);
		} else {
			Float amount = Float.parseFloat(strAmount);
			if (amount >= 300) {
				req.setAttribute("error", "Montant trop élevé.");
				this.doGet(req, resp);
			} else {
				AccountService service = AccountService.getInstance();
				Boolean result = service.cashWithdrawal(id, amount);
				if (result) {
					resp.sendRedirect(this.getServletContext().getContextPath() + "/dashboard.html");
				} else {
					req.setAttribute("error", "Echec du retrait, solde insuffisant.");
					this.doGet(req, resp);
				}
			}
		}
	}
}
