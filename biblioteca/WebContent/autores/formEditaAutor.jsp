<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Autor</title>
</head>
<body>
	<h3>Editar Autor</h3>
	<br />
	<form action="/biblioteca/editarAutor" method="post">
		Novo Nome:<input type="text" name="novoNome"/>
		Novo Email:<input type="text" name="novoEmail" />
		<input type="submit" />
	</form>
</body>
</html>