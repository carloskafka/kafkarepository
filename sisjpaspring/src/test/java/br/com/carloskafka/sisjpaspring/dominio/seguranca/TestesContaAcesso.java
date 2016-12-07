package br.com.carloskafka.sisjpaspring.dominio.seguranca;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.carloskafka.sisjpaspring.dominio.seguranca.ContaAcesso;
import br.com.carloskafka.sisjpaspring.fabricas.ContextoContaAcesso;

public class TestesContaAcesso {
	
	@Test
	public void conta_acesso_validacao_com_erro_obrigatoriedade() {
		ContaAcesso contaAcesso = new ContaAcesso();
		boolean validado = contaAcesso.validarObrigatoriedadeDosDados();

		Assert.assertFalse(validado);
	}

	@Test
	public void conta_acesso_validacao_sem_erro_obrigatoriedade() {
		ContaAcesso contaAcesso = ContextoContaAcesso
				.construirContaAcessoComTodosOsDados();
		boolean validado = contaAcesso.validarObrigatoriedadeDosDados();

		Assert.assertTrue(validado);
	}
}
