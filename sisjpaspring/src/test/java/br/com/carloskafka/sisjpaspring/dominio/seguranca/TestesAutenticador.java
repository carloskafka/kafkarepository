package br.com.carloskafka.sisjpaspring.dominio.seguranca;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.carloskafka.sisjpaspring.fabricas.ContextoContaAcesso;

public class TestesAutenticador {
	private static final Autenticador autenticador = new Autenticador();

	@Test
	public void autenticador_valida_conta_acesso_e_retorna_token() {
		ContaAcesso contaAcesso = ContextoContaAcesso
				.construirContaAcessoComTodosOsDados();
		contaAcesso.setId(new Long(1));

		contaAcesso = autenticador.autenticar(contaAcesso);
		String token = contaAcesso.getToken();

		Assert.assertFalse(token.isEmpty());
		Assert.assertNotNull(token);
	}
	
	@Test
	public void autenticador_lanca_excecao_ao_validar_conta_acesso_inexistente() {
		ContaAcesso contaAcesso = null;

		contaAcesso = autenticador.autenticar(contaAcesso);
		
		Assert.assertNull(contaAcesso.getId());
		Assert.assertNull(contaAcesso.getLogin());
		Assert.assertNull(contaAcesso.getSenha());
	}
}
