package aula05.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aula05.models.Aluno;
import aula05.services.AlunoService;

@WebServlet("/Aluno.do")
public class AlunoServlet extends HttpServlet {
	private static final long serialVersionUID = -4079640014678723136L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");

		System.out.println(nome);
		System.out.println(endereco);

		// crio uma instancia de aluno
		Aluno aluno = new Aluno(nome, endereco);
		// instancio o service
		AlunoService alunoService = new AlunoService();
		// solicito a inserção de aluno
		alunoService.inserir(aluno);

		request.getSession().setAttribute("id", aluno.getId());
		request.getSession().setAttribute("nome", aluno.getNome());
		request.getSession().setAttribute("endereco", aluno.getEndereco());

		RequestDispatcher view = request.getRequestDispatcher("confirmacao.jsp");
		view.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
