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
	<%!
	String ra;
	String nome;
	String endereco;%>
	<%
		ra = (String) request.getSession().getAttribute("ra");
		nome = (String) request.getSession().getAttribute("nome");
		endereco = (String) request.getSession().getAttribute("endereco");
		System.out.println(ra);
		System.out.println(nome);
		System.out.println(endereco);
	%>
	RA: <%=ra%><br> 
	Nome:<%=nome%><br>
	Endereco:<%=endereco%>
	Dados gravados com sucesso.
	<br>
	<br>
	<br> Versão JSTL
	<br>RA: ${ra}
	<br> Nome: ${nome}
	<br> Endereco:${endereco }
	<br> Dados gravados com sucesso.
	<br>
</body>
</html>