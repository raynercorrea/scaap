package br.com.scaap.jpa.domain;

public enum SituacaoCliente {
	ATIVO(0, "Ativo"), 
	INATIVO(1, "Inativo");

	private final String nome;
	private final Integer id;

	private SituacaoCliente(Integer id, String nome) {
		this.nome = nome;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getId() {
		return id;
	}
}
