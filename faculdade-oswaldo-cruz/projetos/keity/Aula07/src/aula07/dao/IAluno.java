package aula07.dao;

import java.util.ArrayList;
import java.util.List;

import aula07.models.Resultado;
import aula07.models.aluno.Aluno;

public interface IAluno {
	public ArrayList<Aluno> listarAlunos();
	public List<Aluno> listarAlunosPor(String chave, String valor);
	public boolean excluirPorId(int id);
	public Resultado editar(Aluno aluno);
}
