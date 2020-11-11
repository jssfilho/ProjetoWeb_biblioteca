<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Colecao</title>
</head>
<body>
	<h3>Nova Colecao</h3>
	<br />
	<form action="/biblioteca/colecoes/novaColecao" method="post">
		Nome:<input type="text" name="nome"/>
		Genero:<input type="text" name="genero" />
		<input type="submit" />
	</form>
	<a href="/biblioteca/">Voltar</a>
</body>
</html>