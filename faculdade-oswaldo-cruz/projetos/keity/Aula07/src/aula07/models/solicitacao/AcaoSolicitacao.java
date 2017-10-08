package aula07.models.solicitacao;

public enum AcaoSolicitacao {
	PROCURAR_ALUNO_POR_OPCAO("procurarAlunoPorOpcao"), 
	EXCLUIR_ALUNO("excluirAluno"), 
	EDITAR_ALUNO("editarAluno"), 
	LISTAR("listar"), 
	INSERIR("inserir"), 
	SELECIONAR("selecionar"), 
	LIMPAR_ALUNO("limparAluno"), 
	VOLTAR_PARA_PAGINA_PRINCIPAL("voltarParaPaginaPrincipal"); 
	
	private String descricao;

	private AcaoSolicitacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
