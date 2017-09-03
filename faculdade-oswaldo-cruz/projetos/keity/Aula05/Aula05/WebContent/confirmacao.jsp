<%@page import="com.sun.net.httpserver.HttpServer, javax.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página de Confirmação</title>
</head>
<body>
	Versão getSession()<br>
	<%!int id;
	String nome;
	String endereco;%>
	<%
		id = (int) request.getSession().getAttribute("id");
		nome = (String) request.getSession().getAttribute("nome");
		endereco = (String) request.getSession().getAttribute("endereco");
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
	<br> Versão JSTL
	<br>ID: ${id}
	<br> Nome: ${nome}
	<br> Endereco:${endereco }
	<br> Dados gravados com sucesso.
	<br>
</body>
</html>