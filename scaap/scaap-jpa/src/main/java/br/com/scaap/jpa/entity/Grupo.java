package br.com.scaap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.scaap.jpa.base.entity.BaseEntity;

@Entity
public class Grupo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	@OneToMany(mappedBy = "grupo", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private List<GrupoModulo> grupoModulos = new ArrayList<GrupoModulo>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<GrupoModulo> getGrupoModulos() {
		return grupoModulos;
	}	
}
