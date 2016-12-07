package br.com.carloskafka.sisjpaspring.utilitarios;

import br.com.carloskafka.sisjpaspring.dominio.seguranca.ContaAcesso;

public class Sessao {
	private ContaAcesso contaAcessoLogada;

	private static final Sessao instancia = new Sessao();
	private String token;

	public Sessao() {
		contaAcessoLogada = new ContaAcesso();
	}

	public static Sessao obterInstancia() {
		return instancia;
	}

	public ContaAcesso obterContaAcessoLogado() {
		return contaAcessoLogada;
	}

	public void setContaAcessoLogada(ContaAcesso contaAcessoLogada) {
		this.contaAcessoLogada = contaAcessoLogada;
	}

	public String obterToken() {
		return token;
	}

	public void armazenarToken(String token) {
		this.token = token;
	}

}
