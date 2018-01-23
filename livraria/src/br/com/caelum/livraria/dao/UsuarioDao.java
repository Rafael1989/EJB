package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager em;

	public Usuario buscaPeloLogin(String login) {
		try {
			return em.createQuery("select u from Usuario u where u.login = :login", 
					Usuario.class).setParameter("login", login).getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
		
	}
}
