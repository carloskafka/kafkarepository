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
		<table cellspacing="0" cellpadding="0" border="1">
			<thead>
				<tr>
					<th width="100px">ID</th>
					<th width="200px">Nome</th>
					<th width="200px">Endere&ccedil;o</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="aluno" items="${alunos}">
					<tr align="center">
						<td>${aluno.getId()}</td>
						<td>${aluno.getNome()}</td>
						<td>${aluno.getEndereco()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>