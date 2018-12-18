package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.entity.BankCard;

/**
 * Hérite de AbstractDao, avec l'entité fixée à BankCard.
 */
public class BankCardDao extends AbstractDao<BankCard> {
	
	/**
	 * Déclaration d'un singleton (instance unique) privé.
	 */
	private static final BankCardDao INSTANCE = new BankCardDao();

	/**
	 * @return BankCardDao l'instance unique (singleton).
	 */
	public static BankCardDao getInstance() {
		return BankCardDao.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BankCard read(Integer id) {
		return this.read(id, new BankCard());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BankCard> readAll() {
		List<BankCard> cards = new ArrayList<>();
		TypedQuery<BankCard> query = this.em
				.createQuery(JpqlQueries.SELECT_ALL_CARD, BankCard.class);
		cards.addAll(query.getResultList());
		return cards;
	}

}
