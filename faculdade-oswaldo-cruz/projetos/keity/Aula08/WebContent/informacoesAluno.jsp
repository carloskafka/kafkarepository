<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Criar/Alterar Aluno
		<form action="Aluno.do?action=editarAluno" method="post">
			<table>
				<tr><td>ID:</td><td><input type="text" name="id" value="${alunoEditado.getId()}" readonly/></td></tr>
				<tr><td>Nome:</td><td><input type="text" name="nome" value="${alunoEditado.getNome()}" /></td></tr>
				<tr><td>Endere&ccedil;o:</td><td><input type="text" name="endereco" value="${alunoEditado.getEndereco()}" /></td></tr>
			</table>
			<input type="submit" value="Salvar"/>&nbsp;&nbsp;&nbsp;<a href="Aluno.do?action=limparAluno"><input type="button" value="Limpar"></a>			
		</form>
		<p id="mensagem">${mensagem}</p>
		<a href="Aluno.do?action=voltarParaPaginaPrincipal"><input type="button" value="Voltar para Pagina Principal"></a>
</body>
</html>