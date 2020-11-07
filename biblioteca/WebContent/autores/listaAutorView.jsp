<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.biblioteca.models.Autor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autores Cadastrados</title>
</head>
<body>
	<h3>Autores Salvos</h3>
	<c:forEach items="${lista}" var="autor">
		<li>
			<label>${ autor.getCodigo() }</label>
			<label>${ autor.getNome() }</label>
			<label>${ autor.getEmail() }</label>
			<form action="/biblioteca/autores/listaAutores" method="POST">
				<button type="submit" name="codigo" value="${autor.getCodigo() }">EXCLUIR</button>
			</form>
			<form action="/biblioteca/autores/editarAutor" method="GET">
				<button type="submit" name="codigo" value="${autor.getCodigo() }">EDITAR</button>
			</form>
		</li>
	</c:forEach>
</body>
</html>