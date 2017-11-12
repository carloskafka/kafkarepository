package aula09.dao;

import java.util.ArrayList;
import java.util.List;

import aula09.models.Resultado;
import aula09.models.aluno.Aluno;

public interface IAluno {
	public ArrayList<Aluno> listarAlunos();
	public List<Aluno> listarAlunosPor(String chave, String valor);
	public boolean excluirPorId(int id);
	public Resultado editar(Aluno aluno);
}
