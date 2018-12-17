package fr.formation.proxi.metier;

import fr.formation.proxi.metier.entity.Chequebook;
import fr.formation.proxi.persistance.ChequebookDao;

public class ChequebookService {

	public static final ChequebookService INSTANCE = new ChequebookService();
	
	public static ChequebookService getInstance() {
		return ChequebookService.INSTANCE;
	}
	
	private final ChequebookDao dao;
	
	public ChequebookService() {
		this.dao = new ChequebookDao();
	}
	
	public void addChequebook(Chequebook chequebook) {
		this.dao.create(chequebook);
	}
}
