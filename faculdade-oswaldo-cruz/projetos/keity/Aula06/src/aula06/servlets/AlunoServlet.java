package aula06.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aula06.models.Aluno;
import aula06.services.AlunoService;

@WebServlet("/Aluno.do")
public class AlunoServlet extends HttpServlet {
	private static final long serialVersionUID = -4079640014678723136L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		teste(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		teste(request, response);
	}

	public void teste(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);

		// instancio o service
		AlunoService alunoService = new AlunoService();

		String fowardTo = "";
		if (action.equals("inserir")) {
			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");

			System.out.println(nome);
			System.out.println(endereco);

			// crio uma instancia de aluno
			Aluno aluno = new Aluno(nome, endereco);
			// solicito a inserção de aluno
			alunoService.inserir(aluno);
			request.getSession().setAttribute("aluno", aluno);
			fowardTo = "confirmacao.jsp";
		} else if (action.equals("listar")) {
			ArrayList<Aluno> alunos = alunoService.listarAlunos();
			request.getSession().setAttribute("alunos", alunos);
			fowardTo = "lista-alunos.jsp";
		}

		RequestDispatcher view = request.getRequestDispatcher(fowardTo);
		view.forward(request, response);
	}
}
