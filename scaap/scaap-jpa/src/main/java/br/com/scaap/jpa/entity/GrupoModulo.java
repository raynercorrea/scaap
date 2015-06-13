package br.com.scaap.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.scaap.jpa.base.entity.BaseEntity;

@Entity
public class GrupoModulo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "grupo_id")
	@ManyToOne(targetEntity = Grupo.class)
	private Grupo grupo;
	
	@JoinColumn(name = "modulo_id")
	@ManyToOne(targetEntity = Modulo.class)
	private Modulo modulo;

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
}
