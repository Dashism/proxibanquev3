package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.AccountService;
import fr.formation.proxi.metier.ClientService;

/**
 * la class AccountlistServlet hérite de la class HttpServlet
 * elle utilise les méthodes doGet() et doPost() 
 * @author Marie_Julien
 *
 */

public class AccountListServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * La méthode doGet() de la classe AccountListServlet permet à l'utilisateur d'afficher dans le jsp 
	 * les informations sur les compte d'un client choisit avec son id
	 * 
	 * @param HttpServletRequest req, HttpServletResponse resp
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strId = req.getParameter("id");
		Integer id = Integer.parseInt(strId);
		AccountService service = AccountService.getInstance();
		req.setAttribute("accounts", service.getAll(id));
		req.setAttribute("client", ClientService.getInstance().getClient(id));
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/accountList.jsp").forward(req, resp);
	}
	

}
