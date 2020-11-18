<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Cadastrar Autores</title>
</head>
<body>
	<h3>Novo Autor</h3>
	<br />
	<form action="/autores/novoAutor" method="post">
		Nome do Autor: <input type="text" name="nome" />
		Email do Autor: <input type="text" name="email" />
		<input type="submit" />
	</form>
	
	<br>
		<a href="/">Voltar</a>
	
</body>
</html>