package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.entity.Chequebook;

public class ChequebookDao extends AbstractDao<Chequebook>{
	
	private static final ChequebookDao INSTANCE = new ChequebookDao();
	
	public static ChequebookDao getInstance() {
		return ChequebookDao.INSTANCE;
	}

	@Override
	public Chequebook read(Integer id) {
		return this.read(id, new Chequebook());
	}

	@Override
	public List<Chequebook> readAll() {
		List<Chequebook> chequebooks = new ArrayList<>();
		TypedQuery<Chequebook> query = this.em
				.createQuery(JpqlQueries.SELECT_ALL_CHEQUEBOOK, Chequebook.class);
		chequebooks.addAll(query.getResultList());
		return chequebooks;
	}

}
