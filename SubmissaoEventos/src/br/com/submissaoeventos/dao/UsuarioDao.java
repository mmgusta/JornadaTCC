package br.com.submissaoeventos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.submissaoeventos.model.Usuario;

@Repository
@Transactional
public class UsuarioDao implements Dao<Usuario> {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public Usuario busca(long id) {
		return manager.find(Usuario.class, id);
	}

	@Override
	public void adiciona(Usuario t) {
		manager.persist(t);
	}

	@Override
	public void remove(long id) {
		Usuario usuario = busca(id);
		manager.remove(usuario);
	}

	@Override
	public void altera(Usuario t) {
		Usuario usuario = busca(t.getId());
		manager.merge(usuario);
	}

	@Override
	public List<Usuario> lista() {
		return manager.createQuery("select u from Usuario u").getResultList();
	}

}
