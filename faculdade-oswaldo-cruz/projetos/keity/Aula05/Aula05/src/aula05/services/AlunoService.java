package aula05.services;

import aula05.dao.AlunoDAO;
import aula05.models.Aluno;

public class AlunoService {
	AlunoDAO alunoDao = new AlunoDAO();

	public int inserir(Aluno aluno) {
		return alunoDao.inserir(aluno);
	}
}