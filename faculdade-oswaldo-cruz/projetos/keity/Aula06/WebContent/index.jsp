<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>P&aacute;gina de Cadastro de Aluno</title>
</head>
<body>
	<form action="Aluno.do" method="post">	
		Nome: <input type="text" name="nome">
		<br>
		Endere&ccedil;o: <input type="text" name="endereco">
		<br>	
		<input type="submit">
		
		<input type="hidden" name="action" value="inserir"/>
	</form>
</body>
</html>