package br.com.scaap.jpa.entity;

import javax.persistence.Entity;

import br.com.scaap.jpa.base.entity.BaseEntity;

@Entity
public class Municipio extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
