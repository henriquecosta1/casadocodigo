package br.com.casadocodigo.loja.security;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.casadocodigo.loja.models.SystemUser;

@Model
public class CurrentUser {

	@Inject
	private HttpServletRequest request;
	
	@Inject
	private SecurityDao securityDao;
	private SystemUser systemUser;
	
	public SystemUser get() {
		return systemUser;
	}
	
	public boolean hasRole(String name) {
		return request.isUserInRole(name);
	}
	
	public String logout() {
		request.getSession().invalidate();
		return "/livros/lista.xhtml?faces-redirect=true";
	}
	
	@PostConstruct
	public void loadSystemUser() {
		Principal principal = request.getUserPrincipal();
		if(principal != null) {
			String login = request.getUserPrincipal().getName();
			systemUser = securityDao.findByLogin(login);
		}		
	}
}
