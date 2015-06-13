package br.com.scaap.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.scaap.jpa.base.entity.BaseEntity;

@Entity
public class Modulo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	
	private String tela;
	
	private Boolean ativo;
	
	@JoinColumn(name = "moduloPai_id")
	@ManyToOne(targetEntity = Modulo.class)
	private Modulo moduloPai;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTela() {
		return tela;
	}

	public void setTela(String tela) {
		this.tela = tela;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Modulo getModuloPai() {
		return moduloPai;
	}

	public void setModuloPai(Modulo moduloPai) {
		this.moduloPai = moduloPai;
	}
}
