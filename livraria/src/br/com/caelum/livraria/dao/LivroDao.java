package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {

	@PersistenceContext
	private EntityManager em;
	
	public void salva(Livro livro) {
		em.persist(livro);
	}
	
	public List<Livro> todosLivros() {
		return em.createQuery("select l from Livro l",Livro.class).getResultList();
	}

	public List<Livro> getLivrosPorTitulo(String titulo) {
		return em.createQuery("select l from Livro l where l.titulo like :titulo",Livro.class).setParameter("titulo", titulo + "%").getResultList();
	}
	
}
