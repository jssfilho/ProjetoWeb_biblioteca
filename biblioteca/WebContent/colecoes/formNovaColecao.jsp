<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Colecao</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<h3>Nova Colecao</h3>
	<br />
	<form action="/colecoes/novaColecao" method="post">
		Nome:<input type="text" name="nome"/><br>
		Genero:<input type="text" name="genero" /><br>
		<br>
		<input type="submit" />
	</form>
	<br>
	<a href="/">Voltar</a>
</body>
</html>