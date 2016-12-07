package br.com.carloskafka.sisjpaspring.dominio.seguranca;

import java.util.UUID;

import br.com.carloskafka.sisjpaspring.repositorios.RepositorioContaAcesso;
import br.com.carloskafka.sisjpaspring.utilitarios.Registro;

public class Autenticador {

	private RepositorioContaAcesso repositorioContaAcesso = Registro
			.obterRepositorioContaAcesso();

	public ContaAcesso autenticar(ContaAcesso contaAcesso) {
		ContaAcesso contaAcessoObtida = repositorioContaAcesso
				.obterContaAcesso(contaAcesso);

		String token = "";
		if (contaAcessoObtida.possuiLogin()) {
			token = UUID.randomUUID().toString();
			contaAcessoObtida.setToken(token);
			repositorioContaAcesso.salvar(contaAcessoObtida);
			System.out.println("Autenticação da " + contaAcessoObtida
					+ " efetuada com sucesso. ");
		} else {
			System.out.println("Tentativa de autenticação da "
					+ contaAcessoObtida + " falhou");
		}
		return contaAcessoObtida;
	}

}
