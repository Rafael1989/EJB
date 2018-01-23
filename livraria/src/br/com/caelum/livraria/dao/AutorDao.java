package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AutorDao {

	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	void aposCriacao() {
		System.out.println("AutorDao criado com sucesso");
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void salva(Autor autor) {
		System.out.println("Salvando ...");
		/*try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		em.persist(autor);
		System.out.println("Salvo");
	}
	
	public List<Autor> todosAutores() {
		return em.createQuery("select a from Autor a",Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = em.find(Autor.class, autorId);
		return autor;
	}
	
}
