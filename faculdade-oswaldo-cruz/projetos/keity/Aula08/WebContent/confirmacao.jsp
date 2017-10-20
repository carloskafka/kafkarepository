<%@page import="com.sun.net.httpserver.HttpServer, javax.servlet.*, aula08.models.aluno.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>P&aacute;gina de Confirma&ccetil;&atilde;o</title>
</head>
<body>
	Vers&atilde;o getSession()<br>
	<%!int id;
	String nome;
	String endereco;%>
	<%
		Aluno aluno = (Aluno) request.getSession().getAttribute("aluno");
		id = aluno.getId();
		nome = aluno.getNome();
		endereco = aluno.getEndereco();
		System.out.println(id);
		System.out.println(nome);
		System.out.println(endereco);
	%>
	ID: <%=id%><br> 
	Nome:<%=nome%><br>
	Endereco:<%=endereco%><br>
	Dados gravados com sucesso.
	<br>
	<br>
	<br> Vers&atilde;o JSTL
	<br>ID: ${aluno.getId()}
	<br> Nome: ${aluno.getNome()}
	<br> Endere&ccedil;o:${aluno.getEndereco()}
	<br> Dados gravados com sucesso.
	<br><br>
	<a href="Aluno.do?action=listar" >Listar Alunos</a>
</body>
</html>