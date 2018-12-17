package fr.formation.proxi.metier;

import fr.formation.proxi.metier.entity.BankCard;
import fr.formation.proxi.persistance.BankCardDao;

public class BankCardService {

public static final BankCardService INSTANCE = new BankCardService();
	
	public static BankCardService getInstance() {
		return BankCardService.INSTANCE;
	}
	
	private final BankCardDao dao;
	
	public BankCardService() {
		this.dao = new BankCardDao();
	}
	
	public void addBankCard(BankCard bankCard) {
		this.dao.create(bankCard);
	}
}
