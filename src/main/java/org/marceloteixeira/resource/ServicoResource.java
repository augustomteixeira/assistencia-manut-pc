package org.marceloteixeira.resource;

import java.util.List;

import org.marceloteixeira.entity.Servico;
import org.marceloteixeira.enumeration.TipoServico;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/servicos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicoResource {
	
	@GET
	public List<Servico> getServicos() {
		return Servico.listAll();
	}
	
	@GET
	@Path("findByTipo")
	public List<Servico> findByTipo(@QueryParam("tipo") TipoServico tipo) {
		return Servico.findByTipoServico(tipo);
	}

}
