package aula09.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aula09.factories.AlunoFactory;
import aula09.models.Resultado;
import aula09.models.aluno.Aluno;
import aula09.models.solicitacao.AcaoSolicitacao;
import aula09.models.solicitacao.ParametroSolicitacao;
import aula09.services.AlunoService;

@WebServlet("/Aluno.do")
public class AlunoServlet extends HttpServlet {
	private static final long serialVersionUID = -4079640014678723136L;

	private static final String INDEX_JSP = "index.jsp";
	private static final String INFORMACOES_ALUNO_JSP = "informacoesAluno.jsp";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		tratarRequest(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void tratarRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		limparMensagem(request);

		String action = request.getParameter(ParametroSolicitacao.ACTION.getDescricao());

		AlunoService alunoService = new AlunoService();

		String fowardTo = "";
		if (action.equals(AcaoSolicitacao.PROCURAR_ALUNO_POR_OPCAO.getDescricao())) {
			fowardTo = procurarAlunoPorOpcao(request, alunoService);
		} else if (action.equals(AcaoSolicitacao.EXCLUIR_ALUNO.getDescricao())) {
			fowardTo = excluirAluno(request, alunoService);
			fowardTo = listarAlunos(request, alunoService);
		} else if (action.equals(AcaoSolicitacao.EDITAR_ALUNO.getDescricao())) {
			fowardTo = editarAluno(request, alunoService);
			fowardTo = listarAlunos(request, alunoService);
		} else if (action.equals(AcaoSolicitacao.LISTAR.getDescricao())) {
			fowardTo = listarAlunos(request, alunoService);
		} else if (action.equals(AcaoSolicitacao.SELECIONAR.getDescricao())) {
			fowardTo = selecionarAluno(request);
		} else if (action.equals(AcaoSolicitacao.LIMPAR_ALUNO.getDescricao())) {
			fowardTo = limparAluno(request);
		} else if (action.equals(AcaoSolicitacao.VOLTAR_PARA_PAGINA_PRINCIPAL.getDescricao())) {
			fowardTo = voltarParaPaginaPrincipal(request);
		}

		RequestDispatcher view = request.getRequestDispatcher(fowardTo);
		view.forward(request, response);
	}

	private String voltarParaPaginaPrincipal(HttpServletRequest request) {
		limparMensagem(request);
		
		return INDEX_JSP;
	}
	
	private void limparMensagem(HttpServletRequest request) {
		request.getSession().setAttribute(ParametroSolicitacao.MENSAGEM.getDescricao(), "");
	}

	private String limparAluno(HttpServletRequest request) {
		request.getSession().setAttribute(ParametroSolicitacao.ALUNO_EDITADO.getDescricao(), new Aluno());

		return INFORMACOES_ALUNO_JSP;
	}

	private String selecionarAluno(HttpServletRequest request) {
		request.getSession().setAttribute(ParametroSolicitacao.ALUNO_EDITADO.getDescricao(),
				AlunoFactory.criarAluno(request));

		return INFORMACOES_ALUNO_JSP;
	}

	private String listarAlunos(HttpServletRequest request, AlunoService alunoService) {
		request.getSession().setAttribute(ParametroSolicitacao.ALUNOS.getDescricao(), alunoService.listarAlunos());

		return INDEX_JSP;
	}

	private String editarAluno(HttpServletRequest request, AlunoService alunoService) {
		Resultado resultado = alunoService.editar(AlunoFactory.criarAluno(request));

		request.getSession().setAttribute(ParametroSolicitacao.ALUNO_EDITADO.getDescricao(),
				resultado.getAlunoEditado());
		exibirResultado(request, resultado);

		return INFORMACOES_ALUNO_JSP;
	}

	private String excluirAluno(HttpServletRequest request, AlunoService alunoService) {
		int id = Integer.parseInt(request.getParameter(ParametroSolicitacao.ID.getDescricao()));
		Resultado resultado = alunoService.excluirPorId(id);

		exibirResultado(request, resultado);

		return INDEX_JSP;
	}

	private String procurarAlunoPorOpcao(HttpServletRequest request, AlunoService alunoService) {
		String opcao = request.getParameter(ParametroSolicitacao.OPCOES.getDescricao());
		String valor = request.getParameter(ParametroSolicitacao.VALOR_PARA_PESQUISAR.getDescricao());

		request.getSession().setAttribute(ParametroSolicitacao.ALUNOS.getDescricao(),
				alunoService.listarAlunosPor(opcao, valor));

		return INDEX_JSP;
	}

	private void exibirResultado(HttpServletRequest request, Resultado resultado) {
		if (resultado.isSucesso()) {
			request.getSession().setAttribute(ParametroSolicitacao.MENSAGEM.getDescricao(), resultado.getMensagens());
		} else {
			request.getSession().setAttribute(ParametroSolicitacao.MENSAGEM.getDescricao(), resultado.getErros());
		}
	}
}
