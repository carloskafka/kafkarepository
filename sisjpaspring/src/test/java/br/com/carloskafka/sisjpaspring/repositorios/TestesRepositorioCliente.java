package br.com.carloskafka.sisjpaspring.repositorios;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.carloskafka.sisjpaspring.dominio.cliente.Cliente;
import br.com.carloskafka.sisjpaspring.dominio.seguranca.Autenticador;
import br.com.carloskafka.sisjpaspring.dominio.seguranca.ContaAcesso;
import br.com.carloskafka.sisjpaspring.fabricas.ContextoCliente;
import br.com.carloskafka.sisjpaspring.fabricas.ContextoContaAcesso;
import br.com.carloskafka.sisjpaspring.utilitarios.Registro;

public class TestesRepositorioCliente {
	private static final RepositorioCliente repositorioCliente = Registro
			.obterRepositorioCliente();

	@Test
	public void repositorio_de_cliente_salva_cliente_com_conta_acesso_valida() {
		ContaAcesso contaAcessoValida = ContextoContaAcesso
				.construirContaAcessoComTodosOsDados();
		contaAcessoValida.setId(new Long(1));

		Cliente clienteASalvar = ContextoCliente
				.fabricarClienteComTodosOsDados();
		clienteASalvar.setId(new Long(1));

		boolean salvo = repositorioCliente.salvar(contaAcessoValida,
				clienteASalvar);

		Assert.assertTrue(salvo);
	}

	@Test
	public void repositorio_de_cliente_salva_cliente_com_conta_acesso_invalida() {
		Autenticador autenticador = new Autenticador();

		ContaAcesso contaAcessoInvalida = null;
		contaAcessoInvalida = autenticador.autenticar(contaAcessoInvalida);

		boolean salvo = false;
		if (contaAcessoInvalida.validarObrigatoriedadeDosDados()) {
			Cliente clienteASalvar = ContextoCliente
					.fabricarClienteComTodosOsDados();
			clienteASalvar.setId(new Long(1));

			salvo = repositorioCliente.salvar(contaAcessoInvalida,
					clienteASalvar);
		}

		Assert.assertFalse(salvo);
	}
}
