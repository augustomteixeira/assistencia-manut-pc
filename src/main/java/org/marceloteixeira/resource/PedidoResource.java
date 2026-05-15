package org.marceloteixeira.resource;

import java.util.List;

import org.marceloteixeira.entity.Pedido;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {
	
	@GET
	public List<Pedido> getPedidos() {
		return Pedido.listAll();
	}
	
	@POST
	@Transactional
	public Pedido addPedido(Pedido pedido) {
		pedido.id = null; // Garantir que o ID seja gerado automaticamente
		pedido.calcularValorTotal();
		pedido.persist();
		
		return pedido;
	}
	
	@PUT
	@Transactional
	public Pedido updatePedido(Pedido pedido) {
		Pedido p = Pedido.findById(pedido.id);
		p.cliente = pedido.cliente;
		p.servicos = pedido.servicos;
		p.status = pedido.status;
		p.calcularValorTotal();
		p.persist();
		
		return pedido;
	}
	
	@DELETE
	@Transactional
	public void deletePedido(int id) {
		Pedido.deleteById(id);
	}

}
