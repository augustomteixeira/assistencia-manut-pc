package org.marceloteixeira.entity;

import java.util.List;

import org.marceloteixeira.enumeration.StatusPedido;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido extends PanacheEntity {
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	public Cliente cliente;
	
	@ManyToMany
	@JoinTable(name = "pedido_servico",
		joinColumns = @JoinColumn(name = "pedido_id"),
		inverseJoinColumns = @JoinColumn(name = "servico_id"))
	public List<Servico> servicos;
	
	public double valorTotal;
	
	@Enumerated(EnumType.STRING)
	public StatusPedido status;
	
	public void calcularValorTotal() {
		this.valorTotal = servicos.stream().mapToDouble(s -> s.preco).sum();
	}

}
