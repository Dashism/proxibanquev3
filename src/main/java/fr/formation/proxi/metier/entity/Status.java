package fr.formation.proxi.metier.entity;

/**
 * Classe instanciée lors de l'appel de la méthode newChequebook() dans la classe AccountService.
 */
public class Status {
	
	/**
	 * Vrai si le nouveau chéquier a été créé, faux sinon.
	 */
	private Boolean valid;
	
	/**
	 * Message à afficher en fonction de l'état du chéquier (nouveau ou pas, premier ou pas).
	 */
	private String message;
	
	public Status() {
	}
	
	public Status(Boolean valid, String message) {
		this.valid = valid;
		this.message = message;
	}
	
	public Boolean getValid() {
		return valid;
	}
	
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}
