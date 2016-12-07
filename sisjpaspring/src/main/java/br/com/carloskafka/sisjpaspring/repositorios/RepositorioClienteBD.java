package br.com.carloskafka.sisjpaspring.repositorios;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.carloskafka.sisjpaspring.dominio.cliente.Cliente;
import br.com.carloskafka.sisjpaspring.dominio.seguranca.ContaAcesso;

@Repository
public class RepositorioClienteBD extends RepositorioDB<Cliente> implements RepositorioCliente {
	
	@Transactional
	public boolean salvar(ContaAcesso contaAcesso, Cliente cliente) {
		boolean salvo = false;
		String acao = "";
		try {
			if (!cliente.possuiId()) {
				em.persist(cliente);
				acao = "Inclusão";
			} else {
				em.merge(cliente);
				acao = "Alteração";
			}
			salvo = true;
			System.out.println(acao + " do " + cliente
					+ " realizada com sucesso pelo " + contaAcesso);
		} catch (Exception e) {
			salvo = false;
			System.out.println("Erro ao salvar " + cliente + ".\nDetalhes: "
					+ e.getMessage());
		}
		return salvo;
	}

}
