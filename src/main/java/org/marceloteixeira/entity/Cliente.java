package org.marceloteixeira.entity;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Cliente extends PanacheEntity {
	
	public String nome;
	public String email;
	public String telefone;
	
	public static List<Cliente> findByNome(String nome) {
		return find("nome", nome).list();
	}

}
