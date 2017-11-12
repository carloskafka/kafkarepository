package aula09.models.solicitacao;

public enum ParametroSolicitacao {
	ID("id"),
	NOME("nome"),
	ENDERECO("endereco"),
	ACTION("action"), 
	ALUNO_EDITADO("alunoEditado"), 
	ALUNO("aluno"),
	ALUNOS("alunos"), 
	MENSAGEM("mensagem"),
	OPCOES("opcoes"),
	VALOR_PARA_PESQUISAR("valorParaPesquisar");

	private String descricao;

	private ParametroSolicitacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
