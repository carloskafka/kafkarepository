package aula07.services;

import java.util.ArrayList;
import java.util.List;

import aula07.dao.AlunoDAO;
import aula07.dao.IAluno;
import aula07.models.Resultado;
import aula07.models.aluno.Aluno;

public class AlunoService {
	private IAluno alunoDao;

	public AlunoService() {
		alunoDao = new AlunoDAO();
	}

	public Resultado editar(Aluno aluno) {
		Resultado resultado = aluno.validarObrigatoriedadeDeDados();

		if (resultado.isSucesso()) {
			Resultado resultadoEdicao = alunoDao.editar(aluno);
			
			if (resultadoEdicao.isSucesso()) {
				resultado.setAlunoEditado(resultadoEdicao.getAlunoEditado());
				resultado.adicionarMensagem(resultadoEdicao.getMensagens());
			} else {
				resultado.adicionarErro(resultadoEdicao.getErros());
			}
		}

		return resultado;
	}

	public ArrayList<Aluno> listarAlunos() {
		return alunoDao.listarAlunos();
	}

	public List<Aluno> listarAlunosPor(String chave, String valor) {
		return alunoDao.listarAlunosPor(chave, valor);
	}

	public Resultado excluirPorId(int id) {
		Resultado resultado = new Resultado();

		if (alunoDao.excluirPorId(id)) {
			resultado.adicionarMensagem("ID " + id + " foi excluido com sucesso");
		} else {
			resultado.adicionarErro("Falha ao excluir id " + id);
		}

		return resultado;
	}
}