package br.com.carloskafka.sisjpaspring.repositorios;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.carloskafka.sisjpaspring.dominio.seguranca.ContaAcesso;
import br.com.carloskafka.sisjpaspring.fabricas.ContextoContaAcesso;
import br.com.carloskafka.sisjpaspring.utilitarios.Registro;

public class TestesRepositorioContaAcesso {
	private static final RepositorioContaAcesso repositorioContaAcesso = Registro
			.obterRepositorioContaAcesso();

	@Test
	public void repositorio_de_conta_acesso_salva_conta_acesso_com_sucesso() {
		ContaAcesso contaAcessoValida = ContextoContaAcesso
				.construirContaAcessoComTodosOsDados();
		contaAcessoValida.setId(new Long(1));

		boolean salvo = repositorioContaAcesso.salvar(contaAcessoValida);

		Assert.assertTrue(salvo);
	}

	@Test
	public void repositorio_de_conta_acesso_salva_conta_acesso_sem_sucesso() {
		ContaAcesso contaAcessoValida = null;

		boolean salvo = repositorioContaAcesso.salvar(contaAcessoValida);

		Assert.assertFalse(salvo);
	}

	@Test
	public void repositorio_de_conta_acesso_obtem_conta_acesso_com_sucesso() {
		ContaAcesso contaAcessoValida = ContextoContaAcesso
				.construirContaAcessoComTodosOsDados();
		contaAcessoValida.setId(new Long(1));

		ContaAcesso contaAcessoObtida = repositorioContaAcesso
				.obterContaAcesso(contaAcessoValida);

		Assert.assertEquals(contaAcessoObtida.getId(),
				contaAcessoValida.getId());
		Assert.assertEquals(contaAcessoObtida.getLogin(),
				contaAcessoValida.getLogin());
		Assert.assertEquals(contaAcessoObtida.getSenha(),
				contaAcessoValida.getSenha());
	}

	@Test
	public void repositorio_de_conta_acesso_obtem_conta_acesso_sem_sucesso() {
		ContaAcesso contaAcessoValida = null;

		ContaAcesso contaAcessoObtida = repositorioContaAcesso
				.obterContaAcesso(contaAcessoValida);
		boolean validado = contaAcessoObtida.validarObrigatoriedadeDosDados();

		Assert.assertFalse(validado);
	}

	@Test
	public void repositorio_de_conta_acesso_obtem_todos_com_sucesso() {
		List<ContaAcesso> contasAcesso = repositorioContaAcesso.obterTodos();

		int quantidade = contasAcesso.size();

		Assert.assertEquals(quantidade, 1);
	}
}
