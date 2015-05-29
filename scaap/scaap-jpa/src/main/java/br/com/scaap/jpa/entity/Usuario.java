package br.com.scaap.jpa.entity;

import javax.persistence.Entity;

import br.com.scaap.jpa.base.entity.BaseEntity;

@Entity
public class Usuario extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	private String login;
	
	private String senha;
	
	public Usuario() {
	}
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
