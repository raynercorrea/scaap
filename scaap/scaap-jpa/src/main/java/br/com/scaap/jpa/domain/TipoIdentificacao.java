package br.com.scaap.jpa.domain;

public enum TipoIdentificacao {
	CPF(0, "CPF"),
	CNPJ(1, "CNPJ");
	
	private final String nome;
	private final Integer id;	
	
	private TipoIdentificacao(Integer id, String nome) {
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
