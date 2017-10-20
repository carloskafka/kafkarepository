package aula08.factories;

import javax.servlet.http.HttpServletRequest;

import aula08.models.aluno.Aluno;
import aula08.models.solicitacao.ParametroSolicitacao;

public class AlunoFactory {

	public static Aluno criarAluno(HttpServletRequest request) {
		Aluno aluno = new Aluno();

		String idString = request.getParameter(ParametroSolicitacao.ID.getDescricao());

		if (!idString.isEmpty()) {
			aluno.setId(Integer.parseInt(idString));
		}
		aluno.setNome(request.getParameter(ParametroSolicitacao.NOME.getDescricao()));
		aluno.setEndereco(request.getParameter(ParametroSolicitacao.ENDERECO.getDescricao()));

		return aluno;
	}

}
