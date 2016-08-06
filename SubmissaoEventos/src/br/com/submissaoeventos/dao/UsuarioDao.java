package br.com.submissaoeventos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.submissaoeventos.model.Usuario;

@Repository
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
	public void remove(Usuario t) {
		Usuario usuario = busca(t.getId());
		manager.remove(usuario);
	}

	@Override
	public void altera(Usuario t) {
		manager.merge(t);
	}

	@Override
	public List<Usuario> lista() {
		return manager.createQuery("select u from Usuario u").getResultList();
	}

}
