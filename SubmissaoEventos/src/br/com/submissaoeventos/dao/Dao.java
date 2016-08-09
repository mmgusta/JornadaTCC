package br.com.submissaoeventos.dao;

import java.util.List;

public interface Dao<T> {

	T busca(long id);
	void adiciona(T t);
	void remove(long id);
	void altera(T t);
	List<T> lista();
}
