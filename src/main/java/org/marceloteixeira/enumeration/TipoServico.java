package org.marceloteixeira.enumeration;

public enum TipoServico {
	FORMATACAO (1, "Formatação do sistema operacional, instalação de drivers e programas básicos."),
	INSTALACAO_PROGRAMAS (2, "Instalação de programas adicionais, como Leitor de PDF, Pacote Office, etc."),
	REMOCAO_VIRUS (3, "Remoção de vírus, malware e outras ameaças de segurança."),
	OTIMIZACAO_DESEMPENHO (4, "Otimização do desempenho do computador, limpeza de arquivos temporários e ajustes de configuração.");

	private int tipo;
	private String descricao;

	TipoServico(int tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public int getTipo() {
		return tipo;
	}

	public String getDescricao() {
		return descricao;
	}

}
