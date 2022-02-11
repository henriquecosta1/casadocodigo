package br.com.casadocodigo.loja.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

@Path("livros")
public class LivroResource {
	
	@Inject
	private LivroDao livroDao;

	@GET
	@Path("lancamentos")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Livro> ultimosLancamentosJson() {
		return livroDao.ultimosLancamentos();
		
	}

}
