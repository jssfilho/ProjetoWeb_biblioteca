<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Editora</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<h3>Nova Editora</h3>
	<br />
	<form action="/editoras/novaEditora" method="post">
		Nome: <input type="text" name="nome"/><br>
		Cnpj: <input type="text" name="cnpj" /><br>
		<input type="submit" />
	</form>
	<a href="/">Voltar</a>
</body>
</html>