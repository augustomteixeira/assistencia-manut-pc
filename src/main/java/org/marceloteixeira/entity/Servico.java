package org.marceloteixeira.entity;

import java.util.List;

import org.marceloteixeira.enumeration.TipoServico;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;

@Entity
public class Servico extends PanacheEntity {
	
	@Enumerated(EnumType.STRING)
	public TipoServico tipo;
	
	public double preco;
	
	@ManyToMany(mappedBy = "servicos")
	@JsonbTransient
	public List<Pedido> pedidos;
	
	public static List<Servico> findByTipoServico(TipoServico tipo) {
		return find("tipo", tipo).list(); 
	}
	
}
