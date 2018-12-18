package fr.formation.proxi.presentation.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.formation.proxi.metier.AccountService;
import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Status;

/**
 * Permet de renvoyer le message à afficher pour la création d'un chéquier à partir de l'identifiant du compte.
 */
@Path("/json")
public class JsonWebService {

	/**
	 * Récupère le compte pour lequel il faut créer un chéquier et renvoit un status contenant un booléen et un string.
	 * @param account Le compte pour lequel l'utilisateur veut un nouveau chéquier.
	 * @return Status Objet composé d'un booléen pour savoir si le chéquier est créé ou non et du message à afficher.
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Status check(Account account) {
		return AccountService.getInstance().newChequebook(account.getId());
	}
}
