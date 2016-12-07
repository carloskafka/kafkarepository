package br.com.carloskafka.sisjpaspring.repositorios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.carloskafka.sisjpaspring.dominio.seguranca.ContaAcesso;

@Repository
public class RepositorioContaAcessoBD extends RepositorioDB<ContaAcesso>
		implements RepositorioContaAcesso {

	@Transactional
	public boolean salvar(ContaAcesso contaAcesso) {
		boolean salvo = false;
		String acao = "";
		try {
			if (!contaAcesso.possuiId()) {
				em.persist(contaAcesso);
				acao = "Inclusão";
			} else {
				em.merge(contaAcesso);
				acao = "Alteração";
			}
			salvo = true;
			System.out.println(acao + " do " + contaAcesso
					+ " realizada com sucesso.");
		} catch (Exception e) {
			salvo = false;
			System.out.println("Erro ao salvar " + contaAcesso
					+ ".\nDetalhes: " + e.getMessage());
		}
		return salvo;
	}

	public List<ContaAcesso> obterTodos() {
		List<ContaAcesso> contasAcesso = new ArrayList<ContaAcesso>();
		try {
			TypedQuery<ContaAcesso> query = em.createQuery(
					"SELECT c FROM ContaAcesso c", ContaAcesso.class);
			contasAcesso = query.getResultList();
		} catch (Exception e) {
			System.out.println("Falha durante a obtenção de listagem");
		}
		return contasAcesso;
	}

	public ContaAcesso obterContaAcesso(ContaAcesso contaAcesso) {
		ContaAcesso contaAcessoObtida = new ContaAcesso();
		try {
			TypedQuery<ContaAcesso> query = em.createQuery(
					"SELECT c FROM ContaAcesso c "
							+ "WHERE c.login = :login and c.senha = :senha",
					ContaAcesso.class);
			query.setParameter("login", contaAcesso.getLogin());
			query.setParameter("senha", contaAcesso.getSenha());
			contaAcessoObtida = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Falha durante a obtenção de " + contaAcesso
					+ ".\nDetalhes: " + e.getMessage());
		}
		return contaAcessoObtida;
	}
}
