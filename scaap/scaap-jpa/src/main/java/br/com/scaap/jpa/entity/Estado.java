package br.com.scaap.jpa.entity;

import javax.persistence.Entity;

import br.com.scaap.jpa.base.entity.BaseEntity;

@Entity
public class Estado extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String uf;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
