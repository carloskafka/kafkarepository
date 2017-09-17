package aula06.services;

import java.util.ArrayList;

import aula06.dao.AlunoDAO;
import aula06.models.Aluno;

public class AlunoService {
	AlunoDAO alunoDao = new AlunoDAO();

	public int inserir(Aluno aluno) {
		return alunoDao.inserir(aluno);
	}

	public ArrayList<Aluno> listarAlunos() {
		return alunoDao.listarAlunos();
	}

}