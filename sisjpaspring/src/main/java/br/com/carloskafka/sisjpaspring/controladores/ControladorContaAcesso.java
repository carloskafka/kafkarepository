package br.com.carloskafka.sisjpaspring.controladores;

import br.com.carloskafka.sisjpaspring.dominio.seguranca.Autenticador;
import br.com.carloskafka.sisjpaspring.dominio.seguranca.ContaAcesso;
import br.com.carloskafka.sisjpaspring.repositorios.RepositorioContaAcesso;
import br.com.carloskafka.sisjpaspring.utilitarios.Registro;
import br.com.carloskafka.sisjpaspring.utilitarios.Sessao;

public class ControladorContaAcesso {

	private Autenticador autenticador = new Autenticador();
	private RepositorioContaAcesso repositorioContaAcesso = Registro
			.obterRepositorioContaAcesso();

	public void autenticarLogin(ContaAcesso contaAcesso) {
		ContaAcesso contaAcessoObtida = autenticador.autenticar(contaAcesso);
		Sessao.obterInstancia().armazenarToken(contaAcessoObtida.getToken());
	}

	public void salvar(ContaAcesso contaAcesso) {
		if (contaAcesso.validarObrigatoriedadeDosDados()) {
			repositorioContaAcesso.salvar(contaAcesso);
		} else {
			System.out.println("Falha na validação de " + contaAcesso);
		}
	}

}
