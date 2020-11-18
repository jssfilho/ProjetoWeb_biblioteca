<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.biblioteca.models.Autor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Editar Autor</title>
</head>
<body>
	<h3>Editar Autor</h3>
	<br />
	<form action="/autores/editarAutor" method="POST">
		Novo Nome:<input type="text" name="novoNome"/><br>
		Novo Email:<input type="text" name="novoEmail" />
		<c:forEach items="${autores}" var="autor">
			<li>
				Codigo: ${ autor.getCodigo() }<br>
				Nome: ${ autor.getNome() }<br>
				Email: ${ autor.getEmail() }<br>
						<br />
				
				<button type="submit" name="codigo" value="${autor.getCodigo() }">EDITAR</button>
				<br />
			</li>
		</c:forEach>
	</form>
		<br />
	<a href="/">Voltar</a>
</body>
</html>