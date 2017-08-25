package aula04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Aluno.do")
public class Aluno extends HttpServlet {
	private static final long serialVersionUID = -4079640014678723136L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ra = request.getParameter("ra");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		
		System.out.println(ra);
		System.out.println(nome);
		System.out.println(endereco);
		
		request.getSession().setAttribute("ra", ra);
		request.getSession().setAttribute("nome", nome);
		request.getSession().setAttribute("endereco", endereco);
		
		RequestDispatcher view = request.getRequestDispatcher("confirmacao.jsp");
		view.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
}
