package br.com.scaap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.scaap.jpa.base.entity.BaseEntity;
import br.com.scaap.jpa.domain.TipoIdentificacao;

@Entity
public class Cliente extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String Identificacao;
	
	@Column(name = "tipoIdentificacao_id")
	@Enumerated(EnumType.ORDINAL)
	private TipoIdentificacao tipoIdentificacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdentificacao() {
		return Identificacao;
	}

	public void setIdentificacao(String identificacao) {
		Identificacao = identificacao;
	}

	public TipoIdentificacao getTipoIdentificacao() {
		return tipoIdentificacao;
	}

	public void setTipoIdentificacao(TipoIdentificacao tipoIdentificacao) {
		this.tipoIdentificacao = tipoIdentificacao;
	}
}
