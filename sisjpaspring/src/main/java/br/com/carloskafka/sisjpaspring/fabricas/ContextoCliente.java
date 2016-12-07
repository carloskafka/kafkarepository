package br.com.carloskafka.sisjpaspring.fabricas;

import br.com.carloskafka.sisjpaspring.dominio.cliente.Cliente;

public class ContextoCliente {

	public static Cliente fabricarClienteComTodosOsDados() {
		String nome = "usuario";
		String cnpj = "1111111111111";
		String razaoSocial = "TESTE Corporations";
		String email = "teste@teste.org.br";
		String telefone = "1199999999";

		Cliente cliente = new Cliente();

		cliente.setNome(nome);
		cliente.setCnpj(cnpj);
		cliente.setRazaoSocial(razaoSocial);
		cliente.setEmail(email);
		cliente.setTelefone(telefone);
		
		return cliente;
	}
}
