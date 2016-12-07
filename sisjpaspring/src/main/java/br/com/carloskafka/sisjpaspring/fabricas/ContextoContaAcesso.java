package br.com.carloskafka.sisjpaspring.fabricas;

import br.com.carloskafka.sisjpaspring.dominio.seguranca.ContaAcesso;

public class ContextoContaAcesso {
	
	public static ContaAcesso construirContaAcessoComTodosOsDados() {
		ContaAcesso contaAcesso = new ContaAcesso();
		contaAcesso.setLogin("usuario");
		contaAcesso.setSenha("1234");

		return contaAcesso;
	}
}
