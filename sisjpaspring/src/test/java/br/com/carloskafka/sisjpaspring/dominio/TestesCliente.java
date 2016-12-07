package br.com.carloskafka.sisjpaspring.dominio;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.carloskafka.sisjpaspring.dominio.cliente.Cliente;
import br.com.carloskafka.sisjpaspring.fabricas.ContextoCliente;

public class TestesCliente {
	@Test
	public void cliente_validacao_com_erro_obrigatoriedade() {
		Cliente cliente = new Cliente();
		boolean validado = cliente.validarObrigatoriedadeDosDados();

		Assert.assertFalse(validado);
	}
	
	@Test
	public void cliente_validacao_sem_erro_obrigatoriedade() {
		Cliente cliente = ContextoCliente.fabricarClienteComTodosOsDados();
		boolean validado = cliente.validarObrigatoriedadeDosDados();

		Assert.assertTrue(validado);
	}
}
