package br.com.carloskafka.sisjpaspring.repositorios;

import br.com.carloskafka.sisjpaspring.dominio.cliente.Cliente;
import br.com.carloskafka.sisjpaspring.dominio.seguranca.ContaAcesso;

public interface RepositorioCliente {
	public boolean salvar(ContaAcesso contaAcesso, Cliente cliente);
}
