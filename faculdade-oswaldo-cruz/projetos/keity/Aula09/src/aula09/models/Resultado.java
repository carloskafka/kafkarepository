package aula09.models;

import aula09.models.aluno.Aluno;

public class Resultado {
	private String mensagens;
	private String erros;
	private boolean sucesso;
	private Aluno alunoEditado;

	public Resultado() {
		mensagens = "";
		erros = "";
		alunoEditado = null;
		sucesso = false;
	}

	public void efetuadoComSucesso(Aluno alunoEditado) {
		sucesso = true;
		this.alunoEditado = alunoEditado;
	}

	public Aluno getAlunoEditado() {
		return alunoEditado;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public String getMensagens() {
		return mensagens;
	}

	public String getErros() {
		return erros;
	}

	public void adicionarMensagem(String mensagem) {
		mensagens += mensagem;
		sucesso = true;
	}

	public void adicionarErro(String erro) {
		erros += erro + "\n";
		sucesso = false;
	}

	public void setAlunoEditado(Aluno alunoEditado) {
		this.alunoEditado = alunoEditado;
	}

}
