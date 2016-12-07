package br.com.carloskafka.sisjpaspring;

import br.com.carloskafka.sisjpaspring.controladores.ControladorCliente;
import br.com.carloskafka.sisjpaspring.controladores.ControladorContaAcesso;
import br.com.carloskafka.sisjpaspring.dominio.cliente.Cliente;
import br.com.carloskafka.sisjpaspring.dominio.seguranca.ContaAcesso;
import br.com.carloskafka.sisjpaspring.fabricas.ContextoCliente;
import br.com.carloskafka.sisjpaspring.fabricas.ContextoContaAcesso;
import br.com.carloskafka.sisjpaspring.utilitarios.Sessao;

public class App {
	private static final ControladorCliente controladorCliente = new ControladorCliente();
	private static final ControladorContaAcesso controladorContaAcesso = new ControladorContaAcesso();

	private void cadastrarContaAcesso(ContaAcesso contaAcesso) {
		controladorContaAcesso.salvar(contaAcesso);
	}

	private void autenticarContaAcesso(ContaAcesso contaAcesso) {
		Sessao.obterInstancia().setContaAcessoLogada(contaAcesso);
		
		controladorContaAcesso.autenticarLogin(contaAcesso);
		contaAcesso.setToken(Sessao.obterInstancia().obterToken());
	}

	public void cadastrarCliente(Cliente cliente) {
		ContaAcesso contaAcessoLogado = Sessao.obterInstancia()
				.obterContaAcessoLogado();
		
		if (contaAcessoLogado.possuiToken()) {
			cliente.setId(new Long(1));
			controladorCliente.salvarCliente(contaAcessoLogado, cliente);
		} else {
			System.out.println("Não há nenhuma conta acesso logado.");
		}
	}

	public static void main(String[] args) {
		App app = new App();

		ContaAcesso contaAcesso = ContextoContaAcesso
				.construirContaAcessoComTodosOsDados();
		contaAcesso.setId(new Long(1));

		app.cadastrarContaAcesso(contaAcesso);
		app.autenticarContaAcesso(contaAcesso);

		Cliente cliente = ContextoCliente.fabricarClienteComTodosOsDados();
		app.cadastrarCliente(cliente);
	}
}
