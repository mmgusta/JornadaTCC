package br.com.submissaoeventos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.submissaoeventos.model.Evento;

@Repository
@Transactional
public class EventoDao implements Dao<Evento>{
	
	@PersistenceContext
	EntityManager manager;

	@Override
	public Evento busca(long id) {
		return manager.find(Evento.class, id);
	}

	@Override
	public void adiciona(Evento t) {
		manager.persist(t);
		
	}

	@Override
	public void remove(long id) {
		Evento evento = busca(id);
		manager.remove(evento);
	}

	@Override
	public void altera(Evento t) {
		manager.merge(t);
	}

	@Override
	public List<Evento> lista() {
		return manager.createQuery("select e from Evento e").getResultList();
	}

}
