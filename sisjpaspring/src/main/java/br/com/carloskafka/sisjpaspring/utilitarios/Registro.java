package br.com.carloskafka.sisjpaspring.utilitarios;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.carloskafka.sisjpaspring.repositorios.RepositorioCliente;
import br.com.carloskafka.sisjpaspring.repositorios.RepositorioContaAcesso;

public class Registro {
	private static ClassPathXmlApplicationContext contexto;

	public static final ApplicationContext inicializarContexto() {
		if (contexto == null) {
			contexto = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		}
		return contexto;
	}

	public static void finalizarContexto() {
		((AbstractApplicationContext) contexto).close();
	}

	public static RepositorioCliente obterRepositorioCliente() {
		inicializarContexto();
		return contexto.getBean(RepositorioCliente.class);
	}

	public static RepositorioContaAcesso obterRepositorioContaAcesso() {
		inicializarContexto();
		return contexto.getBean(RepositorioContaAcesso.class);
	}

}
