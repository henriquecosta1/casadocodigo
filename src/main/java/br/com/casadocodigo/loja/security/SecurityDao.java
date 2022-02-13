package br.com.casadocodigo.loja.security;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.SystemUser;

public class SecurityDao {
	
	@PersistenceContext
	private EntityManager manager;

	public SystemUser findByLogin(String login) {
		return manager.createQuery("select su from SystemUser su where su.login = :login"
				, SystemUser.class).setParameter("login", login).getSingleResult();
	}
	
	

}
