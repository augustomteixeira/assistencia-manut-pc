package org.marceloteixeira.resource;

import java.util.List;

import org.marceloteixeira.entity.Cliente;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {
	
	@GET
	public List<Cliente> getClientes() {
		return Cliente.listAll();
	}
	
	@GET
	@Path("findByNome")
	public List<Cliente> findByNome(@QueryParam("nome") String nome) {
		return Cliente.findByNome(nome);
	}
	
	@POST
	@Transactional
	public Cliente addCliente(Cliente cliente) {
		cliente.id = null; // Garantir que o ID seja gerado automaticamente
		cliente.persist();
		
		return cliente;
	}
	
	@PUT
	@Transactional
	public Cliente updateCliente(Cliente cliente) {
		Cliente c = Cliente.findById(cliente.id);
		c.nome = cliente.nome;
		c.email = cliente.email;
		c.telefone = cliente.telefone;
		c.persist();
		
		return cliente;
	}
	
	@DELETE
	@Transactional
	public void deleteCliente(int id) {
		Cliente.deleteById(id);
	}

}
