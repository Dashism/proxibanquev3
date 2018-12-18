package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.AccountService;

/**
 * la class AccountlistServlet hérite de la class HttpServlet elle utilise les
 * méthodes doGet() et doPost()
 * 
 * @author Marie_Julien
 *
 */

public class CashWithdrawalServlet extends HttpServlet {

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
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/cashWithdrawal.jsp").forward(req, resp);
	}
	
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
					req.setAttribute("error", "Echec du retrait.");
					this.doGet(req, resp);
				}
			}
		}
	}
}
