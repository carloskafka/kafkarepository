package br.com.carloskafka.sisjpaspring.controladores;

import br.com.carloskafka.sisjpaspring.dominio.cliente.Cliente;
import br.com.carloskafka.sisjpaspring.dominio.seguranca.Autenticador;
import br.com.carloskafka.sisjpaspring.dominio.seguranca.ContaAcesso;
import br.com.carloskafka.sisjpaspring.repositorios.RepositorioCliente;
import br.com.carloskafka.sisjpaspring.utilitarios.Registro;

public class ControladorCliente {
	private RepositorioCliente repositorioCliente = Registro
			.obterRepositorioCliente();
	private Autenticador autenticador = new Autenticador();

	public void salvarCliente(ContaAcesso contaAcesso, Cliente cliente) {
		ContaAcesso contaAcessoAutenticado = autenticador
				.autenticar(contaAcesso);
		if (contaAcessoAutenticado != null
				&& contaAcessoAutenticado.validarObrigatoriedadeDosDados()) {
			repositorioCliente.salvar(contaAcesso, cliente);
		}
	}

}
