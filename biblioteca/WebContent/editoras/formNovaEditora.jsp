<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Editora</title>
</head>
<body>
	<h3>Nova Editora</h3>
	<br />
	<form action="/biblioteca/editoras/novaEditora" method="post">
		Nome:<input type="text" name="nome"/>
		Cnpj:<input type="text" name="cnpj" />
		<input type="submit" />
	</form>
	<a href="/biblioteca/">Voltar</a>
</body>
</html>