package br.com.carloskafka.sisjpaspring.repositorios;

import java.util.List;

import br.com.carloskafka.sisjpaspring.dominio.seguranca.ContaAcesso;

public interface RepositorioContaAcesso {
	public boolean salvar(ContaAcesso contaAcesso);
	public ContaAcesso obterContaAcesso(ContaAcesso contaAcesso);
	public List<ContaAcesso> obterTodos();
}
