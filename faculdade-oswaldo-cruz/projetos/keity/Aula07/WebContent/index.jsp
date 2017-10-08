<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de Alunos</title>
</head>
<body>
	<div>	
	Buscar Por Opção
		<form action="Aluno.do?action=procurarAlunoPorOpcao" method="post">
			Opcao:
			<select name="opcoes">
				<option selected>id</option>
				<option>nome</option>
				<option>endereco</option>
			</select>  
			<input type="text" name="valorParaPesquisar"></input>&nbsp;&nbsp;&nbsp;
			<input type="submit" value="Buscar"> <br /> <br />
		</form>
		<form action="Aluno.do" method="post">
			<a href="Aluno.do?action=limparAluno"><input type="button" value="Novo"></a>&nbsp;&nbsp;&nbsp;<input type="submit" value="Listar Todos"> <br /> <br />
			<p id="mensagem">${mensagem}</p>			
			<table cellspacing="0" cellpadding="0" border="1">
				<thead>
					<tr>
						<th width="100px">Opção</th>
						<th width="100px">ID</th>
						<th width="200px">Nome</th>
						<th width="200px">Endere&ccedil;o</th>
					</tr>
				</thead>
				<tbody align="center">
					<c:forEach var="aluno" items="${alunos}">
						<tr align="center">
							<td>
								<table>
									<tr>
										<td><a href="Aluno.do?action=selecionar&id=${aluno.getId()}&nome=${aluno.getNome()}&endereco=${aluno.getEndereco()}">Selecionar</a></td>
										<td><a href="Aluno.do?action=excluirAluno&id=${aluno.id}">Excluir</a></td>
									</tr>
								</table>
							</td>
							<td>${aluno.getId()}</td>
							<td>${aluno.getNome()}</td>
							<td>${aluno.getEndereco()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="hidden" name="action" value="listar" />
		</form>
	</div>
</body>
</html>